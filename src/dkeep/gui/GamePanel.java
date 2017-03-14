package dkeep.gui;

import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


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
	private BufferedImage heroWithKeyArmed;
	
	
	/**
	 * Massive Club Representations
	 * 
	 */
	private BufferedImage club;
	private BufferedImage club_key;
	
	
	
	/**
	 * Ogre representations
	 * 
	 */
	private BufferedImage ogre_front;
	private BufferedImage ogre_back;
	private BufferedImage ogreStunned;
	private BufferedImage ogreKey;
	
	
	/**
	 * Guard Representation
	 *
	 */
	private BufferedImage guard_front;
	private BufferedImage guard_back;
	private BufferedImage guard_sleep;
	
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
	 * Walls and floor representation
	 * 
	 */
	
	 // walls
	private BufferedImage wall;  // isolada
	private BufferedImage wall1;  // parede a norte
	private BufferedImage wall2;  // parede a norte e sul ou só sul
	private BufferedImage wall3;  // parede a oeste
	private BufferedImage wall4;  // parede a este
	private BufferedImage wall5;  // parede a este e oeste
	private BufferedImage wall6;  // parede em todas as direcoes
	private BufferedImage wall7;  // parede excepto em norte
	private BufferedImage wall8;   // parede excepto em sul
	private BufferedImage wall9;   // parede excepto em oeste
	private BufferedImage wall10;   // parede excepto em este
	
	
	
	//floor	
	
	private BufferedImage floor;   // chao sem sombra
	private BufferedImage floors;  // chao com sombra
	
	
	
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
		
		for(int y = 0;y < map.size();y++)
		{
			for (int x=0;x < map.get(y).size();x++)
			{
				int i=x*10;
				int j=y*10;
				switch(map.get(y).get(x))
				{
				//paredes
				
				case "X":
					gr.drawImage(wall, i, j, null);
					break;
				case "X1":
					gr.drawImage(wall1, i, j, null);
					break;
				case "X2":
					gr.drawImage(wall2, i, j, null);
					break;
				case "X3":
					gr.drawImage(wall3, i, j, null);
					break;
				case "X4":
					gr.drawImage(wall4, i, j, null);
					break;
				case "X5":
					gr.drawImage(wall5, i, j, null);
					break;
				case "X6":
					gr.drawImage(wall6, i, j, null);
					break;
				case "X7":
					gr.drawImage(wall7, i, j, null);
					break;
				case "X8":
					gr.drawImage(wall8, i, j, null);
					break;
				case "X9":
					gr.drawImage(wall9, i, j, null);
					break;
				case "X10":
					gr.drawImage(wall10, i, j, null);
					break;
					
				//espacos
					
				case " ":
					gr.drawImage(floor, i, j, null);
					break;
				case "ES":
					gr.drawImage(floors, i, j, null);
					break;
					
				//heroi
					
				case "HF":
					gr.drawImage(hero_front, i, j, null);
					break;
				case "HB":
					gr.drawImage(hero_back, i, j, null);
					break;
				case "HAF":
					gr.drawImage(heroArmed_front, i, j, null);
					break;
				case "HAB":
					gr.drawImage(heroArmed_back, i, j, null);
					break;
				case "HKAF":
					gr.drawImage(heroWithKeyArmed, i, j, null);
					break;
					
				//sombras	
					
				case "HFS":
					gr.drawImage(floors, i, j, null);
					gr.drawImage(hero_front, i, j, null);
					break;
				case "HBS":
					gr.drawImage(floors, i, j, null);
					gr.drawImage(hero_back, i, j, null);
					break;
				case "HAFS":
					gr.drawImage(floors, i, j, null);
					gr.drawImage(heroArmed_front, i, j, null);
					break;
				case "HABS":
					gr.drawImage(floors, i, j, null);
					gr.drawImage(heroArmed_back, i, j, null);
					break;
				case "HKAFS":
					gr.drawImage(floors, i, j, null);
					gr.drawImage(heroWithKeyArmed, i, j, null);
					break;
				
					
				//ogre
					
				case "OF":
					gr.drawImage(ogre_front, i, j, null);
					break;
				case "OB":
					gr.drawImage(ogre_back, i, j, null);
					break;
				case "OS":
					gr.drawImage(ogreStunned, i, j, null);
					break;
				case "O$":
					gr.drawImage(ogreKey, i, j, null);
					break;
					
				//sombra	
					
				case "OFS":
					gr.drawImage(floors, i, j, null);
					gr.drawImage(ogre_front, i, j, null);
					break;
				case "OBS":
					gr.drawImage(floors, i, j, null);
					gr.drawImage(ogre_back, i, j, null);
					break;
				case "OSS":
					gr.drawImage(floors, i, j, null);
					gr.drawImage(ogreStunned, i, j, null);
					break;
				case "O$S":
					gr.drawImage(floors, i, j, null);
					gr.drawImage(ogreKey, i, j, null);
					break;
				
					
				//portas
					
				case "I":
					gr.drawImage(doorClosed, i, j, null);
					break;
				case "S":
					gr.drawImage(doorOpen, i, j, null);
					break;
					
				//key and lever
					
				case "ku":
					gr.drawImage(LeverUp, i, j, null);
					break;
				case "kd":
					gr.drawImage(LeverDown, i, j, null);
					break;
				case "k":
					gr.drawImage(key, i, j, null);
					break;
					
				//sombra
					
				case "kS":
					gr.drawImage(floors, i, j, null);
					gr.drawImage(key, i, j, null);
					break;
					
				//guards
					
				case "GF":
					gr.drawImage(guard_front, i, j, null);
					break;
				case "GB":
					gr.drawImage(guard_back, i, j, null);
					break;
				case "GS":
					gr.drawImage(guard_sleep, i, j, null);
					break;
					
					
				case "GFS":
					gr.drawImage(floors, i, j, null);
					gr.drawImage(guard_front, i, j, null);
					break;
				case "GBS":
					gr.drawImage(floors, i, j, null);
					gr.drawImage(guard_back, i, j, null);
					break;
				case "GSS":
					gr.drawImage(floors, i, j, null);
					gr.drawImage(guard_sleep, i, j, null);
					break;
				
				// club
					
				case "*":
					gr.drawImage(club, i, j, null);
					break;
				case "k$":
					gr.drawImage(club_key, i, j, null);
					break;
				case "*S":
					gr.drawImage(floors, i, j, null);
					gr.drawImage(club, i, j, null);
					break;
				case "k$S":
					gr.drawImage(floors, i, j, null);
					gr.drawImage(club_key, i, j, null);
					break;
				
					
					
				
					
				}
				
			}
			
		}
		
	}
	
	
	
	
}
