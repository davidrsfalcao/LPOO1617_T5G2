package dkeep.logic;
import java.util.ArrayList;
import java.util.Random;

public class Logic {
	private Map map;
	private Guard guard;
	private ArrayList<Ogre> ogres = new ArrayList<Ogre>();
	private Hero hero;
	private Position key;
	private int level = 0;
	
	public Logic(int level) {
		Random rand = new Random();
		this.level = level;

		if (0 == level) {
			this.map = new Maze1();
			this.hero = new Hero(this.level);
			key = new Position(7, 8, 'k');

			int res = rand.nextInt(3);
			if (0 == res)
				this.guard = new Rookie();
			else if (1 == res)
				this.guard = new Drunken();
			else if (2 == res)
				this.guard = new Suspicious();
		} else if (1 == level) {
			this.map = new Maze2();
			this.hero = new Hero(this.level);
			key = new Position(8, 1, 'k');
			int res = rand.nextInt(3) + 1;
			for (int i = 0; i < res; i++)
				this.ogres.add(new Ogre(rand.nextInt(7) + 1, rand.nextInt(7) + 1));
		}
	}
	
	public boolean wonGame(){ 
		
		for (int i = 0; i < map.endPositions.size(); i++)
		{
			if (hero.position.equals(map.endPositions.get(i)))
				return true;
		}
		return false;
	}
	
	public Map getMap(){
		return map;
	}

	public int getLevel(){
		return level;
	}
	
	public ArrayList<Character> getAllCharacters(){ //gathers all characters (hero,guard,ogre) in an ArrayList
		ArrayList<Character> temp = new ArrayList<Character>();
		temp.add(this.hero);
		if(0 == this.level)
			temp.add(this.guard);
		else if (1 == this.level){
			for(Ogre o : this.ogres)
				temp.add(o);
		}
		
		return temp;
	}

	public Logic moveHero(char direction){ //moves hero, returns an object of GameLogic, either next level or same level
		Position temp;
		
		if	   ('w' == direction)
			temp = hero.moveCharacter(map.getMapSize() , 4);
		else if('a' == direction)
			temp = hero.moveCharacter(map.getMapSize() , 3);		
		else if('s' == direction)
			temp = hero.moveCharacter(map.getMapSize() , 2);
		else if('d' == direction)
			temp = hero.moveCharacter(map.getMapSize() , 1);
		else
			return this;
		
		if (checkTriggers(temp)) //check if level up
			return (this.level == 0) ? new Logic(++this.level) : this;
		
		if( this.map.isFree(temp[0],temp[1]))
			this.hero.setPos(temp[0], temp[1], this.map.getMapSize());
		
		return this;
	}

	private boolean checkTriggers(Position pos){ //checks if hero is in a key/lever or entered a door/stairs
		
		if(level == 0 && pos[0] == this.key[0] && pos[1] == this.key[1] )
			map.openDoors();
		else if (level == 1 && this.map.getMap()[pos[0]][pos[1]] == 'I' && this.hero.hasKey()){
			this.map.openDoors();
			pos[1]++; //stop hero from going inside stairs at first attempt
		}
		else if (level == 1 && pos[0] == this.key[0] && pos[1] == this.key[1] && !this.hero.hasKey()){
			this.hero.setKey(true);
			this.map.pickUpKey();
		}
		else if (this.map.getMap()[pos[0]][pos[1]] == 'S'){
			this.hero.setPos(pos[0], pos[1], this.map.getMapSize());
			return true;
		}
			
		
		return false;
	}


}
