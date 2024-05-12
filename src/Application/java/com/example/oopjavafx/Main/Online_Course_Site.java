package com.example.oopjavafx.Main;

import com.example.oopjavafx.Course.Course;
import com.example.oopjavafx.User.Lecturer;
import com.example.oopjavafx.User.Student;
import com.example.oopjavafx.User.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Online_Course_Site {
    private static int totalUsersNum;
    private static int totalCourseNum;
   private static ArrayList<Student> students = new ArrayList<Student>();
   private static ArrayList<Lecturer> lecturers = new ArrayList<Lecturer>();

    public static ArrayList<Course> getCourses() {
        return courses;
    }

    private static ArrayList<Course> courses = new ArrayList<Course>();

   private static Queue<Course> lastReleasedCourses = new LinkedList<Course>();

    public static User getLoginUser() {
        return loginUser;
    }

    public static User loginUser;
   private  static  boolean  logged =false;

    public static int getTotalUsersnum() {
        return totalUsersNum;
    }


    public static int getTotalCoursesNum() {
        return totalUsersNum;
    }


    public static ArrayList<Student> getStudents() {
        return students;
    }

    public static void addNewStudent(Student a){
        Online_Course_Site.students.add(a);
        Online_Course_Site.totalUsersNum++;
    }

    public static ArrayList<Lecturer> getLecturers() {
        return lecturers;
    }

    public static Queue<Course> getLastReleasedCourses() {
        return lastReleasedCourses;
    }


    public static void addNewLecturer(Lecturer a){
        Online_Course_Site.lecturers.add(a);
        Online_Course_Site.totalUsersNum++;
    }

    public static void addNewCourse(Course e) {
        totalCourseNum++;
        courses.add(e);
       if(lastReleasedCourses.size() > 4)
       {
           lastReleasedCourses.poll();

       }
        lastReleasedCourses.add(e);
    }


     public static void  deleteStudent(Student s)
     {
         students.remove(s);
         s=null;
         totalUsersNum--;
         // delete student from students array in StudentObject
     }
    public static void  deleteLecturer(Lecturer lecturer )
    {
        lecturers.remove(lecturer);
        lecturer=null;
        totalUsersNum--;
    }

    public  static void logInAsStudent(String email,String password) throws IllegalArgumentException{
        for(int i=0 ; i<students.size() ;i++){
            if(students.get(i).getEmail().equalsIgnoreCase(email) && students.get(i).getPassword().equals(password) ){
                loginUser=students.get(i);
                logged=true;
                return;
            } ;
        }

        throw new IllegalArgumentException("Student is not exits or may be email or password are incorrect");
    }
    public  static void logInAsLecturer(String email,String password) throws IllegalArgumentException{
        for(int i=0 ; i<lecturers.size() ;i++){
            if(lecturers.get(i).getEmail().equalsIgnoreCase(email) && lecturers.get(i).getPassword().equals(password) ){
                loginUser=lecturers.get(i);
                logged=true;
                return;
            } ;
        }

        throw new IllegalArgumentException("Lecturer is not exits or may be email or password are incorrect");
    }
    public static void  logOut(){
        loginUser=null;
        logged=false;
    }






}
