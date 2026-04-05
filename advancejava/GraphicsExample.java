package com.advancejava;
import javax.swing.*;
import java.awt.*;

public class GraphicsExample extends JPanel{

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.RED);
        g2.fillRect(20, 20, 100, 60);

        g2.setColor(Color.BLUE);
        g2.fillOval(150, 20, 80, 80);

        g2.setColor(Color.GREEN);
        g2.drawLine(20, 100, 250, 100);

        g2.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 18));
        g2.setColor(Color.MAGENTA);
        g2.drawString("Graphics2D Demo", 20, 150);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Graphics2D Example");
        frame.add(new GraphicsExample());
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}




