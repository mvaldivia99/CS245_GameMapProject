module com.example.feproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.feproject to javafx.fxml;
    exports com.example.feproject;
}