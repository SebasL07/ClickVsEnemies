package com.example.clickvsenemies.model;


import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.Light;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class Enemy extends Thread{

    private int x;
    private int y;

    private int size;

    private GraphicsContext gc;

    private Rectangle shape;

    private Point2D click;

    private boolean live;

    private boolean first = true;

    public Enemy(int x, int y, int size, GraphicsContext gc){
        this.x = x;
        this.y = y;
        this.size = size;
        this.gc = gc;
        shape = new Rectangle(x,y,size,size);
        live = true;
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
        int r;
        int g;
        int b;


        long time = System.currentTimeMillis();
        do{
            if(first||System.currentTimeMillis()-time>=1500||(click != null && shape.contains(click))){
                time = System.currentTimeMillis();
                first = false;
                gc.clearRect(x,y,size,size);
                r = (int) (Math.random() * 249);
                g = (int) (Math.random() * 249);
                b = (int) (Math.random() * 249);

                x = (int) (Math.random() * 370);
                y = (int) (Math.random() * 370);

                setShape(new Rectangle(x,y,size,size));

                gc.setFill(Color.rgb(r,g,b));

                gc.fillRect(x,y,size,size);

            }




        }while (live);
    }



    public void setClick(Point2D click) {
        this.click = click;
    }
}
