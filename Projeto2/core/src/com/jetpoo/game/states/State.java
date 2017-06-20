package com.jetpoo.game.states;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.jetpoo.game.JetPoo;



public abstract class State extends ApplicationAdapter{
    protected OrthographicCamera cam;
    protected Vector3 mouse;
    protected GameStateManager gsm;
    protected final JetPoo game;
    protected JetPoo gm;

    public State(GameStateManager gsm, JetPoo game) {
        this.gsm = gsm;
        this.game = game;
        cam = new OrthographicCamera();
        mouse = new Vector3();
        this.gm=game;
    }

    public abstract void update(float dt);

    public abstract void render(SpriteBatch sb);

}

