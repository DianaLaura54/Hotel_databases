package mysql;

import mysql.view.shopView2;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {
    private final String driver;
    private final String dbName;
    private final String connectionURL;
    private final String ssl;
    private final String username;
    private final String password;
    private shopView2 view;

    public DataBaseConnection() {
        driver = "com.mysql.cj.jdbc.Driver";
        connectionURL = "jdbc:mysql://localhost:3306/";
        dbName = "mainn";
        ssl = "?autoReconnect=true&useSSL=false";
        username = "root";
        password = "fizica";
    }

    public Connection getConnection() throws Exception {
        Class.forName(driver);

        return DriverManager.getConnection(connectionURL + dbName + ssl, username, password);
    }

    public static void main(String[] args) {
        DataBaseConnection db = new DataBaseConnection();
        try {
            Connection conn = db.getConnection();
            System.out.println("Database successfully connected!");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}