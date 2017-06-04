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
        velocity.y = 250;
    }
}
