package dkeep.logic;

import java.util.Random;

/**
 * 
 * There is the "Drunken", a tormented pour soul that finds in liquor, 
 * refuge from its troubled life, and that, while patrolling might fall asleep 
 * (randomly, stops and stays at same position for a while, changing his
 *  representation to lowercase "g", and that might reverse his patrolling 
 *  direction when he wakes up. While asleep, hero can move next to the 
 *  guard and not loose the game).
 * 
 * @author davidfalcao
 *
 */
public class Drunken extends Guard{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int counter; // Counter of sleepy rounds and awake rounds
	private Random rand = new Random(); 
	
	/**
	 * Constructor of Drunk Guard
	 * @param posX parameter x of the position
	 * @param posY parameter y of the position
	 * @param playing boolean that shows if this guard is playing or not
	 */
	public Drunken(int posX, int posY, boolean playing)
	{
		this.playing = playing;
		counter = rand.nextInt(5) + 3;
		
		if(!playing)
			position = new Position(-10,-10,'G');
		else position = new Position(posX, posY, 'G');
		
		last_position = new Position(posX, posY, position.getRepresentation());

	}
	
	/**
	 * Test if the guard is playing and move him
	 * 
	 * @return position
	 */
	public Position moveCharacter(int MAP_SIZE) {
		if (playing)
			if (counter == 0)
				restartCounter();
			else
				move();

		return position;
	}

	/**
	 * Restart the counter of sleping or awaking rounds
	 * 
	 */
	private void restartCounter() {
		awake = !awake;

		if (awake) {
			position.setRepresentation('G');
			counter = rand.nextInt(5) + 3;
		} else {
			position.setRepresentation('g');
			counter = rand.nextInt(3) + 1;
		}
	}

	/**
	 * Move the guard if him isn't sleeping
	 * 
	 */
	private void move()
	{
		if (awake) {
			position.changeTo(path[index][0], path[index][1]);
			increaseIndex();
			counter--;
		} else {
			// stay in the same position
			counter--;
		}
		
	}
}
