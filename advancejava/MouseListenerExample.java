package com.advancejava;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MouseListenerExample extends JFrame implements MouseListener {
    
    JTextField t1, t2;
    JLabel output;
    JButton btn;
    
    public MouseListenerExample() {
        setTitle("Mouse Listener Logic Demo");
        setSize(800, 200);
        setLayout(new FlowLayout());
        
        add(new JLabel("Enter 1st number:"));
        t1 = new JTextField(10);
        add(t1);
        
        add(new JLabel("Enter 2nd number:"));
        t2 = new JTextField(10);
        add(t2);
        
        btn = new JButton("Output");
        add(btn);
        
        btn.addMouseListener(this);
        
        output = new JLabel("Result");
        add(output);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);    
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int a = Integer.parseInt(t1.getText());
        int b = Integer.parseInt(t2.getText());

        int smaller = Math.min(a, b);
        output.setText("Smaller Number: " + smaller);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int a = Integer.parseInt(t1.getText());
        int b = Integer.parseInt(t2.getText());

        int greater = Math.max(a, b);
        output.setText("Greater Number: " + greater);
    }

    // Required overrides (unused but mandatory)
    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        new MouseListenerExample();
    }
}
