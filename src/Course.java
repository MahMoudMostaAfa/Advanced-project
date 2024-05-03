package com.example.demo;

import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Discountable, Comparable<Course> {

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

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        if (rate < 0 || rate > 5) {
            throw new IllegalArgumentException("Rate must be between 0 and 5");
        }
        this.rate = rate;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) throws IllegalArgumentException {
        if (discount < 0) {
            throw new IllegalArgumentException("Discount cannot be negative");
        }
        this.discount = discount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) throws IllegalArgumentException {
        if (category == null) {
            throw new IllegalArgumentException("Category cannot be null");
        }
        this.category = category;
    }

    public double getPrice()  {
        return price;
    }

    public void setPrice(double price) throws IllegalArgumentException {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) throws IllegalArgumentException {
        if (description == null) {
            throw new IllegalArgumentException("Description cannot be null");
        }
        this.description = description;
    }

    public int getTotalEnrolled() {
        return totalEnrolled;
    }

    public String getInstructorName() {
        return InstructorName;
    }

    public void setInstructorName(String instructorName) throws IllegalArgumentException {
        if (instructorName == null) {
            throw new IllegalArgumentException("InstructorName cannot be null");
        }
        for (int i = 0, len = instructorName.length(); i < len; i++) {
            char ch = instructorName.charAt(i);
            if(!Character.isLetter(ch)) {
                throw new IllegalArgumentException("InstructorName contains invalid characters");
            }
        }
        InstructorName = instructorName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalArgumentException {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) throws IllegalArgumentException {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        this.id = id;
    }

    public ArrayList<Quiz> getQuizzes() {
        return Quizzes;
    }

    public void addQuiz(Quiz quiz) throws IllegalArgumentException {
        Quizzes.add(quiz);
    }

    public void removeQuiz(Quiz quiz) throws IllegalArgumentException {
        Quizzes.remove(quiz);
    }

    public boolean isDiscountable(){
        return discount != 0;
    }

    public void newEnrolled() {
        totalEnrolled += 1;
    }

    @Override
    public int compareTo(Course o) {
        return this.id.compareTo(o.id);
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
    public static void main(String arg[]){
        Course c = new Course();
        c.setInstructorName("6ore");
    }

}
