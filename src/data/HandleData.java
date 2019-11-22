package data;

import java.io.*;
import java.util.ArrayList;

public class HandleData {

    public static ArrayList<Student> studentsList;
    public static Student currentStudent;
    public static String fileUrl = "src/data/students.data";

    public static void getList() {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            fileInputStream = new FileInputStream(fileUrl);
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

    public static void addStudent(Student student) {
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
                if (objectOutputStream != null) objectOutputStream.close();
            } catch (IOException exc) {
                System.out.println("IOException");
            }
        }
    }

    public static void addCourse(Student student, Course course) {

    }

    public static Student getAccount() {
        return currentStudent;
    }

    public static void setAccount(Student student) {

    }

    public static boolean doesAccountExist(String asuriteId) {
        for (Student student : studentsList) {
            if (student.getAsuriteId().equalsIgnoreCase(asuriteId)) {
                return false;
            }
        }

        return true;
    }

    public static Student getStudent(String asuriteId) {
        for (Student student : studentsList) {
            if (student.getAsuriteId().equalsIgnoreCase(asuriteId)) {
                return student;
            }
        }
        return null;
    }
}
