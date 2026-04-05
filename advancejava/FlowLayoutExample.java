package com.advancejava;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutExample extends JFrame {

    private JButton b1, b2, b3, b4, b5;

    public FlowLayoutExample() {
        setTitle("Flow Layout Example");
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set FlowLayout
        setLayout(new FlowLayout());

        b1 = new JButton("Button 1");
        b2 = new JButton("Button 2");
        b3 = new JButton("Button 3");
        b4 = new JButton("Button 4");
        b5 = new JButton("Button 5");

        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);

        setVisible(true);
    }

    public static void main(String[] args) {
        new FlowLayoutExample();
    }
}
