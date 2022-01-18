package by.jiash.Controllers;

import by.jiash.Constants.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RedirectController {

    @RequestMapping({Constants.PATTERN, Constants.INDEX_MAPPING})
    public String index() {
        return Constants.WELCOME_PAGE_URL;
    }

    @RequestMapping(Constants.LOGIN_MAPPING)
    public String logIn() {
        return Constants.LOGIN_PAGE_URL;
    }

    @RequestMapping(Constants.REGISTRATION_MAPPING)
    public String registration() {
        return Constants.REGISTRATION_PAGE_URL;
    }

    @RequestMapping(Constants.PERSONAL_CABINET_START_MAPPING)
    public String personalCabinetStart() {
        return Constants.PERSONAL_CABINET_START_PAGE_URL;
    }

    @RequestMapping(Constants.ADD_DEVELOPMENT_MAPPING)
    public String addDevelopment() {
        return Constants.ADD_DEVELOPMENT_PAGE_URL;
    }

    @RequestMapping(Constants.EDIT_PANEL_MAPPING)
    public String editInfo() {
        return Constants.EDIT_PANEL_URL;
    }

    @RequestMapping(Constants.EDIT_PROPERTY_MAPPING)
    public String doPost(@RequestParam(Constants.TYPE_PARAMETER_LABEL) String type, Model model) {
        model.addAttribute(Constants.TYPE_PARAMETER_LABEL, type);

        return Constants.EDIT_PANEL_URL;
    }
}
