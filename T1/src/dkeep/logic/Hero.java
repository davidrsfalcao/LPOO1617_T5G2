package dkeep.logic;

import java.util.ArrayList;

public class Hero extends Character{
	
	private boolean have_key;
	private boolean is_armed;
	
	
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
