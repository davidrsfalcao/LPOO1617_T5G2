package com.jetpoo.game.model.entities;

/**
 * Created by davidfalcao on 23/04/17.
 */

public class CharacterModel extends EntityModel {

    /**
     * Creates a new character model in a certain position and having a certain rotation.
     *
     * @param x the x-coordinate in meters
     * @param y the y-coordinate in meters
     * @param rotation the rotation in radians
     */
    public CharacterModel(float x, float y, int rotation) {
        super(x, y, rotation);
    }


}
