package dkeep.logic;
import java.util.Random;

/**
 * The ogre is another character of the game.
 * The Ogre moves randomly in one of four directions (up, down, left, right) 
 * and have a massive club for kill the hero
 * 
 * @author davidfalcao
 *
 */
public class Ogre extends Character {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean stunned = false;
	private int rounds = 2;
	private MassiveClub club = new MassiveClub(); 
	
	/**
	 * Default constructor of Ogre
	 */
 	public Ogre(){
	} 
	
 	/**
 	 * Constructor of Ogre with initialization of position
 	 * 
 	 * @param x
 	 * @param y
 	 */
	public Ogre(int x, int y) {
		playing = true;
		position = new Position(x, y, 'O');
		last_position = new Position(x, y, position.getRepresentation());
	}
	
	/**
	 * Generate a random movement
	 * 
	 * @param Map size
	 * @return position
	 */
	public Position moveCharacter(int MAP_SIZE) {

		backNormal();

		if (stunned) {
			rounds--;
			return position;
		} else {
			Random rand = new Random();
			Position temp = new Position(position.getX(), position.getY(), position.getRepresentation());
			int direction = rand.nextInt(4);
			return positionTemp(temp, direction);
		}
	}
	
	/**
	 * Return a temporary position for the ogre
	 * 
	 * @param temp
	 * @param direction
	 * @return
	 */
	public Position positionTemp(Position temp, int direction){
		switch (direction) {
		case 0: // move up
			temp.increaseY(); break;
		case 1: // move down
			temp.decreaseY(); break;
		case 2: // move right
			temp.increaseX(); break;
		case 3: // move left
			temp.decreaseX(); break;
		}
		return temp;

	}
	
	/**
	 * End of the stun
	 * 
	 */
	private void backNormal()
	{
		if (rounds == 0)
		{
			stunned = false;
			rounds = 2;
			position.setRepresentation('O');
		}
		
	}
	
	/**
	 * The ogre get stun
	 */
	public void stun()
	{
		stunned = true;
		position.setRepresentation('8');
	}
	
	/**
	 * Check if the ogre is stunned
	 * 
	 * @return true or false
	 */
	public boolean isStunned()
	{
		return stunned;
	}
	
	/**
	 * Returns the massive club
	 * 
	 * @return
	 */
	public MassiveClub getClub()
	{
		return club;
	}
	
	/**
	 * Moves the masive club
	 * 
	 * @return temporary position
	 */
	public Position moveClub() {
		Random rand = new Random();
		Position temp = new Position(position.getX(), position.getY(), '*');
		int direction = rand.nextInt(4);

		if (direction == 0)
			temp.increaseX(); // right
		else if (direction == 1)
			temp.decreaseX(); // left
		else if (direction == 2)
			temp.increaseY(); // down
		else
			temp.decreaseY(); // up

		return temp;
	}
	
	/**
	 * Redefines the club
	 * 
	 * @param pos
	 */
	public void setClub(Position pos) {
		club.setVisibility(true);
		club.setPosition(pos);
	}

	/**
	 * Makes the ogre not visible (over other ogres, clubs or walls)
	 * 
	 */
	public void setClubNotVisible() {
		club.setVisibility(false);
	}

	/**
	 * Returns club visibility
	 * 
	 * @return visible or not visible
	 */
	public boolean getClubVisibily() {
		return club.getVisibility();
	}

	/**
	 * Set the representation to draw the front of the ogre 
	 */
	public void setFront()
	{
		if (stunned)
			position.setRepresentationGui("OFS");
		else position.setRepresentationGui("OF");
		
	}
	
	/**
	 * Set the representation to draw the back of the ogre
	 */
	public void setBack()
	{
		if (stunned)
			position.setRepresentationGui("OBS");
		else position.setRepresentationGui("OB");
	}
	
	
}
