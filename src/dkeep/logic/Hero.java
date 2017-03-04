package dkeep.logic;

import java.util.ArrayList;

public class Hero extends Character{
	
	private boolean has_key;
	private boolean is_armed;
	
	public Hero(int level){
		
		playing = false;
		
		if (level == 0)
		{
			position = new Position(1, 1, 'H');
			is_armed = false;
		}
		else if (level == 1)
		{
			position = new Position(1, 7, 'A');
			is_armed = true;
		}
		
		has_key = false;
	
	}
	
	public Position moveCharacter(int MAP_SIZE){
		return null;
	}

	public Position moveCharacter(int MAP_SIZE,int dir){
		Position temp =  new Position(position.getX(), position.getY(), position.getRepresentation());
		
		switch (dir) {
		case 1: // move right
			if (position.getX() + 1 < MAP_SIZE)
				temp.increaseX();
			break;

		case 2: // move down
			if (position.getY() + 1 < MAP_SIZE)
				temp.increaseY();
			break;

		case 3: // move left
			if (position.getX() - 1 >= 0)
				temp.decreaseX();
			break;

		case 4: // move up
			if (position.getY() - 1 >= 0)
				temp.decreaseY();
			break;

		}
		
		return temp;
	}	
	
	public ArrayList<Position> getPrintable()
	{
		ArrayList<Position> temp = new ArrayList<Position>();
		temp.add(position);
		return temp;
	}
	
	public boolean hasKey()
	{
		return has_key;
	}
	
	public void pickUpKey()
	{
		has_key = true;
	}
	
	
}
