package nl.ardemium.ardemiumapptemplate;

import backend.DatabaseConnection;
import backend.User;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class editAccountController implements Initializable {
    @javafx.fxml.FXML
    private TextField HuidigeEmail;
    @javafx.fxml.FXML
    private TextField huidugeWachtwoord;
    @javafx.fxml.FXML
    private Button terugBtn;
    private static User user;
    @javafx.fxml.FXML
    private TextField phone;
    @javafx.fxml.FXML
    private TextField Name;
    @javafx.fxml.FXML
    private TextField points;

    @javafx.fxml.FXML
    public void onTerugButton(ActionEvent actionEvent) throws IOException {
        HelloApplication.changeScreen(actionEvent,"editaccounttabel-view.fxml");
    }

    @javafx.fxml.FXML
    public void onWijzigenButton(ActionEvent actionEvent) throws IOException {
        user.points = Integer.parseInt(points.getText());
        user.name = Name.getText();
        user.email = HuidigeEmail.getText();
        user.phone = phone.getText();
        user.password = huidugeWachtwoord.getText();
        DatabaseConnection dc = new DatabaseConnection();
        dc.changeUser(user);
    }

    public static void setUser(User u){
        user = u;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        huidugeWachtwoord.setText(user.password);
        HuidigeEmail.setText(user.email);
        phone.setText(user.phone);
        points.setText(String.valueOf(user.points));
        Name.setText(user.name);
    }
}
