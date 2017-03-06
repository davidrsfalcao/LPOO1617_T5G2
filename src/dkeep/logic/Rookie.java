package dkeep.logic;

public class Rookie extends Guard {
	
	public Rookie(int posX, int posY, boolean playing)
	{
		this.playing = playing;
		
		if(!playing) 
			position = new Position(-10,-10,'G');
		else position = new Position(posX, posY, 'G');
	}
		
	public Position moveCharacter(int MAP_SIZE)
	{
		position.changeTo(path[index][0] , path[index][1]);
		increaseIndex();
		
		return position;
	}

}
