package by.jiash.model.Services;

import by.jiash.DTO.AddDevelopmentRequest;
import by.jiash.model.Enums.Section;
import by.jiash.model.Enums.Type;
import by.jiash.model.DAO.Implementations.MySQLDevelopmentDAOImpl;
import by.jiash.model.Entities.Development;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MySQLDevelopmentServices {
    private MySQLDevelopmentDAOImpl mySQLDevelopmentDAO;

    @Autowired
    public MySQLDevelopmentServices(MySQLDevelopmentDAOImpl mySQLDevelopmentDAO) {
        this.mySQLDevelopmentDAO = mySQLDevelopmentDAO;
    }

    //
    private Map<Type, List<Development>> listTransformToMap(ArrayList<Development> developmentList) {
        Map<Type, List<Development>> transformedList = new HashMap<>();
        if (!developmentList.isEmpty()) {
            transformedList = developmentList.stream()
                    .collect(Collectors.groupingBy(Development::getType));
        }
        return transformedList;
    }

//
//    public void updateStatus(int id, String[] conferencesId, String[] seminarsId, String[] trainingsId) {
//        mySQLDevelopmentDAO.updateStatus(id, conferencesId, seminarsId, trainingsId);
//    }
//
    public HashMap<Type, List<Development>> showAllDevelopments(Section section) {
        ArrayList<Development> developmentList = mySQLDevelopmentDAO.showSectionDevelopments(section);
        Map<Type, List<Development>> transformedList = listTransformToMap(developmentList);
        return (HashMap<Type, List<Development>>) transformedList;
    }

    public String addDevelopment(AddDevelopmentRequest addDevelopmentRequest) {
        return mySQLDevelopmentDAO.addDevelopment(addDevelopmentRequest);
    }

    //
    public HashMap<Type, List<Development>> showSelfDevelopment(Section section, int id) {
        ArrayList<Development> developmentList = mySQLDevelopmentDAO.showUserDevelopments(section, id);
        Map<Type, List<Development>> transformedList = listTransformToMap(developmentList);
        return (HashMap<Type, List<Development>>) transformedList;
    }

    public void deleteDevelopments(int[] developmentsId) {
        mySQLDevelopmentDAO.deleteDevelopment(developmentsId);
    }


    public HashMap<String, List<Time>> showDevelopmentDetails(int id) {
        HashMap<String, List<Time>> developmentDetails = mySQLDevelopmentDAO.showDevelopmentDetails(id);
        return developmentDetails;
    }
}
//}
