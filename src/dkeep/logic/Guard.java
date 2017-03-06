package dkeep.logic;

public abstract class Guard extends Character {

	protected int[][] path =  {{7,1},{7,2},{7,3},{7,4},{7,5},{6,5},{5,5},{4,5},{3,5},{2,5},{1,5},{1,6},
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
		if (index >= path.length)
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
			index = path.length - 1;
	}
	
	/**
	 * Abstract method for moving Characters
	 * 
	 * @param MAP_SIZE
	 * @return
	 */
	public abstract Position moveCharacter(int MAP_SIZE);
	
	/**
	 * Return if the guard is awake or sleeping
	 * 
	 * @return true or false
	 */
	public boolean isAwake()
	{
		return awake;
	}

	public void setPath (int[][] path)
	{
		this.path = path;
	}
	
}
