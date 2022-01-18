package Controllers;

import Constants.Constants;
import model.services.MySQLDevelopmentServices;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Time;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "ShowDevelopmentDetailsController", value = Constants.SHOW_DEVELOPMENT_DETAILS_CONTROLLER)
public class ShowDevelopmentDetailsController extends AbstractController {
    MySQLDevelopmentServices mySQLDevelopmentServices;

    public ShowDevelopmentDetailsController() {
        mySQLDevelopmentServices = new MySQLDevelopmentServices();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String developmentId = request.getParameter(Constants.DEVELOPMENT_ID_PARAMETER_LABEL);

        HashMap<String, List<Time>> developmentDetails = mySQLDevelopmentServices.showDevelopmentDetails(developmentId);
        request.setAttribute(Constants.DEVELOPMENT_DETAILS_ATTRIBUTE_LABEL, developmentDetails);
        jump(request, response, request.getParameter(Constants.RETURN_URL_PARAMETER_LABEL));
    }
}