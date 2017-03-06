package dkeep.logic;

public abstract class Character {
	
	protected Position position;
	protected boolean playing;
	
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

}
