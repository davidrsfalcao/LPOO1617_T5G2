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

    private final GameStateManager gsm;
    private float screenWidth_con;
    private float screenHeight_con;
    private int resX = JetPoo.WIDTH;
    private int resY = JetPoo.HEIGHT;

    public MenuState(GameStateManager stateManager, final JetPoo game) {
        super(stateManager, game);
        this.gsm = stateManager;
        this.screenWidth_con = (float) resX / (float) Gdx.graphics.getWidth();
        this.screenHeight_con =  (float) resY/ (float) Gdx.graphics.getHeight();

        cam.setToOrtho(false, resX, resY);

        background = game.getAssetManager().get("Menu_bg.png", Texture.class);

        playBtn = new Sprite(game.getAssetManager().get("button_play.png", Texture.class));
        playBtn.setBounds(362/screenWidth_con , 257/screenHeight_con, 300/screenWidth_con , 100/screenHeight_con);

        leaderboardBtn= new Sprite(game.getAssetManager().get("button_leaderboard.png", Texture.class));
        leaderboardBtn.setBounds(362/screenWidth_con , 377/screenHeight_con  , 300/screenWidth_con, 100/screenHeight_con );


        creditsBtn = new Sprite(new Texture("button_credits.png"));
        creditsBtn.setBounds(362/screenWidth_con , 497/screenHeight_con  , 300/screenWidth_con, 100 /screenHeight_con);

        loginBtn=new Texture("login.png");

        Gdx.input.setInputProcessor(new InputAdapter(){

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {


                if(playBtn.getBoundingRectangle().contains(screenX, screenY)){
                    gsm.set(new PlayState(gsm, game));
                }

                if(leaderboardBtn.getBoundingRectangle().contains(screenX, screenY)){
                    gsm.set(new LeaderBoardState(gsm, game));
                }

                if(creditsBtn.getBoundingRectangle().contains(screenX, screenY)){
                    //gsm.set(new LeaderBoardState(gsm, game));
                    System.out.println("Creditos");
                }


                return true;
            }

        });


    }



    @Override
    public void update(float dt) {
        //Do nothing
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background, 0,0, resX, resY);
        sb.draw(playBtn, 362 , resY-(357), 297  , 100);
        sb.draw(leaderboardBtn, 362 , resY-(477), 297  , 100);
        sb.draw(creditsBtn, 362 , resY-(597), 297  , 100);

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
