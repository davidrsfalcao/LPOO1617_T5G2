package dkeep.logic;
import java.util.ArrayList;

public abstract class Guard extends Character {

	protected int[][] movement =  {{1,7},{2,7},{3,7},{4,7},{5,7},{5,6},{5,5},{5,4},{5,3},{5,2},{5,1},{6,1},
			   {6,2},{6,3},{6,4},{6,5},{6,6},{6,7},{6,8},{5,8},{4,8},{3,8},{2,8},{1,8}};

	protected int index = 0;

	
	public abstract Position moveCharacter(int MAP_SIZE);
	
	
	public ArrayList<Position> getPrintable() {
		ArrayList<Position> temp = new ArrayList<Position>();
		temp.add(position);
		return temp;
	}
	
}
