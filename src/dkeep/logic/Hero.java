package dkeep.logic;

public class Hero extends Character{
	
	private Position last_position;
	private boolean has_key;
	private boolean is_armed;
	
	
	public Hero(int posX, int posY, boolean has_key, boolean is_armed)
	{
		playing = true;
		this.has_key = has_key;
		this.is_armed = is_armed;
		
		position = new Position(posX, posY, 'H');
		
		if (is_armed) 
			position.setRepresentation('A');

		if (has_key)
			position.setRepresentation('K');
		
		last_position = new Position(posX, posY, position.getRepresentation());
	}
	
	/**
	 * Implementation of abstract method. Unused by the hero
	 * 
	 */
	public Position moveCharacter(int MAP_SIZE){
		return null;
	}

	/**
	 * Moves the Hero
	 * 
	 * @param MAP_SIZE
	 * @param dir
	 * @return temporary position
	 */
	public Position moveCharacter(int MAP_SIZE,int dir){
		Position temp =  new Position(position.getX(), position.getY(), position.getRepresentation());
		
		switch (dir) {
		case 1: // move right
			if (position.getX() + 1 < MAP_SIZE)
				temp.increaseX();
			break;

		case 2: // move down
			if (position.getY() + 1 < MAP_SIZE)
				temp.increaseY();
			break;

		case 3: // move left
			if (position.getX() - 1 >= 0)
				temp.decreaseX();
			break;

		case 4: // move up
			if (position.getY() - 1 >= 0)
				temp.decreaseY();
			break;

		}
		
		return temp;
	}	
	
	/**
	 * The hero come back to the last position
	 * 
	 */
	public void comeBack()
	{
		position.copy(last_position);
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
	 * Return if the hero has a key or not
	 * 
	 * @return true or false
	 */
	public boolean hasKey()
	{
		return has_key;
	}
	
	/**
	 * Hero catch a key
	 * 
	 */
	public void pickUpKey()
	{
		has_key = true;
		position.setRepresentation('K');
	}
	
	/**
	 * Return if the hero is armed or not
	 * 
	 * @return true or false
	 */
	public boolean is_armed()
	{
		return is_armed;
	}
	
}
