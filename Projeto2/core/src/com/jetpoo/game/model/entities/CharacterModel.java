package com.jetpoo.game.model.entities;

/**
 * Created by davidfalcao on 23/04/17.
 */

public class CharacterModel extends EntityModel {

    private boolean onTheGround = true;
    private boolean accelerating = false;

    /**
     * Creates a new character model in a certain position and having a certain rotation.
     *
     * @param x        the x-coordinate in meters
     * @param y        the y-coordinate in meters
     * @param rotation the rotation in radians
     */
    public CharacterModel(float x, float y, int rotation) {
        super(x, y, rotation);
    }

    /**
     * Return the state of the character: running or flying
     *
     * @return true if the character is on the ground or false is the character is on the air
     */
    public boolean isOnTheGround() {
        return onTheGround;
    }

    /**
     * Redefine the current state of the character
     *
     * @param onTheGround true for running, false for flying
     */
    public void setOnTheGround(boolean onTheGround) {
        this.onTheGround = onTheGround;
    }

    /**
     * Is the jetpack accelerating in this update
     *
     * @return the accelerating flag
     */
    public boolean isAccelerating() {
        return accelerating;
    }

    /**
     * Set the accelerating flag for this ship
     *
     * @param accelerating the accelerating tag
     */
    public void setAccelerating(boolean accelerating) {
        this.accelerating = accelerating;
    }
}
