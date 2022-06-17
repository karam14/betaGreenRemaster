package nl.ardemium.ardemiumapptemplate;

import backend.DatabaseConnection;
import backend.Quote;
import backend.SessionUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class HomeUserController implements Initializable {
    DatabaseConnection dc = new DatabaseConnection();
    @javafx.fxml.FXML
    private Button ritToevoegenButton;
    @javafx.fxml.FXML
    private Button goalsButton;
    @javafx.fxml.FXML
    private Button signOutButton;
    @javafx.fxml.FXML
    private Text quoteLabel;

    @javafx.fxml.FXML
    public void onRitToevoegenButtonAction(ActionEvent actionEvent) throws IOException {
        HelloApplication.changeScreen(actionEvent, "ritToevegen-view.fxml");
    }

    @javafx.fxml.FXML
    public void onGoalsButtonAction(ActionEvent actionEvent) throws IOException {
        HelloApplication.changeScreen(actionEvent, "doelen-view.fxml");
    }

    @javafx.fxml.FXML
    public void onSignOutButtonAction(ActionEvent actionEvent) throws IOException {
        SessionUser.getInstance().clearUser();
        HelloApplication.changeScreen(actionEvent, "login-view.fxml");
    }
    @javafx.fxml.FXML
    public void onRewardsButtonAction(ActionEvent actionEvent) throws IOException {
        HelloApplication.changeScreen(actionEvent, "rewardsUser-view.fxml");

    }
    @javafx.fxml.FXML
    public void onSettingsButtonAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("settings-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 335, 600);
        stage.setScene(scene);
        stage.show();    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            ArrayList<Quote> quotes = dc.getQuotesdb();
            int range = quotes.size();
            Random r = new Random();
            this.quoteLabel.setText(quotes.get(r.nextInt(range)).getQuote() + " " + quotes.get(r.nextInt(range)).getTip());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
