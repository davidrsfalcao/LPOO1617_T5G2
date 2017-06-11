package dkeep.logic;

/**
 * Represents the weapon of the ogres
 * 
 * @author davidfalcao
 *
 */
public class MassiveClub extends Character {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * Massive Club constructor
	 */
	public MassiveClub()
	{ 
		playing = false;
		position = new Position(-10,-10,'*');
		last_position = position;
	}
	
	/**
	 * Unused
	 * 
	 */
	public Position moveCharacter(int MAP_SIZE){
		return null;
}
	
	/**
	 * Makes the ogre not visible (over other ogres, clubs or walls) or visible
	 * 
	 * @param mode true or false
	 */
	public void setVisibility(boolean mode)
	{
		playing = mode;
	}
	
	/**
	 * Return the visibility of the club
	 * 
	 * @return visible or not visible
	 */
	public boolean getVisibility()
	{
		return playing;
	}
	
	/**
	 * Redefines club position
	 * 
	 * @param pos position
	 */
	public void setPosition(Position pos)
	{
		position = pos;
	}
	
	/**
	 *  Represent in the graphic mode
	 */
	@Override
	public String toString()
	{
		return position.getRepresentation() + "";
	}

	/**
	 * Unused
	 * 
	 */
	@Override
	protected void setFront() {
	}

	/**
	 * Unused
	 */
	@Override
	protected void setBack() {
		
	}

}
