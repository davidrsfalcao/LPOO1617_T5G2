package dkeep.logic;
import java.util.ArrayList;

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

	/**
	 * Redefines type
	 * 
	 * @param type
	 */
	public void setType(int type)
	{
		this.type = type;
	}

	/**
	 * Returns the type of a position (0 for default position and != 0 for key positions)
	 * 
	 * @return type
	 */
	public int getType()
	{
		return type;
	}
	
	/**
	 * Overrride of equal
	 * 
	 */
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
	
	/**
	 * Clone the variables of a object of the type Position to another
	 * 
	 * @param pos1
	 */
	public void copy(Position pos1)
	{
		x = pos1.getX();
		y = pos1.getY();
		representation = pos1.getRepresentation();
	}
	
	/**
	 * Returns a ArrayList of adjacent positions 
	 * 
	 * @return surroundings
	 */
	public ArrayList<Position> getSurroundings()
	{
		ArrayList<Position> temp = new ArrayList<Position>();
		
		Position t1 = new Position(x-1,y,representation);
		Position t2 = new Position(x+1,y,representation);
		Position t3 = new Position(x,y+1,representation);
		Position t4 = new Position(x,y-1,representation);
		
		temp.add(t1);
		temp.add(t2);
		temp.add(t3);
		temp.add(t4);
		
		
		return temp;
	}

}
