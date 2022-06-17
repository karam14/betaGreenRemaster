package nl.ardemium.ardemiumapptemplate;

import backend.SessionUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeAdminController {
    @javafx.fxml.FXML
    private Button settings;
    @javafx.fxml.FXML
    private Button editAccount;
    @javafx.fxml.FXML
    private Button scoreBoard;
    @javafx.fxml.FXML
    private ImageView plus;
    @javafx.fxml.FXML
    private Button signOutButton;

    @javafx.fxml.FXML
    public void onSettingsButton(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("settings-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 335, 600);
        stage.setScene(scene);
        stage.show();    }

    @javafx.fxml.FXML
    public void onScoreBoardButton(ActionEvent actionEvent) {
        HelloApplication.underConstructionPopup();
    }

    @javafx.fxml.FXML
    public void onEditAccountButton(ActionEvent actionEvent) throws IOException {
        HelloApplication.changeScreen(actionEvent,"editaccounttabel-view.fxml");
    }

    @javafx.fxml.FXML
    public void onSignOutButtonAction(ActionEvent actionEvent) throws IOException {
        SessionUser.getInstance().clearUser();
        HelloApplication.changeScreen(actionEvent,"login-view.fxml");
    }


}
