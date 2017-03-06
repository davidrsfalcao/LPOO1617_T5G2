package dkeep.test;

import static org.junit.Assert.*;
import org.junit.Test;
import dkeep.test.TestMap;
import dkeep.logic.Logic;


public class GameTests {

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
		Logic game =new Logic( new TestMap());
		int [][] path = {{3,1}};
		game.getGuard().setPath(path);
	
		assertFalse(game.Over());
		game.moveHero('d');
		assertTrue(game.Over());
	
	}
	
}

