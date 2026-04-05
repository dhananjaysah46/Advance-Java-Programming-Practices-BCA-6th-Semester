package com.advancejava;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class Menus extends JFrame {

    private JMenuBar menubar;
    private JMenu file, edit, view;
    private JMenuItem open, save, saveas;
    private ImageIcon image;

    public Menus() {
        setTitle("Menu Example");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Menu bar
        menubar = new JMenuBar();

        file = new JMenu("File");
        edit = new JMenu("Edit");
        view = new JMenu("View");

        menubar.add(file);
        menubar.add(edit);
        menubar.add(view);

        open = new JMenuItem("Open");
        save = new JMenuItem("Save");
        saveas = new JMenuItem("Save As");

        // Keyboard shortcut Ctrl+S
        save.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));

        file.add(open);
        file.add(save);
        file.add(saveas);

        // Correct way to add menu bar
        setJMenuBar(menubar);

        // Load image correctly
        String imagePath = "c:\\users\\images\\myimage.png";
        image = new ImageIcon(imagePath);

        JLabel label = new JLabel(image);
        add(label, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Menus();
    }
}