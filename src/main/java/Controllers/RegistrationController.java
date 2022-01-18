package Controllers;

import Constants.Constants;
import model.Entities.User;
import model.services.MySQLUserServices;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "RegistrationController", value = Constants.REGISTRATION_CONTROLLER)
public class RegistrationController extends AbstractController {
    MySQLUserServices mySQLUserServices;

    public RegistrationController() {
        mySQLUserServices = new MySQLUserServices();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter(Constants.FIRST_NAME_PARAMETER_LABEL);
        String lastName = request.getParameter(Constants.LAST_NAME_PARAMETER_LABEL);
        String login = request.getParameter(Constants.LOGIN_PARAMETER_LABEL);
        String password = request.getParameter(Constants.PASSWORD_PARAMETER_LABEL);
        String email = request.getParameter(Constants.EMAIL_PARAMETER_LABEL);

        User user = mySQLUserServices.registerUser(firstName, lastName, login, password, email);

        if (Objects.nonNull(user)) {
            request.getSession().setAttribute(Constants.USER_ATTRIBUTE_LABEL, user);
            jump(request, response, Constants.LOGIN_PAGE_URL);
        }
        else {
            jumpMessage(request, response, Constants.ALREADY_EXIST_DATA, Constants.REGISTRATION_PAGE_URL);
        }
    }
}
