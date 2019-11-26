package data;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
    private String asuriteId;
    private String fullName;
    private String password;
    private String gradeLevel;
    private ArrayList<Course> courses;

    public Student(String asuriteId, String fullName, String password, String gradeLevel) {
        this.asuriteId = asuriteId;
        this.fullName = fullName;
        this.password = password;
        this.gradeLevel = gradeLevel;
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public String getAsuriteId() {
        return asuriteId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }
}
