package nl.ardemium.ardemiumapptemplate;

import backend.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SignupController {
    DatabaseConnection databaseConnection = new DatabaseConnection();
    @javafx.fxml.FXML
    private TextField textFieldName;
    @javafx.fxml.FXML
    private PasswordField textFieldConfirmPassword;
    @javafx.fxml.FXML
    private TextField textFieldPhone;
    @javafx.fxml.FXML
    private TextField textFieldEmail;
    @javafx.fxml.FXML
    private PasswordField textFieldPassword;

    @javafx.fxml.FXML
    public void onButtonSignup(ActionEvent actionEvent) {
        try {
            if(databaseConnection.userExcist(textFieldEmail.getText())){
                System.out.println("Email excists");
            }
            else if (textFieldPassword.getText().equals(textFieldConfirmPassword.getText())) {
                databaseConnection.saveUser(textFieldEmail.getText(), textFieldPassword.getText(), textFieldName.getText(), textFieldPhone.getText());
            }
            else {
                System.out.println("password not equals");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void onButtonLogin(ActionEvent actionEvent) throws IOException {
        HelloApplication.changeScreen(actionEvent,"hello-view.fxml");
    }
}