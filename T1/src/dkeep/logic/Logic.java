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
			map = new Maze1();
			hero = new Hero(level);
			key = new Position(7, 8, 'k');

			int res = rand.nextInt(3);
			if (0 == res)
				guard = new Rookie();
			else if (1 == res)
				guard = new Drunken();
			else if (2 == res)
				guard = new Suspicious();
		} else if (1 == level) {
			map = new Maze2();
			hero = new Hero(this.level);
			key = new Position(8, 1, 'k');
			int res = rand.nextInt(3) + 1;
			for (int i = 0; i < res; i++)
				ogres.add(new Ogre(rand.nextInt(7) + 1, rand.nextInt(7) + 1));
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

	public Guard getGuard()
	{
		return guard;
	}
	
	public int getLevel(){
		return level;
	}
	
	public ArrayList<Character> getAllCharacters(){ //gathers all characters (hero,guard,ogre) in an ArrayList
		ArrayList<Character> temp = new ArrayList<Character>();
		temp.add(hero);
		if(0 == level)
			temp.add(guard);
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
			return (level == 0) ? new Logic(++level) : this;
		
		if( map.isFree(temp.getX(),temp.getY()))
			hero.setPos(temp.getX(), temp.getY(), map.getMapSize());
		
		return this;
	}

	private boolean checkTriggers(Position pos){ //checks if hero is in a key/lever or entered a door/stairs
		
		if(level == 0 && pos.getX() == key.getX() && pos.getY() == key.getY() )
			map.openDoors();
		else if (level == 1 && map.getMap()[pos.getY()][pos.getX()] == 'I' && hero.hasKey()){
			map.openDoors();
			pos.increaseX(); //stop hero from going inside stairs at first attempt
		}
		else if (level == 1 && pos.getX() == key.getX() && pos.getY() == key.getY() && !hero.hasKey()){
			hero.pickUpKey();
			map.pickUpKey();
		}
		else if (map.getMap()[pos.getY()][pos.getX()] == 'S'){
			this.hero.setPos(pos.getX(), pos.getY(), this.map.getMapSize());
			return true;
		}
			
		
		return false;
	}

	public void moveAllVillains(){ //move all villains based on current level
		Position pos;
		if ( 0 == this.level ){ //move only guards
			do{
				pos = guard.moveCharacter(map.getMapSize());
			}while(!this.map.isFree(pos.getX(), pos.getY()) );
		}
		else if (1 == this.level ){ //move only ogres
			for (Ogre ogre : ogres ){
				do{
					pos = ogre.moveCharacter(map.getMapSize());
				}while(!this.map.isFree(pos.getX(),pos.getY()));
				
				ogre.setPos(pos.getX(), pos.getY(), map.getMapSize());
//				do{
//					pos = o.moveClub(this.map.getMapSize());
//				}while( !this.map.isFree(pos[0],pos[1]));
//				o.setClub(pos[0], pos[1], this.map.getMapSize());
			}
		}
	}

}
