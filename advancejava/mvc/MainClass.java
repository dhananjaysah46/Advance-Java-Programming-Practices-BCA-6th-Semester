package com.advancejava.mvc;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class MainClass extends JFrame implements ActionListener{
	private DataForm dataForm;
	public MainClass() {
		dataForm = new DataForm();
		setSize(800,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(dataForm);
		setVisible(true);
		
		dataForm.listUsers.addActionListener(this);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainClass();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		remove(dataForm);
		setBackground(Color.white);
		add(new ListUsers(this));
		setVisible(true);
		
	}

}
