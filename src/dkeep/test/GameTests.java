package dkeep.test;

import static org.junit.Assert.*;
import org.junit.Test;
import dkeep.logic.Position;
import dkeep.logic.Maze1;
import dkeep.logic.Logic;




public class GameTests {

	char [][] map = {{'X','X','X','X','X'},
			         {'X','H',' ','G','X'},
			         {'X',' ',' ',' ','X'},
			         {'X','k',' ',' ','X'},
			         {'X','X','X','X','X'}};
	
	@Test
	public void testMoveHeroIntoToFreeCell()
	{
		int [] test1 = {1,1},test2= {1,2};
		
		Logic game =new Logic(new TestMap());
		assertEquals(test1[0],game.getHero().getPosition().getX());
		assertEquals(test1[1],game.getHero().getPosition().getY());
		game = game.moveHero('s');
		assertEquals(test2[0],game.getHero().getPosition().getX());
		assertEquals(test2[1],game.getHero().getPosition().getY());
		
	}
	
	@Test
	public void testHeroIsCapturedByGuard()
	{
		Logic game =new Logic( new Maze1());
		assertFalse(game.Over());
		game.moveHero('d');
		assertTrue(game.Over());
		
	}
	
}

