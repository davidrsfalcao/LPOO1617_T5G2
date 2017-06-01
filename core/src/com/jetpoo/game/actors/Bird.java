package com.jetpoo.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import com.jetpoo.game.JetPoo;
import com.jetpoo.game.useful.Animation;


public class Bird {
    private JetPoo game;
    private static final int GRAVITY = -10;
    private static final int MOVEMENT = 100;
    private Vector2 position;
    private Vector2 velocity;
    private Rectangle bounds;
    private Animation birdAnimation;
    private Texture texture;
    private Sound flap;

    public Bird(JetPoo game,int x, int y){
        this.game = game;
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        texture = game.getAssetManager().get("birdanimation.png", Texture.class);
        birdAnimation = new com.jetpoo.game.useful.Animation(new TextureRegion(texture), 3, 0.5f);
        bounds = new Rectangle(x, y, 34, 36);
        flap = Gdx.audio.newSound(Gdx.files.internal("sfx_wing.ogg"));
    }

    public void update(float dt){
        birdAnimation.update(dt);
        if(position.y > 0)
            velocity.add(0, GRAVITY);
        velocity.scl(dt);
        position.add(MOVEMENT * dt, velocity.y);
        if(position.y < 0)
            position.y = 0;
        if (position.y > 360)
            position.y = 360;

        velocity.scl(1/dt);
        bounds.setPosition(position.x, position.y);
    }

    public Vector2 getPosition() {
        return position;
    }

    public TextureRegion getTexture() {
        return birdAnimation.getFrame();
    }

    public void jump(){
        velocity.y = 250;
        flap.play(0.5f);
    }

    public Rectangle getBounds(){
        return bounds;
    }

    public void dispose(){
        texture.dispose();
        flap.dispose();
    }

}