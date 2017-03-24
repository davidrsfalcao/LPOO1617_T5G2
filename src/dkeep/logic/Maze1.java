package dkeep.logic;

import java.util.ArrayList;

public class Maze1 extends Map{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	char[][]temp=
			 {{'X','X','X','X','X','X','X','X','X','X'} ,
			  {'X',' ',' ',' ','I',' ','X',' ',' ','X'} ,
			  {'X','X','X',' ','X','X','X',' ',' ','X'} ,
			  {'X',' ','I',' ','I',' ','X',' ',' ','X'} ,
			  {'X','X','X',' ','X','X','X',' ',' ','X'} ,
			  {'I',' ',' ',' ',' ',' ',' ',' ',' ','X'} ,
			  {'I',' ',' ',' ',' ',' ',' ',' ',' ','X'} ,
			  {'X','X','X',' ','X','X','X','X',' ','X'} ,
			  {'X',' ','I',' ','I',' ','X','k',' ','X'} ,
			  {'X','X','X','X','X','X','X','X','X','X'} };
	
	/**
	 * Constructor of 1st Maze
	 * 
	 */
	public Maze1(){
		MAP_SIZE = 10; 
		init();
	
	}
	
	/**
	 * Returns the next map
	 * 
	 * @return next map
	 */
	public Map nextMap(){
		return new Maze2();
	}
	
	/**
	 * Removes the key from the map
	 * 
	 */
	public void pickUpKey(){
		
	};
	
	protected void setObjectives()
	{
		key = new Position(7,8,'k');
		key.setType(1);
		Position t1 = new Position(0,5,'S');
		endPositions = new ArrayList<Position>();
		endPositions.add(t1);
		Position t2 = new Position(0,6,'S');
		endPositions.add(t2);
	}
	
	protected void setHero()
	{
		ArrayList<Integer> hero = new ArrayList<Integer>();
		hero.add(1); //posX
		hero.add(1); //posY
		hero.add(0); //has_key
		hero.add(0); //is_armed
		initValues.add(hero);
	}
	
	protected void setGuard(){
		ArrayList<Integer> guard = new ArrayList<Integer>();
		guard.add(8); //posX
		guard.add(1); //posY
		guard.add(1); //playing
		initValues.add(guard);
		
	}
	
	protected void setOgres(){
		ArrayList<Integer> ogre = new ArrayList<Integer>();
		ogre.add(0); //playing
		initValues.add(ogre);
	}
	
	protected void setMap() {
		int i = 0;
		for (char[] c : temp) {
			map[i] = (char[]) c.clone();
			i++;
		}
	}
	
}
	
