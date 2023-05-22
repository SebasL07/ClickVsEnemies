package com.example.clickvsenemies.model;


import com.example.clickvsenemies.HelloApplication;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.Light;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class Enemy extends Thread{

    private int x;
    private int y;

    private int size;

    private GraphicsContext gc;

    private Image enemy;

    private Rectangle shape;

    private Point2D click;

    private boolean live;

    private boolean first = true;

    private int lives = 3;

    private int timeSpawn = 1000;

    private long timeAlive;

    public Enemy(int x, int y, int size, GraphicsContext gc){
        this.x = x;
        this.y = y;
        this.size = size;
        this.gc = gc;
        shape = new Rectangle(x,y,size,size);
        live = true;
        String uri = "file:"+ HelloApplication.class.getResource("target.png").getPath();
        enemy = new Image(uri);
    }

    public Rectangle getShape() {
        return shape;
    }

    public void setShape(Rectangle shape) {
        this.shape = shape;
    }

    @Override
    public void run() {
        super.run();

        long time = System.currentTimeMillis();
        timeAlive = System.currentTimeMillis();
        long time2;
        do{
            time2 = System.currentTimeMillis()-time;

            if(first||time2>=timeSpawn||(click != null && shape.contains(click))){
                time = System.currentTimeMillis();

                first = false;
                gc.clearRect(x,y,size,size);

                x = (int) (Math.random() * 370);
                y = (int) (Math.random() * 370);

                setShape(new Rectangle(x,y,size,size));

                gc.setFill(Color.WHITE);

                gc.fillRect(x,y,size,size);

                gc.drawImage(enemy,x,y,size,size);

            }

            if (System.currentTimeMillis()-timeAlive >=30000){
                timeSpawn -= 100;
                timeAlive = System.currentTimeMillis();
            }



        }while (live);
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getLives() {
        return lives;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public void setClick(Point2D click) {
        this.click = click;
    }


}
