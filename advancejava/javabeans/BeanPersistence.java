package com.advancejava.javabeans;

import java.io.*;

public class BeanPersistence {

	public static void main(String[] args) {
		UserBean user = new UserBean();
		user.setName("New User Dhananjay");
		user.setEmail("Dhananjay@gmail.com");
		user.setAge(20);
		
		// Serialize the bean
		try (ObjectOutputStream out = 
				new ObjectOutputStream(new FileOutputStream("userbean"))){
			out.writeObject(user);
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		
		// Deserialize the bean
		try(ObjectInputStream in = 
				new ObjectInputStream(new FileInputStream("userbean"))){
			UserBean retrieve = (UserBean) in.readObject();
			System.out.println("Retrieved user "+retrieve);
		}catch(Exception e) {
			System.out.println(e.toString());
		}

	}

}
