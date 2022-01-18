package Controllers;

import Constants.Constants;
import model.services.MySQLDevelopmentServices;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteDevelopmentController", value = Constants.DELETE_DEVELOPMENT_CONTROLLER)
public class DeleteDevelopmentController extends AbstractController {
    MySQLDevelopmentServices mySQLDevelopmentServices;

    public DeleteDevelopmentController() {
        mySQLDevelopmentServices = new MySQLDevelopmentServices();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] developmentsId = request.getParameterValues(Constants.DEVELOPMENT_ID_PARAMETER_LABEL);

        mySQLDevelopmentServices.deleteDevelopments(developmentsId);

        request.setAttribute(Constants.CHOOSE_ATTRIBUTE_LABEL, "self");

        jump(request, response, Constants.SHOW_DEVELOPMENT_CONTROLLER);
    }
}



