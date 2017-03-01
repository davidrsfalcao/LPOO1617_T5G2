package dkeep.logic;

public class Position {

	private int x;
	private int y;
	
	/**
	 * Constructor of Position with initialization of x and y 
	 * 
	 * @param x
	 * @param y
	 */
	public Position (int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Returns the x of a position 
	 * 
	 * @return x
	 */
	public int getX()
	{
		return x;
	}

	/**
	 * Returns the y of a position
	 * 
	 * @return y
	 */
	public int getY()
	{	
		return y;
	}
	
	/**
	 * Redefines x coordinate 
	 * 
	 * @param x
	 */
	public void setX(int x)
	{
		this.x = x;
	}

	/**
	 * Redefines y coordinate 
	 * 
	 * @param y
	 */
	public void setY(int y)
	{
		this.y = y;
	}
	
}
