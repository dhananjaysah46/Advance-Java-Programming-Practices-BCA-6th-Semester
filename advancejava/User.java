package com.advancejava;

public class User {

    private String name;
    private String email;
    private String password;
    private String gender;
    private String city;

    public User(String name, String email, String password, String gender, String city) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.city = city;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getGender() { return gender; }
    public String getCity() { return city; }
}
