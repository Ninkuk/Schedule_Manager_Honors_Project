package Controllers;

import data.HandleData;
import data.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class LoginScreen {
    public Button backButton;
    public Button loginButton;
    public TextField asuriteidField;
    public TextField passwordField;
    public Label errorMessageLabel;

    public void validateLogin(ActionEvent event) throws Exception {
        String asuriteId = asuriteidField.getText();
        String password = passwordField.getText();
        if (asuriteId.equalsIgnoreCase("") || password.equalsIgnoreCase("")) {
            errorMessageLabel.setText("Please enter all the fields to login!");
            errorMessageLabel.setVisible(true);
        } else {
            errorMessageLabel.setText("");
            errorMessageLabel.setVisible(false);

            ArrayList<Student> studentsList = HandleData.studentsList;
            for (Student student : studentsList) {
                if (student.getAsuriteId().equalsIgnoreCase(asuriteId) && student.getPassword().equals(password)) {
                    proceedToDashboard(event);
                }
            }

            errorMessageLabel.setText("Incorrect username or password, please try again!");
            errorMessageLabel.setVisible(true);
        }
    }

    private void proceedToDashboard(ActionEvent event) throws Exception {
        //clears the form
        asuriteidField.setText("");
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
