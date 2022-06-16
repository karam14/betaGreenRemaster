module nl.ardemium.ardemiumapptemplate {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.google.gson;


    opens nl.ardemium.ardemiumapptemplate to javafx.fxml;
    exports nl.ardemium.ardemiumapptemplate;
    exports backend;
    opens backend to javafx.fxml;
}