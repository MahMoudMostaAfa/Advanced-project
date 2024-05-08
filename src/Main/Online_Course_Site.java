package Main;

import Course.Course;
import User.Lecturer;
import User.Student;
import User.User;

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
    private static User loginUser;
    private static boolean logged = false;

    public static int getTotalUsersnum() {
        return totalUsersNum;
    }

    public int getTotalCoursesNum() {
        return totalUsersNum;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public static void addNewStudent(Student a) {
        Online_Course_Site.students.add(a);
        Online_Course_Site.totalUsersNum++;
    }

    public static ArrayList<Lecturer> getLecturers() {
        return lecturers;
    }

    public Queue<Course> getLastReleasedCourses() {
        return lastReleasedCourses;
    }

    public static void addNewLecturer(Lecturer a) {
        Online_Course_Site.lecturers.add(a);
        Online_Course_Site.totalUsersNum++;
    }

    public static void addNewCourse(Course e) {
        totalCourseNum++;
        courses.add(e);
        if (lastReleasedCourses.size() > 4) {
            lastReleasedCourses.poll();

        }
        lastReleasedCourses.add(e);
    }

    public static void deleteStudent(Student student) {
        students.remove(student);
        totalUsersNum--;

        students.remove(user);
        user.deletestudentcourses();

        user = null;
    }

    public static void deleteLecturer(Lecturer lecturer) {
        lecturers.remove(lecturer);
        totalUsersNum--;
    }

    public static void logInAsStudent(String email, String password) throws IllegalArgumentException {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getEmail().equalsIgnoreCase(email) && students.get(i).getPassword().equals(password)) {
                loginUser = students.get(i);
                logged = true;
                return;
            }
            ;
        }

        throw new IllegalArgumentException("Student is not exits or may be email or password are incorrect");
    }

    public static void logInAsLecturer(String email, String password) throws IllegalArgumentException {
        for (int i = 0; i < lecturers.size(); i++) {
            if (lecturers.get(i).getEmail().equalsIgnoreCase(email)
                    && lecturers.get(i).getPassword().equals(password)) {
                loginUser = lecturers.get(i);
                logged = true;
                return;
            }
            ;
        }

        throw new IllegalArgumentException("Lecturer is not exits or may be email or password are incorrect");
    }

    public static void logOut() {
        loginUser = null;
        logged = false;
    }

}
