package data;

import java.io.*;
import java.util.ArrayList;

public class HandleData {

    public static ArrayList<Student> studentsList = new ArrayList<>();
    public static ArrayList<Course> coursesList = new ArrayList<>();
    public static Student currentStudent;
    public static String fileUrl = "src/data/";

    public static void getStudentListFromFile() {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            fileInputStream = new FileInputStream(fileUrl + "students.data");
            objectInputStream = new ObjectInputStream(fileInputStream);

            //Deserialize Object
            studentsList = (ArrayList<Student>) objectInputStream.readObject();

        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException(Students.data) - possibly due to no users, create a user to instantiate the file");
        } catch (IOException e) {
            System.err.println("IOException students");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException Students");
        } finally {
            try {
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
            } catch (IOException e) {
                System.err.println("IOException");
            }
        }
    }

    public static void getCourseListFromFile() {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            fileInputStream = new FileInputStream(fileUrl + "courses.data");
            objectInputStream = new ObjectInputStream(fileInputStream);

            //Deserialize Object
            coursesList = (ArrayList<Course>) objectInputStream.readObject();

        } catch (FileNotFoundException e) {
            createNewCourses();
        } catch (IOException e) {
            System.err.println("IOException");
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException Course");
        } finally {
            try {
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
            } catch (IOException e) {
                System.err.println("IOException");
            }
        }
    }

    private static void createNewCourses() {
        String[] courseTitles = {"CSE 110", "CSE 205", "FSE 100", "ASU 101", "ENG 101", "MAT 266"};
        int[] courseHours = {3, 3, 2, 1, 3, 3,};
        for (int i = 0; i < courseTitles.length; i++) {
            for (int j = 0; j < 4; j++) {
                Course course = new Course(courseTitles[i], courseHours[i]);
                addCourseToList(course);
            }
        }
    }

    public static void addStudentToList(Student student) {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(fileUrl + "students.data");
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

    public static void addCourseToList(Course course) {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(fileUrl + "courses.data");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            coursesList.add(course);

            // Serialize Student
            objectOutputStream.writeObject(coursesList);

        } catch (NotSerializableException e) {
            System.out.println("NotSerializableException");
        } catch (IOException ee) {
            System.out.println("IOException");
        } finally {
            try {
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }

            } catch (IOException exc) {
                System.out.println("IOException");
            }
        }
    }

    public static Student getCurrentAccount() {
        return currentStudent;
    }

    public static void setCurrentAccount(Student student) {
        currentStudent = student;
    }

    /**
     * @param asuriteId
     * @return false if account does not exists and true if it does.
     */
    public static boolean doesAccountExist(String asuriteId) {
        try {
            for (Student student : studentsList) {
                if (student.getAsuriteId().equalsIgnoreCase(asuriteId)) {
                    return true;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public static void saveStudentChanges() {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(fileUrl + "students.data");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

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
                }

            } catch (IOException exc) {
                System.out.println("IOException");
            }
        }
    }
}
