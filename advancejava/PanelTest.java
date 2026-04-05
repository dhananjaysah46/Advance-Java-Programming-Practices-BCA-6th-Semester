package com.advancejava;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelTest {
	private JFrame frame;
	private JPanel panel;
	public PanelTest() {
		frame = new JFrame("Panel test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		frame.getContentPane().setBackground(Color.BLUE);
		
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		JButton b1 = new JButton("Button 1");
		JButton b2 = new JButton("Button 2");
		JButton b3 = new JButton("Button 3");
		JButton b4 = new JButton("Button 4");
		JButton b5 = new JButton("Button 5");
		JButton b6 = new JButton("Button 6");
		JButton b7 = new JButton("Button 7");
		
		frame.add(panel, BorderLayout.CENTER);
		panel.add(b1); panel.add(b2); panel.add(b3); panel.add(b4);
		panel.add(b5); panel.add(b6); panel.add(b7);
		
		frame.setVisible(true);
		
	}

	public static void main(String[] args) {
		new PanelTest();

	}
}
