package dkeep.logic;

import java.util.ArrayList;
import java.util.Random;

public class Logic {
	private Map map;
	private Guard guard;
	private ArrayList<Ogre> ogres = new ArrayList<Ogre>();
	private Hero hero;

	/**
	 * Level Constructor
	 * 
	 * @param map
	 */
	public Logic(Map map) {
		this.map = map;
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
		
		int res = rand.nextInt(3);

		switch (res) {
		case 0:
			guard = new Drunken(guardX, guardY, guard_playing);
			break;

		case 1:
			guard = new Suspicious(guardX, guardY, guard_playing);
			break;

		case 2:
			guard = new Rookie(guardX, guardY, guard_playing);
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
			int res1 = rand.nextInt(3) + 1;
			for (int i = 0; i < res1; i++)
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
		Position posH = new Position(hero.getPosition().getX(), hero.getPosition().getY(),
				hero.getPosition().getRepresentation());

		Position posG = new Position(guard.getPosition().getX(), guard.getPosition().getY(),
				guard.getPosition().getRepresentation());

		if (guard.isAwake()) {

			for (int i = 0; i < 5; i++) {
				switch (i) {
				case 0: // Guard's position
					if (posH.equals(posG))
						return true;
					else {
						posG.decreaseX();
					}
					break;

				case 1: // Left
					if (posH.equals(posG))
						return true;
					else {
						posG.increaseX();
						posG.increaseX();
					}
					break;

				case 2: // Right
					if (posH.equals(posG))
						return true;
					else {
						posG.decreaseX();
						posG.increaseY();
					}
					break;

				case 3: // Up
					if (posH.equals(posG))
						return true;
					else {
						posG.decreaseY();
						posG.decreaseY();
					}
					break;

				case 4: // Down
					if (posH.equals(posG))
						return true;
					else {
						posG.decreaseY();
						posG.decreaseY();
					}
					break;
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
				return new Logic(map.nextMap());
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
				// do{
				// pos = o.moveClub(this.map.getMapSize());
				// }while( !map.isFree(pos[0],pos[1]));
				// o.setClub(pos[0], pos[1], map.getMapSize());
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
				temp.add(ogre);
		}

		return temp;
	}


}
