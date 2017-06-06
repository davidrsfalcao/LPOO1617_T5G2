package com.jetpoo.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.jetpoo.game.JetPoo;

import java.util.Random;

/**
 * Created by davidfalcao on 03/06/17.
 */

public class Obstacle {
    private Vector2 position;
    private int height;
    protected Rectangle bounds;
    private float con_x; // converter unidades ecrã em unidades do jogo
    private float con_y; // converter unidades ecrã em unidades do jogo
    private Random randomGenerator;

    public Obstacle(JetPoo game, int x) {
        randomGenerator = new Random();
        con_x = (float) JetPoo.WIDTH / (float) Gdx.graphics.getWidth();
        con_y = (float) JetPoo.HEIGHT / (float) Gdx.graphics.getHeight();
        position = new Vector2();
        position.x = x;
        initPosition(game);
        initHeight(game);
        initBounds();

    }

    public void initPosition(JetPoo game){
        int ground = game.getAssetManager().get("ground.png", Texture.class).getHeight()/2;
        int ceiling = game.getAssetManager().get("ceiling.png", Texture.class).getHeight();

        position.y = randomGenerator.nextInt(JetPoo.HEIGHT-ceiling-ground) + ground;
    }

    public void initHeight(JetPoo game){
        int ground = game.getAssetManager().get("ground.png", Texture.class).getHeight()/2;
        int ceiling = game.getAssetManager().get("ceiling.png", Texture.class).getHeight();

        height = randomGenerator.nextInt(JetPoo.HEIGHT-ceiling-ground-200)/2 +100;

        if (position.y + height > JetPoo.HEIGHT-ceiling){
            position.y -= height;
        }

    }

    public void initBounds(){
        bounds = new Rectangle((position.x-20)*con_x, position.y*con_y, 40*con_x, height*con_y);

    }

    public void update(float delta){
        position.x -= delta;
        bounds.setPosition((position.x-40)*con_x,position.y*con_y );

    }

    public float getX(){
        return position.x;
    }

    public float getY(){
        return position.y;
    }

    public int getHeight(){
        return height;
    }

    public Rectangle getBounds() {
        return bounds;
    }
}
