package dkeep.logic;

/**
 * The Dungeon's Guard Militia is composed of 
 * several guards that take turns at patrolling 
 * the dungeon. Each guard has its own "personality.
 * 
 * 
 * @author davidfalcao
 *
 */
public abstract class Guard extends Character {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

	/**
	 * Redefines the path of movement
	 * 
	 * @param path
	 */
	public void setPath (int[][] path)
	{
		this.path = path;
	}
	
	/**
	 * Changes the representation of the guard for 
	 * front representations
	 * 
	 */
	protected void setFront()
	{
		if (awake)
			position.setRepresentationGui("GF");
		else position.setRepresentationGui("GFS");
		
	}
	
	/**
	 * Changes the representation of the guard for
	 * back representations
	 * 
	 */
	protected void setBack()
	{
		if (awake)
			position.setRepresentationGui("GB");
		else position.setRepresentationGui("GFS");
		
	}
	

}
