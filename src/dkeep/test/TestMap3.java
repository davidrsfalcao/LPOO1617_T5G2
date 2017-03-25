package dkeep.test;

import dkeep.logic.*;
import java.util.ArrayList;

public class TestMap3 extends Map{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of 3rd Maze
	 * 
	 */
	public TestMap3()
	{
		MAP_SIZE = 7;
		map = new char[MAP_SIZE][MAP_SIZE];
		ArrayList<Integer> hero = new ArrayList<Integer>();
		hero.add(1); //posX 
		hero.add(1); //posY
		hero.add(0); //has_key
		hero.add(0); //is_armed
		
		ArrayList<Integer> guard = new ArrayList<Integer>();
		guard.add(3); //posX
		guard.add(1); //posY
		guard.add(0); //playing
		
		ArrayList<Integer> ogre = new ArrayList<Integer>();
		ogre.add(0); //playing
		
		initValues.add(hero);
		initValues.add(guard);
		initValues.add(ogre);
		
		key = new Position(1,5,'k');
		key.setType(2);
		
		
		char [][] temp = 
				{{'X','X','X','X','X','X','X'},
		         {'X',' ',' ',' ',' ',' ','X'}, 
		         {'X',' ',' ',' ',' ',' ','X'},
		         {'X',' ',' ',' ',' ',' ','X'},
		         {'I',' ',' ',' ',' ',' ','X'},
		         {'I','k',' ',' ',' ',' ','X'},
		         {'X','X','X','X','X','X','X'}};
		int i = 0;
		for( char[] c : temp){
			map[i] = (char[])c.clone();
			i++;
		}
		
		endPositions = new ArrayList<Position>();
		endPositions.add(new Position(0,5,'I'));
		endPositions.add(new Position(0,4,'I'));
		
		
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
		
	};
	
	protected void setObjectives(){}

	protected void setHero(){}
	
	protected void setGuard(){}
	
	protected void setOgres(){}
	
	protected void setMap(){}
}
	