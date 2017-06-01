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
    private static final float FRAME_TIME = 0.09f;

    /**
     * The animation used when the ship is accelerating
     */
    private Animation<TextureRegion> acceleratingAnimation;

    /**
     * The texture used when the ship is not accelerating
     */
    private TextureRegion notAcceleratingRegion;

    /**
     * The texture used when the ship is not accelerating
     */
    private Animation<TextureRegion> runningAnimation;

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

    /**
     * Creates a sprite representing this space ship.
     *
     * @param game the game this view belongs to. Needed to access the
     *             asset manager to get textures.
     * @return the sprite representing this space ship
     */
    @Override
    public Sprite createSprite(JetPoo game) {
        runningAnimation = createRunningAnimation(game);
        notAcceleratingRegion = createNotAcceleratingRegion(game);

        return new Sprite(notAcceleratingRegion);
    }

    /**
     * Creates the animation used when the character is running
     *
     * @param game the game this view belongs to. Needed to access the
     *             asset manager to get textures.
     * @return the animation used when the character is running
     */
    private Animation<TextureRegion> createRunningAnimation(JetPoo game) {
        Texture runTexture = game.getAssetManager().get("Character-run.png");
        TextureRegion[][] runRegion = TextureRegion.split(runTexture, runTexture.getWidth() / 6, runTexture.getHeight());

        TextureRegion[] frames = new TextureRegion[6];
        System.arraycopy(runRegion[0], 0, frames, 0, 6);

        return new Animation<TextureRegion>(FRAME_TIME, frames);
    }

    /**
     * Creates the texture used when the ship is not accelerating
     *
     * @param game the game this view belongs to. Needed to access the
     *             asset manager to get textures.
     * @return the texture used when the ship is not accelerating
     */
    private TextureRegion createNotAcceleratingRegion(JetPoo game) {
        Texture noThrustTexture = game.getAssetManager().get("Character-static.png");
        return new TextureRegion(noThrustTexture, noThrustTexture.getWidth(), noThrustTexture.getHeight());
    }




    /**
     * Updates this ship model. Also save and resets
     * the accelerating flag from the model.
     *
     * @param model the model used to update this view
     */
    @Override
    public void update(EntityModel model) {
        super.update(model);

        accelerating = ((CharacterModel) model).isAccelerating();
        ((CharacterModel) model).setAccelerating(false);

        onTheGround= ((CharacterModel)model).isOnTheGround();
    }

    /**
     * Draws the sprite from this view using a sprite batch.
     * Chooses the correct texture or animation to be used
     * depending on the accelerating flag.
     *
     * @param batch The sprite batch to be used for drawing.
     */
    @Override
    public void draw(SpriteBatch batch) {
        stateTime += Gdx.graphics.getDeltaTime();

        if (onTheGround)
            sprite.setRegion(runningAnimation.getKeyFrame(stateTime, true));
        else sprite.setRegion(notAcceleratingRegion);

        sprite.draw(batch);
    }

}
