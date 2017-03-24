package dkeep.logic;

public class Hero extends Character{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	public Position moveCharacter(int MAP_SIZE, int dir) {
		switch (dir) {
		case 1:
			return moveRight(MAP_SIZE);
		case 2:
			return moveDown(MAP_SIZE);
		case 3:
			return moveLeft(MAP_SIZE);
		case 4:
			return moveUp(MAP_SIZE);
		}
		return position;
	}
	
	public Position moveRight(int MAP_SIZE)
	{
		Position temp =  new Position(position.getX(), position.getY(), position.getRepresentation());
		if (position.getX() + 1 < MAP_SIZE)
			temp.increaseX();
		
		return temp;	
	}
	
	public Position moveDown(int MAP_SIZE)
	{
		Position temp =  new Position(position.getX(), position.getY(), position.getRepresentation());
		if (position.getY() + 1 < MAP_SIZE)
			temp.increaseY();
		return temp;	
	}
	
	public Position moveLeft(int MAP_SIZE)
	{
		Position temp =  new Position(position.getX(), position.getY(), position.getRepresentation());
		if (position.getX() - 1 >= 0) 
			temp.decreaseX(); 
		return temp;	
	}
	
	public Position moveUp(int MAP_SIZE)
	{
		Position temp =  new Position(position.getX(), position.getY(), position.getRepresentation());
		if (position.getY() - 1 >= 0)
			temp.decreaseY();
		return temp;	
	}
	
	/**
	 * The hero come back to the last position
	 * 
	 */
	public void comeBack()
	{
		position.copy(last_position);
		updateDirection();
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
	
	public void setWeapon(boolean armed)
	{
		this.is_armed=armed;
		
	}
	
	protected void setFront()
	{
			if (!is_armed && !has_key)
				position.setRepresentationGui("HF");
			else if (is_armed && !has_key)
				position.setRepresentationGui("HFA");
			else if (!is_armed && has_key)
				position.setRepresentationGui("HFK");
			else position.setRepresentationGui("HFAK");

	}
	
	protected void setBack()
	{
			if (!is_armed)
				position.setRepresentationGui("HB");
			else if (is_armed)
				position.setRepresentationGui("HBA");

	}
	
}
