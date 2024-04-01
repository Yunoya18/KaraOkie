package database;

import java.sql.*;
import java.time.*;
import java.time.format.*;
import java.util.ArrayList;
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
    //oneline statement
    public static ResultSet getData(String sql) {
        ResultSet rec = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement ps = connect.prepareStatement(sql);
            rec = ps.executeQuery();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return rec;
    }
    //prepared statement
    public static ResultSet getData(PreparedStatement ps) {
        ResultSet rec = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            rec = ps.executeQuery();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return rec;
    }
    //day
    public static ArrayList<Double> getCostWeekly(ArrayList<String> allDate) throws SQLException {
        ArrayList<Double> total = new ArrayList<>();
        sql = "SELECT SUM(amount) AS total_amount FROM stat WHERE DATE(time) = ?";
        connect = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement ps = connect.prepareStatement(sql);
        for (String date : allDate) {
            ps.setString(1, date);
            rec = getData(ps);
            while (rec.next()) {
                total.add(rec.getDouble("total_amount"));
            }
        }
        return total;
    }
    //week
    public static ArrayList<Double> getCostMonthly(ArrayList<String> allDate) throws SQLException {
        ArrayList<Double> total = new ArrayList<>();
        sql = "SELECT SUM(amount) AS total_amount FROM stat WHERE DATE(time) BETWEEN ? AND ?";
        connect = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement ps = connect.prepareStatement(sql);
        for (int i = 0; i < (allDate.size()/2); i+=2) {
            ps.setString(1, allDate.get(i));
            ps.setString(2, allDate.get(i+1));
            rec = getData(ps);
            while (rec.next()) {
                total.add(rec.getDouble("total_amount"));
            }
        }
        return total;
    }
    //month
    public static ArrayList<Double> getCostYearly() throws SQLException {
        ArrayList<Double> total = new ArrayList<>();
        sql = "SELECT SUM(amount) AS total_amount FROM stat WHERE YEAR(time) = YEAR(CURRENT_DATE()) AND MONTH(time) = ?";
        connect = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement ps = connect.prepareStatement(sql);
        for (int i = 1; i <= 12; i++) {
            ps.setString(1, String.valueOf(i));
            rec = getData(ps);
            while (rec.next()) {
                total.add(rec.getDouble("total_amount"));
            }
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
    //add total from customer
    public static void addAmount(double cost) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        sql = String.format("INSERT INTO stat (time, amount) VALUES ('%s', '%s');", dtf.format(LocalDateTime.now()), cost);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(URL, USER, PASSWORD);
            s = connect.createStatement();
            s.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
