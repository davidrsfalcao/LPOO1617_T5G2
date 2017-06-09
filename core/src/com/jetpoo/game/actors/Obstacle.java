package com.jetpoo.game.actors;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.jetpoo.game.JetPoo;

import java.util.Random;

/**
 * Created by davidfalcao on 03/06/17.
 */

public class Obstacle {
    private Vector2 position;
    private int height;
    private int width;
    private Rectangle bounds;
    private Random randomGenerator;

    public Obstacle(int x) {
        randomGenerator = new Random();
        position = new Vector2();
        position.x = x;
        initPosition();
        initHeight();
        initBounds();

    }

    public void initPosition(){
        int ground = 64;
        int ceiling = 128;

        position.y = randomGenerator.nextInt(JetPoo.HEIGHT-ceiling-ground) + ground;
    }

    public void initHeight(){
        int ground = 64;
        int ceiling = 128;

        height = randomGenerator.nextInt(JetPoo.HEIGHT-ceiling-ground-200)/2 +100;

        if (position.y + height > JetPoo.HEIGHT-ceiling){
            position.y -= height;
        }

        width = height/2;

    }

    public void initBounds(){
        bounds = new Rectangle((position.x+width/4), position.y, width/3, height);

    }

    public void update(float delta){
        position.x -= delta;
        bounds.setPosition((position.x+width/4),position.y);

    }

    public float getX(){
        return position.x;
    }

    public float getY(){
        return position.y;
    }

    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }

    public Rectangle getBounds() {
        return bounds;
    }
}
