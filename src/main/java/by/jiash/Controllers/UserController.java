package by.jiash.Controllers;

import by.jiash.Constants.Constants;
import by.jiash.DTO.EditInfoRequest;
import by.jiash.DTO.LogInRequest;
import by.jiash.DTO.RegistrationRequest;
import by.jiash.model.Entities.User;
import by.jiash.model.Services.MySQLUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
public class UserController {
    private MySQLUserServices mySQLUserServices;

    @Autowired
    public UserController(MySQLUserServices mySQLUserServices) {
        this.mySQLUserServices = mySQLUserServices;
    }

    @PostMapping(Constants.AUTHORIZATION_MAPPING)
    public String logIn(LogInRequest logInRequest, Model model, HttpSession httpSession) {
        User result = mySQLUserServices.enterInSystem(logInRequest);

        if (Objects.isNull(result)) {
            model.addAttribute(Constants.MESSAGE_ATTRIBUTE_LABEL, Constants.INVALID_DATA);
            return Constants.LOGIN_PAGE_URL;
        }
        else {
            httpSession.setAttribute(Constants.USER_ATTRIBUTE_LABEL, result);
            return Constants.WELCOME_PAGE_URL;
        }
    }

    @PostMapping(Constants.LOGOUT_MAPPING)
    public String logOut(HttpSession httpSession) {
        if (Objects.nonNull(httpSession.getAttribute(Constants.USER_ATTRIBUTE_LABEL))) {
            httpSession.invalidate();
        }

        return Constants.WELCOME_PAGE_URL;
    }

    @PostMapping(Constants.REGISTRATION_MAPPING)
    public String registration(RegistrationRequest registrationRequest, Model model, HttpSession httpSession) {
        User user = mySQLUserServices.registerUser(registrationRequest);

        if (Objects.nonNull(user)) {
            httpSession.setAttribute(Constants.USER_ATTRIBUTE_LABEL, user);
            return Constants.WELCOME_PAGE_URL;
        } else {
            model.addAttribute(Constants.ALREADY_EXIST_DATA);
            return Constants.REGISTRATION_PAGE_URL;
        }
    }

    @PostMapping(Constants.CHANGE_INFO_MAPPING)
    public String editInfo(EditInfoRequest editInfoRequest, HttpSession httpSession) {
        User updatedUser = mySQLUserServices.editInfo(editInfoRequest);

        httpSession.setAttribute(Constants.USER_ATTRIBUTE_LABEL, updatedUser);

        return Constants.EDIT_PANEL_URL;
    }
}
