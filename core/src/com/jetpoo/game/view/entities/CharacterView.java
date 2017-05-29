package com.jetpoo.game.view.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import com.jetpoo.game.model.entities.EntityModel;
import com.jetpoo.game.model.entities.CharacterModel;
import com.jetpoo.game.JetPoo;

/**
 * A view representing a character
 *
 * Created by davidfalcao on 29/05/17.
 */

public class CharacterView extends EntityView{

    /**
     * The time between the animation frames
     */
    private static final float FRAME_TIME = 0.05f;

    /**
     * The animation used when the ship is accelerating
     */
    private Animation<TextureRegion> acceleratingAnimation;

    /**
     * The texture used when the ship is not accelerating
     */
    private Animation<TextureRegion> notAcceleratingRegion;

    /**
     * Time since the character started the game. Used
     * to calculate the frame to show in animations.
     */
    private float stateTime = 0;

    /**
     * Is the character accelerating.
     */
    private boolean accelerating;


    /**
     * Is the character on the ground.
     */
    private boolean onTheGround;









   public CharacterView(JetPoo game) {
        super(game);
    }

    @Override
    public Sprite createSprite(JetPoo game) {
        return null;
    }
}
