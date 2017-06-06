package com.jetpoo.game.actors;

import com.jetpoo.game.states.PlayState;

/**
 * Created by davidfalcao on 01/06/17.
 */

public class NormalGuy extends Hero{

    public NormalGuy(int x, int y) {
        super(x, y);
    }

    @Override
    public void update(float dt){
        if(!ontheGround)
            velocity.add(0, -PlayState.GRAVITY);
        velocity.scl(dt);
        position.add(0 , velocity.y);
        velocity.scl(1/dt);

        updateBounds();
    }

    @Override
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
}
