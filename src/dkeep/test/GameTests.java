package dkeep.test;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;
import dkeep.test.TestMap;
import dkeep.logic.*;
import dkeep.logic.Logic.status;

public class GameTests {

	private Random rand = new Random();
	@Test
	public void testMoveHeroIntoToFreeCell() {
		int[] test1 = { 1, 1 }, test2 = { 1, 2 };

		Logic game = new Logic(new TestMap(), rand.nextInt(3), rand.nextInt(3)+1);
		assertEquals(test1[0], game.getHero().getPosition().getX());
		assertEquals(test1[1], game.getHero().getPosition().getY());
		game = game.moveHero('s');
		assertEquals(test2[0], game.getHero().getPosition().getX());
		assertEquals(test2[1], game.getHero().getPosition().getY());

	}

	@Test
	public void testHeroIsCapturedByGuard() {
		Logic game = new Logic(new TestMap(), rand.nextInt(3), rand.nextInt(3)+1);
		int[][] path = { { 3, 1 } };
		game.getGuard().setPath(path);

		assertFalse(game.Over());
		game.moveHero('d');
		assertTrue(game.Over());
		game.Over();
		assertEquals(status.DEFEAT, game.condition);

	}

	@Test
	public void testHeroTriesMoveIntoToWall() {
		int[] test1 = { 1, 1 };

		Logic game = new Logic(new TestMap(), rand.nextInt(3), rand.nextInt(3)+1);;
		assertEquals(test1[0], game.getHero().getPosition().getX());
		assertEquals(test1[1], game.getHero().getPosition().getY());
		game = game.moveHero('w');
		assertEquals(test1[0], game.getHero().getPosition().getX());
		assertEquals(test1[1], game.getHero().getPosition().getY());

	}

	@Test
	public void testHeroTriesToGoOut() {
		int[] test1 = { 1, 1 };
		int[] test2 = { 1, 2 };

		Logic game = new Logic(new TestMap(), rand.nextInt(3), rand.nextInt(3)+1);;
		assertEquals(test1[0], game.getHero().getPosition().getX());
		assertEquals(test1[1], game.getHero().getPosition().getY());
		game = game.moveHero('s');
		game = game.moveHero('a');
		assertEquals(test2[0], game.getHero().getPosition().getX());
		assertEquals(test2[1], game.getHero().getPosition().getY());

	}

	@Test
	public void testHeroOpensDoorsLever() {
		int[] test1 = { 1, 1 };
		int[] test2 = { 1, 2 };

		Logic game = new Logic(new TestMap(), rand.nextInt(3), rand.nextInt(3)+1);;
		assertEquals(test1[0], game.getHero().getPosition().getX());
		assertEquals(test1[1], game.getHero().getPosition().getY());
		game = game.moveHero('s');
		game = game.moveHero('s');
		assertEquals(test2[0], game.getHero().getPosition().getX());
		assertEquals(test2[1], game.getHero().getPosition().getY());
		assertEquals('S', game.getMap().getMap()[2][0]);

	}

	@Test
	public void testHeroWins() {
		int[] test1 = { 1, 1 };
		int[] test2 = { 1, 2 };

		Logic game = new Logic(new TestMap(), rand.nextInt(3), rand.nextInt(3)+1);;
		assertEquals(test1[0], game.getHero().getPosition().getX());
		assertEquals(test1[1], game.getHero().getPosition().getY());
		game = game.moveHero('s');
		game = game.moveHero('s');
		assertEquals(test2[0], game.getHero().getPosition().getX());
		assertEquals(test2[1], game.getHero().getPosition().getY());
		game = game.moveHero('a');
		game.levelUp();
		assertEquals(status.WON, game.condition);

	}

	@Test
	public void testHeroKillByOgre()
	{
		int [] test1 = {1,1};
		
		Logic game = new Logic(new TestMap2(), rand.nextInt(3), rand.nextInt(3)+1);;
		Ogre ogre = new Ogre(3,1);
		game.setOgre(ogre);
		assertEquals(test1[0],game.getHero().getPosition().getX());
		assertEquals(test1[1],game.getHero().getPosition().getY());
		game = game.moveHero('d');
		assertTrue(game.Over());
		game.Over();
		assertEquals(status.DEFEAT, game.condition);
		
	}
	
	@Test
	public void testHeroChagesToK()
	{
		int [] test1 = {1,1};
		
		Logic game = new Logic(new TestMap2(), rand.nextInt(3), rand.nextInt(3)+1);;
		assertEquals(test1[0],game.getHero().getPosition().getX());
		assertEquals(test1[1],game.getHero().getPosition().getY());
		game = game.moveHero('s');
		game = game.moveHero('s');
		assertEquals('K',game.getHero().getRepresentation());
		
	}

