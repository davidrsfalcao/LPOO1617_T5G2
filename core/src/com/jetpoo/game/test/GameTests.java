package com.jetpoo.game.test;

import org.junit.Test;
import static org.junit.Assert.*;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.jetpoo.game.actors.*;

/**
 * Created by davidfalcao on 11/06/17.
 */


public class GameTests {

    @Test
    /**
     * Test hero inicialization
     */
    public void testCreatHero(){
        Hero hero = new NormalGuy(100, 100);
        assertEquals(hero.getX(), 100);
        assertEquals(hero.getY(), 100);
        assertEquals(hero.isOntheGround(), false);
        assertEquals(hero.isAcelerating(), false);
        assertEquals(hero.getVelocity(), new Vector2(0,0));

        int x = hero.getX();
        int y = hero.getY();

        assertEquals(hero.getBounds(), new Rectangle(x+20, y, 60, 100));

        hero = new HeavyGuy(100, 64);
        assertEquals(hero.getCounter(), 15, 0.001);
        assertEquals(hero.isOntheGround(), true);
    }

    @Test
    public void testHeroJump(){
        Hero hero = new NormalGuy(100, 64);
        assertEquals(hero.isOntheGround(), true);
        hero.jump();
        assertEquals(hero.isOntheGround(), false);
        assertEquals(hero.isAcelerating(), true);
        assertEquals(hero.getVelocity(), new Vector2(0,150));
        hero.jump();
        assertEquals(hero.getVelocity(), new Vector2(0,175));

        hero = new HeavyGuy(100, 64);
        assertEquals(hero.isOntheGround(), true);
        hero.jump();
        assertEquals(hero.isOntheGround(), false);
        assertEquals(hero.isAcelerating(), true);
        assertEquals(hero.getVelocity(), new Vector2(0,100));
        hero.jump();
        assertEquals(hero.getVelocity(), new Vector2(0,150));

    }
}
