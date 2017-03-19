package dkeep.logic;

public class MassiveClub extends Character {
	
	public Position moveCharacter(int MAP_SIZE){
			return null;
	}
	
	public MassiveClub()
	{ 
		playing = false;
		position = new Position(-10,-10,'*');
		last_position = position;
	}
	
	public void setVisibility(boolean mode)
	{
		playing = mode;
	}
	
	public boolean getVisibility()
	{
		return playing;
	}
	
	public void setPosition(Position pos)
	{
		position = pos;
	}

}
