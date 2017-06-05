package com.jetpoo.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.jetpoo.game.JetPoo;
import com.jetpoo.game.actors.Bird;
import com.jetpoo.game.actors.Hero;
import com.jetpoo.game.actors.NormalGuy;
import com.jetpoo.game.actors.Tube;
import com.jetpoo.game.useful.Animation;


public class PlayState extends State{
    private static final int TUBE_SPACING = 300;
    private static final int TUBE_COUNT = 4;
    public static final int GRAVITY = 10;


    //Character
    private Bird bird;
    private Hero hero;
    private Animation runningAnimation;
    private Animation aceleratingAnimation;
    private Texture fallingAnimation;



    private int speed;

    private boolean screenTouched;


    //Textures
    private Texture ground;
    private Texture ceiling;
    private Vector2 groundPos1, groundPos2;
    private Texture bottom;
    private Vector2 bottomPos1, bottomPos2;

    private Array<Tube> tubes;

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
        runningAnimation = new Animation(new TextureRegion(tmp), 6, 0.5f );

    }

    private void initVariables(){
        cam.setToOrtho(false, JetPoo.WIDTH, JetPoo.HEIGHT);

        speed = 100;
        hero = new NormalGuy(100,0);
        screenTouched = false;


        bird = new Bird(50, 300);
        groundPos1 = new Vector2(0, 0);
        groundPos2 = new Vector2(ground.getWidth(), 0);

        bottomPos1 = new Vector2(0,0);
        bottomPos2 = new Vector2(bottom.getWidth(),0);


        tubes = new Array<Tube>();

        for(int i = 1; i <= TUBE_COUNT; i++){
            tubes.add(new Tube(i * (TUBE_SPACING + Tube.TUBE_WIDTH)));
        }

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


    @Override
    public void update(float dt) {

        handleInput();
        updateScene(dt);


        hero.updatePosition(dt);
        runningAnimation.update(dt);


        for(int i = 0; i < tubes.size; i++){
            Tube tube = tubes.get(i);

            if(cam.position.x - (cam.viewportWidth / 2) > tube.getPosTopTube().x + tube.getTopTube().getWidth()){
                tube.reposition(tube.getPosTopTube().x  + ((Tube.TUBE_WIDTH + TUBE_SPACING) * TUBE_COUNT));
            }

            if(tube.collides(bird.getBounds()))
                gsm.set(new GameOverState(gsm, game));
        }

        if(bird.getPosition().y <= ground.getHeight() + 0)
            gsm.set(new GameOverState(gsm, game));
        cam.update();

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


        sb.draw(runningAnimation.getFrame(), hero.getX(), hero.getY() + ground.getHeight()/2, 100, 100);


        sb.end();
    }

    @Override
    public void dispose() {
        bird.dispose();
        ground.dispose();
        for(Tube tube : tubes)
            tube.dispose();

    }

    private void updateScene(float dt){
        moveSceen(dt, ground, groundPos1, groundPos2);
        moveSceen(dt, bottom, bottomPos1, bottomPos2);
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
}
