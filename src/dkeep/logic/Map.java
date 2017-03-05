package dkeep.logic;
import java.util.ArrayList;

public abstract class Map {
	protected int MAP_SIZE;
	protected char[][] map;
	protected ArrayList<Position> endPositions;
	protected Position key;
	
	/**
	 *  { {hero}, {guard}, {ogres}} 
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

	public char[][] getMap(){
		char[][] temp = new char[MAP_SIZE][];
		int i = 0;
		for (char[] arr : this.map){
			temp[i] = (char[])arr.clone();
			i++;
		}
		return temp;
	}

	public int getMapSize(){
		return MAP_SIZE;
	}

	public boolean isFree(int x , int y){
		
		if (map[y][x] == ' ' || map[y][x] == 'k' || map[y][x] == 'S')
			return true;
		else return false;
		
	}
	
	public boolean isFreeForHero(int x , int y)
	{
		if (map[y][x] == ' ' || map[y][x] == 'k' || map[y][x] == 'S' || map[y][x] == 'I')
			return true;
		else return false;
		
	}
	
	public void openDoors()
	{
		for (int i = 0; i < MAP_SIZE; i++)
			for (int k = 0; k < MAP_SIZE; k++)
			{
				if (map[i][k] == 'I')
					map[i][k] = 'S';
			}
		
	}
	
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
	
	public abstract Map nextMap();
	
	public abstract void pickUpKey();
	
	public ArrayList<Position> getEndPositions()
	{
		return endPositions;
	}
	
	public Position getKey()
	{
		return key;
	}

	public ArrayList<ArrayList<Integer>> getInitValues()
	{
		return initValues;
	}
}
