package com.jetpoo.game.actors;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.jetpoo.game.states.PlayState;

/**
 * Created by davidfalcao on 01/06/17.
 */

public abstract class Hero {

    protected Vector2 position;
    protected Vector2 velocity;
    protected Rectangle bounds;
    protected boolean acelerating = false;
    protected boolean ontheGround = true;


    public Hero(int x, int y){
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        bounds = new Rectangle(x,y, 100, 100);
    }

    public void update(float dt){
        if(position.y > 0)
            velocity.add(0, -PlayState.GRAVITY);
        velocity.scl(dt);
        position.add(0 , velocity.y);

        if(position.y < 0)
            position.y = 0;
        if (position.y > 440)
            position.y = 440;

        velocity.scl(1/dt);
        bounds.setPosition(position.x, position.y);
    }

    public abstract void jump();

    public Rectangle getBounds(){
        return bounds;
    }



    public boolean isAcelerating() {
        return acelerating;
    }

    public void setAcelerating(boolean acelerating) {
        this.acelerating = acelerating;
    }

    public boolean isOntheGround() {
        return ontheGround;
    }

    public void setOntheGround(boolean ontheGround) {
        this.ontheGround = ontheGround;
    }

    public int getX(){
        return (int) position.x;
    }

    public int getY(){
        return (int) position.y;
    }

}
