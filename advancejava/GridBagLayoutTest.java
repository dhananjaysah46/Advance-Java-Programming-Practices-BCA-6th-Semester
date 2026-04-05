package com.advancejava;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class GridBagLayoutTest extends JFrame{
	
	public GridBagLayoutTest() {
		setTitle("GridBag Layout Example");
		setSize(400,400);
		setLayout(new GridBagLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		gbc.insets = new Insets(2,2,2,2);
		add(new JButton("Button1"),gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		
		gbc.insets = new Insets(2,2,2,2);
		add(new JButton("Button2"),gbc);
		
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> 
		new GridBagLayoutTest().setVisible(true));

	}

}

