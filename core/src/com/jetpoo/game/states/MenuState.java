package com.jetpoo.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jetpoo.game.JetPoo;

public class MenuState extends State{
    private Texture background;
    private Texture playBtn;
    private Texture loginBtn;
    private Texture leaderboardBtn;
    public MenuState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, JetPoo.WIDTH, JetPoo.HEIGHT/2);
        background = new Texture("bg.png");
        playBtn = new Texture("playbtn.png");
        leaderboardBtn=new Texture("leaderboard.png");
        loginBtn=new Texture("login.png");


    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()) {
            if (Gdx.input.getX() < cam.position.x - 20 && Gdx.input.getX() > cam.position.x - 100 && Gdx.input.getY() < cam.position.y - 100 && Gdx.input.getY() > cam.position.y - 160) {
                gsm.set(new PlayState(gsm));
            }
            if (Gdx.input.getX() < cam.position.x - 20 && Gdx.input.getX() > cam.position.x - 80 && Gdx.input.getY() < cam.position.y + 40 && Gdx.input.getY() > cam.position.y - 40) {
                gsm.set(new LeaderBoardState(gsm));
            }
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
        sb.draw(playBtn, cam.position.x - playBtn.getWidth()/ 2, cam.position.y+90);
        sb.draw(leaderboardBtn,cam.position.x - leaderboardBtn.getWidth()/2,cam.position.y-50);
        sb.draw(loginBtn,10,cam.position.y-200);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
        leaderboardBtn.dispose();
        loginBtn.dispose();
        System.out.println("Menu State Disposed");
    }
}
