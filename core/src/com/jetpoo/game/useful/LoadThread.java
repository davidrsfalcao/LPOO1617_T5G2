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
        System.out.println("Here");
        this.game.getAssetManager().load("bg.png", Texture.class);
        this.game.getAssetManager().load("Menu_bg.png", Texture.class);
        this.game.getAssetManager().load("button_play.png", Texture.class);
        this.game.getAssetManager().load("button_leaderboard.png", Texture.class);




        finished = true;


    }
}
