package nl.ardemium.ardemiumapptemplate;

import backend.Admin;
import backend.DatabaseConnection;
import backend.SessionUser;
import backend.User;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ManageController implements Initializable {
    DatabaseConnection databaseConnection = new DatabaseConnection();
    ArrayList<User> userdb = SessionUser.getInstance().getAdmin().getEmployees();
    User selected = null;

    @javafx.fxml.FXML
    private ListView<User> listViewUsers;
    @javafx.fxml.FXML
    private CheckBox checkBoxAdmin;

    @javafx.fxml.FXML
    public void onButtonBack(ActionEvent actionEvent) throws IOException {
        HelloApplication.changeScreen(actionEvent,"admin-view.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
           userdb = databaseConnection.getUserdb();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        listViewUsers.getItems().addAll(userdb);
        listViewUsers.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<User>() {
            @Override
            public void changed(ObservableValue<? extends User> observable, User oldValue, User newValue) {
                selected = listViewUsers.getSelectionModel().getSelectedItem();
                checkBoxAdmin.setSelected(selected.admin);
            }
        });
    }

    @javafx.fxml.FXML
    public void onButtonDelete(ActionEvent actionEvent) throws IOException {
        userdb.remove(selected);
        databaseConnection.setUserdb(userdb);
        listViewUsers.getItems().remove(selected);
    }

    @javafx.fxml.FXML
    public void onButtonChange(ActionEvent actionEvent) throws IOException {
        selected.admin = checkBoxAdmin.isSelected();
        databaseConnection.setUserdb(userdb);
        listViewUsers.refresh();
    }
}
