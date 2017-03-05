package dkeep.test;

import static org.junit.Assert.*;
import org.junit.Test;
import dkeep.logic.Position;
import dkeep.logic.Maze1;
import dkeep.logic.Logic;
import dkeep.logic.Hero;


public class GameTests {

	char [][] map = {{'X','X','X','X','X'},
			         {'X','H',' ','G','X'},
			         {'X',' ',' ',' ','X'},
			         {'X','k',' ',' ','X'},
			         {'X','X','X','X','X'}};
	
	@Test
	public void testMoveHeroIntoToFreeCell()
	{
		int [] test1 = {1,1},test2= {2,1};
		
		Maze1 gameMap = new Maze1(map);
		Logic game=new Logic(gameMap,0);
		assertEquals(test1[0],game.getHero().getPosition().getX());
		assertEquals(test1[1],game.getHero().getPosition().getY());
		game.moveHero('s');
		assertEquals(test2[0],game.getHero().getPosition().getX());
		assertEquals(test2[1],game.getHero().getPosition().getY());
		
	}
	
	@Test
	public void testHeroIsCapturedByGuard()
	{
		Maze1 gameMap = new Maze1(map);
		Logic game=new Logic(gameMap,0);
		assertFalse(game.Over());
		game.moveHero('d');
		assertTrue(game.Over());
		
	}
	
}

