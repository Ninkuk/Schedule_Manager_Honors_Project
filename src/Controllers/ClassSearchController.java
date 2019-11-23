package Controllers;

import data.Course;
import data.HandleData;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ClassSearchController implements Initializable {
    public TableView<Course> classSearchTable;
    public TableColumn<Course, String> title;
    public TableColumn<Course, String> classCode;
    public TableColumn<Course, Integer> days;
    public TableColumn<Course, String> startTime;
    public TableColumn<Course, String> endTime;
    public TableColumn<Course, Integer> units;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Course> courses = HandleData.coursesList;

        title.setCellFactory(new PropertyValueFactory<>("title"));
        classSearchTable.setItems(courses);
    }
}
