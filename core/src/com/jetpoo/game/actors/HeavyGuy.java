package com.jetpoo.game.actors;

import com.jetpoo.game.states.PlayState;

/**
 * Created by davidfalcao on 10/06/17.
 */

public class HeavyGuy extends Hero{

    private float counter = 15;
    /**
     * @brief constructor of HeavyGuy
     *
     * @param x position of Character
     * @param y position of Character
     */
    public HeavyGuy(int x, int y) {
        super(x, y);
    }

    @Override
    /**
     * @brief updates the state of the character when on mode HeavyGuy
     *
     * @param dt update time
     */
    public void update(float dt){
        if(!ontheGround)
            velocity.add(0, -3*PlayState.GRAVITY);
        velocity.scl(dt);
        position.add(0 , velocity.y);
        velocity.scl(1/dt);

        counter -= dt;

        updateBounds();
    }

    @Override
    /**
     * @brief makes the character jump ans switches the animation
     *
     */
    public void jump() {
        if (velocity.y == 0)
        {
            velocity.y = 100;
        }
        else if (velocity.y < 500 ){
            velocity.y += 50;
        }

        ontheGround = false;
        acelerating = true;
    }

    @Override
    /**
     * @return returns the counter of the time that the character is able to be on HeavyMode
     */
    public float getCounter() {
        return counter;
    }
}
