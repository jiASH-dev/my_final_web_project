package by.jiash.Constants;

public class SQLRequests {
    public static String GLOBAL_FINDER_REQUEST = "select developments.id, " +
            "users.first_name, " +
            "users.last_name, " +
            "developments.location, " +
            "developments.date, " +
            "developments.passedStatus, " +
            "developments.description, " +
            "developments.type " +
            "from users " +
            "inner join developments on users.id = developments.user_id ";

    public static String GLOBAL_EDIT_REQUEST = "update users ";

    public static String SHOW_USER_DEVELOPMENTS_REQUEST = "select developments.id, " +
            "developments.location, " +
            "developments.date, " +
            "developments.passedStatus, " +
            "developments.description, " +
            "developments.type " +
            "from users " +
            "inner join developments on users.id = developments.user_id where users.id = ?";

    public static String GET_USER_ON_ID = "select id, first_name, last_name, login, email from users where id = ?";
    public static String GET_USER = "select id, first_name, last_name, login, email from users where login=? and password=?";
    public static String ADD_DEVELOPMENT = "insert into developments(location, date, passedStatus, description, type, user_id) values(?, ?, ?, ?, ?, ?)";
    public static String ADD_TIMETABLE = "insert into timetable(name, time_start, time_end, development_id) values(?, ?, ?, ?)";
    public static String GET_DEVELOPMENTS_AND_TIMETABLE = "select developments.id, developments.date, group_concat(timetable.time_start), group_concat(timetable.time_end) from developments" +
            " inner join timetable where developments.id = development_id" +
            " group by developments.id";
    public static String DELETE_DEVELOPMENTS = "delete from developments where id = ?";
    public static String DEVELOPMENT_DETAILS = "select name, time_start, time_end from timetable where development_id = ?";
    public static String CHECK_VALID_DATA = "select login from users where login=? or email=?";
    public static String CREATE_USER = "insert into users(first_name, last_name, login, password, email) values(?, ?, ?, ?, ?)";

    public static String FIRST_NAME_POSTSCRIPT = "set first_name = ? where id = ?";
    public static String LAST_NAME_POSTSCRIPT = "set last_name = ? where id = ?";
    public static String PASSWORD_POSTSCRIPT = "set password = ? where id = ?";
    public static String EMAIL_POSTSCRIPT = "set email = ? where id = ?";

    public static String TODAY_POSTSCRIPT = "where date=curdate()";
    public static String TOMORROW_POSTSCRIPT = "where date=date_add(curdate(), interval 1 day)";
    public static String SOON_POSTSCRIPT = "where date>date_add(curdate(), interval 1 day)";
    public static String PAST_POSTSCRIPT = "where date<curdate()";
    public static String ALL_POSTSCRIPT = "";
    public static String SELF_POSTSCRIPT = "where user_id = ?";
}