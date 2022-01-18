package Controllers;

import Constants.Constants;
import model.Entities.User;
import model.services.MySQLUserServices;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "LogInController", value = Constants.LOGIN_CONTROLLER)
public class LogInController extends AbstractController {
    MySQLUserServices mySQLUserServices;

    public LogInController() {
        mySQLUserServices = new MySQLUserServices();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter(Constants.LOGIN_PARAMETER_LABEL);
        String password = request.getParameter(Constants.PASSWORD_PARAMETER_LABEL);

        User result = mySQLUserServices.enterInSystem(login, password);

        if (Objects.nonNull(result)) {
            request.getSession().setAttribute(Constants.USER_ATTRIBUTE_LABEL, result);
            jump(request, response, Constants.WELCOME_PAGE_URL);
        }
        else {
            jumpMessage(request, response, Constants.INVALID_DATA, Constants.LOGIN_PAGE_URL);
        }
    }
}