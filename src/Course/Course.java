package Course;

import Main.Online_Course_Site;
import User.Lecturer;
import User.Student;

import java.util.ArrayList;
import java.util.Date;

public class Course implements Discountable, Comparable<Course> {

    private String id;
    ArrayList<Quiz> quizzes ;
    private  ArrayList<Student> courseStudents;
    private String name;
    private String InstructorName;
    private int totalEnrolled;
    private String description;
    private double price;
    private String category;
    private int discount;
    private double  discountablePrice ;
    private double rate;
    public Course() {

    }
    public Course(  String name ,String description, double price, String instructorName, String category) {

        this.name = name;
        this.discount = 0;
        this.category = category;
        this.description = description;
        this.price = price;
        InstructorName = instructorName;
        this.id = new Date().toString();
        this.courseStudents = new ArrayList<Student>();
        this.quizzes=new ArrayList<Quiz>();

        Online_Course_Site.addNewCourse(this);
        Online_Course_Site.incrementTotalCoursesnum();
    }


    public double getRate() {
        return rate;
    }

    public void setRate(double rate) throws IllegalArgumentException {
        if (rate < 0 || rate > 5) {
            throw new IllegalArgumentException("Rate must be between 0 and 5");
        }
        this.rate = rate;
    }

    public int getDiscount() {
        return discount;
    }


    // by percentage
    public void setDiscount(int discount) throws IllegalArgumentException {
        if (discount < 0) {
            throw new IllegalArgumentException("Discount cannot be negative");
        }
        this.discount = discount;
        this.discountablePrice =   (double) this.price/ (1+(discount/100)) ;

    }

    public String getCategory() {
        return category;
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
        if (description.length() < 15) {
            throw new IllegalArgumentException("Description must be 15 letter at least");
        }
        this.description = description;
    }

    public int getTotalEnrolled() {
        return totalEnrolled;
    }

    public String getInstructorName() {
        return InstructorName;
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


    public void setId(String id) throws IllegalArgumentException {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        this.id = id;
    }

    public ArrayList<Quiz> getQuizzes() {
        return quizzes;
    }

    public void addQuiz(Quiz quiz) throws IllegalArgumentException {
        quizzes.add(quiz);
    }

    public void removeQuiz(Quiz quiz) throws IllegalArgumentException {
        quizzes.remove(quiz);
    }

    public boolean isDiscountable(){
        return discount != 0;
    }

    public void newEnrolled(Student s) {
        totalEnrolled += 1;
        courseStudents.add(s);
        Lecturer.getLecturerByName(this.InstructorName).increaseTotalStudent();
       Lecturer.getLecturerByName(this.InstructorName).increaseBalance(this.price);

    }
    public void newWithDraw(Student s) {
        totalEnrolled -= 1;
        courseStudents.remove(s);
        Lecturer.getLecturerByName(this.InstructorName).DecreaseTotalStudent();

    }

    @Override
    public int compareTo(Course o) {
        return this.id.compareTo(o.id);
    }



    public  ArrayList<Student> getCourse_students() {
        return courseStudents;
    }

    public void setCourse_students(ArrayList<Student> course_students) {
        this.courseStudents = course_students;
    }

   

}

