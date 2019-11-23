package data;

import java.io.*;
import java.util.ArrayList;

public class HandleData {

    public static ArrayList<Student> studentsList;
    public static ArrayList<Course> coursesList;
    public static Student currentStudent;
    public static String fileUrl = "src/data/";

    public static void getStudentList() {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            fileInputStream = new FileInputStream(fileUrl + "students.data");
            objectInputStream = new ObjectInputStream(fileInputStream);

            //Deserialize Object
            studentsList = (ArrayList<Student>) objectInputStream.readObject();

        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException");
        } catch (IOException e) {
            System.err.println("IOException");
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException");
        } finally {
            try {
                if (objectInputStream != null) {
                    objectInputStream.close();
                    for (Student student : studentsList) {
                        System.out.println(student.getAsuriteId());
                    }
                }
            } catch (IOException e) {
                System.err.println("IOException");
            }
        }
    }

    public static void getCourseList() {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            fileInputStream = new FileInputStream(fileUrl + "courses.data");
            objectInputStream = new ObjectInputStream(fileInputStream);

            //Deserialize Object
            coursesList = (ArrayList<Course>) objectInputStream.readObject();

        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException");
        } catch (IOException e) {
            System.err.println("IOException");
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException");
        } finally {
            try {
                if (objectInputStream != null) {
                    objectInputStream.close();
                    for (Course course : coursesList) {
                        System.out.println(course.getTitle());
                    }
                }
            } catch (IOException e) {
                System.err.println("IOException");
            }
        }
    }

    public static void addStudentToList(Student student) {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(fileUrl);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            studentsList.add(student);

            // Serialize Student
            objectOutputStream.writeObject(studentsList);

        } catch (NotSerializableException e) {
            System.out.println("NotSerializableException");
        } catch (IOException ee) {
            System.out.println("IOException");
        } finally {
            try {
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                    setCurrentAccount(student);
                }

            } catch (IOException exc) {
                System.out.println("IOException");
            }
        }
    }

    public static void addCourse(Student student, Course course) {

    }

    public static Student getCurrentAccount() {
        return currentStudent;
    }

    public static void setCurrentAccount(Student student) {
        currentStudent = student;
    }

    public static boolean doesAccountExist(String asuriteId) {
        for (Student student : studentsList) {
            if (student.getAsuriteId().equalsIgnoreCase(asuriteId)) {
                return false;
            }
        }

        return true;
    }
}
