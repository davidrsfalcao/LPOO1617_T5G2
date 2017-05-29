package com.jetpoo.game.model;

import com.jetpoo.game.model.entities.CharacterModel;

/**
 * Created by davidfalcao on 23/04/17.
 *
 * A model representing a game.
 */
public class GameModel {

    /**
     * The singleton instance of the game model
     */
    private static GameModel instance;

    /**
     * The character controlled by the user in this game.
     */
    private CharacterModel character;

    /*
     * Returns a singleton instance of the game model
     *
     * @return the singleton instance
     */
    public static GameModel getInstance() {
        if (instance == null)
            instance = new GameModel();
        return instance;
    }


}
