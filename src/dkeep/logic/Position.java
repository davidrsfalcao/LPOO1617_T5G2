package dkeep.logic;

public class Position {

	private int x;
	private int y;
	private char representation;
	private int type = 0; // 0 for default, 1 for lever and 2 for key
	
	/**
	 * Constructor of Position with initialization of x and y and representation
	 * 
	 * @param x
	 * @param y
	 * @param representation
	 */
 	public Position(int x, int y, char representation)
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
	public void setRepresentation(char representation)
	{
		this.representation = representation;
	}
	
	/**
	 * Returns the representation
	 * 
	 * @return representation
	 */
	public char getRepresentation()
	{	
		return representation;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == null) {
			return false;
		}
		
		Position pos = (Position)obj;
		
		if (x != pos.getX())
			return false;
		else if(y != pos.getY())
			return false;
		
		return true;
		
	}
	
	public void copy(Position pos1)
	{
		x = pos1.getX();
		y = pos1.getY();
		representation = pos1.getRepresentation();
	}

	public void setType(int type)
	{
		this.type = type;
	}

	public int getType()
	{
		return type;
	}
}
