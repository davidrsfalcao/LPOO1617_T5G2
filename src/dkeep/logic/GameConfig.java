package dkeep.logic;

import java.awt.event.KeyEvent;

public class GameConfig {
	private int width, height;
	private int guardType;
	private int nOgres;
	private int upKeyAssignment = KeyEvent.VK_W;
	private int downKeyAssignment = KeyEvent.VK_S;
	private int leftKeyAssignment = KeyEvent.VK_A;
	private int rightKeyAssignment = KeyEvent.VK_D;

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

	public int getUpKeyAssignment() {
		return upKeyAssignment;
	}

	public int getDownKeyAssignment() {
		return downKeyAssignment;
	}

	public int getLeftKeyAssignment() {
		return leftKeyAssignment;
	}

	public int getRightKeyAssignment() {
		return rightKeyAssignment;
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

	public void setUpKeyAssignment(int upKeyAssignment) {
		this.upKeyAssignment = upKeyAssignment;
	}

	public void setDownKeyAssignment(int downKeyAssignment) {
		this.downKeyAssignment = downKeyAssignment;
	}

	public void setLeftKeyAssignment(int leftKeyAssignment) {
		this.leftKeyAssignment = leftKeyAssignment;
	}

	public void setRightKeyAssignment(int rightKeyAssignment) {
		this.rightKeyAssignment = rightKeyAssignment;
	}

}
