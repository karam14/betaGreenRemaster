package nl.ardemium.ardemiumapptemplate;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 335, 600);
        stage.setTitle("Ardemium");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static void changeScreen(ActionEvent actionEvent, String location) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(location));
        Scene scene = new Scene(fxmlLoader.load(), 335, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void underConstructionPopup(){
        Alert underConstruction = new Alert(Alert.AlertType.INFORMATION);
        underConstruction.setTitle("Under Construction");
        underConstruction.setHeaderText("We are working on it. :)");
        underConstruction.setContentText("This is under construction. Check in the future!");
        underConstruction.show();
    }
}