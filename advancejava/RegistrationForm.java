package com.advancejava;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class RegistrationForm extends JFrame implements ActionListener {

    private JTextField tName, tEmail;
    private JPasswordField tPassword;
    private JRadioButton male, female;
    private JComboBox<String> cityBox;
    private JButton submit;

    private DBConnect db;

    public RegistrationForm() {

        db = new DBConnect();
        setTitle("Registration Form");
        setSize(450, 450);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel name = new JLabel("Name:");
        JLabel email = new JLabel("Email:");
        JLabel password = new JLabel("Password:");
        JLabel gender = new JLabel("Gender:");
        JLabel city = new JLabel("City:");

        name.setBounds(50, 40, 100, 30);
        email.setBounds(50, 90, 100, 30);
        password.setBounds(50, 140, 100, 30);
        gender.setBounds(50, 190, 100, 30);
        city.setBounds(50, 250, 100, 30);

        tName = new JTextField();
        tEmail = new JTextField();
        tPassword = new JPasswordField();

        tName.setBounds(150, 40, 180, 30);
        tEmail.setBounds(150, 90, 180, 30);
        tPassword.setBounds(150, 140, 180, 30);

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");

        male.setBounds(150, 190, 80, 30);
        female.setBounds(240, 190, 80, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        String[] cities = {"Kathmandu", "Bhaktapur", "Lalitpur", "Pokhara"};
        cityBox = new JComboBox<>(cities);
        cityBox.setBounds(150, 250, 180, 30);

        submit = new JButton("Register");
        submit.setBounds(160, 320, 120, 35);
        submit.addActionListener(this);

        add(name); add(email); add(password); add(gender); add(city);
        add(tName); add(tEmail); add(tPassword);
        add(male); add(female);
        add(cityBox); add(submit);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String name = tName.getText();
        String email = tEmail.getText();
        String password = new String(tPassword.getPassword());
        String gender = male.isSelected() ? "Male" : "Female";
        String city = cityBox.getSelectedItem().toString();

        User user = new User(name, email, password, gender, city);
        db.registerUser(user);

        JOptionPane.showMessageDialog(this, "Registration Successful!");
    }

    public static void main(String[] args) {
        new RegistrationForm();
    }
}
