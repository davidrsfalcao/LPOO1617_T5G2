package com.jetpoo.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jetpoo.game.JetPoo;


/**
 * Created by pedromiranda on 01/06/17.
 */

public class LeaderBoardState extends State{

    private Texture background;
    private Texture okBtn;
    public LeaderBoardState(GameStateManager gsm, JetPoo game) {
        super(gsm, game);
        cam.setToOrtho(false, JetPoo.WIDTH, JetPoo.HEIGHT/2);
        background = new Texture("bg.png");

        okBtn = new Texture("ok.png");


    }

    //@Override
    public void handleInput() {
        if(Gdx.input.getX() < cam.position.x-30 && Gdx.input.getX() > cam.position.x - 80 && Gdx.input.getY() > cam.position.y-80 && Gdx.input.getY() < cam.position.y-20){
            gsm.set(new MenuState(gsm, game));
        }



    }
  @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background, 0,0);
        sb.draw(okBtn, cam.position.x - okBtn.getWidth()/ 2, cam.position.y);

        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        okBtn.dispose();
        System.out.println("LeaderBoard State Disposed");
    }

}
