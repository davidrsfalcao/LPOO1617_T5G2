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

    /**
     * @brief constructor of Hero
     *
     * @param x position of Character
     * @param y position of Character
     */
    public Hero(int x, int y){
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        bounds = new Rectangle(x+20,y, 60, 100);

        if (y == 64)
            ontheGround = true;
        else ontheGround = false;

    }
    /**
     * @brief updates the state of the character
     *
     * @param dt update time
     */
    public abstract void update(float dt);

    /**
     * @brief update Character's bounds
     */
    protected void updateBounds(){
        bounds.setPosition(position.x+20, position.y);
    }

    /**
     * @brief makes the character jump
     *
     */
    public abstract void jump();

    /**
     * @brief returns the counter of the time that the character is able to be on a Mode
     *
     * @return the counter
     */
    public abstract float getCounter();

    /**
     * @brief Return a value that tells if the hero is flying or not
     *
     * @return True of Hero is flying,False if not
     */
    public boolean isAcelerating() {
        return acelerating;
    }

    /**
     * @brief sets the hero to fly or run
     * @param acelerating if True,Hero is flying,if False,Hero is running
     */
    public void setAcelerating(boolean acelerating) {
        this.acelerating = acelerating;
    }
    /**
     * @brief Return a value that tells if the hero is running or not
     * @return True of Hero is running,False if not
     */
    public boolean isOntheGround() {
        return ontheGround;
    }

    /**
     * @brief returns the x position of the hero
     *
     * @return Hero's x position
     */
    public int getX(){
        return (int) position.x;
    }
    /**
     *@brief returns the y position of the hero
     *
     * @return Hero's y position
     */
    public int getY(){
        return (int) position.y;
    }

    /**
     * @brief tests if Hero touches the ground
     * @param ground ground area to test
     * @return True if touches,False if not
     */
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
    /**
     * @brief tests if Hero touches the ceiling
     * @param ceiling ceiling area to test
     * @return True if touches,False if not
     */
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
    /**
     * @brief tests if Hero touches the lasers
     * @param laser ceiling area to test
     * @return True if touches,False if not
     */
    public boolean colideLaser(Obstacle laser){

        if (bounds.overlaps(laser.getBounds())){
            return true;
        }


        return false;

    }

    /**
     * @brief tests if Hero catches the PowerUp
     * @param pw PowerUp to test
     * @return True if Catches,False if not
     */
    public boolean catchPowerUp(PowerUp pw) {
        for (int i = 0; i < 80; i++){
            for(int k = 0; k < 100; k++){
                if (pw.getBounds().contains(position.x+20 + i, position.y+k))
                    return true;
            }
        }

        return false;
    }

    /**
     * @brief returns the Hero's bounds
     *
     * @return bounds of the Hero
     */
    public Rectangle getBounds() {
        return bounds;
    }
    /**
     *@brief returns the Hero's velocity
     *
     * @return velocity of the Hero
     */
    public Vector2 getVelocity() {
        return velocity;
    }
}
