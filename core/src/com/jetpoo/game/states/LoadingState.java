package com.jetpoo.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jetpoo.game.JetPoo;
import com.jetpoo.game.useful.LoadThread;

/**
 * Created by davidfalcao on 03/06/17.
 */

public class LoadingState extends State {

    private float time = 3; //segundos
    private float elapsed = 1;
    private int mult = 0;
    private LoadThread thread;


    public LoadingState(GameStateManager gsm, JetPoo game) {
        super(gsm, game);
        cam.setToOrtho(false, JetPoo.WIDTH, JetPoo.HEIGHT);


        this.game.getAssetManager().load("Loading.png", Texture.class);
        this.game.getAssetManager().load("Loading_bar.png", Texture.class);
        this.game.getAssetManager().finishLoading();

        this.thread = new LoadThread(game);
        thread.start();


    }

    @Override
    public void update(float dt) {

        if (mult < 10){
            elapsed += dt;

            mult = (int) (elapsed / 0.3);

        }
        else {
            if (thread.finished){
                this.game.getAssetManager().finishLoading();
                gsm.set(new MenuState(gsm, game));

            }

        }


    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);


        Gdx.gl.glClearColor( 1, 1, 1, 1 );
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );


        sb.begin();
        sb.draw(this.game.getAssetManager().get("Loading.png", Texture.class), 0,0, JetPoo.WIDTH, JetPoo.HEIGHT);
        sb.draw(this.game.getAssetManager().get("Loading_bar.png", Texture.class), 129,360,(770 / 10)*mult,47 );
        sb.end();

    }

    @Override
    public void dispose() {

    }


    private JetPoo getGame()
    {
        return game;
    }

}
