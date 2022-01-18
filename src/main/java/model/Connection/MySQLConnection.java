package model.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class MySQLConnection {
    private static final String DB_URL = "jdbc:mysql://localhost/finaltask?serverTimezone=Europe/Minsk";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    private static Connection cn;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            if (Objects.isNull(cn) || cn.isClosed()) {
                cn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cn;
    }

    public static void closeConnection () {
        if (Objects.nonNull(cn)) {
            try {
                cn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void closeStatement (Statement st) {
        if (Objects.nonNull(st)) {
            try {
                st.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
