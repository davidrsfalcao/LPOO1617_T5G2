package com.jetpoo.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.jetpoo.game.JetPoo;
import com.jetpoo.game.actors.Hero;
import com.jetpoo.game.actors.NormalGuy;
import com.jetpoo.game.actors.Obstacle;
import com.jetpoo.game.useful.Animation;

import java.util.Vector;


public class PlayState extends State{

    private enum Condition {
        running, falling, acelerating;
    }

    public static final int GRAVITY = 10;
    private int speed;
    private int counter = 0;
    private int score;
    private boolean game_pause;
    private boolean screenTouched;
    private Condition condition;

    /*
    * ACTORS
    * */
    private Hero hero;
    private Vector<Obstacle> lasers;

    /*
    * TEXTURES
    * */
    private Animation runningAnimation;
    private Animation aceleratingAnimation;
    private Texture fallingAnimation;
    private TextureRegion actual;
    private Texture ground;
    private Texture ceiling;
    private Texture bottom;
    private Animation laserAnimation;
    private Animation numbers;
    private Texture score_board;







    //Textures

    private Rectangle ground_bounds;

    private Rectangle ceiling_bounds;
    private Vector2 groundPos1, groundPos2;

    private Vector2 bottomPos1, bottomPos2;


    public PlayState(GameStateManager gsm, JetPoo game) {
        super(gsm, game);

        start();
    }

    private void start(){
        getAssets();
        initVariables();
        initTouchListener();

    }

    private void getAssets(){
        ground = game.getAssetManager().get("ground.png", Texture.class);
        bottom = game.getAssetManager().get("Menu_bg1.png", Texture.class);
        ceiling = game.getAssetManager().get("ceiling.png", Texture.class);
        Texture tmp = game.getAssetManager().get("Character-run.png", Texture.class);
        runningAnimation = new Animation(new TextureRegion(tmp), 6, 0.9f);
        tmp = game.getAssetManager().get("Character-acelerating.png", Texture.class);
        aceleratingAnimation = new Animation(new TextureRegion(tmp), 7, 0.5f );
        fallingAnimation = game.getAssetManager().get("Character-falling.png", Texture.class);
        tmp = game.getAssetManager().get("laser.png", Texture.class);
        laserAnimation = new Animation(new TextureRegion(tmp), 7, 1 );
        tmp = game.getAssetManager().get("numbers.png", Texture.class);
        numbers = new Animation(new TextureRegion(tmp), 10, 1 );
        score_board = game.getAssetManager().get("score_board.png", Texture.class);

    }

    private void initVariables(){
        cam.setToOrtho(false, JetPoo.WIDTH, JetPoo.HEIGHT);

        speed = 100;
        score = 0;
        game_pause = false;
        hero = new NormalGuy(100,64);
        screenTouched = false;
        condition = Condition.running;
        lasers = new Vector<Obstacle>();


        float con_x = hero.getScreenWidth_con();
        float con_y = hero.getScreenHeight_con();

        ceiling_bounds = new Rectangle(0,(JetPoo.HEIGHT-ceiling.getHeight())*con_y, (ceiling.getWidth()/2)*con_x, ceiling.getHeight()*con_y);
        ground_bounds = new Rectangle(0,0, (ground.getWidth()/2)*con_x, (ground.getHeight()/2)*con_y);
        groundPos1 = new Vector2(0, 0);
        groundPos2 = new Vector2(ground.getWidth(), 0);

        bottomPos1 = new Vector2(0,0);
        bottomPos2 = new Vector2(bottom.getWidth(),0);


    }

