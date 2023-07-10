module com.veike.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.veike.demo to javafx.fxml;
    exports com.veike.demo;
}