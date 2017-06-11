package dkeep.logic;

/**
 * There is the "Rookie", always alert and scrupulously
 *  walking the patrolling path with no mishaps.
 * 
 * @author davidfalcao
 *
 */
public class Rookie extends Guard {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of Rookie Guard
	 * @param posX parameter x of the position
	 * @param posY parameter y of the position
	 * @param playing boolean that shows if this guard is playing or not
	 */
	public Rookie(int posX, int posY, boolean playing)
	{
		this.playing = playing;
		
		if(!playing) 
			position = new Position(-10,-10,'G');
		else position = new Position(posX, posY, 'G');
		
		last_position = new Position(posX, posY, position.getRepresentation());

	}
		
	/**
	 * Moves the guard into the next path position
	 * 
	 * return Position
	 */
	public Position moveCharacter(int MAP_SIZE)
	{
		position.changeTo(path[index][0] , path[index][1]);
		increaseIndex();
		return position;
	}

}
