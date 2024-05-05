import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Online_Course_Site {
    private static int totalUsersnum;
    private static int totalCoursesnum;
   private static ArrayList<Student> students = new ArrayList<>();
   private static ArrayList<Lecturer> lecturers = new ArrayList<>();
   private static ArrayList<Course> courses = new ArrayList<>();
   private static Queue<Course> lastReleasedCourses = new LinkedList<Course>();
      static int counter =0;

    public static int getTotalUsersnum() {
        return totalUsersnum;
    }

    public static void setTotalUsersnum(int totalUsersnum) {
        totalUsersnum = totalUsersnum;
    }
    public static void incrementTotalUsersnum() {
        totalUsersnum ++;
    }
    public static void incrementTotalCoursesnum() {
        totalCoursesnum ++;
    }

    public int getTotalCoursesnum() {
        return totalCoursesnum;
    }

    public static void setTotalCoursesnum(int totalCoursesnum) {
        totalCoursesnum = totalCoursesnum;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public static void addStudent(Student a){
        Online_Course_Site.students.add(a);
    }
    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public static void addLecturer(Lecturer a){
        Online_Course_Site.lecturers.add(a);
    }
    public ArrayList<Lecturer> getLecturers() {
        return lecturers;
    }

    public void setLecturers(ArrayList<Lecturer> Lecturers) {
        this.lecturers = Lecturers;
    }

    public Queue<Course> getLastReleasedCourses() {
        return lastReleasedCourses;
    }

    public static void addnewcourse(Course e) {
        lastReleasedCourses.add(e);
        courses.add(e);
       counter++;
       if(counter > 5)
       {
           lastReleasedCourses.poll();
       }
    }
    
    
    
    
     public static Student createStudent(String firstName, String lastName, String email, String password, String phone, String image, boolean gender, String country)
     {
         return new Student(firstName, lastName, email, password, phone, image, true, country);
     }
     public static Lecturer createLecturer(String firstName, String lastName, String email, String password, String phone, String image, boolean gender, String country)
     {
         return new Lecturer(firstName, lastName, email, password, phone, image, true, country);
     }
     public static void  deleteStudent(Student user )
     {
         
         
             students.remove(user);
             user.deletestudentcourses();
         
         totalUsersnum--;
         
         user=null;
     }
    
     public void editUser()
     {
         //using setters of user class
     }
      public void deleteCourse(Student st,Course cou)
     {
         st.deletecourse(cou);
         cou.deletestudent(st);
         
     }
}
