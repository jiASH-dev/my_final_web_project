package Controllers;

import Constants.Constants;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet(name = "AbstractController")
public abstract class AbstractController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void jump(HttpServletRequest req, HttpServletResponse resp, String url) throws ServletException, IOException {
        req.getRequestDispatcher(url).forward(req, resp);
    }

    protected void jumpMessage(HttpServletRequest req, HttpServletResponse resp, String message, String url) throws ServletException, IOException {
        req.setAttribute(Constants.MESSAGE_ATTRIBUTE_LABEL, message);
        req.getRequestDispatcher(url).forward(req,resp);
    }

    protected void redirect(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
        response.sendRedirect(getServletContext().getContextPath() + url);
    }
}