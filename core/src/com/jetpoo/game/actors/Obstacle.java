package com.jetpoo.game.actors;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.jetpoo.game.JetPoo;

import java.util.Random;

/**
 * Represents an obstacle. It comes randomly.
 *
 * Created by davidfalcao on 03/06/17.
 */
public class Obstacle {
    private Vector2 position;
    private int height;
    private int width;
    private Rectangle bounds;
    private Random randomGenerator;

    /**
     * @brief Obstacle Constructor
     * @param x position of the obstacle
     *
     */
    public Obstacle(int x) {
        randomGenerator = new Random();
        position = new Vector2();
        position.x = x;
        initPosition();
        initHeight();
        initBounds();

    }

    /**
     * @brief inits the position of the obstacle
     */
    public void initPosition(){
        int ground = 64;
        int ceiling = 128;

        position.y = randomGenerator.nextInt(JetPoo.HEIGHT-ceiling-ground) + ground;
    }

    /**
     * @brief inits Height of the obstacle
     */
    public void initHeight(){
        int ground = 64;
        int ceiling = 128;

        height = randomGenerator.nextInt(JetPoo.HEIGHT-ceiling-ground-200)/2 +100;

        if (position.y + height > JetPoo.HEIGHT-ceiling){
            position.y -= height;
        }

        width = height/2;

    }

    /**
     * @brief inits the Bounds of the obstacle
     */
    public void initBounds(){
        bounds = new Rectangle((position.x+width/4), position.y, width/3, height);

    }

    /**
     * @brief updates obstacle position
     * @param delta update difference
     */
    public void update(float delta){
        position.x -= delta;
        bounds.setPosition((position.x+width/4),position.y);

    }

    /**
     * @brief returns the x position of the obstacle
     *
     * @return obstacle's x position
     */
    public float getX(){
        return position.x;
    }

    /**
     * @brief returns the y position of the obstacle
     *
     * @return obstacle's y position
     */
    public float getY(){
        return position.y;
    }

    /**
     * @brief returns the height of the obstacle
     *
     * @return obstacle's height
     */
    public int getHeight(){
        return height;
    }

    /**
     * @brief returns the width of the obstacle
     *
     * @return obstacle's width
     */
    public int getWidth(){
        return width;
    }

    /**
     * @brief returns the obstacle's bounds
     *
     * @return bounds of the obstacle
     */
    public Rectangle getBounds() {
        return bounds;
    }

    /**
     * @brief sets the obstacles's Position (only for testing)
     * @param y obstacles's Position
     *
     **/
    public void setY(int y){
        position.y = y;
    }
}
