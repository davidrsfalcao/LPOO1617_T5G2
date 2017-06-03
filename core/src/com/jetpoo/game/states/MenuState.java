package com.jetpoo.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jetpoo.game.JetPoo;

public class MenuState extends State{
    private Texture background;
    private Sprite playBtn;
    private Texture loginBtn;
    private Texture leaderboardBtn;
    private GameStateManager gsm;
    public MenuState(final GameStateManager gsm) {
        super(gsm);
        this.gsm = gsm;
        cam.setToOrtho(false, 1024, 768);
        background = new Texture("bg.png");
        playBtn = new Sprite(new Texture("playbtn.png"));
        //playBtn.setBounds(170,190, 185, 38);
        playBtn.setBounds(0,0, 200, 200);
        leaderboardBtn=new Texture("leaderboard.png");
        loginBtn=new Texture("login.png");

        Gdx.input.setInputProcessor(new InputAdapter(){

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {

                if(playBtn.getBoundingRectangle().contains(screenX, screenY)){
                    gsm.set(new PlayState(gsm));
                    System.out.println("Play button");
                }

                return true;
            }

        });


    }

    /*
    @Override
    public void handleInput() {

        if (Gdx.input.getX() < cam.position.x - 20 && Gdx.input.getX() > cam.position.x - 100 && Gdx.input.getY() < cam.position.y - 100 && Gdx.input.getY() > cam.position.y - 160) {
            gsm.set(new PlayState(gsm));
        }
        if (Gdx.input.getX() < cam.position.x - 20 && Gdx.input.getX() > cam.position.x - 80 && Gdx.input.getY() < cam.position.y + 40 && Gdx.input.getY() > cam.position.y - 40) {
            gsm.set(new LeaderBoardState(gsm));
        }

    }
    */

    @Override
    public void update(float dt) {
        //handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background, 0,0);
        sb.draw(playBtn, 270, 400);
        sb.draw(leaderboardBtn,cam.position.x - leaderboardBtn.getWidth()/2,cam.position.y-50);
        sb.draw(loginBtn,10,cam.position.y-200);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        //playBtn.dispose();
        leaderboardBtn.dispose();
        loginBtn.dispose();
        Gdx.input.setInputProcessor(null);
    }
}
