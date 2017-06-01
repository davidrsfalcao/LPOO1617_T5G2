package com.jetpoo.game.actors;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by davidfalcao on 01/06/17.
 */

public abstract class Character {

    protected Vector2 position;
    protected Vector2 velocity;
    protected Rectangle bounds;
    protected static final int GRAVITY = -10;
    protected static final int MOVEMENT = 100;

    public void update(float dt){
        if(position.y > 0)
            velocity.add(0, GRAVITY);
        velocity.scl(dt);
        position.add(MOVEMENT * dt, velocity.y);

        if(position.y < 0)
            position.y = 0;
        if (position.y > 440)
            position.y = 440;

        velocity.scl(1/dt);
        bounds.setPosition(position.x, position.y);
    }

    public Vector2 getPosition() {
        return position;
    }

    protected abstract void jump();

    public Rectangle getBounds(){
        return bounds;
    }

    public Character(int x, int y){
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        bounds = new Rectangle(x, y, 128, 128);
    }
}
