package dkeep.logic;
import java.util.Random;

public class Suspicious extends Guard {

	private boolean front = true;
	private int steps_front;
	private int steps_back;
	private Random rand = new Random();
	
	
	public Suspicious()
	{
		super();
		steps_front = rand.nextInt(5) + 3;
		steps_back = rand.nextInt(3) + 1;
		
	}
	
	public Position moveCharacter(int MAP_SIZE)
	{
		if (front) {
			increaseIndex();
			position.changeTo(patch[index][0], patch[index][1]);
			steps_front--;
			
		} else {
			decreaseIndex();
			position.changeTo(patch[index][0], patch[index][1]);
			steps_back--;
		}
		
		if (steps_front == 0)
		{
			steps_front = rand.nextInt(5) + 3;
			front = false;
		}
		
		if (steps_back == 0)
		{
			steps_back = rand.nextInt(3) + 1;
			front = true;
			
		}
		
		
		
		return position;
	}
	
}
