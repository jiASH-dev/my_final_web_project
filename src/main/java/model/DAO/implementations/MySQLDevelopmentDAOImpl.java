package model.DAO.implementations;

import Constants.Constants;
import Constants.SQLRequests;
import Enums.Section;
import Enums.Type;
import model.Entities.Development;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import model.Entities.User;
import model.Connection.MySQLConnection;
import model.DAO.interfaces.DevelopmentDAO;

public class MySQLDevelopmentDAOImpl implements DevelopmentDAO {

    private ArrayList<Development> createDevelopmentList(PreparedStatement preparedStatement) throws SQLException {
        ResultSet resultSet;
        ArrayList<Development> sectionList = new ArrayList<>();

        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String FirstName = resultSet.getString(2);
            String LastName = resultSet.getString(3);
            String location = resultSet.getString(4);
            Date date = resultSet.getDate(5);
            boolean passedStatus = resultSet.getBoolean(6);
            String description = resultSet.getString(7);
            Type type = Type.valueOf(resultSet.getString(8).toUpperCase(Locale.ROOT));
            User user = new User(FirstName, LastName);

            Development newDevelopment = new Development(id, location, user, date, passedStatus, description, type);

            sectionList.add(newDevelopment);
        }

        return sectionList;
    }

    @Override
    public ArrayList<Development> showSectionDevelopments(Section section) {
        ArrayList<Development> sectionList = null;

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(section.getValue())) {
            sectionList = createDevelopmentList(preparedStatement);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return sectionList;
    }

    @Override
    public ArrayList<Development> showUserDevelopments(Section section, int userId) {
        ArrayList<Development> usersList = null;

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(section.getValue())) {
            preparedStatement.setInt(1, userId);
            usersList = createDevelopmentList(preparedStatement);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return usersList;
    }

    @Override
    public void updateStatus(int id, String[] conferencesId, String[] seminarsId, String[] trainingsId) {
        Connection connection;
        PreparedStatement preparedStatement = null;
        try {
            connection = MySQLConnection.getConnection();
            int count = 0;
            while (count != 3) {
                switch (count) {
                    case 0:
                        if (Objects.nonNull(conferencesId)) {
                            preparedStatement = connection.prepareStatement("update conferences set passed = 1 where id = ?");
                            for (String conferenceId : conferencesId) {
                                preparedStatement.setString(1, conferenceId);
                                preparedStatement.executeUpdate();
                            }
                        }
                        count++;
                        break;
                    case 1:
                        if (Objects.nonNull(seminarsId)) {
                            preparedStatement = connection.prepareStatement("update seminars set passed = 1 where id = ?");
                            for (String seminarId : seminarsId) {
                                preparedStatement.setString(1, seminarId);
                                preparedStatement.executeUpdate();
                            }
                        }
                        count++;
                        break;
                    case 2:
                        if (Objects.nonNull(trainingsId)) {
                            preparedStatement = connection.prepareStatement("update trainings set passed = 1 where id = ?");
                            for (String trainingId : trainingsId) {
                                preparedStatement.setString(1, trainingId);
                                preparedStatement.executeUpdate();
                            }
                        }
                        count++;
                        break;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            MySQLConnection.closeStatement(preparedStatement);
            MySQLConnection.closeConnection();
        }
    }

    @Override
    public String addDevelopment(int userId, String location, String date, String description, Type type, String[] eventNames, Time[] eventTimesStart, Time[] eventTimesEnd) {
        LocalDate dateNow = LocalDate.now();
        LocalTime timeNow = LocalTime.now();

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement getDevelopmentsAndTimetable = connection.prepareStatement(SQLRequests.GET_DEVELOPMENTS_AND_TIMETABLE);
             PreparedStatement addDevelopment = connection.prepareStatement(SQLRequests.ADD_DEVELOPMENT, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement addTimetable = connection.prepareStatement(SQLRequests.ADD_TIMETABLE)) {
            if (LocalDate.parse(date).isBefore(dateNow)) {
                return Constants.INVALID_DATE;
            } else if (LocalDate.parse(date).equals(dateNow) && LocalTime.parse(String.valueOf(eventTimesStart[0])).isBefore(timeNow)) {
                return Constants.INVALID_TIME;
            } else {
                ResultSet resultSet = getDevelopmentsAndTimetable.executeQuery();
                while (resultSet.next()) {
                    LocalDate localDate = LocalDate.parse(resultSet.getString(2));
                    String times = resultSet.getString(3);
                    String[] splitTimes = times.split(",");
                    LocalTime[] localTimes = new LocalTime[splitTimes.length];
                    for (int i = 0; i < localTimes.length; i++) {
                        localTimes[i] = LocalTime.parse(splitTimes[i]);
                    }
                    if (LocalDate.parse(date).equals(localDate) &&
                            (LocalTime.parse(String.valueOf(eventTimesEnd[eventTimesEnd.length - 1])).isAfter(localTimes[0]) && LocalTime.parse(String.valueOf(eventTimesStart[0])).isBefore(localTimes[localTimes.length - 1]))) {
                        return Constants.ALREADY_EXIST_TIME;
                    }
                }

                addDevelopment.setString(1, location);
                addDevelopment.setString(2, date);
                addDevelopment.setBoolean(3, false);
                addDevelopment.setString(4, description);
                addDevelopment.setString(5, type.name());
                addDevelopment.setInt(6, userId);

                addDevelopment.executeUpdate();

                resultSet = addDevelopment.getGeneratedKeys();
                if (resultSet.next()) {
                    int developmentId = resultSet.getInt(1);
                    for (int i = 0; i < eventNames.length; i++) {
                        addTimetable.setString(1, eventNames[i]);
                        addTimetable.setTime(2, eventTimesStart[i]);
                        addTimetable.setTime(3, eventTimesEnd[i]);
                        addTimetable.setInt(4, developmentId);
                        addTimetable.executeUpdate();
                    }
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "";
    }

    @Override
    public void deleteDevelopment(int[] developmentsId) {
        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQLRequests.DELETE_DEVELOPMENTS)) {
            for (int developmentId : developmentsId) {
                preparedStatement.setInt(1, developmentId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public HashMap<String, List<Time>> showDevelopmentDetails(int developmentId) {
        HashMap<String, List<Time>> developmentDetails = new HashMap<>();

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQLRequests.DEVELOPMENT_DETAILS)) {
            preparedStatement.setInt(1, developmentId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString(1);
                Time timeStart = resultSet.getTime(2);
                Time timeEnd = resultSet.getTime(3);
                developmentDetails.put(name, Arrays.asList(timeStart, timeEnd));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return developmentDetails;
    }
}
