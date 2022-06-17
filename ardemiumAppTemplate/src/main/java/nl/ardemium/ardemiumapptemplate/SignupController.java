package nl.ardemium.ardemiumapptemplate;

import backend.DatabaseConnection;
import backend.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class SignupController {
    DatabaseConnection databaseConnection = new DatabaseConnection();
    @javafx.fxml.FXML
    private PasswordField password;
    @javafx.fxml.FXML
    private TextField phone;
    @javafx.fxml.FXML
    private TextField fullName;
    @javafx.fxml.FXML
    private PasswordField confirmPassword;
    @javafx.fxml.FXML
    private TextField email;


    @javafx.fxml.FXML
    public void onSignInButtonAction(ActionEvent actionEvent) throws IOException {
        HelloApplication.changeScreen(actionEvent, "login-view.fxml");

    }

    @javafx.fxml.FXML
    public void onSignUpButtonAction(ActionEvent actionEvent) {
        try {
            if (databaseConnection.userExcist(email.getText())) {
                System.out.println("Email excists");
            } else if (password.getText().equals(confirmPassword.getText())) {
                ArrayList<User> userdb = databaseConnection.getUserdb();
                User u = new User(userdb.size(), false);
                u.email = email.getText();
                u.password = password.getText();
                u.name = fullName.getText();
                u.phone = phone.getText();
                u.points = 0;
                u.goals = new Integer[0];
                databaseConnection.saveUser(u);
            } else {
                System.out.println("password not equals");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}