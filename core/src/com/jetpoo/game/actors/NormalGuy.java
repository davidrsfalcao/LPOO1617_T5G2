package com.jetpoo.game.actors;

import com.jetpoo.game.states.PlayState;

/**
 * Represents the hero with normal weight. He is the initial hero
 *
 * Created by davidfalcao on 01/06/17.
 */

public class NormalGuy extends Hero{
    /**
     * @brief constructor of NormalGuy
     *
     * @param x position of Character
     * @param y position of Character
     */
    public NormalGuy(int x, int y) {
        super(x, y);
    }

    @Override
    /**
     * @brief updates the state of the character when on mode NormalGuy
     *
     * @param dt update time
     */
    public void update(float dt){
        if(!ontheGround)
            velocity.add(0, -PlayState.GRAVITY);
        velocity.scl(dt);
        position.add(0 , velocity.y);
        velocity.scl(1/dt);

        updateBounds();
    }

    @Override
    /**
     * @brief makes the character jump and switches the animation
     *
     */
    public void jump() {
        if (velocity.y == 0)
        {
            velocity.y = 150;
        }
        else if (velocity.y < 500 ){
            velocity.y += 25;
        }

        ontheGround = false;
        acelerating = true;
    }

    @Override
    /**
     * @brief returns the counter of the time that the character is able to be on NormalMode
     *
     * @return the counter
     */
    public float getCounter() {
        return 0;
    }
}
