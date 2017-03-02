package dkeep.logic;
import java.util.ArrayList;

public abstract class Map {
	protected int MAP_SIZE;
	protected char[][] map = new char[10][];
	protected ArrayList<Position> endPositions;

	public char[][] getMap(){
		char[][] temp = new char[this.MAP_SIZE][];
		int i = 0;
		for (char[] arr : this.map){
			temp[i] = (char[])arr.clone();
			i++;
		}
		return temp;
	}

	public int getMapSize(){
		return this.MAP_SIZE;
	}

	public boolean isFree(int x , int y){
		return (this.map[x][y] == ' ' || this.map[x][y] == 'K' || this.map[x][y] == 'S');
	}
	
	public abstract void openDoors();
	
	public abstract Map nextMap();
	
	public abstract void pickUpKey();
	
	public ArrayList<Position> getEndPositions()
	{
		return endPositions;
	}
}