	@Test
	public void testHeroTrysToExitWithoutKey()
	{
		int [] test1 = {1,1};
		int[] test2 = { 1, 2 };
		
		Logic game = new Logic(new TestMap2(), rand.nextInt(3), rand.nextInt(3)+1);;
		assertEquals(test1[0],game.getHero().getPosition().getX());
		assertEquals(test1[1],game.getHero().getPosition().getY());
		game = game.moveHero('s');
		game = game.moveHero('a');
		assertEquals(test2[0], game.getHero().getPosition().getX());
		assertEquals(test2[1], game.getHero().getPosition().getY());
		assertEquals('I', game.getMap().getMap()[2][0]);
		
	}
	
	@Test
	public void testHeroOpenDoorsKey()
	{
		int [] test1 = {1,1};
		
		Logic game = new Logic(new TestMap2(), rand.nextInt(3), rand.nextInt(3)+1);;
		assertEquals(test1[0],game.getHero().getPosition().getX());
		assertEquals(test1[1],game.getHero().getPosition().getY());
		game = game.moveHero('s');
		game = game.moveHero('s');
		assertEquals('K',game.getHero().getRepresentation());
		game = game.moveHero('a');
		assertEquals('S', game.getMap().getMap()[2][0]);
		
	}
	
	@Test
	public void testHeroWins2level()
	{
		int [] test1 = {1,1};
		
		Logic game = new Logic(new TestMap2(), rand.nextInt(3), rand.nextInt(3)+1);;
		assertEquals(test1[0],game.getHero().getPosition().getX());
		assertEquals(test1[1],game.getHero().getPosition().getY());
		game = game.moveHero('s');
		game = game.moveHero('s');
		assertEquals('K',game.getHero().getRepresentation());
		game = game.moveHero('a');
		assertEquals('S', game.getMap().getMap()[2][0]);
		game = game.moveHero('a');
		game.levelUp();
		assertEquals(status.WON, game.condition);
		
	}
	
	@Test (timeout=1000)
	public void testRandomBehabior()
	{
		//ogre positions
		int [] testO1 = {2,3};
		int [] testO2 = {3,2};
		int [] testO3 = {4,3};
		int [] testO4 = {3,4};
		
		//club positions
		//testO1
		int[] testC1 = {1,3};
		int[] testC2 = {3,3};
		int[] testC3 = {2,2};
		int[] testC4 = {2,4};
		
		//testO2
		int[] testC5 = {3,1};
		int[] testC6 = {4,2};
		
		//testO3
		int[] testC7 = {4,2};
		int[] testC8 = {4,4};
		int[] testC9 = {5,3};
		
		//testO4
		int[] testC10 = {3,5};
		
		
		
		boolean outcome1=false,outcome2=false;
		Logic game=new Logic(new TestMap3(), rand.nextInt(3), rand.nextInt(3)+1);;
		Ogre ogre = new Ogre(3,3);
		game.setOgre(ogre);
		game.moveAllVillains();
		if((game.getOgre().getPosition().getX() == testO1[0] && game.getOgre().getPosition().getY() == testO1[1]) || (game.getOgre().getPosition().getX() == testO2[0] && game.getOgre().getPosition().getY() == testO2[1]) || (game.getOgre().getPosition().getX() == testO3[0] && game.getOgre().getPosition().getY() == testO3[1]) || (game.getOgre().getPosition().getX() == testO4[0] && game.getOgre().getPosition().getY() == testO4[1]) )
		{
			outcome1=true;
			
		}
		assertTrue(outcome1);
		
		if((game.getOgre().getClub().getPosition().getX() == testC1[0] && game.getOgre().getClub().getPosition().getY() == testC1[1]) || (game.getOgre().getClub().getPosition().getX() == testC2[0] && game.getOgre().getClub().getPosition().getY() == testC2[1]) || (game.getOgre().getClub().getPosition().getX() == testC3[0] && game.getOgre().getClub().getPosition().getY() == testC3[1]) || (game.getOgre().getClub().getPosition().getX() == testC4[0] && game.getOgre().getClub().getPosition().getY() == testC4[1]) || (game.getOgre().getClub().getPosition().getX() == testC5[0] && game.getOgre().getClub().getPosition().getY() == testC5[1]) || (game.getOgre().getClub().getPosition().getX() == testC6[0] && game.getOgre().getClub().getPosition().getY() == testC6[1]) || (game.getOgre().getClub().getPosition().getX() == testC7[0] && game.getOgre().getClub().getPosition().getY() == testC7[1]) || (game.getOgre().getClub().getPosition().getX() == testC8[0] && game.getOgre().getClub().getPosition().getY() == testC8[1]) || (game.getOgre().getClub().getPosition().getX() == testC9[0] && game.getOgre().getClub().getPosition().getY() == testC9[1]) || (game.getOgre().getClub().getPosition().getX() == testC10[0] && game.getOgre().getClub().getPosition().getY() == testC10[1]))
		{
			outcome2=true;
			
		}
		assertTrue(outcome2);
		
		
	}

