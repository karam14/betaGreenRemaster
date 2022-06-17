package nl.ardemium.ardemiumapptemplate;

import backend.SessionUser;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ShopViewController implements Initializable {
    @javafx.fxml.FXML
    private Button returnButton;
    @javafx.fxml.FXML
    private Text points;

    @javafx.fxml.FXML
    public void onReturnButton(ActionEvent actionEvent) throws IOException {
        HelloApplication.changeScreen(actionEvent,"rewardsUser-view.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        points.setText(String.valueOf(SessionUser.getInstance().getUser().points));

    }
}
