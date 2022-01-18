package Controllers;

import Constants.Constants;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "LogOutController", value = Constants.LOGOUT_CONTROLLER)
public class LogOutController extends AbstractController {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Objects.nonNull(request.getSession().getAttribute(Constants.USER_ATTRIBUTE_LABEL))) {
            request.getSession().invalidate();
        }
        jump(request, response, Constants.WELCOME_PAGE_URL);
    }
}