package com.jetpoo.game.states;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.jetpoo.game.JetPoo;
import com.jetpoo.game.useful.Animation;

/**
 * Created by pedromiranda on 01/06/17.
 */

public class GameOverState extends State{

    private int score;
    private Animation numbers;
    private Texture score_board;

    public GameOverState(GameStateManager gsm, JetPoo game, int score) {
        super(gsm, game);
        this.score = score;
        cam.setToOrtho(false, JetPoo.WIDTH, JetPoo.HEIGHT);
        game.playServices.submitScore(score);

        initTouchListener();
        getAssets();

    }

    private void getAssets(){
        Texture tmp = game.getAssetManager().get("others/numbers.png", Texture.class);
        numbers = new Animation(new TextureRegion(tmp), 10, 1 );
        score_board = game.getAssetManager().get("others/score_board.png", Texture.class);
    }

    private void initTouchListener(){
        Gdx.input.setInputProcessor(new InputAdapter(){

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                gsm.set(new MenuState(gsm, game));
                return true;
            }

        });

    }



    @Override
    public void update(float dt) {
        //do nothing
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        Texture background =  game.getAssetManager().get("background/Game_Over_bg.png", Texture.class);
        sb.draw(background, 0,0);

        displayScore(sb);

        sb.end();
    }

    @Override
    public void dispose() {
        //nothing to dispose
    }

    private void displayScore(SpriteBatch sb){

        /*
        * Mostra números de até 4 digitos
        * */
        int space = 30;
        int number = score;
        int x = 250;

        //sb.draw(score_board, 14 , JetPoo.HEIGHT - 102, 242, 100);

        for(int i=0; i < 4; i++ ){

            switch (number % 10){
                case 0:
                    sb.draw(numbers.getFrame(0), x +(3-i)*(space+100) , JetPoo.HEIGHT/2, 100, 160);
                    break;
                case 1:
                    sb.draw(numbers.getFrame(1), x + (3-i)*(space+100) , JetPoo.HEIGHT/2, 100, 160);
                    break;
                case 2:
                    sb.draw(numbers.getFrame(2), x + (3-i)*(space+100) , JetPoo.HEIGHT/2, 100, 160);
                    break;
                case 3:
                    sb.draw(numbers.getFrame(3), x + (3-i)*(space+100) , JetPoo.HEIGHT/2, 100, 160);
                    break;
                case 4:
                    sb.draw(numbers.getFrame(4), x + (3-i)*(space+100) , JetPoo.HEIGHT/2, 100, 160);
                    break;
                case 5:
                    sb.draw(numbers.getFrame(5), x + (3-i)*(space+100) , JetPoo.HEIGHT/2, 100, 160);
                    break;
                case 6:
                    sb.draw(numbers.getFrame(6), x + (3-i)*(space+100) , JetPoo.HEIGHT/2, 100, 160);
                    break;
                case 7:
                    sb.draw(numbers.getFrame(7), x + (3-i)*(space+100) , JetPoo.HEIGHT/2, 100, 160);
                    break;
                case 8:
                    sb.draw(numbers.getFrame(8), x + (3-i)*(space+100) , JetPoo.HEIGHT/2, 100, 160);
                    break;
                case 9:
                    sb.draw(numbers.getFrame(9), x + (3-i)*(space+100) , JetPoo.HEIGHT/2, 100, 160);
                    break;
            }
            number /= 10;

        }


    }
}
