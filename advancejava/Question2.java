package com.advancejava;

import javax.swing.*;

public class Question2 {
    public static void main(String[] args) {

        JFrame f = new JFrame("Message Example");
        JButton b = new JButton("Click Me");

        b.setBounds(100, 100, 120, 40);

        f.add(b);

        b.addActionListener(e -> {
            JOptionPane.showMessageDialog(f, "Button Clicked!");
        });

        f.setSize(300, 300);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}