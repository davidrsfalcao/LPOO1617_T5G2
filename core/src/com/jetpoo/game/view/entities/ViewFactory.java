package com.jetpoo.game.view.entities;

import com.jetpoo.game.JetPoo;
import com.jetpoo.game.model.entities.EntityModel;
import java.util.HashMap;
import java.util.Map;

import static com.jetpoo.game.model.entities.EntityModel.ModelType.CHARACTER;

/**
 * /**
 * A factory for EntityView objects with cache
 *
 * Created by davidfalcao on 01/06/17.
 */
public class ViewFactory {
    private static Map<EntityModel.ModelType, EntityView> cache = new HashMap<EntityModel.ModelType, EntityView>();

    public static EntityView makeView(JetPoo game, EntityModel model) {
        if (!cache.containsKey(model.getType())) {
            if (model.getType() == CHARACTER)
                cache.put(model.getType(), new CharacterView(game));

        }
        return cache.get(model.getType());
    }
}
