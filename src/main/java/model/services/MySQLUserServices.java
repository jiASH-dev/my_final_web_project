package model.services;

import Enums.Property;
import model.Entities.User;
import model.DAO.implementations.MySQLUserDAOImpl;
import java.util.Locale;

public class MySQLUserServices {
    private final MySQLUserDAOImpl mySQLUserDAO;

    public MySQLUserServices() {
        mySQLUserDAO = new MySQLUserDAOImpl();
    }

    public User registerUser(String firstName, String lastName, String login, String password, String email) {
        return mySQLUserDAO.registrationUser(firstName, lastName, login, password, email);
    }

    public User enterInSystem (String login, String password) {
        return mySQLUserDAO.enterInSystem(login, password); // логгирование
    }

    public User editInfo (String type, int userId, String newFirstName) {
        Property property = Property.valueOf(type.toUpperCase(Locale.ROOT));
        return mySQLUserDAO.updateInfo(property, userId, newFirstName);
    }


}
