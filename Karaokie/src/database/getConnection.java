package database;

import java.sql.*;

public class getConnection {
    private static Connection connect = null;
    private static Statement s = null;
    private static final String url = "jdbc:mysql://karaokie.cfc6ke0wsven.ap-southeast-2.rds.amazonaws.com/user";
    private static final String user = "root";
    private static final String password = "karaokie1234";
    public static void testConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(url, user, password);
            s = connect.createStatement();
            String sql = "select * from user.info";
            ResultSet rec = s.executeQuery(sql);
            System.out.println("Connect Success");
            while (rec.next()) {
                System.out.println(rec.getString("role"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (connect != null) {
                s.close();
                connect.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static String getRole(String username, String pass) {
        String sql = String.format("SELECT * FROM info WHERE id = '%s' AND password = '%s'", username, pass);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(url, user, password);
            s = connect.createStatement();
            ResultSet rec = s.executeQuery(sql);
            while (rec.next()) {
                return rec.getString("role");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResultSet getData(String sql) {
        ResultSet rec = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(url, user, password);
            s = connect.createStatement();
            rec = s.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rec;
    }
}
