package com.advancejava;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayoutExample implements ActionListener{
	public GridLayoutExample() {
		JFrame frame = new JFrame("Grid layout test");
		frame.setLayout(new GridLayout(3,3));
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.red);		
		JButton b1 = new JButton("Button 1");
		JButton b2 = new JButton("Button 2");
		JButton b3 = new JButton("Button 3");
		JButton b4 = new JButton("Button 4");
		JButton b5 = new JButton("Button 5");
		JButton b6 = new JButton("Button 6");
		JButton b7 = new JButton("Button 7");	
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);		
		frame.add(b1); frame.add(b2); frame.add(b3);
		frame.add(b4); frame.add(b5); frame.add(b6);
		frame.add(b7);		
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new GridLayoutExample();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Button pressed");
		
	}

}
