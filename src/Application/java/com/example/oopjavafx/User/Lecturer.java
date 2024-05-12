package com.example.oopjavafx.User;


import com.example.oopjavafx.Course.Course;
import com.example.oopjavafx.Main.Online_Course_Site;

import java.util.ArrayList;

public class Lecturer extends User {
    private ArrayList<Course> courses;
    private int totalStudent;
    private double balance;


    public Lecturer() {
    }

    public Lecturer(String firstName, String lastName, String email, String password, String phone, String image, boolean gender, String country) {
        super(firstName, lastName, email, password, phone, image, gender, country);
        Online_Course_Site.addNewLecturer(this);
    }
    @Override
    public void displayInfo() {
        System.out.println("lecturer Name is "+getFirstName()+" "+getLastName() );
        System.out.println("lecturer email is "+getEmail());
        System.out.println("lecturer balance is "+getBalance() );
        System.out.println("User.Lecturer totalCourses is "+ courses.size() );
        System.out.println("lecturer joined at "+getJoinedAt() );

    }

    public ArrayList<Course> getCourses() {

        return courses;


    }



    public int getTotalStudent() {
        return totalStudent;
    }



    public double getBalance() {
        return balance;
    }



    public void withDrawMoney(double value) throws IllegalArgumentException {
       if(this.balance < value)  throw  new IllegalArgumentException("Insufficient Funds");
       this.balance -= value;
    }
    public void increaseTotalStudent(){
        this.totalStudent++;
    }
    public void DecreaseTotalStudent(){
        this.totalStudent--;
    }
    public void increaseBalance(double value){
        this.balance+=value;
    }
    public void publicCourse(String name ,String description, double price, String category) {
        String instructorName=this.getFirstName()+" "+this.getLastName() ;
        Course course= new Course(name,description,price,instructorName,category);
        this.courses.add(course);

    }

    // function that return certain lecturer by passing its name
    public static Lecturer getLecturerByName(String lecturerName){
        ArrayList<Lecturer>  lecturers=  Online_Course_Site.getLecturers();
        for ( int i=0 ; i < lecturers.size() ;i++){
            String totalName = lecturers.get(i).getFirstName()+" "+lecturers.get(i).getLastName();
            if( lecturerName.equals(totalName) ) return lecturers.get(i);

        }
        return null;
    }
}
