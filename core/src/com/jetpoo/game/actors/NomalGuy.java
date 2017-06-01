package com.jetpoo.game.actors;

/**
 * Created by davidfalcao on 01/06/17.
 */

public class NomalGuy extends Character {

    public NomalGuy(int x, int y) {
        super(x, y);
    }

    @Override
    protected void jump() {
        velocity.y = 250;
    }
}
