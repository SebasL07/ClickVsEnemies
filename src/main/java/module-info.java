module com.example.clickvsenemies {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.clickvsenemies to javafx.fxml;
    exports com.example.clickvsenemies;
}