package dkeep.logic;

public class Rookie extends Guard {
	
	public Rookie()
	{
		super();
	}
	
	public Position moveCharacter(int MAP_SIZE)
	{
		increaseIndex();
		position.changeTo(patch[index][0] , patch[index][1]);
		
		return position;
	}

}
