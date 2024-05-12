package com.example.oopjavafx.User;


import com.example.oopjavafx.Utils.Validator;

import java.util.Date;

public abstract class  User {
    public String getId() {
        return id;
    }

    private String id ;
    private String firstName;
    private String lastName;
    private String email ;
    private String password ;
    private String phone ;
    private String image ;
    private boolean gender ;
    private String country ;

    public Date getJoinedAt() {
        return joinedAt;
    }

    Date joinedAt ;
    public User(){
    }
    public User(String firstName, String lastName, String email, String password, String phone, String image, boolean gender, String country) throws IllegalArgumentException {
        if (!Validator.isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format: " + email);
        }
        if (!Validator.isValidPassword(password)) {
            throw new IllegalArgumentException("Invalid password format: " + password);
        }
        if( firstName==null || lastName ==null || email==null || password==null )  throw new IllegalArgumentException("name ,email and password is required  ");

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.image = image;
        this.gender = gender;
        this.country = country;
        this.joinedAt = new Date();
        this.id = new Date().toString();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws IllegalArgumentException  {
        if (!Validator.isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format: " + email);
        }

        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws IllegalArgumentException {
        if(!Validator.isValidPassword(password)) throw  new IllegalArgumentException("Invalid password format: " + password);
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    public abstract void displayInfo();


}
