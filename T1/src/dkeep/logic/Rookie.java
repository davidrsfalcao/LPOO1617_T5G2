package dkeep.logic;

public class Rookie extends Guard {
	
	public Position moveCharacter(int MAP_SIZE)
	{
		position.changeTo(patch[index][0] , patch[index][1]);
		
		return position;
	}

}
