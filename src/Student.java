import java.util.ArrayList;

public class Student extends User {
    private ArrayList<Course> enrolledCourses;
    private ArrayList<Course> wishList;
    private ArrayList<Course> finsihedCourse;
    private double wallet ;


    public Student() {
        Online_Course_Site.addStudent(this);
        enrolledCourses=new ArrayList<>();
        wishList=new ArrayList<>();
        finsihedCourse=new ArrayList<>();
    }

    public Student(String firstName, String lastName, String email, String password, String phone, String image, boolean gender, String country) 
    {
        super(firstName, lastName, email, password, phone, image, gender, country);
        Online_Course_Site.addStudent(this);
        enrolledCourses=new ArrayList<>();
        wishList=new ArrayList<>();
        finsihedCourse=new ArrayList<>();
    }


    public ArrayList<Course> getEnrolledCourses()
    {
        return enrolledCourses;
    }

    public void setEnrolledCourses(ArrayList<Course> enrolledCourses) 
    {
        this.enrolledCourses = enrolledCourses;
    }

    public ArrayList<Course> getWishList() 
    {
        return wishList;
    }

    public void setWishList(ArrayList<Course> wishList) 
    {
        this.wishList = wishList;
    }

    public ArrayList<Course> getFinsihedCourse()
    {
        return finsihedCourse;
    }

    public void setFinsihedCourse(ArrayList<Course> finsihedCourse)
    {
        this.finsihedCourse = finsihedCourse;
    }

    public double getWallet() 
    {
        return wallet;
    }

    public void setWallet(double wallet) 
    {
        this.wallet = wallet;
    }
    public void enrollNewCourse(Course course)
    {
        if(this.wallet < course.getPrice()) return; // exception
        this.enrolledCourses.add(course);
        this.wallet -= course.getPrice();
        course.newEnrolled(this);

    }
    public void withDrawCourse(Course course)
    {
        this.enrolledCourses.remove(course);

    }
    public void addToWallet(double addedValue)
    {
        if(addedValue<=0) return;
        this.wallet += addedValue;
    }
    
    public  void deletecourse(Course c)
    {
        this.enrolledCourses.remove(c);
    }
    public  void deletestudentcourses()
    {
      
             for (int i = 0; i < enrolledCourses.size(); i++)
             {
                   enrolledCourses.get(i).deletestudent(this);
                  
             }
    }
}
