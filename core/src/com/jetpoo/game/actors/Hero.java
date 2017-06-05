package com.jetpoo.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.jetpoo.game.JetPoo;
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
    private float screenWidth_con;
    private float screenHeight_con;


    public Hero(int x, int y){
        screenWidth_con = (float) JetPoo.WIDTH / (float) Gdx.graphics.getWidth();
        screenHeight_con = (float) JetPoo.HEIGHT / (float) Gdx.graphics.getHeight();

        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        bounds = new Rectangle(x*screenHeight_con,y*screenHeight_con, 100*screenHeight_con, 100*screenHeight_con);

    }

    public void updatePosition(float dt){
        if(position.y > 0)
            velocity.add(0, -PlayState.GRAVITY);
        velocity.scl(dt);
        position.add(0 , velocity.y);
        velocity.scl(1/dt);

        if (position.y < 0)
            position.y = 0;

    }

    public void updateBounds(){
        bounds.setPosition(position.x*screenHeight_con, position.y*screenHeight_con);
    }

    public abstract void jump();

    public Rectangle getBounds(){
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
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

    public Vector2 getVelocity() {
        return velocity;
    }
}
