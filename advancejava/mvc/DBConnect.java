package com.advancejava.mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {
	public Connection con;
	private String formTable = "form_table";
	private String books = "books";
	public DBConnect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.
				getConnection("jdbc:mysql://localhost:3306/vscollege","root","root");
		System.out.println("Database connected & Table Created");
		String sql = "create table if not exists "+formTable+" (id int primary key "
				+ "auto_increment, "
				+ "name varchar(30), email varchar(30), "
				+ "height decimal(3,2), phone varchar(12))";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.execute();
		
		String sql1 = "create table if not exists "+books+" (id int primary key "
				+ "auto_increment, "
				+ "name varchar(30), email varchar(30), "
				+ "height decimal(3,2), phone varchar(12))";
		PreparedStatement stmt1 = con.prepareStatement(sql1);
		stmt1.execute();
		
		System.out.println("Table Created");
	}
	
	public int deleteUserData(String name) {
		
		try {
			String sql = "delete from "+formTable+" where name='"+name+"'";
			PreparedStatement stmt1 = con.prepareStatement(sql);
			int check = stmt1.executeUpdate();
			return check;
		}catch (Exception e) {
			return -1;
		}
	}
	
	public int updateUserData(String fieldName, String old, String newValue) {
		try {
		String sql = "update "+formTable+" set "+fieldName+"='"+newValue+"' where "+fieldName+"= '"+old+"'";
		System.out.println(sql);
		PreparedStatement stmt1 = con.prepareStatement(sql);
		int check = stmt1.executeUpdate();
		return check;
		}catch(Exception e) {
			return -1;
		}
	}
	
	public void insertUser(UserData user, DatabaseCallback callback) {
		try {
		String sql = "insert into "+formTable+"(name,email,height,phone) values (?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, user.getName());
		stmt.setString(2, user.getEmail());
		stmt.setFloat(3, user.getHeight());
		stmt.setString(4, String.valueOf(user.getPhone()));
		int check = stmt.executeUpdate();
		if(check != -1) {
			callback.onDataEntrySuccess();
		}else {
			callback.onDataEntryFailure("Unable to enter sql data");
		}
		}catch(Exception e) {
			callback.onDataEntryFailure(String.valueOf(e));
		}
		
	}
	
	public ResultSet retrieveUserList() throws SQLException {
		String sql = "select * from "+formTable;
		Statement stmt = con.createStatement();
		return stmt.executeQuery(sql);
	}
	
	// update table set name = ... where id = ... ;
	public ResultSet retrieveResultSetUsers() throws Exception{
		String query = "select * from "+formTable;
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = stmt.executeQuery(query);
		return rs;
	}

}
