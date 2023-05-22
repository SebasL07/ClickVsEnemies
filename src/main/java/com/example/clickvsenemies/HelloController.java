package com.example.clickvsenemies;

import com.example.clickvsenemies.model.Enemy;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Canvas canvas;

    private GraphicsContext gc;

    @FXML
    public VBox v;

    private Enemy enemy;
    @FXML
    public Label score;

    @FXML
    public Label lives2;

    private int score1;

    private int lives = 3;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gc = canvas.getGraphicsContext2D();

        enemy = new Enemy(100, 30, 30, gc);
        enemy.setDaemon(true);
        enemy.start();
        setEvents();


    }


    public void setEvents() {
        canvas.setFocusTraversable(true);
        canvas.setOnMouseClicked(clickEvent -> {
            Point2D point2D = new Point2D(clickEvent.getX(), clickEvent.getY());
            if (enemy.getShape().contains(point2D)) {
                enemy.setClick(point2D);
                score1++;
                score.setText("Score: " + score1);
            } else {
                enemy.setLives(enemy.getLives() - 1);
                lives2.setText("Lives: " + enemy.getLives());
                if (enemy.getLives() <= 0) {
                    enemy.setLive(false);
                    showAlert();
                    openNewWindow();
                }
            }
        });
    }


    public void openNewWindow() {
        HelloApplication.hideWindow((Stage) score.getScene().getWindow());
        HelloApplication.showWindow("message-lose");
    }

    public void showAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Total score");
        alert.setTitle("Score");
        alert.setContentText("Your score was: " + score1);
        alert.showAndWait();
    }

    public void updateLabel(){


        if(enemy.getLives() <= 0){
            openNewWindow();
        }
    }

    public Enemy getEnemy() {
        return enemy;
    }
}