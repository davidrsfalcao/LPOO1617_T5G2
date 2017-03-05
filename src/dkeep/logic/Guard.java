package dkeep.logic;
import java.util.ArrayList;

public abstract class Guard extends Character {

	protected int[][] patch =  {{7,1},{7,2},{7,3},{7,4},{7,5},{6,5},{5,5},{4,5},{3,5},{2,5},{1,5},{1,6},
			   {2,6},{3,6},{4,6},{5,6},{6,6},{7,6},{8,6},{8,5},{8,4},{8,3},{8,2},{8,1}};
	protected int index = 0;
	protected boolean awake = true;
		
	/**
	 * Increase index 
	 * 
	 */
	public void increaseIndex()
	{
		index++;
		if (index >= patch.length)
			index = 0;
	}
	
	/**
	 * Decrese index 
	 * 
	 */
	public void decreaseIndex()
	{
		index--;
		if (index <= 0)
			index = patch.length - 1;
	}
	
	public abstract Position moveCharacter(int MAP_SIZE);
	
	public ArrayList<Position> getPrintable() {
		ArrayList<Position> temp = new ArrayList<Position>();
		temp.add(position);
		return temp;
	}
	
	public boolean isAwake()
	{
		return awake;
	}
	
	
}
