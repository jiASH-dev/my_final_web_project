package model.DAO.interfaces;

import Enums.Section;
import Enums.Type;
import model.Entities.Development;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface DevelopmentDAO {
    ArrayList<Development> showSectionDevelopments (Section section);
    ArrayList<Development> showUserDevelopments (Section section, int id);
    void updateStatus(int id, String[] conferencesId, String[] seminarsId, String[] trainingsId);
    String addDevelopment(int userId, String location, String date, String description, Type type, String[] eventNames, Time[] eventTimesStart, Time[] eventTimesEnd);
    void deleteDevelopment(int[] developmentsId);
    HashMap<String, List<Time>> showDevelopmentDetails (int developmentId);
}
