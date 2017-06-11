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
        assertEquals(hero.getCounter(), 0, 0.001);

        int x = hero.getX();
        int y = hero.getY();
        assertEquals(hero.getBounds(), new Rectangle(x+20, y, 60, 100));

        hero = new HeavyGuy(100, 64);
        assertEquals(hero.getCounter(), 15, 0.001);
        assertEquals(hero.isOntheGround(), true);

        hero = new NormalGuy(100, 100);
        assertEquals(hero.isAcelerating(), false);
        hero.setAcelerating(true);
        assertEquals(hero.isAcelerating(), true);
    }


    @Test
    /**
     * Test hero jump
     */
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

    @Test
    /**
     * Test hero update
     */
    public void testHeroUpdate(){
        Hero hero = new NormalGuy(100, 64);
        assertEquals(hero.isOntheGround(), true);
        int x = hero.getX();
        int y = hero.getY();
        assertEquals(hero.getBounds(), new Rectangle(x+20, y, 60, 100));
        hero.jump();
        hero.update(1.0f);
        assertEquals(hero.getVelocity(), new Vector2(0,140));
        assertEquals(hero.getX(), x);
        assertEquals(hero.getY(), y + 140);
        assertEquals(hero.getBounds(), new Rectangle(x+20, y+140, 60, 100));

        hero = new HeavyGuy(100, 64);
        assertEquals(hero.isOntheGround(), true);
        x = hero.getX();
        y = hero.getY();
        assertEquals(hero.getBounds(), new Rectangle(x+20, y, 60, 100));
        hero.jump();
        hero.update(1.0f);
        assertEquals(hero.getVelocity(), new Vector2(0,70));
        assertEquals(hero.getX(), x);
        assertEquals(hero.getY(), y + 70);
        assertEquals(hero.getBounds(), new Rectangle(x+20, y+70, 60, 100));

    }

    @Test
    /**
     * Hero colides with ground
     */
    public void testColisionHeroGround(){
        Rectangle ground = new Rectangle(0,0, 1024, 64);
        Hero hero;

        /**
         * Without bounce
         */
        hero = new NormalGuy(100, 70);
        assertEquals(hero.colideGround(ground), false);
        hero.update(1f);
        assertEquals(hero.colideGround(ground), true);
        assertEquals(hero.isOntheGround(), true);

        /**
         * With bounce
         */
        hero = new NormalGuy(100, 600);
        assertEquals(hero.colideGround(ground), false);
        for(int i = 0; i< 33; i++){
            hero.update(0.1f);
        }

        /**
         * Hits the ground with velocity -330
         */
        assertEquals(hero.colideGround(ground), true);
        assertEquals(hero.isOntheGround(), false);
        assertEquals(hero.getVelocity(), new Vector2(0, 330/5));
    }

    @Test
    /**
     * Hero colides with ceiling
     */
    public void testColisionHeroCeiling(){
        Rectangle ceiling = new Rectangle(0,648, 1024, 128);
        Hero hero;

        /**
         * No colision
         *
         */
        hero = new NormalGuy(100, 100);
        assertEquals(hero.colideCeiling(ceiling), false);

        /**
         * Without bounce
         */
        hero = new NormalGuy(100, 650);
        assertEquals(hero.colideCeiling(ceiling), true);
        assertEquals(hero.getVelocity(), new Vector2(0, 10));

        /**
         * With bounce
         */
        hero = new NormalGuy(100, 650);
        hero.jump();
        assertEquals(hero.colideCeiling(ceiling), true);
        assertEquals(hero.getVelocity(), new Vector2(0, -75));

    }

    @Test
    /**
     * Hero catch powerUp
     */
    public void testHeroCatchPowerUp(){
        Hero hero = new NormalGuy(100, 64);
        PowerUp pw = new PowerUp();

        assertEquals(hero.catchPowerUp(pw), false);



    }

}
