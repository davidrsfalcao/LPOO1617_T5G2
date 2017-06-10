package com.jetpoo.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Circle;
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
    protected boolean ontheGround;


    public Hero(int x, int y){
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        bounds = new Rectangle(x+20,y, 60, 100);

        if (y == 64)
            ontheGround = true;
        else ontheGround = false;

    }

    public abstract void update(float dt);

    protected void updateBounds(){
        bounds.setPosition(position.x+20, position.y);
    }

    public abstract void jump();

    public abstract float getCounter();

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
                position.y = ground.getY()+ground.getHeight();
                velocity = new Vector2(0, 0);
                updateBounds();
                return true;
            }
            else{ //ressalto
                position.y = ground.getY()+ground.getHeight();
                velocity = new Vector2(0, -velocity.y/5);
                updateBounds();
                return true;
            }

        }

        return false;
    }

    public boolean colideCeiling(Rectangle ceiling){

        if (bounds.overlaps(ceiling)){

            if (velocity.y < 10){
                position.y = ceiling.getY() - 100;
                velocity = new Vector2(0, PlayState.GRAVITY);
                updateBounds();
                return true;
            }
            else { //ressalto
                position.y = ceiling.getY() - 100;
                velocity = new Vector2(0, -velocity.y/2);
                updateBounds();
                return true;
            }

        }

        return false;
    }

    public boolean colideLaser(Obstacle laser){

        if (bounds.overlaps(laser.getBounds())){
            return true;
        }


        return false;

    }

    public boolean catchPowerUp(PowerUp pw) {
        for (int i = 0; i < 80; i++){
            for(int k = 0; k < 100; k++){
                if (pw.getBounds().contains(position.x+20 + i, position.y+k))
                    return true;
            }
        }

        return false;
    }

    public Rectangle getBounds() {
        return bounds;
    }
}
