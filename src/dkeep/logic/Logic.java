package dkeep.logic;

import java.util.ArrayList;
import java.util.Random;

public class Logic {
	private Map map;
	private Guard guard; 
	private ArrayList<Ogre> ogres = new ArrayList<Ogre>();
	private Hero hero;
	public status condition = status.RUNNING;
	private Random rand = new Random();
	private int nOgres;
	private int typeGuard = rand.nextInt(3);
	
	
	public enum status {
		WON, DEFEAT, RUNNING
	}
	
	/**
	 * Level Constructor
	 * 
	 * @param map
	 */
	public Logic(Map map, int typeGuard, int nOgres) {
		this.map = map;
		this.typeGuard = typeGuard;
		this.nOgres = nOgres;
		initCharacters();	
	}

	/**
	 * Init all the characters based on current map
	 * 
	 */
	private void initCharacters()
	{
		Random rand = new Random();
		ArrayList<ArrayList<Integer>> temp = map.getInitValues();
		
		/**
		 * Init Hero
		 * 
		 */
		ArrayList<Integer> heroArr = temp.get(0);
		int heroX = heroArr.get(0);
		int heroY = heroArr.get(1);
		int hero_key = heroArr.get(2);
		boolean hero_has_key;
		if (hero_key == 0)
			hero_has_key = false;
		else hero_has_key = true;
		int hero_armed = heroArr.get(3);
		boolean hero_is_armed;
		if (hero_armed ==0)
			hero_is_armed = false;
		else hero_is_armed = true;
		
		hero = new Hero(heroX, heroY, hero_has_key, hero_is_armed);
		
		/**
		 * Init Guard
		 * 
		 */
		ArrayList<Integer> guardArr = temp.get(1);
		int guardX = guardArr.get(0);
		int guardY = guardArr.get(1);
		int guard_play = guardArr.get(2);
		boolean guard_playing;
		if (guard_play == 0)
			guard_playing = false;
		else guard_playing = true;
		

		switch (typeGuard) {
		
		case 0:
			guard = new Rookie(guardX, guardY, guard_playing);
			break;
	
		case 1:
			guard = new Drunken(guardX, guardY, guard_playing);
			break;

		case 2:
			guard = new Suspicious(guardX, guardY, guard_playing);
			break;

		}
		
		/**
		 * Init Ogres
		 * 
		 */
		ArrayList<Integer> ogreArr = temp.get(2);
		
		int ogre_play = ogreArr.get(0);
		boolean ogre_playing;
		if (ogre_play == 0)
			ogre_playing = false;
		else ogre_playing = true;
		
		if (ogre_playing) {
			
			for (int i = 0; i < nOgres; i++) 
				ogres.add(new Ogre(rand.nextInt(map.getMapSize() - 3) + 1, rand.nextInt(map.getMapSize() - 3) + 1));
		}
		
		
	}
	
	/**
	 * Check if the hero has passed the level
	 * 
	 * @return true or false
	 */
	public boolean levelUp() {
		for (Position end : map.getEndPositions()) {
			if (hero.getPosition().equals(end))
				return true;
		}

		return false;
	}

	/**
	 * Check if the villains catch the hero and the game ends
	 * 
	 * @return true or false
	 */
	public boolean Over() {

		if (guard.isPlaying()) {
			if (guard.isAwake()) {
				for (Position pos : guard.getPosition().getSurroundings()) {
					if (pos.equals(hero.getPosition()))
					{
						condition = status.DEFEAT;
						return true;
					}	
				}

			}
		}
		
		for (Ogre ogre : ogres)
		{
			if (!hero.is_armed())
			{
				for (Position pos : ogre.getPosition().getSurroundings()) {
					if (pos.equals(hero.getPosition())) {
						condition = status.DEFEAT;
						return true;
					}
				}
				
			}
			
			
			if (ogre.getClubVisibily())
			{
				for (Position pos : ogre.getClub().getPosition().getSurroundings()) {
					if (pos.equals(hero.getPosition())) {
						condition = status.DEFEAT;
						return true;
					}
				}
			}
		}

		return false;
	}

	/**
	 * Check level objectives such as keys and levers
	 * 
	 */
	private void checkObjectives() {

		if (hero.getPosition().equals(map.getKey())) {
			int type = map.getKey().getType();

			switch (type) {
			case 1:
				map.changeDoors();
				hero.comeBack();
				break;

			case 2:
				hero.pickUpKey();
				map.pickUpKey();
				break;

			}
		} else if (map.getMap()[hero.getPosition().getY()][hero.getPosition().getX()] == 'I') {
			if (hero.hasKey()) {
				map.openDoors();
				hero.comeBack();
			} else {
				hero.comeBack();
			}
		}

	}
 
