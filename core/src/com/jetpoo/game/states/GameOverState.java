package com.jetpoo.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.jetpoo.game.JetPoo;

/**
 * Created by pedromiranda on 01/06/17.
 */

public class GameOverState extends State{

    private Texture background;
    private Texture replayBtn;
    private Texture menuBtn;
    public GameOverState(GameStateManager gsm, JetPoo game) {
        super(gsm, game);
        cam.setToOrtho(false, JetPoo.WIDTH, JetPoo.HEIGHT/2);

        replayBtn = new Texture("playbtn.png");
        menuBtn = new Texture ("x.png");


    }

    //@Override
    public void handleInput() {
        if(Gdx.input.getX() < cam.position.x+20 && Gdx.input.getX() > cam.position.x - 130 && Gdx.input.getY() < cam.position.y+50 && Gdx.input.getY() > cam.position.y-50){
            gsm.set(new PlayState(gsm, game));
        }
        if(Gdx.input.getX() > cam.position.x+90 && Gdx.input.getX() < cam.position.x + 170 && Gdx.input.getY() < cam.position.y+50 && Gdx.input.getY() > cam.position.y-50){
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
        sb.draw(replayBtn, cam.position.x - replayBtn.getWidth()-90/ 2, cam.position.y);
        sb.draw(menuBtn,cam.position.x - menuBtn.getWidth()+150/2,cam.position.y);

        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        replayBtn.dispose();
        menuBtn.dispose();
    }
}
