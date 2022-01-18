package Controllers;

import Constants.Constants;
import model.Entities.User;
import model.services.MySQLUserServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditInfoController", value = Constants.EDIT_INFO_CONTROLLER)
public class EditInfoController extends AbstractController{
    MySQLUserServices mySQLUserServices;

    public EditInfoController() {
        mySQLUserServices = new MySQLUserServices();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter(Constants.TYPE_PARAMETER_LABEL);
        User user = (User) request.getSession().getAttribute(Constants.USER_ATTRIBUTE_LABEL);
        int userId = user.getId();
        String newProperty = request.getParameter(Constants.EDITED_PROPERTY_PARAMETER_LABEL);

        User updatedUser = mySQLUserServices.editInfo(type, userId, newProperty);

        request.getSession().setAttribute(Constants.USER_ATTRIBUTE_LABEL, updatedUser);

        jump(request, response, Constants.EDIT_DATA_URL);
    }
}