package nl.ardemium.ardemiumapptemplate;

import backend.DatabaseConnection;
import backend.Doel;
import backend.SessionUser;
import com.google.gson.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.stream.Stream;

public class DoelenController implements Initializable {
    @javafx.fxml.FXML
    public Button voegToeButton;
    public TextField doelenVeldInput;
    public TextField doelVerwijderenVeld;
    public TextArea doelenVeldText;
    public Button terugButton;
    public ArrayList<Doel> userDoelen;
    public ArrayList<Doel> doelenTotaal;
    public ArrayList<Integer> userDoelenIndex;

    public void onVoegToeButtonAction(ActionEvent actionEvent) throws IOException {
        Gson gson = new Gson();
        Doel doel = new Doel(doelenVeldInput.getText());
        userDoelen.add(doel);
        doelenTotaal.add(doel);
        userDoelenIndex.add(doelenTotaal.size());
        FileWriter fileWriter = new FileWriter("ardemiumAppTemplate/src/main/resources/gsondb/goalsdb.json");
        gson.toJson(doelenTotaal, fileWriter);
        fileWriter.close();
        doelenVeldText.setText(getString());
        userNewArray();
    }

    public void userNewArray() throws IOException {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Integer[] arr = new Integer[userDoelenIndex.size()];
        arr = userDoelenIndex.toArray(arr);
        SessionUser.getInstance().getUser().goals = arr;
        databaseConnection.changeUser(SessionUser.getInstance().getUser());

    }

    private String getString() {
        String s = "";
        int counter = 1;
        for (Doel d :
                userDoelen) {
            s = s + counter + ": " + d.getDoel() + "\n";
            counter++;
        }
        return s;
    }

    public void verwijderDoel(ActionEvent actionEvent) throws IOException {
        Gson gson = new Gson();
        ArrayList<Doel> doelToRemove = new ArrayList<>();
        doelToRemove.add(userDoelen.get(Integer.parseInt(doelVerwijderenVeld.getText()) - 1));
        userDoelen.remove(Integer.parseInt(doelVerwijderenVeld.getText()) - 1);
        userDoelenIndex.remove(Integer.parseInt(doelVerwijderenVeld.getText()) - 1);
        doelenTotaal.removeAll(doelToRemove);
        FileWriter fileWriter = new FileWriter("ardemiumAppTemplate/src/main/resources/gsondb/goalsdb.json");
        gson.toJson(doelenTotaal, fileWriter);
        fileWriter.close();
        userNewArray();
        doelenVeldText.setText(getString());
    }

    @javafx.fxml.FXML
    public void onTerugButtonAction(ActionEvent actionEvent) throws IOException {
        HelloApplication.changeScreen(actionEvent,"homeUser-view.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Gson gson = new Gson();
        ArrayList<Doel> lijstjeDoelen = new ArrayList<>();
        ArrayList<Doel> userLijstjeDoelen = new ArrayList<>();
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("ardemiumAppTemplate/src/main/resources/gsondb/goalsdb.json");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        JsonArray lijstje = gson.fromJson(fileReader, JsonArray.class);
        for (JsonElement o : lijstje) {
            lijstjeDoelen.add(gson.fromJson(o, Doel.class));
        }
        Integer[] Doelen = SessionUser.getInstance().getUser().goals;
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        for (Integer i : Doelen) {
            int index = i - 1;
            indexes.add((index + 1));
            userLijstjeDoelen.add(lijstjeDoelen.get(index));
        }

        this.userDoelenIndex = indexes;
        this.doelenTotaal = lijstjeDoelen;
        this.userDoelen = userLijstjeDoelen;
        try {
            userNewArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        doelenVeldText.setText(getString());
    }
}