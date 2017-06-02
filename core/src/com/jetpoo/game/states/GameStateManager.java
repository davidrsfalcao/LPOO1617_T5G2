package com.jetpoo.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jetpoo.game.JetPoo;

import java.util.Stack;

public class GameStateManager {

    private JetPoo game;
    private Stack<State> states;

    public GameStateManager(JetPoo game){
        this.game = game;
        states = new Stack<State>();
    }

    public void push(State state){
        states.push(state);
    }

    public void pop(){
        states.pop().dispose();
    }

    public void set(State state){
        states.pop().dispose();
        states.push(state);
    }

    public void update(float dt){
        states.peek().update(dt);
    }

    public void render(SpriteBatch sb){
        states.peek().render(sb);
    }

    public JetPoo getGame() {
        return game;
    }
}
