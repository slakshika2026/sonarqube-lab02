package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

public class UserService {

    private static final Logger logger = Logger.getLogger(UserService.class.getName());

    // Uses PreparedStatement to prevent SQL Injection
    public void findUser(String username) throws SQLException {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db", "root", System.getenv("DB_PASSWORD"))) {
            String query = "SELECT * FROM users WHERE name = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, username);
                stmt.executeQuery();
            }
        }
    }


    // Uses PreparedStatement to prevent SQL Injection
    public void deleteUser(String username) throws SQLException {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db", "root", System.getenv("DB_PASSWORD"))) {
            String query = "DELETE FROM users WHERE name = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, username);
                stmt.execute();
            }
        }
    }
}


