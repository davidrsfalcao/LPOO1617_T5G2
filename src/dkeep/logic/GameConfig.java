package dkeep.logic;

import java.awt.event.KeyEvent;

public class GameConfig {
	private int width, height;
	private int guardType;
	private int nOgres;

	public GameConfig() {
		width = 10;
		height = 10;
		guardType = 0; // Rookie
		nOgres = 3;
	}

	public void setGameConfig(int width, int height, int guardType, int nOgres) {
		this.width = width;
		this.height = height;
		this.guardType = guardType;
		this.nOgres = nOgres;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getGuardType() {
		return guardType;
	}

	public int getNOgres() {
		return nOgres;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setGuardType(int guardType) {
		this.guardType = guardType;
	}

	public void setNOgres(int nOgres) {
		this.nOgres = nOgres;
	}


}
