package com.example.clickvsenemies;

import com.example.clickvsenemies.model.Enemy;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.security.Key;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Canvas canvas;

    private GraphicsContext gc;

    private Enemy enemy;
    @FXML
    public Label score;

    private int score1;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gc = canvas.getGraphicsContext2D();

        enemy = new Enemy(100,10,10,gc);
        enemy.setDaemon(true);
        enemy.start();
        setEvents();

    }


    public void setEvents(){
        canvas.setFocusTraversable(true);
        canvas.setOnMouseClicked(clickEvent ->{
            Point2D point2D = new Point2D(clickEvent.getX(),clickEvent.getY());
            if (enemy.getShape().contains(point2D)){
                System.out.println("Auch!");
                enemy.setClick(point2D);
                score1++;
                score.setText("Score: " + score1);

            }
        });
    }
}