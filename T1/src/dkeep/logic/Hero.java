package dkeep.logic;

import java.util.ArrayList;

public class Hero extends Character{
	
	private boolean have_key;
	private boolean is_armed;
	
	public Hero(int level){
		
		if (level == 1)
		{
			position = new Position(1, 1, 'H');
			is_armed = false;
		}
		else if (level == 2)
		{
			position = new Position(1, 7, 'A');
			is_armed = true;
		}
		
		have_key = false;
	
	}
	
	public Position moveCharacter(int MAP_SIZE){
		
		return null;
	}

	public ArrayList<Position> getPrintable()
	{
		ArrayList<Position> temp = new ArrayList<Position>();
		temp.add(position);
		return temp;
	}
	
}
