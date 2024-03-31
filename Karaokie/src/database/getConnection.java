package database;

import java.sql.*;
import java.time.*;
import java.time.format.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class getConnection {
    private static Connection connect = null;
    private static Statement s = null;
    private static final String URL = "jdbc:mysql://karaokie.cfc6ke0wsven.ap-southeast-2.rds.amazonaws.com/user";
    private static final String USER = "root";
    private static final String PASSWORD = "karaokie1234";
    private static String sql;
    private static ResultSet rec;
    public static ResultSet getData(String sql) {
        ResultSet rec = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement ps = connect.prepareStatement(sql);
            rec = ps.executeQuery(sql);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return rec;
    }
    public static double getCost(String date) {
        double total = 0;
        sql = "SELECT SUM(amount) AS total_amount FROM stat WHERE DATE(time) = '" + date + "'";
        rec = getData(sql);
        try {
            if (rec.next()) {
                total = rec.getDouble("total_amount");
            }
        } catch (SQLException ex) {
            Logger.getLogger(getConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }
    public static double getCost(String start, String end) {
        double total = 0;
        sql = "SELECT SUM(amount) AS total_amount FROM stat WHERE DATE(time) BETWEEN '" + start + "' AND '" + end + "'";
        rec = getData(sql);
        try {
            if (rec.next()) {
                total = rec.getDouble("total_amount");
            }
        } catch (SQLException ex) {
            Logger.getLogger(getConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }
    public static double getCost(int month) {
        double total = 0;
        sql = "SELECT SUM(amount) AS total_amount FROM stat WHERE YEAR(time) = YEAR(CURRENT_DATE()) AND MONTH(time) = " + month;
        rec = getData(sql);
        try {
            if (rec.next()) {
                total = rec.getDouble("total_amount");
            }
        } catch (SQLException ex) {
            Logger.getLogger(getConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }
    public static String[] getInfo(String username, String password) {
        sql = String.format("SELECT * FROM info WHERE id = '%s' AND password = '%s';", username, password);
        rec = getData(sql);
        String[] temp = new String[2];
        try {
            if (rec.next()) {
                temp[0] = rec.getString("id");
                temp[1] = rec.getString("role");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return temp;
    }
    
    public static void addData(double cost) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        sql = String.format("INSERT INTO stat (time, amount) VALUES ('%s', '%s');", dtf.format(LocalDateTime.now()), cost);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(URL, USER, PASSWORD);
            s = connect.createStatement();
            s.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
