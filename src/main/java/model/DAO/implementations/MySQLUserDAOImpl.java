package model.DAO.implementations;

import Constants.SQLRequests;
import Enums.Property;
import model.Connection.MySQLConnection;
import model.Entities.User;
import model.DAO.interfaces.UserDAO;

import java.sql.*;

public class MySQLUserDAOImpl implements UserDAO {
    private final Object mutex;

    public MySQLUserDAOImpl() {
        mutex = new Object();
    }

    public User registrationUser(String currentFirstName, String currentLastName, String currentLogin, String currentPassword, String currentEmail) {
        User user = null;

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement checkStatement = connection.prepareStatement(SQLRequests.CHECK_VALID_DATA);
             PreparedStatement createUser = connection.prepareStatement(SQLRequests.CREATE_USER, Statement.RETURN_GENERATED_KEYS)) {
            synchronized (mutex) {
                checkStatement.setString(1, currentLogin);
                checkStatement.setString(2, currentEmail);
                ResultSet resultSetUser = checkStatement.executeQuery();

                if (!resultSetUser.next()) {
                    createUser.setString(1, currentFirstName);
                    createUser.setString(2, currentLastName);
                    createUser.setString(3, currentLogin);
                    createUser.setString(4, currentPassword);
                    createUser.setString(5, currentEmail);

                    createUser.executeUpdate();

                    resultSetUser = createUser.getGeneratedKeys();
                    if (resultSetUser.next()) {
                        int currentUserId = resultSetUser.getInt(1);
                        user = new User(currentUserId, currentFirstName, currentLastName, currentLogin, currentEmail);
                    }
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace(); // логирование
        }
        return user;
    }

    @Override
    public User enterInSystem(String login, String password) {
        User user = null;

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement dataStatement = connection.prepareStatement(SQLRequests.GET_USER)) {
            dataStatement.setString(1, login);
            dataStatement.setString(2, password);
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
    public User updateInfo(Property property, int userId, String newFirstName) {
        User user = null;

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement updateStatement = connection.prepareStatement(property.getValue());
             PreparedStatement getUpdatedInfoStatement = connection.prepareStatement(SQLRequests.GET_USER_ON_ID)) {
            updateStatement.setString(1, newFirstName);
            updateStatement.setInt(2, userId);

            updateStatement.executeUpdate();

            getUpdatedInfoStatement.setInt(1, userId);

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
