package dkeep.logic;

import java.util.ArrayList;

/**
 * 
 * Map of a level created using "Create Maze"
 * 
 * @author davidfalcao
 *
 */
public class Maze3 extends Map {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int i, j;

	/**
	 * Constructor of Maze3
	 */
	public Maze3() {
		endPositions = new ArrayList<Position>();
	}

	/**
	 * Defines the map of a level
	 * 
	 * @param map new map
	 * 
	 */
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

	/**
	 * Defines the key or lever and the endpositions of the map
	 * 
	 */
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

	/**
	 * Defines de initial position of the hero
	 * 
	 */
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

	/**
	 * Defines the initial position of the guard
	 * 
	 */
	@Override
	protected void setGuard() {
		setGuardInactive();
	}

	/**
	 * Defines if the level was played by ogres
	 * 
	 */
	@Override
	protected void setOgres() {
		ArrayList<Integer> ogre = new ArrayList<Integer>();
		ogre.add(0); // playing

		initValues.add(ogre);

	}

	/**
	 * Defines the map of a level
	 * 
	 */
	@Override
	protected void setMap() {

	}

	/**
	 * Clean the 'O' of map returned by "Create Maze"
	 * 
	 */
	private void cleanOgres() {
		if (map[i][j] == 'O') {
			map[i][j] = ' ';
		}
	}

}
