package com.advancejava;

import java.sql.*;

public class Question4 {
    public static void main(String[] args) {
        try {
            // Load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create connection
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bca",
                "root", "root"
            );

            // Prepare statement
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO student(id, name) VALUES (?, ?)"
            );

            ps.setInt(1, 101);
            ps.setString(2, "Cheetah");

            ps.executeUpdate();

            System.out.println("Record Inserted Successfully");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}