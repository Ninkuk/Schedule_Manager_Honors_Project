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
import java.util.ResourceBundle;

public class MyScheduleController implements Initializable {
    public TableView<Course> myScheduleTable;
    public TableColumn<Course, String> titleColumn;
    public TableColumn<Course, Integer> classCodeColumn;
    public TableColumn<Course, String> daysColumn;
    public TableColumn<Course, String> startTimeColumn;
    public TableColumn<Course, String> endTimeColumn;
    public TableColumn<Course, Integer> unitsColumn;

    public Button dropCourseButton;
    public Label errorMessageLabel;

    public void removeCourseFromStudent() {
        Course courseSelected = myScheduleTable.getSelectionModel().getSelectedItem();
        if (courseSelected == null) {
            errorMessageLabel.setText("Please select a course first");
            errorMessageLabel.setTextFill(Color.web("#f44336"));
            errorMessageLabel.setVisible(true);
        } else {
            for (int i = 0; i < HandleData.currentStudent.getCourses().size(); i++) {
                if (courseSelected.getClassCode() == HandleData.currentStudent.getCourses().get(i).getClassCode()) {
                    HandleData.currentStudent.getCourses().remove(i);
                    errorMessageLabel.setText("Course successfully dropped");
                    errorMessageLabel.setTextFill(Color.web("#00bfa5"));
                    errorMessageLabel.setVisible(true);
                    updateTable();
                }
            }
            HandleData.saveStudentChanges();
        }

    }

    private void updateTable() {
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        classCodeColumn.setCellValueFactory(new PropertyValueFactory<>("classCode"));
        daysColumn.setCellValueFactory(new PropertyValueFactory<>("days"));
        startTimeColumn.setCellValueFactory(new PropertyValueFactory<>("start"));
        endTimeColumn.setCellValueFactory(new PropertyValueFactory<>("end"));
        unitsColumn.setCellValueFactory(new PropertyValueFactory<>("units"));
        myScheduleTable.setItems(FXCollections.observableArrayList(HandleData.currentStudent.getCourses()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateTable();
    }
}
