package Controllers;

import Constants.Constants;
import model.services.MySQLUserServices;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TypeSpecifierController", value = Constants.TYPE_SPECIFIER_CONTROLLER)
public class TypeSpecifierController extends AbstractController{
    MySQLUserServices mySQLUserServices;

    public TypeSpecifierController() {
        mySQLUserServices = new MySQLUserServices();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter(Constants.TYPE_PARAMETER_LABEL);
        request.setAttribute(Constants.TYPE_PARAMETER_LABEL, type);
        jump(request, response, Constants.EDIT_DATA_URL);
    }
}