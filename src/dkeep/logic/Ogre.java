package dkeep.logic;
import java.util.Random;

public class Ogre extends Character {
	
	private boolean stunned = false;
	private int rounds = 2;
	private MassiveClub club = new MassiveClub();
	
 	public Ogre(){
		
	}
	
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
	
	public MassiveClub getClub()
	{
		return club;
	}
	
	public Position moveClub()
	{
		Random rand = new Random();
		Position temp = new Position(position.getX(), position.getY(), '*');
		
		int direction = rand.nextInt(4);
		
		switch(direction)
		{
		case 0: //right
			temp.increaseX();
			break;
		
		case 1: //left
			temp.decreaseX();
			break;
			
		case 2: //down
			temp.increaseY();
			break;
			
		case 3: //up
			temp.decreaseY();
			break;
		}
				
		return temp;
	}
	
	public void setClub(Position pos)
	{
		club.setVisibility(true);
		club.setPosition(pos);
	}

	public void setClubNotVisible()
	{
		club.setVisibility(false);
	}

	public boolean getClubVisibily()
	{
		return club.getVisibility();
	}
	
}
