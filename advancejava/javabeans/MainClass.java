package com.advancejava.javabeans;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserBean user = new UserBean();
		
		user.setEmail("vs@gmail.com");
		user.setName("VS College");
		user.setAge(21);
		
		System.out.println(user.getName() +", "+ user.getEmail()+", "+user.getAge());

	}

}