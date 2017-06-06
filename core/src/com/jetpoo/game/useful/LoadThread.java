package com.jetpoo.game.useful;

import com.badlogic.gdx.graphics.Texture;
import com.jetpoo.game.JetPoo;

/**
 * Created by davidfalcao on 03/06/17.
 */

public class LoadThread extends Thread{

    private JetPoo game;
    public boolean finished = false;

    public LoadThread(JetPoo game) {
        this.game = game;
    }

    @Override
    public void run() {
        super.run();
        this.game.getAssetManager().load("bg.png", Texture.class);
        this.game.getAssetManager().load("Menu_bg.png", Texture.class);
        this.game.getAssetManager().load("Menu_bg1.png", Texture.class);
        this.game.getAssetManager().load("button_play.png", Texture.class);
        this.game.getAssetManager().load("button_leaderboard.png", Texture.class);

        this.game.getAssetManager().load("ground.png", Texture.class);
        this.game.getAssetManager().load("ceiling.png", Texture.class);
        this.game.getAssetManager().load("Character-run.png", Texture.class);
        this.game.getAssetManager().load("Character-acelerating.png", Texture.class);
        this.game.getAssetManager().load("Character-falling.png", Texture.class);

        this.game.getAssetManager().load("laser.png", Texture.class);
        this.game.getAssetManager().load("numbers.png", Texture.class);
        this.game.getAssetManager().load("score_board.png", Texture.class);

        finished = true;

    }
}