	@Test
	public void testClubKillsHero()
	{
		int [] test1 = {1,1};
		
		Logic game = new Logic(new TestMap2(), rand.nextInt(3), rand.nextInt(3)+1);;
		Ogre ogre = new Ogre(3,1);
		game.setOgre(ogre);
		ogre.getClub().setVisibility(true);
		ogre.getClub().setPosition(2, 1);
		assertEquals(test1[0],game.getHero().getPosition().getX());
		assertEquals(test1[1],game.getHero().getPosition().getY());
		assertTrue(game.Over());
		game.Over();
		assertEquals(status.DEFEAT, game.condition);
		
	}
	
	@Test
	public void testHeroStunsOgre()
	{
		int [] test1 = {1,1};
		
		Logic game = new Logic(new TestMap2(), rand.nextInt(3), rand.nextInt(3)+1);;
		Ogre ogre = new Ogre(3,1);
		game.setOgre(ogre);
		game.getHero().setWeapon(true);
		assertEquals(test1[0],game.getHero().getPosition().getX());
		assertEquals(test1[1],game.getHero().getPosition().getY());
		game.moveHero('d');
		game.atack_villains();
		assertTrue(game.getOgre().isStunned());		
	}
  
	@Test
	public void MakeMaze1()
	{
		int[] test1 = { 1, 1 }, test2 = { 2, 1 };

		Logic game = new Logic(new Maze1(), rand.nextInt(3), rand.nextInt(3)+1);;
		assertEquals(test1[0], game.getHero().getPosition().getX());
		assertEquals(test1[1], game.getHero().getPosition().getY());
		game = game.moveHero('d');
		assertEquals(test2[0], game.getHero().getPosition().getX());
		assertEquals(test2[1], game.getHero().getPosition().getY());
		
		
	}
	
	@Test
	public void MakeMaze2()
	{
		int[] test1 = { 1, 7 }, test2 = { 2, 7 };

		Logic game = new Logic(new Maze2(), rand.nextInt(3), rand.nextInt(3)+1);
		assertEquals(test1[0], game.getHero().getPosition().getX());
		assertEquals(test1[1], game.getHero().getPosition().getY());
		game = game.moveHero('d');
		assertEquals(test2[0], game.getHero().getPosition().getX());
		assertEquals(test2[1], game.getHero().getPosition().getY());
		
		
	}

	@Test
	public void SuspiciousMove()
	{
		Suspicious go = new Suspicious(1,1,true);
		int path[][] = {{1,1},{2,1},{3,1},{3,2},{2,2},{1,2}};
		int[] test1 = { 1, 1 };
		go.setPath(path);
		assertEquals(test1[0], go.getPosition().getX());
		assertEquals(test1[1], go.getPosition().getY());
		go.moveCharacter(5);
		go.moveCharacter(5);
		go.moveCharacter(5);
		go.moveCharacter(5);
		go.moveCharacter(5);
		go.moveCharacter(5);
		go.moveCharacter(5);
		go.moveCharacter(5);
		go.moveCharacter(5);
		go.moveCharacter(5);
		go.moveCharacter(5);
		go.moveCharacter(5);
		go.moveCharacter(5);
		go.moveCharacter(5);
		
		
	}
	
	@Test
	public void DrunkenMove()
	{
		Drunken go = new Drunken(1,1,true);
		int path[][] = {{1,1},{2,1},{3,1},{3,2},{2,2},{1,2}};
		int[] test1 = { 1, 1 };
		go.setPath(path);
		assertEquals(test1[0], go.getPosition().getX());
		assertEquals(test1[1], go.getPosition().getY());
		for(int i=0;i < 9;i++){
		go.moveCharacter(5);
		if(go.isAwake())
			assertTrue(go.isAwake());
		}
		assertTrue(go.isPlaying());
		
		
	}
	
