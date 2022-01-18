package Controllers;

import Constants.Constants;
import Enums.Section;
import Enums.Type;
import model.Entities.Development;
import model.Entities.User;
import model.services.MySQLDevelopmentServices;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

@WebServlet(name = "ShowDevelopmentController", value = Constants.SHOW_DEVELOPMENT_CONTROLLER)
public class ShowDevelopmentController extends AbstractController {
    MySQLDevelopmentServices mySQLDevelopmentServices;

    public ShowDevelopmentController() {
        mySQLDevelopmentServices = new MySQLDevelopmentServices();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String choose;

        if (Objects.nonNull(request.getParameter(Constants.CHOOSE_PARAMETER_LABEL))) {
            choose = request.getParameter(Constants.CHOOSE_PARAMETER_LABEL);
        }
        else {
            choose = (String) request.getAttribute(Constants.CHOOSE_ATTRIBUTE_LABEL);
        }

        Section section = Section.valueOf(choose.toUpperCase(Locale.ROOT));
        HashMap<Type, List<Development>> developmentMap;

        if (section == Section.SELF) {
            User user = (User) request.getSession().getAttribute(Constants.USER_ATTRIBUTE_LABEL);
            int id = user.getId();
            developmentMap = mySQLDevelopmentServices.showSelfDevelopment(section, id);

            if (!developmentMap.isEmpty()) {
                request.setAttribute(Constants.DEVELOPMENT_MAP_ATTRIBUTE_LABEL, developmentMap);
                jump(request, response, Constants.USER_DEVELOPMENTS_INFO_URL);
            }
            else {
                jumpMessage(request, response, Constants.USER_EMPTY_DEVELOPMENT_MAP, Constants.USER_DEVELOPMENTS_INFO_URL);
            }

        }
        else {
            developmentMap = mySQLDevelopmentServices.showAllDevelopments(section);

            if (!developmentMap.isEmpty()) {
                request.setAttribute(Constants.DEVELOPMENT_MAP_ATTRIBUTE_LABEL, developmentMap);
                jump(request, response, Constants.ANY_DEVELOPMENTS_INFO_URL);
            }
            else {
                jumpMessage(request, response, Constants.ANY_EMPTY_DEVELOPMENT_MAP, Constants.ANY_DEVELOPMENTS_INFO_URL);
            }
        }
    }
}