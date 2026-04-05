package com.advancejava.mvc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ListUsers extends JPanel{
	private FormController controller;
	
	public ListUsers(JFrame frame) {
		setLayout(new BorderLayout());
		controller = new FormController();
		
		JPanel panel = new JPanel();
		add(panel,BorderLayout.NORTH);
		JButton button = new JButton("Back");
		panel.add(button);
		
		JTable table = new JTable();
		table.setModel(controller.retrieveUserData());
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane,BorderLayout.CENTER);
		
//		JTable table1 = new JTable();
//		table1.setModel(controller.retrieveUsers());
//		JScrollPane scrollPane1 = new JScrollPane(table1);
//		add(scrollPane1,BorderLayout.CENTER);
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().remove(ListUsers.this);
				frame.getContentPane().add(new DataForm());
				frame.getContentPane().setVisible(true);
			}
		});
	}

}
