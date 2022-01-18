package Controllers;

import Constants.Constants;
import model.Entities.User;
import model.services.MySQLDevelopmentServices;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddDevelopmentController", value = Constants.ADD_DEVELOPMENT_CONTROLLER)
public class AddDevelopmentController extends AbstractController {
    MySQLDevelopmentServices mySQLDevelopmentServices;

    public AddDevelopmentController() {
        mySQLDevelopmentServices = new MySQLDevelopmentServices();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String location = request.getParameter(Constants.LOCATION_PARAMETER_LABEL);
        String date = request.getParameter(Constants.DATE_PARAMETER_LABEL);
        String description = request.getParameter(Constants.DESCRIPTION_PARAMETER_LABEL);
        String type = request.getParameter(Constants.TYPE_PARAMETER_LABEL);
        String[] eventNames = request.getParameterValues(Constants.EVENT_NAME_PARAMETER_LABEL);
        String[] eventTimesStart = request.getParameterValues(Constants.EVENT_TIME_START_PARAMETER_LABEL);
        String[] eventTimesEnd = request.getParameterValues(Constants.EVENT_TIME_END_PARAMETER_LABEL);

        User user = (User) request.getSession().getAttribute(Constants.USER_ATTRIBUTE_LABEL);
        int userId = user.getId();

        String result = mySQLDevelopmentServices.addDevelopment(userId, location, date, description, type, eventNames, eventTimesStart, eventTimesEnd);

        if (result.isEmpty()){
            jump(request, response, Constants.ADD_DEVELOPMENT_PAGE_URL);
        }
        else {
            jumpMessage(request, response, result, Constants.ADD_DEVELOPMENT_PAGE_URL);
        }
    }
}
