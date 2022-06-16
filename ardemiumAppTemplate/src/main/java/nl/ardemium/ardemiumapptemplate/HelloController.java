package nl.ardemium.ardemiumapptemplate;

import backend.Admin;
import backend.DatabaseConnection;
import backend.SessionUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class HelloController {
    DatabaseConnection databaseConnection = new DatabaseConnection();
    @FXML
    private TextField TextFieldEmail;
    @FXML
    private PasswordField PasswordFieldPassword;

    @FXML
    public void onButtonForgot(ActionEvent actionEvent) throws IOException {
        HelloApplication.underConstructionPopup();
    }

    @FXML
    public void onButtonSignup(ActionEvent actionEvent) throws IOException {
        HelloApplication.changeScreen(actionEvent,"signup-view.fxml");
    }

    @FXML
    public void onButtonLogin(ActionEvent actionEvent) throws IOException {
        int[] response = databaseConnection.validateUser(TextFieldEmail.getText(), PasswordFieldPassword.getText());
        if (response[0] == -1) {
            System.out.println("User not in database");
        } else if (response[0] == 0) {
            SessionUser sessionUser = SessionUser.getInstance();
            sessionUser.setUser(databaseConnection.getUser(response));
            HelloApplication.changeScreen(actionEvent,"user-view.fxml");
        } else if (response[0] == 1) {
            SessionUser sessionUser = SessionUser.getInstance();
            Admin admin = new Admin(databaseConnection.getUser(response));
            sessionUser.setUser(admin);
            HelloApplication.changeScreen(actionEvent,"admin-view.fxml");
        }
    }
}