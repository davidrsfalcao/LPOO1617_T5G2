package dkeep.logic;
import java.util.Random;

/**
 * There's the "Suspicious", an insecure, over-zealous guard, 
 * that keeps turning back to check for something he though 
 * he heard (randomly reverses patrolling direction, after a while). 
 * 
 * @author davidfalcao
 *
 */
public class Suspicious extends Guard {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean front = true;
	private int steps_front;
	private int steps_back;
	private Random rand = new Random();
	
	/**
	 * Constructor of Suspicious Guard
	 * @param posX parameter x of the position
	 * @param posY parameter y of the position
	 * @param playing boolean that shows if this guard is playing or not
	 */
	public Suspicious(int posX, int posY, boolean playing)
	{
		this.playing = playing;
		steps_front = rand.nextInt(5) + 3;
		steps_back = rand.nextInt(3) + 1;
		
		if(!playing)
			position = new Position(-10,-10,'G');
		else position = new Position(posX, posY, 'G');
		
		last_position = new Position(posX, posY, position.getRepresentation());

	}
	
	/**
	 * Control the guard movement
	 * 
	 * @return Position
	 * 
	 */
	public Position moveCharacter(int MAP_SIZE) {

		if (front) {
			moveFront();
		} else {
			moveBack();
		}
		changeDirection();
		
		return position;
	}
	
	/**
	 * Move guard to the next path position
	 * 
	 */
	private void moveFront()
	{
		position.changeTo(path[index][0], path[index][1]);
		steps_front--;
		increaseIndex();
	}
	
	/**
	 * Reverses the guard to the last position
	 * 
	 */
	private void moveBack()
	{
		position.changeTo(path[index][0], path[index][1]);
		steps_back--;
		decreaseIndex();
		
	}
	
	/**
	 * Check if the guard has changed his direction
	 * 
	 */
	private void changeDirection() {
		if (steps_front == 0) {
			steps_front = rand.nextInt(5) + 3;
			front = false;
		}
		if (steps_back == 0) {
			steps_back = rand.nextInt(3) + 1;
			front = true;
		}
	}
	
}
