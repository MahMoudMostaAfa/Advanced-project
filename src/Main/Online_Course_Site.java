package Main;

import Course.Course;
import User.Lecturer;
import User.Student;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Online_Course_Site {
    private static int totalUsersNum;
    private static int totalCourseNum;
   private static ArrayList<Student> students = new ArrayList<>();
   private static ArrayList<Lecturer> lecturers = new ArrayList<>();
   private static ArrayList<Course> courses = new ArrayList<>();
   private static Queue<Course> lastReleasedCourses = new LinkedList<Course>();


    public static int getTotalUsersnum() {
        return totalUsersNum;
    }


    public static void incrementTotalUsersNum() {
        totalUsersNum ++;
    }
    public static void incrementTotalCoursesNum() {
        totalUsersNum ++;
    }

    public int getTotalCoursesnum() {
        return totalUsersNum;
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
    public static ArrayList<Lecturer> getLecturers() {
        return lecturers;
    }

    public void setLecturers(ArrayList<Lecturer> Lecturers) {
        this.lecturers = Lecturers;
    }

    public Queue<Course> getLastReleasedCourses() {
        return lastReleasedCourses;
    }

    public static void addNewCourse(Course e) {

        courses.add(e);
       if(lastReleasedCourses.size() > 4)
       {
           lastReleasedCourses.poll();

       }
        lastReleasedCourses.add(e);
    }


     public static void  deleteStudent(Student student )
     {
         students.remove(student);
         totalUsersNum--;
     }
    public static void  deleteLecturer(Lecturer lecturer )
    {
        lecturers.remove(lecturer);
        totalUsersNum--;
    }






}
