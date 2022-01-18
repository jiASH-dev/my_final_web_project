package Controllers;

import Constants.Constants;
import model.services.MySQLDevelopmentServices;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SetStatusController", value = Constants.SET_STATUS_CONTROLLER)
public class SetStatusController extends AbstractController {
    MySQLDevelopmentServices mySQLDevelopmentServices;

    public SetStatusController() {
        mySQLDevelopmentServices = new MySQLDevelopmentServices();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String[] conferencesId = request.getParameterValues("conferences");
//        String[] seminarsId = request.getParameterValues("seminars");
//        String[] trainingsId = request.getParameterValues("trainings");
//        int userId = ((User) request.getSession().getAttribute("user")).getId();
//
//        mySQLDevelopmentServices.updateStatus(userId, conferencesId, seminarsId, trainingsId);
//
//        jump(request, response, Constants.CONTROL_PANEL_PAGE_URL);
    }
}
