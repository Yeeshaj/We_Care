package Util;
import java.sql.*;
import java.sql.SQLException;


import com.mysql.*;

public class DbManager {
	
	private final String driverName = "com.mysql.cj.jdbc.Driver";
    private final String connectionUrl = "jdbc:mysql://127.0.0.1:3306/TABLES?autoReconnect=true&useSSL=false";
    private final String userName = "root";
    private final String userPass = "root";

    private java.sql.Connection con = null;

    public DbManager() {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        }
    }

    public Connection createConnection() {
        try {
            con =  DriverManager.getConnection(connectionUrl, userName, userPass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public void closeConnection() {
        try {
            this.con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
