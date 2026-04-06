package com.advancejava;
import javax.swing.*;

public class Question1 {
    public static void main(String[] args) {

        JFrame f = new JFrame("Simple Form");

        JLabel l1 = new JLabel("Name:");
        JLabel l2 = new JLabel("Email:");

        JTextField t1 = new JTextField();
        JTextField t2 = new JTextField();

        JButton b = new JButton("Submit");

        l1.setBounds(50, 50, 100, 30);
        t1.setBounds(150, 50, 150, 30);

        l2.setBounds(50, 100, 100, 30);
        t2.setBounds(150, 100, 150, 30);

        b.setBounds(150, 150, 100, 30);

        f.add(l1); f.add(t1);
        f.add(l2); f.add(t2);
        f.add(b);

        b.addActionListener(e -> {
            String name = t1.getText();
            String email = t2.getText();
            JOptionPane.showMessageDialog(f, "Name: " + name + "\nEmail: " + email);
        });

        f.setSize(400, 300);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}