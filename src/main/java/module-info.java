module com.example.web {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.web to javafx.fxml;
    exports com.example.web;
}