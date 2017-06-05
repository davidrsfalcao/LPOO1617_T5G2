package com.jetpoo.game.actors;

/**
 * Created by davidfalcao on 01/06/17.
 */

public class NormalGuy extends Hero{

    public NormalGuy(int x, int y) {
        super(x, y);
    }

    @Override
    public void jump() {
        if (velocity.y == 0)
        {
            velocity.y = 150;
        }
        else if (velocity.y < 700 ){
            velocity.y += 25;
        }

        ontheGround = false;
        acelerating = true;
    }
}
