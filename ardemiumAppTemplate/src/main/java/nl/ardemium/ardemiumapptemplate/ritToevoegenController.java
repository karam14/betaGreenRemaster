package nl.ardemium.ardemiumapptemplate;

import backend.Plane;
import backend.WithPlate;
import com.gluonhq.charm.glisten.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class ritToevoegenController {
    public ToggleButton carBtn;
    public ToggleButton motorBtn;
    public ToggleButton bikeBtn;
    public ToggleButton trainBtn;
    public ToggleButton airplaneBtn;
    public Button berekenBtn;
    public TextField startLocatie;
    public TextField eindLocatie;
    public TextField vervoerInfo;
    public TextField uitstoot;
    public Label labelUitstoot;
    public GridPane gridPaneAuto;


    public void onCarBtnButtonAction(ActionEvent actionEvent) throws IOException {
        uitstoot.setText("");
        startLocatie.setText("");
        eindLocatie.setText("");
        vervoerInfo.setText("");
        startLocatie.setPromptText("Startlocatie");
        eindLocatie.setPromptText("Bestemmingslocatie");
        vervoerInfo.setPromptText("Kenteken");
        startLocatie.setVisible(true);
        eindLocatie.setVisible(true);
        vervoerInfo.setVisible(true);
        uitstoot.setVisible(true);
        labelUitstoot.setVisible(true);
    }
    @javafx.fxml.FXML
    public void onReturnButtonAction(ActionEvent actionEvent) throws IOException {
        HelloApplication.changeScreen(actionEvent,"homeUser-view.fxml");
    }

    @javafx.fxml.FXML
    public void onBerekenButtonAction(ActionEvent actionEvent) throws IOException {
        if (carBtn.isSelected()) {
            WithPlate WP = new WithPlate();
            uitstoot.setText(String.valueOf(WP.getUistoot(startLocatie.getText(),eindLocatie.getText(),vervoerInfo.getText())));
        }
        else   if (motorBtn.isSelected()) {
            uitstoot.setText("-");
        } else if (trainBtn.isSelected()) {
            uitstoot.setText("Een trein rijdt op groene stroom");
        } else if (bikeBtn.isSelected()) {
            uitstoot.setText("Een fiets heeft geen CO2 uitstoot");
        } else if (airplaneBtn.isSelected()) {
            Plane plane = new Plane();
            uitstoot.setText(String.valueOf(plane.getUistoot(startLocatie.getText(),eindLocatie.getText(),vervoerInfo.getText())));

        }
    }

    @javafx.fxml.FXML
    public void onTrainBtnButtonAction(ActionEvent actionEvent) {
        uitstoot.setText("");
        startLocatie.setText("");
        eindLocatie.setText("");
        vervoerInfo.setText("");
        startLocatie.setPromptText("Startlocatie");
        eindLocatie.setPromptText("Bestemmingslocatie");
        vervoerInfo.setPromptText("Kenteken");
        startLocatie.setVisible(false);
        eindLocatie.setVisible(false);
        vervoerInfo.setVisible(false);
        uitstoot.setVisible(true);
        labelUitstoot.setVisible(true);
    }

    @javafx.fxml.FXML
    public void onMotorBtnButtonAction(ActionEvent actionEvent) {
        uitstoot.setText("");
        startLocatie.setText("");
        eindLocatie.setText("");
        vervoerInfo.setText("");
        startLocatie.setPromptText("Startlocatie");
        eindLocatie.setPromptText("Bestemmingslocatie");
        vervoerInfo.setPromptText("Kenteken");
        startLocatie.setVisible(false);
        eindLocatie.setVisible(false);
        vervoerInfo.setVisible(false);
        uitstoot.setVisible(true);
        labelUitstoot.setVisible(true);
    }

    @javafx.fxml.FXML
    public void onAirplaneBtnButtonAction(ActionEvent actionEvent) {
        uitstoot.setText("");
        startLocatie.setText("");
        eindLocatie.setText("");
        vervoerInfo.setText("");
        startLocatie.setPromptText("Startlocatie (ITIA)");
        eindLocatie.setPromptText("Bestemmingslocatie (ITIA)");
        vervoerInfo.setPromptText("Vlucht Klasse");
        startLocatie.setVisible(true);
        eindLocatie.setVisible(true);
        vervoerInfo.setVisible(true);
        uitstoot.setVisible(true);
        labelUitstoot.setVisible(true);
    }

    @javafx.fxml.FXML
    public void onBikeBtnButtonAction(ActionEvent actionEvent) {
        uitstoot.setText("");
        startLocatie.setText("");
        eindLocatie.setText("");
        vervoerInfo.setText("");
        startLocatie.setPromptText("Startlocatie");
        eindLocatie.setPromptText("Bestemmingslocatie");
        vervoerInfo.setPromptText("Kenteken");
        startLocatie.setVisible(false);
        eindLocatie.setVisible(false);
        vervoerInfo.setVisible(false);
        uitstoot.setVisible(true);
        labelUitstoot.setVisible(true);
    }
}
