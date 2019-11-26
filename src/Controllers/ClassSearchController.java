package Controllers;

import data.Course;
import data.HandleData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ClassSearchController implements Initializable {
    public TableView<Course> classSearchTable;
    public TableColumn<Course, String> titleColumn;
    public TableColumn<Course, String> classCodeColumn;
    public TableColumn<Course, String> daysColumn;
    public TableColumn<Course, String> startTimeColumn;
    public TableColumn<Course, String> endTimeColumn;
    public TableColumn<Course, Integer> unitsColumn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        classCodeColumn.setCellValueFactory(new PropertyValueFactory<>("classCode"));
        daysColumn.setCellValueFactory(new PropertyValueFactory<>("days"));
        startTimeColumn.setCellValueFactory(new PropertyValueFactory<>("start"));
        endTimeColumn.setCellValueFactory(new PropertyValueFactory<>("end"));
        unitsColumn.setCellValueFactory(new PropertyValueFactory<>("units"));
        classSearchTable.setItems(getCourses());
//        classSearchTable.getColumns().addAll(titleColumn, classCodeColumn, daysColumn, startTimeColumn, endTimeColumn, unitsColumn);
    }

    public ObservableList<Course> getCourses() {
        ObservableList<Course> courses = FXCollections.observableArrayList(HandleData.coursesList);
//        courses.add(new Course("bookTitle1", "230", 2, "today", "tomorrow", 5));
//        courses.add(new Course("bookTitle2", "230", 2, "today", "tomorrow", 5));
//        courses.add(new Course("bookTitle3", "230", 2, "today", "tomorrow", 5));
//        courses.add(new Course("bookTitle4", "230", 2, "today", "tomorrow", 5));

        return courses;
    }
}
