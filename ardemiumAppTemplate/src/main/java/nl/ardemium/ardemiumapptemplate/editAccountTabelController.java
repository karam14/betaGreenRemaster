package nl.ardemium.ardemiumapptemplate;

import backend.SessionUser;
import backend.User;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class editAccountTabelController implements Initializable {
    @javafx.fxml.FXML
    private TableColumn nummerCol;
    @javafx.fxml.FXML
    private TableView<User> overzichtTabel;
    @javafx.fxml.FXML
    private TableColumn naamCol;
    @javafx.fxml.FXML
    private Button returnButton;
    public User selected = null;

    @javafx.fxml.FXML
    public void onReturnButton(ActionEvent actionEvent) throws IOException {
        HelloApplication.changeScreen(actionEvent, "homeAdmin-view.fxml");
    }

    @javafx.fxml.FXML
    public void onEditButton(ActionEvent actionEvent) throws IOException {
        selected = overzichtTabel.getSelectionModel().getSelectedItem();
        System.out.println(selected);
        editAccountController.setUser(selected);
        HelloApplication.changeScreen(actionEvent,"editAccount-view.fxml");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        naamCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        nummerCol.setCellValueFactory(new PropertyValueFactory<>("email"));

        ArrayList<User> gebruikers = SessionUser.getInstance().getAdmin().getEmployees();
        ObservableList<User> observableList = FXCollections.observableArrayList(gebruikers);
        overzichtTabel.setItems(observableList);
    }
}