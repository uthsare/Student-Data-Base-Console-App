package com.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
        private static DBConnection instance;
        private final Connection connection;
        private static final String URL = "jdbc:mysql://localhost:3306/studentdb";
        private static final String USER = "root";
        private static final String PASSWORD = "1234";

        private DBConnection() throws SQLException {
            try {
                // Optionally, load the driver class explicitly (depends on driver and setup)
                Class.forName("com.mysql.cj.jdbc.Driver");
                this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException ex) {
                System.out.println("Database Driver not found: " + ex.getMessage());
                throw new SQLException(ex);
            }
        }

        public Connection getConnection() {
            return connection;
        }

        public static DBConnection getInstance() throws SQLException {
            if (instance == null) {
                synchronized (DBConnection.class) {
                    if (instance == null) {
                        instance = new DBConnection();
                    }
                }
            } else if (instance.getConnection().isClosed()) {
                instance = new DBConnection();
            }
            return instance;
        }
    }


