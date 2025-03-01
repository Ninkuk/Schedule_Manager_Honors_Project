package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class StartScreenController {
    public Button loginButton;
    public Button signupButton;

    public void buttonToLoginScreen(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../res/layouts/LoginScreen.fxml"));
        Scene scene = new Scene(root, 1000, 650);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    public void buttonToSignupScreen(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../res/layouts/SignupScreen.fxml"));
        Scene scene = new Scene(root, 1000, 650);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
