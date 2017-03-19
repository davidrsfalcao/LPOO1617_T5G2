package dkeep.logic;

import java.util.Random;

public class Drunken extends Guard{

	private int counter; // Counter of sleepy rounds and awake rounds
	private Random rand = new Random(); 
	
	public Drunken(int posX, int posY, boolean playing)
	{
		this.playing = playing;
		counter = rand.nextInt(5) + 3;
		
		if(!playing)
			position = new Position(-10,-10,'G');
		else position = new Position(posX, posY, 'G');
		
		last_position = new Position(posX, posY, position.getRepresentation());

	}
	
	public Position moveCharacter(int MAP_SIZE)
	{
		
		if (!playing)
			return position;
		
		if (counter == 0)
		{
			awake = !awake;
			
			if (awake)
			{
				position.setRepresentation('G');
				counter = rand.nextInt(5) + 3;	
			}
			else {
				position.setRepresentation('g');
				counter = rand.nextInt(3) + 1;	
			}
				
			
		}
		else if (awake)
		{
			position.changeTo(path[index][0] , path[index][1]);
			increaseIndex();
			counter--;
		}
		else {
			// stay in the same position
			counter--;
		}
		
		return position;
	}
	
}
