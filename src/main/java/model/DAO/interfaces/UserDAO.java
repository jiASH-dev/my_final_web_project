package model.DAO.interfaces;
import Enums.Property;
import model.Entities.User;

public interface UserDAO {
    User registrationUser(String firstName, String lastName, String login, String password, String email);
    User enterInSystem (String login, String password);
    User updateInfo(Property property, int userId, String newFirstName);
}
