package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SignupScreen implements Initializable {
    public Button backButton;
    public Button signupButton;
    public ComboBox<String> gradeLevelCB;

    String[] grades = {"Freshman", "Sophomore", "Junior", "Senior"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gradeLevelCB.getItems().addAll(grades);
    }

    public void buttonToDashboard(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../res/layouts/StudentDashboard.fxml"));
        Scene scene = new Scene(root, 1000, 650);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    public void backToStartScreen(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../res/layouts/StartScreen.fxml"));
        Scene scene = new Scene(root, 1000, 650);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
