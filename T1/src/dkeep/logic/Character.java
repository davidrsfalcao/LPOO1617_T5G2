package dkeep.logic;
import java.util.ArrayList;

public abstract class Character {
	
	protected Position position;
	
	public char getRepresentation()
	{
		return position.getRepresentation();
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

	public boolean setPos(int x , int y , int MAP_SIZE){
		if( x >= 0 && x < MAP_SIZE && y >= 0 && y < MAP_SIZE){
			position.changeTo(x, y);
			return true;
		}
		return false;
	}

	public abstract Position moveCharacter(int MAP_SIZE);
	
	public abstract ArrayList<Position> getPrintable();

}
