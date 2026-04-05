package com.advancejava;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LayoutExample implements ActionListener{
	private JFrame f;
	private JButton submit;
	private JLabel uname, pwd;
	private JTextField tUname, tPwd;
	
	public LayoutExample() {
		f = new JFrame();
		f.setTitle("Login Form using Null Layout");
		f.setLayout(null); // default it has BorderLayout 
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(400,400);
		
		uname = new JLabel("Username :");
		uname.setBounds(100, 100, 100, 30);
		
		tUname = new JTextField();
		tUname.setBounds(200,100,100,30);
		
		pwd = new JLabel("Password :");
		pwd.setBounds(100, 150, 100, 30);
		
		tPwd = new JTextField();
		tPwd.setBounds(200, 150, 100, 30);
		
		submit = new JButton("Submit");
		submit.setBounds(150, 200, 100, 40);
		submit.addActionListener(this);
		
		f.add(submit);
		f.add(tUname);
		f.add(uname);
		f.add(tPwd);
		f.add(pwd);
		
		f.setVisible(true);
		
	}

	public static void main(String[] args) {
		// GUI AWT vs Swing 
		new LayoutExample();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = tUname.getText().toString();
		String pwd = tPwd.getText().toString();
		System.out.println(name +" "+pwd);
		
	}

}
