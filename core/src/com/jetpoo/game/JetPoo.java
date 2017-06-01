package com.jetpoo.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jetpoo.game.states.GameStateManager;
import com.jetpoo.game.states.MenuState;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Text;

public class JetPoo extends ApplicationAdapter {

	private static JetPoo instance;

	public static final int WIDTH = 768;
	public static final int HEIGHT = 1024;

	public static final String TITLE = "JetPoo";
	private GameStateManager gsm;
	private SpriteBatch batch;
	private AssetManager assetManager;

	private Music music;


	@Override
	public void create () {
		assetManager = new AssetManager();
		batch = new SpriteBatch();
		gsm = new GameStateManager(this);
		startGame();

	}

	/**
	 * Starts the game.
	 */
	private void startGame() {
		assetManager.load("birdanimation.png", Texture.class);
		assetManager.finishLoading();
		music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
		music.setLooping(true);
		music.setVolume(0.1f);
		music.play();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		gsm.push(new MenuState(gsm));
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
		music.dispose();
		assetManager.dispose();
	}


	public AssetManager getAssetManager(){
		return assetManager;
	}

	public static JetPoo getInstance(){
		return instance;
	}
}
