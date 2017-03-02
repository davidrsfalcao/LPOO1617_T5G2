package dkeep.logic;

public class Position {

	private int x;
	private int y;
	private String representation;
	
	/**
	 * Constructor of Position with initialization of x and y and representation
	 * 
	 * @param x
	 * @param y
	 * @param representation
	 */
	public Position(int x, int y, String representation)
	{
		this.x = x;
		this.y = y;
		this.representation = representation;
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
	 * Increase x
	 * 
	 */
	public void increaseX()
	{
		x++;
	}
	
	/**
	 * Decrease x
	 * 
	 */
	public void decreaseX()
	{
		x--;
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
	
	/**
	 * Increase y
	 * 
	 */
	public void increaseY()
	{
		y++;
	}
	
	/**
	 * Decrease y
	 * 
	 */
	public void decreaseY()
	{
		y--;
	}
	
	/**
	 * Redefines x and y coordinates
	 * 
	 * @param x
	 * @param y
	 */
	public void changeTo(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Redefines representation
	 * 
	 * @param representation
	 */
	public void setRepresentation(String representation)
	{
		this.representation = representation;
	}
	
	/**
	 * Returns the representation
	 * 
	 * @return representation
	 */
	public String getRepresentation()
	{	
		return representation;
	}
	
}
