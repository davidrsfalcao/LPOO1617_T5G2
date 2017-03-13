package dkeep.gui;

import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import dkeep.logic.*;


public class GamePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private ArrayList<ArrayList<String>> map = new ArrayList<ArrayList<String>>();
	
	/**
	 * Hero representations
	 * 
	 */
	private BufferedImage hero_front;
	private BufferedImage hero_back;
	private BufferedImage heroArmed_front;
	private BufferedImage heroArmed_back;
	private BufferedImage heroWithKey;
	private BufferedImage heroWithKeyArmed;
	
	/**
	 * Ogre representations
	 * 
	 */
	private BufferedImage ogre_front;
	private BufferedImage ogre_back;
	private BufferedImage ogreStunned;
	
	/**
	 * Objectives representations 
	 * 
	 */
	private BufferedImage doorClosed;
	private BufferedImage doorOpen;
	private BufferedImage key;
	private BufferedImage LeverUp;
	private BufferedImage LeverDown;
	
	/**
	 * Walls and floor represenatation
	 * 
	 */
	private BufferedImage wall1;
	private BufferedImage wall2;
	private BufferedImage wall3;
	private BufferedImage wall4;
		////(.....) terminar
	
	
	public GamePanel() {

		/**
		 * HERO
		 * 
		 */
		try {
			hero_front = ImageIO.read(new File("res/hero/Hero.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			hero_back = ImageIO.read(new File("res/hero/HeroBack.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			heroArmed_back = ImageIO.read(new File("res/hero/HeroBackArmed.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			heroArmed_front = ImageIO.read(new File("res/hero/HeroArmed.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			heroWithKeyArmed = ImageIO.read(new File("res/hero/HeroArmedWithKey.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			heroWithKey = ImageIO.read(new File("res/hero/HeroWithKey.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/**
		 * OGRE
		 * 
		 */
		try {
			ogre_front = ImageIO.read(new File("res/ogre/Ogre.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			ogre_back = ImageIO.read(new File("res/ogre/OgreBack.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			ogreStunned = ImageIO.read(new File("res/ogre/OgreStunned.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	public void paintComponent(Graphics gr) {
		super.paintComponent(gr); // clears the background ...		
		drawGame(gr);
	}
	
	public void drawGame(Graphics gr)
	{
		
		
	}
	
	
	
}
