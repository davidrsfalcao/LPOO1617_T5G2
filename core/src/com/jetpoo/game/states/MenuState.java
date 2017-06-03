package com.jetpoo.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jetpoo.game.JetPoo;

public class MenuState extends State{
    private Texture background;
    private Sprite playBtn;
    private Texture loginBtn;
    private Sprite leaderboardBtn;
    private Sprite creditsBtn;

    private GameStateManager gsm;
    private float screenWidth_con;
    private float screenHeight_con;
    private int resX = 1024;
    private int resY = 768;

    public MenuState(final GameStateManager gsm) {
        super(gsm);
        this.gsm = gsm;
        this.screenWidth_con = (float) resX / (float) Gdx.graphics.getWidth();
        this.screenHeight_con =  (float) resY/ (float) Gdx.graphics.getHeight();

        cam.setToOrtho(false, resX, resY);

        background = new Texture("Menu_bg.png");

        playBtn = new Sprite(new Texture("button_play.png"));
        playBtn.setBounds(7/screenWidth_con , 7/screenHeight_con, 297/screenWidth_con , 100/screenHeight_con);

        leaderboardBtn= new Sprite(new Texture("button_leaderboard.png"));
        leaderboardBtn.setBounds(7/screenWidth_con , 127/screenHeight_con  , 297/screenWidth_con, 100/screenHeight_con );


        creditsBtn = new Sprite(new Texture("button_credits.png"));
        creditsBtn.setBounds(7/screenWidth_con , 247/screenHeight_con  , 297/screenWidth_con, 100 /screenHeight_con);

        loginBtn=new Texture("login.png");

        Gdx.input.setInputProcessor(new InputAdapter(){

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {


                if(playBtn.getBoundingRectangle().contains(screenX, screenY)){
                    gsm.set(new PlayState(gsm));
                }


                if(leaderboardBtn.getBoundingRectangle().contains(screenX, screenY)){
                    gsm.set(new LeaderBoardState(gsm));
                }

                if(creditsBtn.getBoundingRectangle().contains(screenX, screenY)){
                    //gsm.set(new LeaderBoardState(gsm));
                    System.out.println("Creditos");
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
        //Do nothing
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background, 0,0, resX, resY);
        sb.draw(playBtn, 7 , resY-(107), 297  , 100);
        sb.draw(leaderboardBtn, 7 , resY-(227), 297  , 100);
        sb.draw(creditsBtn, 7 , resY-(347), 297  , 100);

        //sb.draw(loginBtn,10,cam.position.y-200);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        //playBtn.dispose();
        //leaderboardBtn.dispose();
        loginBtn.dispose();
        Gdx.input.setInputProcessor(null);
    }
}
