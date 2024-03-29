package database;

import java.sql.*;

public class getConnection {
    public static void main(String[] args) {
        Connection connect = null;
        Statement statement = null;
        String host = "jdbc:mysql://karaokie.cfc6ke0wsven.ap-southeast-2.rds.amazonaws.com/user";
        String user = "root";
        String password = "karaokie1234";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(host, user, password);
            statement = connect.createStatement();
            String sql = "select * from user.info";
            ResultSet rec = statement.executeQuery(sql);
            System.out.println("Connect Success");
            while (rec.next()) {
                System.out.println(rec.getString("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (connect != null) {
                statement.close();
                connect.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
