package database;

import java.sql.*;
import java.time.*;
import java.time.format.*;

public class getConnection {
    private static Connection connect = null;
    private static Statement s = null;
    private static final String URL = "jdbc:mysql://karaokie.cfc6ke0wsven.ap-southeast-2.rds.amazonaws.com/user";
    private static final String USER = "root";
    private static final String PASSWORD = "karaokie1234";
    private static String sql;
    public static ResultSet getData(String sql) {
        ResultSet rec = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(URL, USER, PASSWORD);
            s = connect.createStatement();
            rec = s.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rec;
    }
    public static String getRole(String username, String password) {
        sql = String.format("SELECT * FROM info WHERE id = '%s' AND password = '%s';", username, password);
        ResultSet rec = getData(sql);
        try {
            while (rec.next()) {
                return rec.getString("role");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public static void addData() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        sql = String.format("INSERT INTO stat (time, cost) VALUES ('%s', 500);", dtf.format(LocalDateTime.now()));
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(URL, USER, PASSWORD);
            s = connect.createStatement();
            s.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void getHour() {
        sql = "SELECT * FROM stat WHERE DATE_FORMAT(time, '%H') = HOUR(CURTIME());";
    }
}
