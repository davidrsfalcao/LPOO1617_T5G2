package dkeep.logic;
import java.util.Random;

public class Ogre extends Character {
	
	private boolean stunned = false;
	private int rounds = 2;
	
	
	public Ogre(int x, int y) {
		playing = true;
		position = new Position(x, y, 'O');
	}
	
	public Position moveCharacter(int MAP_SIZE) {
		Random rand = new Random();
		Position temp = new Position(position.getX(), position.getY(), position.getRepresentation());

		if (rounds == 0)
		{
			stunned = false;
			rounds = 2;
			position.setRepresentation('O');
		}
		
		if (stunned) {
			rounds--;
		} else {

			int direction = rand.nextInt(4);

			/**
			 * 0 - move up 1 - move down 2 - move righ 3 - move left
			 * 
			 */

			switch (direction) {
			case 0:
				temp.increaseY();
				break;

			case 1:
				temp.decreaseY();
				break;

			case 2:
				temp.increaseX();
				break;

			case 3:
				temp.decreaseX();
				break;

			}
		}
		return temp;
	}

	public void stun()
	{
		stunned = true;
		position.setRepresentation('o');
	}
	
	public boolean isStunned()
	{
		return stunned;
	}
	
}
