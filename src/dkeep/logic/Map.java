package dkeep.logic;
import java.util.ArrayList;

public abstract class Map {
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
	 * @param x
	 * @param y
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
	 * @param x
	 * @param y
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
	 * @return
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
	 * @return
	 */
	public Position getKey()
	{
		return key;
	}

	/**
	 * Returns a ArrayList<ArrayList<Integer>> with the initialization of characters objects.
	 * 
	 * The structure is:
	 * 
	 * 	---->   {{hero}, {guard}, {ogres}} 
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
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> getInitValues()
	{
		return initValues;
	}

	protected abstract void setObjectives();
	
	protected abstract void setHero();
	
	protected abstract void setGuard();
	
	protected abstract void setOgres();
	
	protected abstract void setMap();
	
	
	
	
	

}
