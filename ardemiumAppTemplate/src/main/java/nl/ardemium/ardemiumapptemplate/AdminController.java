package nl.ardemium.ardemiumapptemplate;

import backend.SessionUser;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
    @javafx.fxml.FXML
    private Label labelTest;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SessionUser.getInstance().getAdmin().admin = true;
        labelTest.setText("A deity or a god\n is a supernatural being\n who is considered\n divine or sacred or " + SessionUser.getInstance().getAdmin().name);
    }

    @javafx.fxml.FXML
    public void onButtonLogout(ActionEvent actionEvent) throws IOException {
        SessionUser.getInstance().clearUser();
        HelloApplication.changeScreen(actionEvent,"hello-view.fxml");
    }

    @javafx.fxml.FXML
    public void onButtonSettings(ActionEvent actionEvent) throws IOException {
        HelloApplication.changeScreen(actionEvent,"settings-view.fxml");
    }

    @javafx.fxml.FXML
    public void onButtonManageUsers(ActionEvent actionEvent) throws IOException {
        HelloApplication.changeScreen(actionEvent, "manage-view.fxml");
    }
}