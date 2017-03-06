package dkeep.test;

import dkeep.logic.*;
import java.util.ArrayList;

public class TestMap extends Map{

	/**
	 * Constructor of 1st Maze
	 * 
	 */
	public TestMap()
	{
		MAP_SIZE = 5;
		map = new char[MAP_SIZE][MAP_SIZE];
		ArrayList<Integer> hero = new ArrayList<Integer>();
		hero.add(1); //posX 
		hero.add(1); //posY
		hero.add(0); //has_key
		hero.add(0); //is_armed
		
		ArrayList<Integer> guard = new ArrayList<Integer>();
		guard.add(3); //posX
		guard.add(1); //posY
		guard.add(1); //playing
		
		ArrayList<Integer> ogre = new ArrayList<Integer>();
		ogre.add(0); //playing
		
		initValues.add(hero);
		initValues.add(guard);
		initValues.add(ogre);
		
		key = new Position(1,3,'k');
		key.setType(1);
		
		
		char [][] temp = 
				{{'X','X','X','X','X'},
		         {'X','H',' ','G','X'},
		         {'X',' ',' ',' ','X'},
		         {'X','k',' ',' ','X'},
		         {'X','X','X','X','X'}};
		int i = 0;
		for( char[] c : temp){
			map[i] = (char[])c.clone();
			i++;
		}
		
		endPositions = new ArrayList<Position>();
		
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
	
}
	
