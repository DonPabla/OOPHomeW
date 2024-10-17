module org.example.demogui {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.demogui to javafx.fxml;
    exports org.example.demogui;
}