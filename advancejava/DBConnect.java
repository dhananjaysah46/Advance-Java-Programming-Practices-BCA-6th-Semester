package com.advancejava;

import java.sql.*;

public class DBConnect {

    private Connection conn;

    public DBConnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/vs?serverTimezone=UTC",
                "root",
                "root"
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void registerUser(User user) {
        try {
            String sql = """
                INSERT INTO users (name, email, password, gender, city)
                VALUES (?, ?, ?, ?, ?)
            """;

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getGender());
            pstmt.setString(5, user.getCity());

            pstmt.executeUpdate();

            System.out.println("User registered: " + user.getName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
