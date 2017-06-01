package com.jetpoo.game.controller.entities;

import com.badlogic.gdx.physics.box2d.World;
import com.jetpoo.game.model.entities.EntityModel;
import com.jetpoo.game.model.entities.CharacterModel;

/**
 * Created by davidfalcao on 01/06/17.
 */

public class CharacterBody extends EntityBody {

    public CharacterBody(World world, CharacterModel model) {
        super(world, model);

        float density = 0.5f, friction = 0.4f, restitution = 0.5f;
        int width = 256, height = 256;

        createFixture(body, new float[]{
                0,0, 256,0, 256,256, 0,256
        }, width, height, density, friction, restitution, CHARACTER_BODY, (short) (OBSTACLE_BODY | OBSTACLE_BODY| POWERUP_BODY));
    }

}
