package Controllers;

import data.HandleData;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentDashboardController implements Initializable {

    public BorderPane dashboardBP;
    public Button classSearchButton;
    public Button signoutButton;
    public Label userName;

    public int viewState = 1;

    public void switchToClassSearch() throws Exception {
        VBox homeView = FXMLLoader.load(getClass().getResource("../res/layouts/ClassSearchView.fxml"));
        dashboardBP.setCenter(homeView);
        dashboardBP.setAlignment(dashboardBP.getCenter(), Pos.TOP_CENTER);
        viewState = 1;
    }

    public void signoutToStartScreen(ActionEvent event) throws Exception {
        HandleData.setCurrentAccount(null);

        Parent root = FXMLLoader.load(getClass().getResource("../res/layouts/StartScreen.fxml"));
        Scene scene = new Scene(root, 1000, 650);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userName.setText(HandleData.currentStudent.getFullName());
        classSearchButton.fire();
    }
}
