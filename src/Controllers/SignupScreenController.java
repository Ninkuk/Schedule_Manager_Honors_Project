package Controllers;

import data.HandleData;
import data.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SignupScreenController implements Initializable {
    public Button backButton;
    public Button signupButton;
    public ComboBox<String> gradeLevelCB;
    public TextField fullNameField;
    public TextField asuriteidField;
    public TextField passwordField;
    public Label errorMessageLabel;


    String[] grades = {"Freshman", "Sophomore", "Junior", "Senior"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gradeLevelCB.getItems().addAll(grades);
    }

    public void validateSignup(ActionEvent event) throws Exception {
        String asuriteId = asuriteidField.getText();
        String fullName = fullNameField.getText();
        String password = passwordField.getText();
        String gradeLevel = gradeLevelCB.getValue();
        if (asuriteId.equalsIgnoreCase("") || fullName.equalsIgnoreCase("") || password.equalsIgnoreCase("") || gradeLevel == null) {
            errorMessageLabel.setText("Please enter all the fields to signup!");
            errorMessageLabel.setVisible(true);
        } else {
            errorMessageLabel.setText("");
            errorMessageLabel.setVisible(false);
            if (!HandleData.doesAccountExist(asuriteId)) {
                errorMessageLabel.setText("");
                errorMessageLabel.setVisible(false);

                Student student = new Student(asuriteId, fullName, password, gradeLevel);
                HandleData.addStudentToList(student);
                proceedToDashboard(event);
            } else {
                errorMessageLabel.setText("Account already exists!");
                errorMessageLabel.setVisible(true);
            }
        }
    }

    private void proceedToDashboard(ActionEvent event) throws Exception {
        //clears the form
        asuriteidField.setText("");
        fullNameField.setText("");
        passwordField.setText("");

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
