import java.util.ArrayList;

public class Lecturer extends User {
    private ArrayList<Course> courses;
    private int totalStudent;
    private double balance;


    public Lecturer() {
    }

    public Lecturer(String firstName, String lastName, String email, String password, String phone, String image, boolean gender, String country) {
        super(firstName, lastName, email, password, phone, image, gender, country);
        Online_Course_Site.addLecturer(this);
    }

    public ArrayList<Course> getCourses() {

        return courses;


    }

    public void setCourses(ArrayList<Course> courses) {

        this.courses = courses;
    }

    public int getTotalStudent() {
        return totalStudent;
    }

    public void setTotalStudent(int totalStudent) {
        if (totalStudent < 0)
            throw new IllegalArgumentException("try again.(Negative Numbers are not Accepted)")
        else
            this.totalStudent = totalStudent;

    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance < 0)
            throw new IllegalArgumentException("try again.(Negative Numbers are not Accepted)");
        else
            this.balance=balance;
    }

    public void withDrawMoney(double value) {
        if (this.balance < value) {
             System.out.println("Insufficient Funds");
        } else
            this.balance -= value;
    }

    public void publicCourse(Course course) {
        this.courses.add(course);
    }
}
