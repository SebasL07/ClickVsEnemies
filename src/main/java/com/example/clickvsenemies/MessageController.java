package com.example.clickvsenemies;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MessageController implements Initializable {

    @FXML
    protected ImageView imageField;
    @FXML
    protected Hyperlink link;
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String uri = "file:"+ HelloApplication.class.getResource("icesigood.png").getPath();
        imageField.setImage(new Image(uri));
        setEvents();
    }

    public void setEvents(){

        link.setOnAction(mouseEvent -> {
            HelloApplication.hideWindow((Stage) imageField.getScene().getWindow());
        });
    }






}
