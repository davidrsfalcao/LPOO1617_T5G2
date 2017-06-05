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
        bounds = new Rectangle(x*screenWidth_con,y*screenWidth_con, 100*screenHeight_con, 100*screenWidth_con);

    }

    public void updatePosition(float dt){
        if(!ontheGround)
            velocity.add(0, -PlayState.GRAVITY);
        velocity.scl(dt);
        position.add(0 , velocity.y);
        velocity.scl(1/dt);

    }

    public void updateBounds(){
        bounds.setPosition(position.x*screenWidth_con, position.y*screenHeight_con);
    }

    public abstract void jump();

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

    public boolean colideGround(Rectangle ground){

        if (bounds.overlaps(ground)){

            if (velocity.y > -50){
                ontheGround = true;
                position.y = (ground.getY()+ground.getHeight())/screenHeight_con;
                velocity = new Vector2(0, 0);
                return true;
            }
            else{ //ressalto
                position.y = (ground.getY()+ground.getHeight())/screenHeight_con;
                velocity = new Vector2(0, -velocity.y/5);
                return true;
            }

        }

        return false;
    }

    public boolean colideCeiling(Rectangle ceiling){

        if (bounds.overlaps(ceiling)){

            if (velocity.y < 10){
                position.y = ceiling.getY()/screenHeight_con - 100;
                velocity = new Vector2(0, PlayState.GRAVITY);
                return true;
            }
            else { //ressalto
                position.y = ceiling.getY()/screenHeight_con - 100;
                velocity = new Vector2(0, -velocity.y/2);
                return true;
            }

        }

        return false;
    }

    public float getScreenWidth_con() {
        return screenWidth_con;
    }

    public float getScreenHeight_con() {
        return screenHeight_con;
    }
}
