package Controllers;

import data.Course;
import data.HandleData;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;

import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class ClassSearchController implements Initializable {
    public TableView<Course> classSearchTable;
    public TableColumn<Course, String> titleColumn;
    public TableColumn<Course, Integer> classCodeColumn;
    public TableColumn<Course, String> daysColumn;
    public TableColumn<Course, String> startTimeColumn;
    public TableColumn<Course, String> endTimeColumn;
    public TableColumn<Course, Integer> unitsColumn;

    public Button addCourseButton;
    public Label errorMessageLabel;

    public void addCourseToStudent() {
        Course courseSelected = classSearchTable.getSelectionModel().getSelectedItem();

        if (courseSelected == null) {
            errorMessageLabel.setText("Please select a course first");
            errorMessageLabel.setTextFill(Color.web("#f44336"));
            errorMessageLabel.setVisible(true);
        } else if (doesCourseAlreadyExist(courseSelected)) {
            errorMessageLabel.setText("Course already added to schedule");
            errorMessageLabel.setTextFill(Color.web("#f44336"));
            errorMessageLabel.setVisible(true);
        } else if (isScheduleConflicting(courseSelected)) {
            errorMessageLabel.setText("Course conflicting with another class. Please remove it from your schedule or select another class.");
            errorMessageLabel.setTextFill(Color.web("#f44336"));
            errorMessageLabel.setVisible(true);
        } else {
            HandleData.currentStudent.addCourse(courseSelected);
            HandleData.saveStudentChanges();

            //TODO: Add timer to remove message after a second

            errorMessageLabel.setText("Course Added Successfully!");
            errorMessageLabel.setTextFill(Color.web("#00bfa5"));
            errorMessageLabel.setVisible(true);
        }
    }

    private boolean isScheduleConflicting(Course courseSelected) {
        for (Course course : HandleData.currentStudent.getCourses()) {
            LocalTime startTimeList = course.getStart();
            LocalTime endTimeList = course.getEnd();
            LocalTime startTimeSelected = courseSelected.getStart();
            LocalTime endTimeSelected = courseSelected.getEnd();
            if (courseSelected.getDays().size() == course.getDays().size()) {
                if ((startTimeSelected.isAfter(startTimeList) && startTimeSelected.isBefore(endTimeList)) || (endTimeSelected.isAfter(startTimeList) && endTimeSelected.isBefore(endTimeList))) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean doesCourseAlreadyExist(Course courseSelected) {
        for (Course course : HandleData.currentStudent.getCourses()) {
            if (courseSelected.getClassCode() == course.getClassCode()) {
                return true;
            }
        }
        return false;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        classCodeColumn.setCellValueFactory(new PropertyValueFactory<>("classCode"));
        daysColumn.setCellValueFactory(new PropertyValueFactory<>("days"));
        startTimeColumn.setCellValueFactory(new PropertyValueFactory<>("start"));
        endTimeColumn.setCellValueFactory(new PropertyValueFactory<>("end"));
        unitsColumn.setCellValueFactory(new PropertyValueFactory<>("units"));
        classSearchTable.setItems(FXCollections.observableArrayList(HandleData.coursesList));
    }
}
