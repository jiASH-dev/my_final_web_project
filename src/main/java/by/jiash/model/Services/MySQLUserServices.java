package by.jiash.model.Services;

import by.jiash.DTO.EditInfoRequest;
import by.jiash.DTO.LogInRequest;
import by.jiash.DTO.RegistrationRequest;
import by.jiash.model.DAO.Implementations.MySQLUserDAOImpl;
import by.jiash.model.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MySQLUserServices {
    private MySQLUserDAOImpl mySQLUserDAO;

    @Autowired
    public MySQLUserServices(MySQLUserDAOImpl mySQLUserDAO) {
        this.mySQLUserDAO = mySQLUserDAO;
    }

    public User registerUser(RegistrationRequest registrationRequest) {
        User user = mySQLUserDAO.registrationUser(registrationRequest);
        return user;
    }

    public User enterInSystem (LogInRequest logInRequest) {
        return mySQLUserDAO.enterInSystem(logInRequest); // логгирование
    }

    public User editInfo (EditInfoRequest editInfoRequest) {
        return mySQLUserDAO.updateInfo(editInfoRequest);
    }


}
