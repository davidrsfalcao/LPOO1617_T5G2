package dkeep.test;

import static org.junit.Assert.*;
import org.junit.Test;
import dkeep.test.TestMap;
import dkeep.logic.*;
import dkeep.logic.Logic.status;

public class GameTests {

	@Test
	public void testMoveHeroIntoToFreeCell() {
		int[] test1 = { 1, 1 }, test2 = { 1, 2 };

		Logic game = new Logic(new TestMap());
		assertEquals(test1[0], game.getHero().getPosition().getX());
		assertEquals(test1[1], game.getHero().getPosition().getY());
		game = game.moveHero('s');
		assertEquals(test2[0], game.getHero().getPosition().getX());
		assertEquals(test2[1], game.getHero().getPosition().getY());

	}

	@Test
	public void testHeroIsCapturedByGuard() {
		Logic game = new Logic(new TestMap());
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

		Logic game = new Logic(new TestMap());
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

		Logic game = new Logic(new TestMap());
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

		Logic game = new Logic(new TestMap());
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

		Logic game = new Logic(new TestMap());
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
		
		Logic game = new Logic(new TestMap2());
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
		
		Logic game = new Logic(new TestMap2());
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
		
		Logic game = new Logic(new TestMap2());
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
		
		Logic game = new Logic(new TestMap2());
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
		
		Logic game = new Logic(new TestMap2());
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
	
	

	
}
