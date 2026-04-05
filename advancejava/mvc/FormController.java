package com.advancejava.mvc;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.table.DefaultTableModel;

public class FormController {
	private DBConnect db;
	
	public FormController() {
		try {
		db = new DBConnect();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void submitData(UserData user, FormViewInterface callback) {
		db.insertUser(user,new DatabaseCallback() {

			@Override
			public void onDataEntrySuccess() {
				callback.onSuccess();
				
			}

			@Override
			public void onDataEntryFailure(String error) {
				// TODO Auto-generated method stub
				callback.onFailure(error);
			}
			
		});
	}
	
	public int deleteUserData(String name) {
		return db.deleteUserData(name);
	}
	
	public int updateData(String fieldName, String old, String newValue) {
		return db.updateUserData(fieldName,old,newValue);
	}
	
	public DefaultTableModel retrieveUserData() {
		DefaultTableModel model = new DefaultTableModel();
		try {
		model.addColumn("ID");
		model.addColumn("Username");
		model.addColumn("Email");
		model.addColumn("Phone");
		model.addColumn("Height");
		ResultSet rs = db.retrieveUserList();
		while(rs.next()) {
			model.addRow(new Object [] {
					rs.getInt(1),rs.getString(2),rs.getString(3),
					rs.getFloat(4),rs.getString(5)
			});
		}
		
		}catch(Exception e) {
			System.out.println(e);
		}
		return model;
	}
	
	public DefaultTableModel retrieveUsers() {
		DefaultTableModel model = new DefaultTableModel();
		try {
		ResultSetMetaData metaData = db.retrieveResultSetUsers().getMetaData();
		for(int i=1; i<=metaData.getColumnCount(); i++) {
			model.addColumn(metaData.getColumnName(i));
		}
		ResultSet rs = db.retrieveResultSetUsers();
		while(rs.next()) {
			model.addRow(new Object [] {
					rs.getInt(1),rs.getString(2),rs.getString(3),
					rs.getFloat(4),rs.getString(5)
			});
		}
		}catch(Exception e) {
			System.out.println(e);
		}
		return model;
	}

}
