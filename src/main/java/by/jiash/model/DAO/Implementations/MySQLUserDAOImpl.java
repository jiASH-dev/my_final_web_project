package by.jiash.model.DAO.Implementations;

import by.jiash.Constants.SQLRequests;
import by.jiash.DTO.EditInfoRequest;
import by.jiash.DTO.LogInRequest;
import by.jiash.DTO.RegistrationRequest;
import by.jiash.model.Connection.MySQLConnection;
import by.jiash.model.DAO.Interfaces.UserDAO;
import by.jiash.model.Entities.User;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class MySQLUserDAOImpl implements UserDAO {
    private final Object mutex;

    public MySQLUserDAOImpl() {
        mutex = new Object();
    }

    public User registrationUser(RegistrationRequest registrationRequest) {
        User user = null;

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement checkStatement = connection.prepareStatement(SQLRequests.CHECK_VALID_DATA);
             PreparedStatement createUser = connection.prepareStatement(SQLRequests.CREATE_USER, Statement.RETURN_GENERATED_KEYS)) {
            synchronized (mutex) {
                checkStatement.setString(1, registrationRequest.getLogin());
                checkStatement.setString(2, registrationRequest.getEmail());
                ResultSet resultSetUser = checkStatement.executeQuery();

                if (!resultSetUser.next()) {
                    createUser.setString(1, registrationRequest.getFirstName());
                    createUser.setString(2, registrationRequest.getLastName());
                    createUser.setString(3, registrationRequest.getLogin());
                    createUser.setString(4, registrationRequest.getPassword());
                    createUser.setString(5, registrationRequest.getEmail());

                    createUser.executeUpdate();

                    resultSetUser = createUser.getGeneratedKeys();
                    if (resultSetUser.next()) {
                        int currentUserId = resultSetUser.getInt(1);
                        user = new User(currentUserId,
                                registrationRequest.getFirstName(),
                                registrationRequest.getLastName(),
                                registrationRequest.getLogin(),
                                registrationRequest.getEmail());
                    }
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace(); // логирование
        }
        return user;
    }

    @Override
    public User enterInSystem(LogInRequest logInRequest) {
        User user = null;

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement dataStatement = connection.prepareStatement(SQLRequests.GET_USER)) {
            dataStatement.setString(1, logInRequest.getLogin());
            dataStatement.setString(2, logInRequest.getPassword());
            ResultSet resultSet = dataStatement.executeQuery();
            if (resultSet.next()) {
                int id = Integer.parseInt(resultSet.getString(1));
                String first_name = resultSet.getString(2);
                String last_name = resultSet.getString(3);
                String getLogin = resultSet.getString(4);
                String getEmail = resultSet.getString(5);
                user = new User(id, first_name, last_name, getLogin, getEmail);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public User updateInfo(EditInfoRequest editInfoRequest) {
        User user = null;

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement updateStatement = connection.prepareStatement(editInfoRequest.getProperty().getValue());
             PreparedStatement getUpdatedInfoStatement = connection.prepareStatement(SQLRequests.GET_USER_ON_ID)) {
            updateStatement.setString(1, editInfoRequest.getNewValue());
            updateStatement.setInt(2, editInfoRequest.getId());

            updateStatement.executeUpdate();

            getUpdatedInfoStatement.setInt(1, editInfoRequest.getId());

            ResultSet resultSet = getUpdatedInfoStatement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                String login = resultSet.getString(4);
                String email = resultSet.getString(5);

                user = new User(id, firstName, lastName, login, email);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }
}
