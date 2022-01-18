package by.jiash.Controllers;

import by.jiash.Constants.Constants;
import by.jiash.DTO.AddDevelopmentRequest;
import by.jiash.model.Enums.Section;
import by.jiash.model.Enums.Type;
import by.jiash.model.Entities.Development;
import by.jiash.model.Entities.User;
import by.jiash.model.Services.MySQLDevelopmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;
import java.sql.Time;
import java.util.HashMap;
import java.util.List;

@Controller
public class DevelopmentController {
    private MySQLDevelopmentServices mySQLDevelopmentServices;

    @Autowired
    public DevelopmentController(MySQLDevelopmentServices mySQLDevelopmentServices) {
        this.mySQLDevelopmentServices = mySQLDevelopmentServices;
    }

    @PostMapping(Constants.CREATE_DEVELOPMENT_MAPPING)
    public String addDevelopment(AddDevelopmentRequest addDevelopmentRequest, Model model) {
        System.out.println(addDevelopmentRequest);
        String result = mySQLDevelopmentServices.addDevelopment(addDevelopmentRequest);//

        if (!result.isEmpty()){
            model.addAttribute(Constants.MESSAGE_ATTRIBUTE_LABEL, result);
        }

        return Constants.ADD_DEVELOPMENT_PAGE_URL;
    }

    @GetMapping(value = Constants.REMOVE_DEVELOPMENT_MAPPING)
    public String deleteDevelopment(int[] developmentsId, HttpSession httpSession, Model model) {
        mySQLDevelopmentServices.deleteDevelopments(developmentsId);
        return showDevelopment(Section.SELF, httpSession, model);
    }

    @GetMapping(Constants.SHOW_DEVELOPMENT_MAPPING)
    public String showDevelopment(Section section, HttpSession httpSession, Model model) {
        HashMap<Type, List<Development>> developmentMap;

        if (section == Section.SELF) {
            User user = (User) httpSession.getAttribute(Constants.USER_ATTRIBUTE_LABEL);
            int id = user.getId();
            developmentMap = mySQLDevelopmentServices.showSelfDevelopment(section, id);

            if (developmentMap.isEmpty()) {
                model.addAttribute(Constants.MESSAGE_ATTRIBUTE_LABEL, Constants.USER_EMPTY_DEVELOPMENT_MAP);
            }
            else {
                model.addAttribute(Constants.DEVELOPMENT_MAP_ATTRIBUTE_LABEL, developmentMap);
            }

            return Constants.USER_DEVELOPMENTS_INFO_URL;

        }
        else {
            developmentMap = mySQLDevelopmentServices.showAllDevelopments(section);

            if (developmentMap.isEmpty()) {
                model.addAttribute(Constants.MESSAGE_ATTRIBUTE_LABEL, Constants.ANY_EMPTY_DEVELOPMENT_MAP);
            }
            else {
                model.addAttribute(Constants.DEVELOPMENT_MAP_ATTRIBUTE_LABEL, developmentMap);
            }

            return Constants.ANY_DEVELOPMENTS_INFO_URL;
        }
    }

    @GetMapping(Constants.SHOW_DEVELOPMENT_DETAILS_MAPPING)
    public String showDevelopmentDetails(int developmentId, @RequestParam(Constants.RETURN_URL_PARAMETER_LABEL) String return_url, Model model) {
        HashMap<String, List<Time>> developmentDetails = mySQLDevelopmentServices.showDevelopmentDetails(developmentId);
        model.addAttribute(Constants.DEVELOPMENT_DETAILS_ATTRIBUTE_LABEL, developmentDetails);

        return return_url;
    }
}
