package dkeep.logic;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Represents a mapf
 * 
 * @author davidfalcao
 *
 */
public abstract class Map implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int MAP_SIZE; 
	protected char[][] map;
	protected ArrayList<Position> endPositions;
	protected Position key;
	
	/**
	 *  {{hero}, {guard}, {ogres}} 
	 *  
	 *  {hero} = {posX, posY, has_key(*), is_armed(*)}
	 *   
	 *  {guard} = {posX, posY, playing(*)}
	 * 
	 *  {ogre} = {playing(*)}
	 *  
	 * 		  (*) 1 for true and 0 for false
	 * 
	 */
	protected ArrayList<ArrayList<Integer>> initValues = new ArrayList<ArrayList<Integer>>();

	/**
	 * Returns the board
	 * 
	 * @return map
	 */
	public char[][] getMap(){
		char[][] temp = new char[MAP_SIZE][]; 
		int i = 0;
		for (char[] arr : this.map){
			temp[i] = (char[])arr.clone();
			i++;
		}
		return temp;
	}

	/**
	 * Returns the size of the map
	 * 
	 * @return map_size
	 */
	public int getMapSize(){
		return MAP_SIZE;
	}

	/**
	 * Check if a certain position is free to a villain move into
	 * 
	 * @param x position X
	 * @param y position y
	 * @return true or false
	 */
	public boolean isFree(int x , int y){
		
		if (map[y][x] == ' ' || map[y][x] == 'k' || map[y][x] == 'S')
			return true;
		else return false;
		
	}
	
	/**
	 * Check if a certain position is free to the hero move into
	 * 
	 * @param x position x
	 * @param y position y
	 * @return true or false
	 */
	public boolean isFreeForHero(int x , int y)
	{
		if (map[y][x] == ' ' || map[y][x] == 'k' || map[y][x] == 'S' || map[y][x] == 'I')
			return true;
		else return false;
		
	}
	
	/**
	 * Open the doors of the map (change 'I' to 'S')
	 * 
	 */
	public void openDoors()
	{
		for (int i = 0; i < MAP_SIZE; i++)
			for (int k = 0; k < MAP_SIZE; k++)
			{
				if (map[i][k] == 'I')
					map[i][k] = 'S';
			}
		
	}
	
	/**
	 * In case of levers, if the doors was open then it close them and if the doors was closed,
	 * it open them
	 * 
	 */
	public void changeDoors()
	{
		for (int i = 0; i < MAP_SIZE; i++)
			for (int k = 0; k < MAP_SIZE; k++)
			{
				if (map[i][k] == 'I')
					map[i][k] = 'S';
				else if (map[i][k] == 'S')
					map[i][k] = 'I';
			}
		
	}
	
	/**
	 * Return the next level's map
	 * 
	 * @return map
	 */
	public abstract Map nextMap();
	
	/**
	 * Abstract method to pick up the keys
	 * 
	 */
	public abstract void pickUpKey();
	
	/**
	 * Returns a ArrayList whith all of finnish positions
	 * 
	 * @return finnish positions
	 */
	public ArrayList<Position> getEndPositions()
	{
		return endPositions;
	}
	
	/**
	 * Return the position of the key
	 * 
	 * @return position
	 */
	public Position getKey()
	{
		return key;
	}

	/**
	 * Returns a ArrayList with the initialization of characters objects.
	 * 
	 * The structure is:
	 * 
	 * 		   {{hero}, {guard}, {ogres}} 
	 *  
	 *  {hero} = {posX, posY, has_key(*), is_armed(*)}
	 *   
	 *  {guard} = {posX, posY, playing(*)}
	 * 
	 *  {ogre} = {playing(*)}
	 *  
	 * 		  (*) 1 for true and 0 for false
	 * 
	 * 
	 * @return initValues
	 */
	public ArrayList<ArrayList<Integer>> getInitValues()
	{
		return initValues;
	}

	/**
	 * Defines the key or lever and the endpositions of the map
	 * 
	 */
	protected abstract void setObjectives();
	
	/**
	 * Defines de initial position of the hero
	 * 
	 */
	protected abstract void setHero();
	
	/**
	 * Defines the initial position of the guard
	 * 
	 */
	protected abstract void setGuard();
	
	/**
	 * Defines a inative guard (map without guard)
	 * 
	 */
	protected void setGuardInactive()
	{
		ArrayList<Integer> guard = new ArrayList<Integer>();
		guard.add(0); // posX
		guard.add(0); // posY
		guard.add(0); // playing
		initValues.add(guard);	
		
	}
	
	/**
	 * Defines if the level was played by ogres
	 * 
	 */
	protected abstract void setOgres();
	
	/**
	 * Defines the map of a level
	 * 
	 */
	protected abstract void setMap();
	
	/**
	 * Initialization of the map 
	 * 
	 */
	protected void init(){
		map = new char[MAP_SIZE][MAP_SIZE];
		setHero();
		setGuard();
		setOgres();
		setObjectives();
		setMap();
	};
	
	

}