	/**
	 * Check if there is no ogre stunned or guard sleeping in a certain position
	 * 
	 * @param temp
	 * @return true or false
	 */
	private boolean positionClear(Position temp) {
		if (temp.equals(guard.getPosition()))
			return false;

		for (Ogre ogre : ogres) {
			if (temp.equals(ogre.getPosition()))
				return false;
		}
		
		return true;

	}

	/**
	 * Move hero and check if hero has passed the level. Case affirmative, returns a new level.
	 * 
	 * @param direction
	 * @return Logic
	 */
	public Logic moveHero(char direction) {
		Position temp;

		if ('w' == direction)
			temp = hero.moveCharacter(map.getMapSize(), 4);
		else if ('a' == direction)
			temp = hero.moveCharacter(map.getMapSize(), 3);
		else if ('s' == direction)
			temp = hero.moveCharacter(map.getMapSize(), 2);
		else if ('d' == direction)
			temp = hero.moveCharacter(map.getMapSize(), 1);
		else
			return this;


		if (map.isFreeForHero(temp.getX(), temp.getY()) && positionClear(temp))
		{
			hero.updateLastPosition();
			hero.setPosition(temp.getX(), temp.getY());
		}

		checkObjectives();
		
		if (levelUp()) {
			if (map.nextMap() != null)
				return new Logic(map.nextMap(), typeGuard, nOgres);
			else condition = status.WON;
		}
		return this;
	}

	/**
	 * Move all villains according to the level
	 * 
	 */
	public void moveAllVillains() {
		Position pos;
		if (guard.isPlaying()) {
			do {
				pos = guard.moveCharacter(map.getMapSize());
			} while (!this.map.isFree(pos.getX(), pos.getY()));

		} else { 
			for (Ogre ogre : ogres) {
				if (ogre.isPlaying()){
				do {
					pos = ogre.moveCharacter(map.getMapSize());
				} while (!map.isFree(pos.getX(), pos.getY()));

				ogre.setPosition(pos.getX(), pos.getY());				
				}
			}	
			for (int k = 0; k < ogres.size(); k++) {
				pos = ogres.get(k).moveClub();

				if (map.isFree(pos.getX(), pos.getY()) && positionClear(pos)) {
					ogres.get(k).setClub(pos);
				} else
					ogres.get(k).setClubNotVisible();

			}
		}
	}

	/**
	 * Hero atacks villains if they are surrounding him
	 * 
	 */
	public void atack_villains()
	{
		if (hero.is_armed())
		{
			for (Position pos : hero.getPosition().getSurroundings())
			{
				for (int i = 0; i < ogres.size(); i++)
				{
					if (ogres.get(i).getPosition().equals(pos))
						ogres.get(i).stun();
				}
				
			}
			
		}
		
	}
	
	/**
	 * Returns current map
	 * 
	 * @return map
	 */
	public Map getMap() {
		return map;
	}

	/**
	 * Return a ArrayList with all character of a level
	 * 
	 * @return
	 */
	public ArrayList<Character> getAllCharacters() {
		ArrayList<Character> temp = new ArrayList<Character>();
		temp.add(hero);

		if (guard.isPlaying())
			temp.add(guard);

		for (Ogre ogre : ogres)
		{
			if (ogre.isPlaying())
			{
				if (ogre.getPosition().equals(map.getKey()))
					ogre.setRepresentation('$');
				else if (!ogre.isStunned())
					ogre.setRepresentation('O');
				else ogre.setRepresentation('8');
					
				temp.add(ogre);
				
				if (ogre.getClubVisibily())
				{
					if (ogre.getClub().getPosition().equals(map.getKey()))
						ogre.getClub().setRepresentation('$');
					else ogre.getClub().setRepresentation('*');
					temp.add(ogre.getClub());
				}
			}
		}

		return temp;
	}
	
	public void setHero(Hero hero)
	{
		this.hero = hero;
	}
	
	public void setOgre(Ogre ogre)
	{
		ogres.add(ogre);
	}
	
	/**
	 * Returns hero
	 * 
	 * @return hero
	 */
	public Hero getHero()
	{
		return hero;
		
	}

	/**
	 * Returns guard
	 * 	
	 * @return guard
	 */
	public Guard getGuard()
	{
		return guard;
	}
	
	public Ogre getOgre()
	{
		return ogres.get(0);
		
	}
	
	
}
