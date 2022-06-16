package nl.ardemium.ardemiumapptemplate;

import backend.SessionUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @javafx.fxml.FXML
    public void onButtonLogout(ActionEvent actionEvent) throws IOException {
        SessionUser.getInstance().clearUser();
        HelloApplication.changeScreen(actionEvent,"hello-view.fxml");
    }

    @javafx.fxml.FXML
    public void onButtonSettings(ActionEvent actionEvent) throws IOException {
        HelloApplication.changeScreen(actionEvent, "settings-view.fxml");
    }

    @javafx.fxml.FXML
    public void onButtonTrip(ActionEvent actionEvent) {
    }
}