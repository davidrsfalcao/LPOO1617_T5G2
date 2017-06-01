package com.jetpoo.game.model;

import com.jetpoo.game.model.entities.CharacterModel;
import com.jetpoo.game.controller.GameController;

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

    /**
     * Constructs a game with a.space ship in the middle of the
     * arena and a certain number of asteroids in different sizes.
     */
    private GameModel() {

        character = new CharacterModel(GameController.ARENA_WIDTH / 2, GameController.ARENA_HEIGHT / 2, 0);

    }


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

    public CharacterModel getCharacter() {
        return character;
    }

    public void update(float delta) {

    }
}
