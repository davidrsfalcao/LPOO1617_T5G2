package dkeep.logic;

import java.io.Serializable;

/**
 * Is the representation of all that moves in the game, 
 * although each character have got is own personality
 * 
 * @author davidfalcao
 *
 */
public abstract class Character implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Position position;
	protected Position last_position;
	protected boolean playing;
	protected char direction_mov = 'D';
	
	/**
	 * Returns the character representation
	 * 
	 * @return representation 
	 */
	public char getRepresentation()
	{ 
		return position.getRepresentation();
	}

	/**
	 * Redefines the representation of character
	 * 
	 * @param representation
	 */
	public void setRepresentation(char representation)
	{
		position.setRepresentation(representation);
	}
	
	/**
	 * Returns the position of the character
	 * 
	 * @return Position
	 */
	public Position getPosition()
	{
		return position;
	}
	
	/**
	 * Redefines the position of character
	 * 
	 * @param x
	 * @param y
	 */
	public void setPosition(int x, int y)
	{
		position.setX(x);
		position.setY(y);
	}

	/**
	 * Abstract method for moving Characters
	 * 
	 * @param MAP_SIZE
	 * @return
	 */
	public abstract Position moveCharacter(int MAP_SIZE);
	
	/**
	 * Return if the character is playing in the current level
	 * 
	 * @return
	 */
	public boolean isPlaying()
	{
		return playing;
	}

	/**
	 * Update the last position
	 * 
	 */
	public void updateLastPosition()
	{
		last_position.copy(position);
	}
	
	/**
	 * Update the Direction of the movement
	 * 
	 */
	public void updateDirection()
	{
		if (position.equals(last_position))
			return;
		else direction_mov = position.getDirection(last_position);
	}
	
	/**
	 * Returns the Direction of the movement
	 * 
	 * @return Direction
	 */
	public char getDirection()
	{
		return direction_mov;
	}

	/**
	 * Set the representation to draw the front of the character 
	 */
	protected abstract void setFront();
	
	/**
	 * Set the representation to draw the back of the character 
	 */
	protected abstract void setBack();
	
	/**
	 * Shows in what direction the character is moving to represent in the graphic mode
	 * 
	 *  @return Representation in Graphic Mode
	 */
	@Override
	public String toString()
	{
		if (direction_mov == 'D' || direction_mov == 'L')
			setFront();
		else
			setBack();
		
		
		return position.getRepresentationGui();
	}
}
