package com.jetpoo.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.jetpoo.game.JetPoo;

public class MenuState extends State{
    private Texture background;
    private Sprite playBtn;
    private Sprite leaderboardBtn;
    private Sprite creditsBtn;
    private Texture bottom;
    private Vector2 bottomPos1, bottomPos2;

    private final GameStateManager gsm;
    private float screenWidth_con;
    private float screenHeight_con;
    private int resX = JetPoo.WIDTH;
    private int resY = JetPoo.HEIGHT;
    private JetPoo gm;


    public MenuState(GameStateManager stateManager, final JetPoo game) {
        super(stateManager, game);
        this.gsm = stateManager;
        this.screenWidth_con = (float) resX / (float) Gdx.graphics.getWidth();
        this.screenHeight_con =  (float) resY/ (float) Gdx.graphics.getHeight();
        this.gm=game;

        cam.setToOrtho(false, resX, resY);

        background = game.getAssetManager().get("background/Menu_bg.png", Texture.class);
        bottom = game.getAssetManager().get("background/Menu_bg1.png", Texture.class);
        bottomPos1 = new Vector2(0,0);
        bottomPos2 = new Vector2(bottom.getWidth(),0);

        playBtn = new Sprite(game.getAssetManager().get("buttons/button_play.png", Texture.class));
        playBtn.setBounds(362/screenWidth_con , 257/screenHeight_con, 300/screenWidth_con , 100/screenHeight_con);

        leaderboardBtn= new Sprite(game.getAssetManager().get("buttons/button_leaderboard.png", Texture.class));
        leaderboardBtn.setBounds(362/screenWidth_con , 377/screenHeight_con  , 300/screenWidth_con, 100/screenHeight_con );


        creditsBtn = new Sprite(game.getAssetManager().get("buttons/button_credits.png", Texture.class));
        creditsBtn.setBounds(362/screenWidth_con , 497/screenHeight_con  , 300/screenWidth_con, 100 /screenHeight_con);


        Gdx.input.setInputProcessor(new InputAdapter(){

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {


                if(playBtn.getBoundingRectangle().contains(screenX, screenY)){
                    gsm.set(new PlayState(gsm, game));
                }

                if(leaderboardBtn.getBoundingRectangle().contains(screenX, screenY)){
                    gm.playServices.showScore();
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

        if (bottomPos1.x <= - bottom.getWidth())
        {
            bottomPos1.x = bottom.getWidth()-4;
        }
        else {
            bottomPos1.x -= 2;
        }

        if (bottomPos2.x <= - bottom.getWidth())
        {
            bottomPos2.x = bottom.getWidth()-4;
        }
        else {
            bottomPos2.x -= 2;
        }


    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);

        Gdx.gl.glClearColor( 1, 1, 1, 1 );
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );

        sb.begin();

        // Moving botton
        sb.draw(bottom, bottomPos1.x, bottomPos1.y);
        sb.draw(bottom, bottomPos2.x, bottomPos2.y);

        // Background
        sb.draw(background, 0,0, resX, resY);

        //Buttons
        sb.draw(playBtn, 362 , resY-(357), 297  , 100);
        sb.draw(leaderboardBtn, 362 , resY-(477), 297  , 100);
        //sb.draw(creditsBtn, 362 , resY-(597), 297  , 100);


        sb.end();
    }

}
