package com.advancejava.mvc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DataForm extends JPanel implements ActionListener, FormViewInterface{
	
	private JLabel name,email,height,phone;
	private JTextField tname, temail, theight, tphone;
	public JButton submit,listUsers,edit,delete;
	private FormController controller;
	public DataForm() {
		controller = new FormController();
		setLayout(null);
		
		name = new JLabel("Full name");
		name.setBounds(300, 200, 100, 30);
		tname = new JTextField();
		tname.setBounds(400, 200, 100, 30);
		
		email = new JLabel("User Email");
		email.setBounds(300, 250, 100, 30);
		temail = new JTextField();
		temail.setBounds(400, 250, 100, 30);
		
		height = new JLabel("User height");
		height.setBounds(300, 300, 100, 30);
		theight = new JTextField();
		theight.setBounds(400, 300, 100, 30);
		
		phone = new JLabel("User phone");
		phone.setBounds(300, 350, 100, 30);
		tphone = new JTextField();
		tphone.setBounds(400, 350, 100, 30);
		
		submit = new JButton("Create User data");
		submit.setBounds(300, 400, 200, 30);
		
		listUsers = new JButton("Read Users");
		listUsers.setBounds(400, 500, 150, 40);
		
		edit = new JButton("Update User");
		edit.setBounds(200,500,150,40);
		
		delete = new JButton("Delete User");
		delete.setBounds(50,500,150,40);
		
		add(name); add(tname); add(email); add(temail); add(height);
		add(theight); add(submit); add(phone); add(tphone); add(listUsers); add(edit); add(delete);
		
		submit.addActionListener(this);
		
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("Insert the name you want to delete");
				int check = controller.deleteUserData(name);
					if(check == -1) {
						JOptionPane.showMessageDialog(delete, "Data deletion error");
					}else {
						JOptionPane.showMessageDialog(delete, "Data deleted successfully");
					}
			}
		});
		
		edit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel panel = new JPanel() {
		            @Override
		            public Dimension getPreferredSize() {
		                return new Dimension(420, 140);
		            }
		        };
				panel.setLayout(null);
				panel.setSize(500,500);
				
				JLabel label = new JLabel("Enter field name :");
				JLabel label1 = new JLabel("Enter old value: ");
				JLabel label2 = new JLabel ("Enter the new value: ");
				
				JTextField tf1 = new JTextField("1");
				JTextField tf2 = new JTextField("2");
				JTextField tf3 = new JTextField("3");
				
				label.setBounds(10,10,150,30);
				tf1.setBounds(150,10,150,30);
				
				label1.setBounds(10,50,150,30);
				tf2.setBounds(150,50,150,30);
				
				label2.setBounds(10,100,150,30);
				tf3.setBounds(150,100,150,30);
				
				panel.add(label); panel.add(label1); panel.add(label2); panel.add(tf1); panel.add(tf2); panel.add(tf3);
				
				panel.setVisible(true);
				
				int check = JOptionPane.showConfirmDialog(edit, panel,"Update data", JOptionPane.OK_CANCEL_OPTION);
				
				if(check == JOptionPane.OK_OPTION) {
					// check if the textfields are empty or not
					String field = tf1.getText().toString();
					String oldValue = tf2.getText().toString();
					String newValue = tf3.getText().toString();
					
					int value = controller.updateData(field,oldValue,newValue);
					
					if(value != -1) {
						JOptionPane.showMessageDialog(edit, "Data updated successfully");
					}
					
				}
				
			}
		});
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == submit) {
			
		String name = tname.getText().toString();
		String email = temail.getText().toString();
		String phone = tphone.getText().toString();
		String height = theight.getText().toString();
		
		if(name.isEmpty()) {
			tname.setBackground(Color.red);
		}else if(email.isEmpty()) {
			temail.setBackground(Color.red);
		}else if(phone.isEmpty()) {
			tphone.setBackground(Color.red);
		}else if(height.isEmpty()) {
			theight.setBackground(Color.red);
		}else if(Float.parseFloat(height) > 10) {
			theight.setBackground(Color.orange);
		}else {
			UserData user = new UserData(name,email,
					Float.parseFloat(height),
					Long.parseLong(phone));
			
			/// Call form controller submit method
			controller.submitData(user, this);
			
		}
	}
		
	}

	@Override
	public void onSuccess() {
		JOptionPane.showMessageDialog(submit, "Data inserted Successfully");
		tname.setText("");
		temail.setText("");
		theight.setText("");
		tphone.setText("");
		
	}

	@Override
	public void onFailure(String reason) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(submit, reason);

	}

}
