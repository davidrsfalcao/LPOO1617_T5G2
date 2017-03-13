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
	
	//// (.....) terminar
	
	
	
	public void paintComponent(Graphics gr) {
		super.paintComponent(gr); // clears the background ...		
		drawGame(gr);
	}
	
	public void drawGame(Graphics gr)
	{
		
		
	}
	
	
	
}
