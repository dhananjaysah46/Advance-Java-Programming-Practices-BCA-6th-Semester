package com.advancejava;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsTest extends JPanel{
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.blue);
		g.drawRect(100, 100, 200, 100);
		
		g.setColor(Color.GREEN);
		g.drawString("This is graphics", 200, 300);
		
		g.setColor(Color.RED);
		g.fillOval(400, 400, 400, 200);
		
		int a[] = {100, 150, 200, 175, 125};
        int b[] = {400, 350, 400, 450, 450};
		g.drawPolygon(a, b, 5);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Drawing graphics");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.add(new GraphicsTest());
		
		frame.setVisible(true);

	}

}
