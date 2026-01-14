module com.example.fe {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.fe to javafx.fxml;
    exports com.example.fe;
    exports com.example.fe.inventory;
    opens com.example.fe.inventory to javafx.fxml;
}