package com.example.demo;

import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Discountable {
    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTotalEnrolled() {
        return totalEnrolled;
    }

    public String getInstructorName() {
        return InstructorName;
    }

    public void setInstructorName(String instructorName) {
        InstructorName = instructorName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Quiz> getQuizzes() {
        return Quizzes;
    }

    public void addQuiz(Quiz quiz){
        Quizzes.add(quiz);
    }

    public void removeQuiz(Quiz quiz){
        Quizzes.remove(quiz);
    }

    private String id;
    ArrayList<Quiz> Quizzes = new ArrayList<Quiz>();
    private String name;
    private String InstructorName;
    private int totalEnrolled;
    private String description;
    private double price;
    private String category;
    private int discount;
    private double rate;

    public boolean isDiscountable(){
        return discount != 0;
    }

    public void newEnrolled(){
        totalEnrolled += 1;
    }

    public Course(String id, String category, String description, double price, String instructorName, String name) {
        this.id = id;
        this.rate = 0;
        this.discount = 0;
        this.category = category;
        this.description = description;
        this.price = price;
        this.totalEnrolled = 0;
        InstructorName = instructorName;
        this.name = name;
    }

    public Course() {
        this.id = null;
        this.rate = 0;
        this.discount = 0;
        this.category = null;
        this.description = null;
        this.price = 0;
        this.totalEnrolled = 0;
        InstructorName = null;
        this.name = null;
    }
}
