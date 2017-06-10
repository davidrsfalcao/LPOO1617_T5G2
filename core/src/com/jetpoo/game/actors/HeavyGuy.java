package com.jetpoo.game.actors;

import com.jetpoo.game.states.PlayState;

/**
 * Created by davidfalcao on 10/06/17.
 */

public class HeavyGuy extends Hero{

    private float counter = 15;

    public HeavyGuy(int x, int y) {
        super(x, y);
    }

    @Override
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
    public float getCounter() {
        return counter;
    }
}
