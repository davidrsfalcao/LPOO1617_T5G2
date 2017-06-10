package com.jetpoo.game.actors;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.jetpoo.game.JetPoo;

import java.util.Random;

/**
 * Created by davidfalcao on 09/06/17.
 */

public class PowerUp {
    private Vector2 position;

    /*
    * Type 0: Change Hero to heavyGuy
    * Type 1: increase score by 10
    * Type 2: decrease velocity by 20
    **/
    private int type;
    private Circle bounds;
    private Random randomGenerator;


    public PowerUp() {
        randomGenerator = new Random();
        type = randomGenerator.nextInt(3);
        initPosition();
        bounds = new Circle(position.x, position.y, 25);
    }

    public void initPosition(){
        int ground = 64;
        int ceiling = 128;
        position = new Vector2();
        this.position.x = 1100;
        position.y = randomGenerator.nextInt(JetPoo.HEIGHT-ceiling-ground-50) + ground+25;
    }

    public void update(float delta){
        position.x -= delta;
        bounds.setPosition(position);
    }


    public Circle getBounds() {
        return bounds;
    }

    public int getType() {
        return type;
    }

    public float getX(){
        return position.x - 25;
    }

    public float getY(){
        return position.y - 25;
    }


}
