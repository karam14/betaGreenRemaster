package nl.ardemium.ardemiumapptemplate;

import backend.SessionUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RewardsUserController implements Initializable {
    public Button returnButton;
    public Text points;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        points.setText(String.valueOf(SessionUser.getInstance().getUser().points));

    }
    public void shopOnClick(ActionEvent actionEvent) throws IOException {
      HelloApplication.changeScreen(actionEvent,"shop-view.fxml");
    }

    public void onReturnButton(ActionEvent actionEvent) throws IOException {
        HelloApplication.changeScreen(actionEvent,"homeUser-view.fxml");
    }
}
