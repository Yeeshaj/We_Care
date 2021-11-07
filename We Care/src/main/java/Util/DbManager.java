package Util;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
public class DbManager {
	public static Connection createConnection() {
        String databaseURL = "jdbc:mysql://localhost:3306/Tables";
        String user = "root";
        String password = "root";
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(databaseURL, user, password);
            if (conn != null) {
                System.out.println("Connected to the database");
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Could not find database driver class");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
		return conn;
    }
}
