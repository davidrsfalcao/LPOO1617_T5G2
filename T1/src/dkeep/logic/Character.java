package dkeep.logic;

public class Character {
	
	protected Position position;
	protected  String representation;
	
	public String getRepresent()
	{
		return representation;
	}

	public Position getPosition()
	{
		return position;
	}
	
	public void setPosition(int x, int y)
	{
		position.setX(x);
		position.setY(y);
	}
	
}
