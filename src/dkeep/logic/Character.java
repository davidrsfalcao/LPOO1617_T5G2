package dkeep.logic;

import java.io.Serializable;

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

	public void updateDirection()
	{
		if (position.equals(last_position))
			return;
		else direction_mov = position.getDirection(last_position);
	}

	public char getDirection()
	{
		return direction_mov;
	}

	protected abstract void setFront();
	
	protected abstract void setBack();
	
	
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
