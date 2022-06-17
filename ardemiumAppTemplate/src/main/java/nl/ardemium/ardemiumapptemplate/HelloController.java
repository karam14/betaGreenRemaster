package nl.ardemium.ardemiumapptemplate;

import backend.Admin;
import backend.DatabaseConnection;
import backend.SessionUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;
import java.io.IOException;

public class HelloController {
    DatabaseConnection databaseConnection = new DatabaseConnection();
    @FXML
    private TextField emailTextField;
    @FXML
    private PasswordField passwordPasswordField;

    @FXML
    public void onSignUpButtonAction(ActionEvent actionEvent) throws IOException {
        HelloApplication.changeScreen(actionEvent,"register-view.fxml");

    }

    @FXML
    public void onForgotButtonAction(ActionEvent actionEvent) {
        HelloApplication.underConstructionPopup();

    }

    @FXML
    public void onLoginButtonAction(ActionEvent actionEvent) throws IOException {
        int[] response = databaseConnection.validateUser(emailTextField.getText(), passwordPasswordField.getText());
        if (response[0] == -1) {
            System.out.println("User not in database");
        } else if (response[0] == 0) {
            SessionUser sessionUser = SessionUser.getInstance();
            sessionUser.setUser(databaseConnection.getUser(response));
            HelloApplication.changeScreen(actionEvent,"homeUser-view.fxml");
        } else if (response[0] == 1) {
            SessionUser sessionUser = SessionUser.getInstance();
            Admin admin = new Admin(databaseConnection.getUser(response));
            sessionUser.setAdmin(admin);
            HelloApplication.changeScreen(actionEvent,"homeAdmin-view.fxml");
        }
    }
}