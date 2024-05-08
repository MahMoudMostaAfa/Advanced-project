package User;

import Course.Course;
import Main.Online_Course_Site;
import User.User;
import Utils.Validator;

import java.util.ArrayList;

public class Student extends User {
    private ArrayList<Course> enrolledCourses;
    private ArrayList<Course> wishList;
    private ArrayList<Course> finsihedCourse;
    private double wallet ;


    public Student() {
    }

    public Student(String firstName, String lastName, String email, String password, String phone, String image, boolean gender, String country) 
    {
        super(firstName, lastName, email, password, phone, image, gender, country);
        Online_Course_Site.addNewStudent(this);;
        enrolledCourses=new ArrayList<Course>();
        wishList=new ArrayList<Course>();
        finsihedCourse=new ArrayList<Course>();
    }

    @Override
    public void displayInfo() {
        System.out.println("User.Student Name is "+getFirstName()+" "+getLastName() );
        System.out.println("User.Student email is "+getEmail());
        System.out.println("User.Student balance is "+getWallet() );
        System.out.println("User.Student totalCourses is "+ enrolledCourses.size() );
        System.out.println("User.Student wishList courses is "+ wishList.size());
        System.out.println("User.Student joined at "+getJoinedAt() );

    }


    public ArrayList<Course> getEnrolledCourses()
    {
        return enrolledCourses;
    }

    public ArrayList<Course> getWishList() 
    {
        return wishList;
    }

    public ArrayList<Course> getFinsihedCourse()
    {
        return finsihedCourse;
    }


    public double getWallet() 
    {
        return wallet;
    }

    public void enrollNewCourse(Course course) throws IllegalArgumentException
    {
        if(this.wallet < course.getPrice())throw  new IllegalArgumentException("there is no enough money ... recharge your wallet");
        if(this.enrolledCourses.contains(course)) throw  new IllegalArgumentException("already enrolled in this course");
        this.enrolledCourses.add(course);
        this.wallet -= course.getPrice();
        course.newEnrolled(this);

    }
    public void withDrawCourse(Course course) throws IllegalArgumentException
    {   if(!this.enrolledCourses.contains(course)) throw  new IllegalArgumentException("this course is not enrolled yet");
        this.enrolledCourses.remove(course);
        course.newWithDraw(this);

    }
    public void addToWallet(double addedValue) throws IllegalArgumentException
    {
        if(addedValue<10)  throw new IllegalArgumentException("must add at least 10 pounds");
        this.wallet += addedValue;
    }
    public void addToWishList(Course course){
        this.wishList.add(course);
    }
    
    public  void deletestudentcourses()
    {
      
             for (int i = 0; i < enrolledCourses.size(); i++)
             {
                   enrolledCourses.get(i).deletestudent(this);
                  
             }
    }


}
