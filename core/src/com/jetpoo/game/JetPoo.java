package com.jetpoo.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jetpoo.game.states.GameStateManager;
import com.jetpoo.game.states.LoadingState;
import com.jetpoo.game.Server.PlayServices;


public class JetPoo extends ApplicationAdapter {

	public static final int WIDTH = 1024;
	public static final int HEIGHT = 768;
	public static PlayServices playServices;

	public static final String TITLE = "JetPoo";
	private GameStateManager gsm;
	private SpriteBatch batch;
	private AssetManager assetManager;

	@Override
	public void create () {
		assetManager = new AssetManager();
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		startGame();

	}

	/**
	 * Starts the game.
	 */
	private void startGame() {
		gsm.push(new LoadingState(gsm, this));
	}


	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}

	@Override
	public void dispose() {
		super.dispose();
		assetManager.dispose();
	}

	public JetPoo(){
	}

	public JetPoo(PlayServices playServices)
	{
		this.playServices = playServices;
	}


	public AssetManager getAssetManager(){
		return assetManager;
	}


}
