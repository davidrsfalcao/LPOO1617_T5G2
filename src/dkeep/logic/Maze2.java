package dkeep.logic;

import java.util.ArrayList;

public class Maze2 extends Map{
	
	/**
	 * Constructor of 2nd Maze
	 * 
	 */
	public Maze2(){ 
		MAP_SIZE = 9;
		map = new char[MAP_SIZE][MAP_SIZE];
		
		ArrayList<Integer> hero = new ArrayList<Integer>();
		hero.add(1); //posX
		hero.add(7); //posY
		hero.add(0); //has_key
		hero.add(1); //is_armed
		
		ArrayList<Integer> guard = new ArrayList<Integer>();
		guard.add(0); //posX
		guard.add(0); //posY
		guard.add(0); //playing
		
		ArrayList<Integer> ogre = new ArrayList<Integer>();
		ogre.add(1); //playing
		
		initValues.add(hero);
		initValues.add(guard);
		initValues.add(ogre);
		
		key = new Position(7,1,'k');
		key.setType(2);
		
		char[][]temp={{'X','X','X','X','X','X','X','X','X'} ,
					  {'I',' ',' ',' ',' ',' ',' ','k','X'} ,
					  {'X',' ',' ',' ',' ',' ',' ',' ','X'} ,
					  {'X',' ',' ',' ',' ',' ',' ',' ','X'} ,
					  {'X',' ',' ',' ',' ',' ',' ',' ','X'} ,
					  {'X',' ',' ',' ',' ',' ',' ',' ','X'} ,
					  {'X',' ',' ',' ',' ',' ',' ',' ','X'} ,
					  {'X',' ',' ',' ',' ',' ',' ',' ','X'} ,
					  {'X','X','X','X','X','X','X','X','X'} };
		
		int i = 0;
		for( char[] c : temp){
			map[i] = c;
			i++;
		}
		endPositions = new ArrayList<Position>();
		Position t1 = new Position(0,1,'S');
		endPositions.add(t1);
	}
	
	public void setObjectives()
	{
		
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

	protected void setHero(){}
	
	protected void setGuard(){}
	
	protected void setOgres(){}
	
	protected void setMap(){}
}
