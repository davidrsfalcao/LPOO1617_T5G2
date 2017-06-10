package com.jetpoo.game.states;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.jetpoo.game.JetPoo;

/**
 * Created by pedromiranda on 01/06/17.
 */

public class GameOverState extends State{


    public GameOverState(GameStateManager gsm, JetPoo game, int score) {
        super(gsm, game);
        cam.setToOrtho(false, JetPoo.WIDTH, JetPoo.HEIGHT);

        initTouchListener();

    }

    private void initTouchListener(){
        Gdx.input.setInputProcessor(new InputAdapter(){

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                gsm.set(new MenuState(gsm, game));
                return true;
            }

        });

    }



    @Override
    public void update(float dt) {
        //do nothing
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        Texture background =  game.getAssetManager().get("background/Game_Over_bg.png", Texture.class);
        sb.draw(background, 0,0);

        sb.end();
    }

    @Override
    public void dispose() {
        //nothing to dispose

    }
}
