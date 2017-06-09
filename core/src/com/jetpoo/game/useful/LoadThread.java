package com.jetpoo.game.useful;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
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
        this.game.getAssetManager().load("background/Menu_bg.png", Texture.class);
        this.game.getAssetManager().load("background/Menu_bg1.png", Texture.class);
        this.game.getAssetManager().load("buttons/button_play.png", Texture.class);
        this.game.getAssetManager().load("buttons/button_leaderboard.png", Texture.class);
        this.game.getAssetManager().load("buttons/button_credits.png", Texture.class);

        this.game.getAssetManager().load("background/ground.png", Texture.class);
        this.game.getAssetManager().load("background/ceiling.png", Texture.class);
        this.game.getAssetManager().load("character/Character-run.png", Texture.class);
        this.game.getAssetManager().load("character/Character-acelerating.png", Texture.class);
        this.game.getAssetManager().load("character/Character-falling.png", Texture.class);

        this.game.getAssetManager().load("laser.png", Texture.class);
        this.game.getAssetManager().load("numbers.png", Texture.class);
        this.game.getAssetManager().load("score_board.png", Texture.class);

        this.game.getAssetManager().load("sounds/sound.ogg", Music.class);

        finished = true;

    }
}
