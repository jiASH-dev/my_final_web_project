package model.services;

import Enums.Section;
import Enums.Type;
import model.Entities.Development;
import model.DAO.implementations.MySQLDevelopmentDAOImpl;
import java.sql.Time;
import java.util.*;
import java.util.stream.Collectors;

public class MySQLDevelopmentServices {
    private final MySQLDevelopmentDAOImpl mySQLDevelopmentDAO;

    public MySQLDevelopmentServices() {
        mySQLDevelopmentDAO = new MySQLDevelopmentDAOImpl();
    }

    private Map<Type, List<Development>> listTransformToMap (ArrayList<Development> developmentList) {
        Map<Type, List<Development>> transformedList = new HashMap<>();
        if (!developmentList.isEmpty()) {
            transformedList = developmentList.stream()
                    .collect(Collectors.groupingBy(Development::getType));
        }
        return transformedList;
    }

    public void updateStatus(int id, String[] conferencesId, String[] seminarsId, String[] trainingsId) {
        mySQLDevelopmentDAO.updateStatus(id, conferencesId, seminarsId, trainingsId);
    }

    public HashMap<Type, List<Development>> showAllDevelopments(Section section) {
        ArrayList<Development> developmentList = mySQLDevelopmentDAO.showSectionDevelopments(section);
        Map<Type, List<Development>> transformedList = listTransformToMap(developmentList);
        return (HashMap<Type, List<Development>>) transformedList;
    }

    public String addDevelopment(int userId, String location, String date, String description, String type, String[] eventNames, String[] eventTimesStart, String[] eventTimesEnd) {
        Type parsedType = Type.valueOf(type.toUpperCase(Locale.ROOT));
        Time[] parsedEventTimesStart = new Time[eventTimesStart.length];
        Time[] parsedEventTimesEnd = new Time[eventTimesEnd.length];
        for (int i = 0; i < parsedEventTimesStart.length; i++){
            parsedEventTimesStart[i] = Time.valueOf(eventTimesStart[i]);
            parsedEventTimesEnd[i] = Time.valueOf(eventTimesEnd[i]);
        }
        return mySQLDevelopmentDAO.addDevelopment(userId, location, date,  description, parsedType, eventNames, parsedEventTimesStart, parsedEventTimesEnd);
    }

    public HashMap<Type, List<Development>> showSelfDevelopment(Section section, int id) {
        ArrayList<Development> developmentList = mySQLDevelopmentDAO.showUserDevelopments(section, id);
        Map<Type, List<Development>> transformedList = listTransformToMap(developmentList);
        return (HashMap<Type, List<Development>>) transformedList;
    }

    public void deleteDevelopments(String[] developmentsId) {
        int[] parsedDevelopmentsId = new int[developmentsId.length];
        for (int i = 0; i < developmentsId.length; i++) {
            parsedDevelopmentsId[i] = Integer.parseInt(developmentsId[i]);
        }
        mySQLDevelopmentDAO.deleteDevelopment(parsedDevelopmentsId);
    }

    public HashMap<String, List<Time>> showDevelopmentDetails (String id) {
        int parsedId = Integer.parseInt(id);
        return mySQLDevelopmentDAO.showDevelopmentDetails(parsedId);
    }
}
