package by.jiash.model.DAO.Interfaces;

import by.jiash.DTO.AddDevelopmentRequest;
import by.jiash.model.Enums.Section;
import by.jiash.model.Entities.Development;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface DevelopmentDAO {
    ArrayList<Development> showSectionDevelopments(Section section);
    ArrayList<Development> showUserDevelopments(Section section, int id);
    void updateStatus(int id, String[] conferencesId, String[] seminarsId, String[] trainingsId);
    String addDevelopment(AddDevelopmentRequest addDevelopmentRequest);
    void deleteDevelopment(int[] developmentsId);
    HashMap<String, List<Time>> showDevelopmentDetails(int developmentId);
}