	@Test
	public void OgreTest()
	{
		Ogre gi = new Ogre();
		Ogre go = new Ogre(1,1);
		int[] test1 = { 1, 1 };
		assertEquals(test1[0], go.getPosition().getX());
		assertEquals(test1[1], go.getPosition().getY());
		go.setPosition(1, 0);
		go.updateDirection();
		go.updateLastPosition();
		String rep = go + "";
		go.setPosition(1, 1);
		go.updateDirection();
		go.updateLastPosition();
		rep=go+"";
		go.moveClub();
		go.moveCharacter(5);
		go.moveClub();
		go.moveCharacter(5);
		go.moveClub();
		go.moveCharacter(5);
		go.moveClub();
		go.moveCharacter(5);
		go.moveClub();
		go.moveCharacter(5);
		go.moveClub();
		go.moveCharacter(5);
		go.moveClub();
		go.moveCharacter(5);
		go.moveClub();
		go.moveCharacter(5);
		go.moveClub();
		go.moveCharacter(5);
		go.moveClub();
		go.moveCharacter(5);
		go.moveClub();
		go.moveCharacter(5);
		go.setClubNotVisible();
		
		
		
	}
	
	@Test
	public void RookieMove()
	{
		Rookie go = new Rookie(1,1,true);
		int path[][] = {{1,1},{2,1},{3,1},{3,2},{2,2},{1,2}};
		int[] test1 = { 1, 1 };
		go.setPath(path);
		assertEquals(test1[0], go.getPosition().getX());
		assertEquals(test1[1], go.getPosition().getY());
		go.setPosition(1, 2);
		go.updateDirection();
		go.updateLastPosition();
		String r = go + "";
		go.setPosition(1, 1);
		go.updateDirection();
		go.updateLastPosition();
		go.moveCharacter(5);
		assertTrue(go.isPlaying());
		go.moveCharacter(5);
		go.moveCharacter(5);
		
		
	}
	
	@Test
	public void ClubMove()
	{
		MassiveClub go = new MassiveClub();
		assertFalse(go.getVisibility());
		go.moveCharacter(5);
		String r = ""+go;
		
	}
	
	@Test
	public void TestHero()
	{
		Hero go = new Hero(1,1,true,false);
		go.moveCharacter(5);
		String s = ""+go;
		
	}
	
	@Test 
	public void TestMaze3() 
	{
		char[][] map = {{'X','X','X','X','X'},
					    {'X',' ',' ','A','X'}, 
					    {'I',' ',' ',' ','X'},
					    {'I','k',' ',' ','X'},
					    {'X','X','X','X','X'}};
		
		Maze3 maze=new Maze3();
		maze.setMap(map);
		Logic game = new Logic(maze, rand.nextInt(3), rand.nextInt(3)+1);
		int[] test1 = { 3, 1 }, test2 = { 2, 1 };
		assertEquals(test1[0], game.getHero().getPosition().getX());
		assertEquals(test1[1], game.getHero().getPosition().getY());
		game = game.moveHero('a');
		assertEquals(test2[0], game.getHero().getPosition().getX());
		assertEquals(test2[1], game.getHero().getPosition().getY());
		assertTrue(maze.getKey().getX() == 1);
		assertTrue(maze.getKey().getY() == 3);
		assertFalse(maze.getMapSize() == 0);
		
		 
	}
	
	@Test 
	public void TestLogic()
	{
		Logic game = new Logic(new TestMap2(), rand.nextInt(3), rand.nextInt(3)+1);
		assertFalse(game.getAllCharacters().isEmpty());
		assertTrue(game.typeOfWall("X", 0, 0).startsWith("X"));
		assertTrue(game.typeOfWall("X", 0, 3).startsWith("X"));
		assertTrue(game.typeOfWall("X", 0, 2).startsWith("X"));
		assertTrue(game.typeOfWall("X", 0, 4).startsWith("X"));
		assertTrue(game.typeOfWall("X", 2, 0).startsWith("X"));
		assertTrue(game.typeOfWall("X", 4, 0).startsWith("X"));
		assertTrue(game.typeOfWall("X", 4, 4).startsWith("X"));
		assertTrue(game.typeOfWall("X", 4, 2).startsWith("X"));
		assertTrue(game.typeOfWall("X", 2, 4).startsWith("X"));
		
		
		
	}
	
	@Test
	public void TestOgreStunned()
	{
		int [] test1 = {1,1};
		Logic game = new Logic(new TestMap2(), rand.nextInt(3), 0);
		Ogre ogre = new Ogre(3,1);
		ogre.setClubNotVisible();
		game.setOgre(ogre);
		game.getHero().setWeapon(true);
		assertEquals(test1[0],game.getHero().getPosition().getX());
		assertEquals(test1[1],game.getHero().getPosition().getY());
		game = game.moveHero('d');
		assertTrue(game.getHero().is_armed());
		assertFalse(game.getOgre().isStunned());
		
	}
	
	
	
}