    private void initTouchListener(){
        Gdx.input.setInputProcessor(new InputAdapter(){

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                screenTouched = true;
                return true;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                screenTouched = false;
                return true;
            }

        });

    }

    public void handleInput(){
        if (screenTouched){
            hero.jump();
        }
        else hero.setAcelerating(false);
    }

    public void testColisions(){
        hero.colideGround(ground_bounds);
        hero.colideCeiling(ceiling_bounds);
    }

    void updateHeroTexture(float dt){
        Condition a;

        if (hero.isOntheGround()){
            a = Condition.running;
        }
        else if (hero.isAcelerating()){
            a = Condition.acelerating;
        }
        else a = Condition.falling;

        switch (a){
            case running:
                if (condition == a)
                {
                    runningAnimation.update(dt);
                    actual = runningAnimation.getFrame();
                }
                else {
                    runningAnimation.reset();
                    actual = runningAnimation.getFrame();
                }
                break;

            case falling:
                actual = new TextureRegion(fallingAnimation);
                break;

            case acelerating:
                if (condition == a)
                {
                    aceleratingAnimation.update(dt);
                    actual = aceleratingAnimation.getFrame();
                }
                else {
                    aceleratingAnimation.reset();
                    actual = aceleratingAnimation.getFrame();
                }
                break;
        }

        condition = a;

    }

    @Override
    public void update(float dt) {

        if(!game_pause && dt < 1) {
            handleInput();
            updateScene(dt);

            hero.update(dt);
            runningAnimation.update(dt);
            testColisions();
            obstaclesFactory(dt);
            updateHeroTexture(dt);
        }


    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();

        sb.draw(bottom, bottomPos1.x, bottomPos1.y);
        sb.draw(bottom, bottomPos2.x, bottomPos2.y);

        sb.draw(ground, groundPos1.x, - ground.getHeight()/2);
        sb.draw(ground, groundPos2.x, - ground.getHeight()/2);
        sb.draw(ceiling, groundPos1.x, JetPoo.HEIGHT-ceiling.getHeight());
        sb.draw(ceiling, groundPos2.x, JetPoo.HEIGHT-ceiling.getHeight());

        displayScore(sb);


        for(int i=0; i < lasers.size(); i++){
            sb.draw(laserAnimation.getFrame(), lasers.get(i).getX(),lasers.get(i).getY(), 160, lasers.get(i).getHeight());
        }


        if (condition == Condition.acelerating){
            sb.draw(actual, hero.getX()-10, hero.getY()-8, 120, 110);

        }
        else sb.draw(actual, hero.getX(), hero.getY(), 100, 100);


        sb.end();
    }

    @Override
    public void dispose() {
        ground.dispose();
        ceiling.dispose();
        bottom.dispose();

    }

    @Override
    public void pause(){
        game_pause = true;

    }

    @Override
    public void resume(){
        game_pause = false;

    }

    private void updateScene(float dt){
        moveSceen(dt, ground, groundPos1, groundPos2);
        moveSceen(dt, bottom, bottomPos1, bottomPos2);
        counter += speed * dt;
    }

    private void moveSceen(float dt, Texture text, Vector2 v1, Vector2 v2){

        if (v1.x <= - text.getWidth())
        {
            v1.x = v2.x + text.getWidth()/2;
        }
        else if (v2.x <= - text.getWidth())
        {
            v2.x =v1.x+ text.getWidth()/2;
        }

        v1.x -= speed * dt;
        v2.x -= speed*dt;

    }

    private void obstaclesFactory(float dt){

        boolean increase = false;
        for (int i= 0; i < lasers.size(); i++){
            if (lasers.get(i).getX() < -100){
                lasers.remove(i);
                score += 1;
                increase = true;
            }
            else {
                lasers.get(i).update(speed * dt);
                if (hero.colideLaser(lasers.get(i))){
                    gsm.set(new GameOverState(gsm, game));
                }
            }
        }

        if (counter > 500){
            lasers.add(new Obstacle(game, JetPoo.WIDTH + 10));
            counter = 0;
        }

        if (increase)
            speed += 10;
        laserAnimation.update(dt);
    }

    private void displayScore(SpriteBatch sb){

        /*
        * Mostra números de até 4 digitos
        * */
        int space = 10;
        int number = score;

        sb.draw(score_board, 14 , JetPoo.HEIGHT - 102, 242, 100);

        for(int i=0; i < 4; i++ ){

            switch (number % 10){
                case 0:
                    sb.draw(numbers.getFrame(0), 20 +(3-i)*(space+50) , JetPoo.HEIGHT - 90, 50, 80);
                    break;
                case 1:
                    sb.draw(numbers.getFrame(1), 20 + (3-i)*(space+50) , JetPoo.HEIGHT - 90, 50, 80);
                    break;
                case 2:
                    sb.draw(numbers.getFrame(2), 20 + (3-i)*(space+50) , JetPoo.HEIGHT - 90, 50, 80);
                    break;
                case 3:
                    sb.draw(numbers.getFrame(3), 20 + (3-i)*(space+50) , JetPoo.HEIGHT - 90, 50, 80);
                    break;
                case 4:
                    sb.draw(numbers.getFrame(4), 20 + (3-i)*(space+50) , JetPoo.HEIGHT - 90, 50, 80);
                    break;
                case 5:
                    sb.draw(numbers.getFrame(5), 20 + (3-i)*(space+50) , JetPoo.HEIGHT - 90, 50, 80);
                    break;
                case 6:
                    sb.draw(numbers.getFrame(6), 20 + (3-i)*(space+50) , JetPoo.HEIGHT - 90, 50, 80);
                    break;
                case 7:
                    sb.draw(numbers.getFrame(7), 20 + (3-i)*(space+50) , JetPoo.HEIGHT - 90, 50, 80);
                    break;
                case 8:
                    sb.draw(numbers.getFrame(8), 20 + (3-i)*(space+50) , JetPoo.HEIGHT - 90, 50, 80);
                    break;
                case 9:
                    sb.draw(numbers.getFrame(9), 20 + (3-i)*(space+50) , JetPoo.HEIGHT - 90, 50, 80);
                    break;
            }
            number /= 10;

        }


    }

}
