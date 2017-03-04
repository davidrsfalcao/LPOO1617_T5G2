package dkeep.logic;
import java.util.ArrayList;
import java.util.Random;

public class Ogre extends Character {
	
	public Ogre(int x, int y) {
		position = new Position(x, y, 'O');
	}
	
	public Position moveCharacter(int MAP_SIZE) {
		Random rand = new Random();
		Position temp = new Position(position.getX(), position.getY(), position.getRepresentation());

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

		return temp;
	}
	
	public ArrayList<Position> getPrintable()
	{
		ArrayList<Position> temp = new ArrayList<Position>();
		temp.add(position);
		return temp;
	}
	
}
