package com.jetpoo.game.view.entities;

import com.jetpoo.game.JetPoo;
import com.jetpoo.game.model.entities.EntityModel;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


import static com.jetpoo.game.view.GameView.PIXEL_TO_METER;

/**
 * Created by davidfalcao on 28/05/17.
 */

public abstract class EntityView {

    /**
     * The sprite representing this entity view.
     */
    Sprite sprite;

    /**
     * Creates a view belonging to a game.
     *
     * @param game the game this view belongs to. Needed to access the
     *             asset manager to get textures.
     */
    EntityView(JetPoo game) {
        sprite = createSprite(game);
    }

    /**
     * Draws the sprite from this view using a sprite batch.
     *
     * @param batch The sprite batch to be used for drawing.
     */
    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }


    /**
     * Abstract method that creates the view sprite. Concrete
     * implementation should extend this method to create their
     * own sprites.
     *
     * @param game the game this view belongs to. Needed to access the
     *             asset manager to get textures.
     * @return the sprite representing this view.
     */
    public abstract Sprite createSprite(JetPoo game);

    /**
     * Updates this view based on a certain model.
     *
     * @param model the model used to update this view
     */
    public void update(EntityModel model) {
        sprite.setCenter(model.getX() / PIXEL_TO_METER, model.getY() / PIXEL_TO_METER);
        sprite.setRotation((float) Math.toDegrees(model.getRotation()));
    }

}
