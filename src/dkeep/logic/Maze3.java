package dkeep.logic;

import java.util.ArrayList;

public class Maze3 extends Map {

	private int i, j;

	public Maze3() {
		endPositions = new ArrayList<Position>();
	}

	public void setMap(char[][] map) {
		this.map = map;
		MAP_SIZE = map[0].length;

		for (i = 0; i < MAP_SIZE; i++) {
			for (j = 0; j < MAP_SIZE; j++) {
				setHero();
				setObjectives();
				cleanOgres();
			}
		}
		setGuard();
		setOgres();
	}

	/**
	 * Returns the next map
	 * 
	 * @return next map
	 */
	public Map nextMap() {
		return null;
	}

	/**
	 * Removes the key from the map
	 * 
	 */
	public void pickUpKey() {
		map[key.getY()][key.getX()] = ' ';
		key.changeTo(-10, -10);
	}

	@Override
	protected void setObjectives() {
		if (map[i][j] == 'k') {
			key = new Position(j, i, 'k');
			key.setType(2);
		}
		if (map[i][j] == 'I') {

			Position t1 = new Position(j, i, 'S');
			endPositions.add(t1);
		}

	}

	@Override
	protected void setHero() {
		ArrayList<Integer> hero = new ArrayList<Integer>();
		if (map[i][j] == 'A') {
			hero.add(j); // posX
			hero.add(i); // posY
			hero.add(0); // has_key
			hero.add(1); // is_armed
			map[i][j] = ' ';
			initValues.add(hero);
		}

	}

	@Override
	protected void setGuard() {
		setGuardInactive();
	}

	@Override
	protected void setOgres() {
		ArrayList<Integer> ogre = new ArrayList<Integer>();
		ogre.add(0); // playing

		initValues.add(ogre);

	}

	@Override
	protected void setMap() {
		// TODO Auto-generated method stub

	}

	private void cleanOgres() {
		if (map[i][j] == 'O') {
			map[i][j] = ' ';
		}
	}

}
