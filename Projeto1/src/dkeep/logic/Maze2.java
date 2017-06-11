package dkeep.logic;

import java.util.ArrayList;

/**
 * Map of second level
 * 
 * @author davidfalcao
 *
 */
public class Maze2 extends Map{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	char[][]temp={{'X','X','X','X','X','X','X','X','X'} ,
				  {'I',' ',' ',' ',' ',' ',' ','k','X'} ,
				  {'X',' ',' ',' ',' ',' ',' ',' ','X'} ,
				  {'X',' ',' ',' ',' ',' ',' ',' ','X'} ,
				  {'X',' ',' ',' ',' ',' ',' ',' ','X'} ,
				  {'X',' ',' ',' ',' ',' ',' ',' ','X'} ,
				  {'X',' ',' ',' ',' ',' ',' ',' ','X'} ,
				  {'X',' ',' ',' ',' ',' ',' ',' ','X'} ,
				  {'X','X','X','X','X','X','X','X','X'} };
	
	/**
	 * Constructor of 2nd Maze
	 * 
	 */
	public Maze2(){ 
		MAP_SIZE = 9;
		init();

	}
	
	/**
	 * Defines the key or lever and the endpositions of the map
	 * 
	 */
	public void setObjectives()
	{
		key = new Position(7,1,'k');
		key.setType(2);
		endPositions = new ArrayList<Position>();
		Position t1 = new Position(0,1,'S');
		endPositions.add(t1);
		
	}
	
	/**
	 * Returns the next map
	 * 
	 * @return next map
	 */
	public Map nextMap(){
		return null;
	}

	/**
	 * Removes the key from the map
	 * 
	 */
	public void pickUpKey(){
		map[1][7] = ' ';
		key.changeTo(-10, -10);
	}

	/**
	 * Defines de initial position of the hero
	 * 
	 */
	protected void setHero(){
		ArrayList<Integer> hero = new ArrayList<Integer>();
		hero.add(1); //posX
		hero.add(7); //posY
		hero.add(0); //has_key
		hero.add(1); //is_armed
		initValues.add(hero);
		
	}
	
	/**
	 * Defines the initial position of the guard
	 * 
	 */
	protected void setGuard(){
		setGuardInactive();
	}
	
	/**
	 * Defines if the level was played by ogres
	 * 
	 */
	protected void setOgres(){
		ArrayList<Integer> ogre = new ArrayList<Integer>();
		ogre.add(1); //playing
		initValues.add(ogre);
	}
	
	/**
	 * Defines the map of a level
	 * 
	 */
	protected void setMap() {
		int i = 0;
		for (char[] c : temp) {
			map[i] = c;
			i++;
		}
	}
}
