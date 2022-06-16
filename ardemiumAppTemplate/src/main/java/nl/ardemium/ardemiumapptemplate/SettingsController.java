package nl.ardemium.ardemiumapptemplate;

import backend.DatabaseConnection;
import backend.SessionUser;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController implements Initializable {

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
    public void onButtonChangePhone(ActionEvent actionEvent) throws IOException {
        SessionUser.getInstance().getUser().phone = textFieldPhone.getText();
        databaseConnection.changeUser(SessionUser.getInstance().getUser());
    }

    @javafx.fxml.FXML
    public void onButtonChangeName(ActionEvent actionEvent) throws IOException {
        SessionUser.getInstance().getUser().name = textFieldName.getText();
        databaseConnection.changeUser(SessionUser.getInstance().getUser());
    }

    @javafx.fxml.FXML
    public void onButtonChangeEmail(ActionEvent actionEvent) throws IOException {
        if(databaseConnection.userExcist(textFieldEmail.getText())){
            System.out.println("Email excists");
        }
        else{
            SessionUser.getInstance().getUser().email = textFieldEmail.getText();
            databaseConnection.changeUser(SessionUser.getInstance().getUser());
        }
    }

    @javafx.fxml.FXML
    public void onButtonBack(ActionEvent actionEvent) throws IOException {
        System.out.println(SessionUser.getInstance().getUser().getClass());
        if(SessionUser.getInstance().getUser().admin){
            HelloApplication.changeScreen(actionEvent,"admin-view.fxml");
        }
        else{
            HelloApplication.changeScreen(actionEvent,"user-view.fxml");
        }
    }

    @javafx.fxml.FXML
    public void onButtonChangePassword(ActionEvent actionEvent) throws IOException {
        if(textFieldPassword.getText().equals(textFieldConfirmPassword.getText())){
            SessionUser.getInstance().getUser().password = textFieldPassword.getText();
            databaseConnection.changeUser(SessionUser.getInstance().getUser());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textFieldName.setText(SessionUser.getInstance().getUser().name);
        textFieldEmail.setText(SessionUser.getInstance().getUser().email);
        textFieldPhone.setText(SessionUser.getInstance().getUser().phone);
    }
}
