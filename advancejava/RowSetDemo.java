package com.advancejava;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class RowSetDemo {

    public static void main(String[] args) {

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create JdbcRowSet object
            JdbcRowSet rowSet = RowSetProvider.newFactory()
                                             .createJdbcRowSet();

            // Set MySQL database connection details
            rowSet.setUrl("jdbc:mysql://localhost:3306/college");
            rowSet.setUsername("root");
            rowSet.setPassword("root");

            // SQL query
            rowSet.setCommand("SELECT * FROM student");

            // Execute query
            rowSet.execute();

            // Display records
            while (rowSet.next()) {
                System.out.println("Roll No : " + rowSet.getInt("rollno"));
                System.out.println("Name    : " + rowSet.getString("name"));
                System.out.println("Marks  : " + rowSet.getFloat("marks"));
                System.out.println("-------------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
