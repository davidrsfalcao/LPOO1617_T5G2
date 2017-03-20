package dkeep.gui;

import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import dkeep.logic.*;
import dkeep.logic.Character;


public class GamePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<ArrayList<String>> map = new ArrayList<ArrayList<String>>();
	private ArrayList<Position> objectives = new ArrayList<Position>();
	private ArrayList<Position> characters = new ArrayList<Position>();
	
	/**
	 * Hero representations
	 * 
	 */
	private BufferedImage hero_front;
	private BufferedImage hero_back;
	private BufferedImage heroArmed_front;
	private BufferedImage heroKey_front;
	private BufferedImage heroArmed_back;
	private BufferedImage heroKeyArmed_front;
	
	
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
	private BufferedImage ogreStunned_front;
	private BufferedImage ogreStunned_back;
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
	private BufferedImage wall00;  // este e oeste
	private BufferedImage wall01;  // parede a norte
	private BufferedImage wall02;  // parede a norte e sul ou só sul
	private BufferedImage wall03;  // parede a oeste
	private BufferedImage wall04;  // parede a este
	private BufferedImage wall05;  // parede a este e oeste
	private BufferedImage wall06;  // parede em todas as direcoes
	private BufferedImage wall07;  // parede excepto em norte
	private BufferedImage wall08;   // parede excepto em sul
	private BufferedImage wall09;   // parede excepto em oeste
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
			 heroKeyArmed_front = ImageIO.read(new File("res/hero/HeroArmedWithKey.png"));
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
			ogreStunned_front = ImageIO.read(new File("res/ogre/OgreStunned.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			ogreStunned_back = ImageIO.read(new File("res/ogre/OgreStunned.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		


		/**
		 * 
		 * Walls
		 * 
		 */
		
		try {
			wall00 = ImageIO.read(new File("res/walls/Wall00.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			wall02 = ImageIO.read(new File("res/walls/Wall01.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			floor = ImageIO.read(new File("res/floor/Grass.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	@Override
	public void paintComponent(Graphics gr) {
		super.paintComponent(gr); // clears the background ...		
		drawBoard(gr);
		drawCharacters(gr);
	}
	
	public void drawBoard(Graphics gr)
	{
		Resizer res = new Resizer();
		BufferedImage temp;
		
		int map_size = map.size();
		
		int resX = 1024/((map_size*2)-1);
		int resY = resX;
		
		
		for(int y = 0;y < map_size;y++)
		{
			for (int x=0;x < map_size;x++)
			{
				int i=(map_size-(y+1)+x)*resX;
				int j=(2+y)*resY;
				
				switch(map.get(y).get(x))
				{
				//paredes
				
				case "X00":
					temp = res.resize(wall00, resX, resY);
					gr.drawImage(temp, i, j, null);
					break;
				case "X01":
					temp = res.resize(wall01, resX, resY);
					gr.drawImage(temp, i, j, null);
					break;
				case "X02":
					temp = res.resize(wall02, resX, resY);
					gr.drawImage(temp, i, j, null);
					break;
				case "X03":
					temp = res.resize(wall03, resX, resY);
					gr.drawImage(temp, i, j, null);
					break;
				case "X04":
					temp = res.resize(wall04, resX, resY);
					gr.drawImage(temp, i, j, null);
					break;
				case "X05":
					temp = res.resize(wall05, resX, resY);
					gr.drawImage(temp, i, j, null);
					break;
				case "X06":
					temp = res.resize(wall06, resX, resY);
					gr.drawImage(temp, i, j, null);
					break;
				case "X07":
					temp = res.resize(wall07, resX, resY);
					gr.drawImage(temp, i, j, null);
					break;
				case "X08":
					temp = res.resize(wall08, resX, resY);
					gr.drawImage(temp, i, j, null);
					break;
				case "X09":
					temp = res.resize(wall09, resX, resY);
					gr.drawImage(temp, i, j, null);
					break;
				case "X10":
					temp = res.resize(wall10, resX, resY);
					gr.drawImage(temp, i, j, null);
					break;
					
				//espacos
					
				case " ":
					temp = res.resize(floor, resX, resY);
					gr.drawImage(temp, i, j, null);
					break;
				case "ES":
					gr.drawImage(floors, i, j, null);
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

				
				}
				
			}
			
		}
		
	}
	
	public void drawCharacters(Graphics gr)
	{
		Resizer res = new Resizer();
		BufferedImage temp;
		
		int map_size = map.size();
		
		int resX = 1024/((map_size*2)-1);
		int resY = resX;
		
		
		
		for (Position pos : characters)
		{
			int x = pos.getX();
			int y = pos.getY();
			int i=(map_size-(y+1)+x)*resX;
			int j=(2+y)*resY;
			
			switch(pos.getRepresentationGui())
			{
			case "HF":
				temp = res.resize(hero_front, resX, resY);
				gr.drawImage(temp, i, j, null);
				break;
				
			case "HFA":
				temp = res.resize(heroArmed_front, resX, resY);
				gr.drawImage(temp, i, j, null);
				break;
				
			case "HFK":
				temp = res.resize(heroKey_front, resX, resY);
				gr.drawImage(temp, i, j, null);
				break;
				
			case "HFAK":
				temp = res.resize(heroKeyArmed_front, resX, resY);
				gr.drawImage(temp, i, j, null);
				break;
				
			case "HB":
				temp = res.resize(hero_back, resX, resY);
				gr.drawImage(temp, i, j, null);
				break;
				
			case "HBA":
				temp = res.resize(heroArmed_back, resX, resY);
				gr.drawImage(temp, i, j, null);
				break;
				
			case "OF":
				temp = res.resize(ogre_front, resX, resY);
				gr.drawImage(temp, i, j, null);
				break;
				
			case "OFS":
				temp = res.resize(ogreStunned_front, resX, resY);
				gr.drawImage(temp, i, j, null);
				break;
				
			case "OB":
				temp = res.resize(ogre_back, resX, resY);
				gr.drawImage(temp, i, j, null);
				break;
				
			case "OBS":
				temp = res.resize(ogreStunned_front, resX, resY);
				gr.drawImage(temp, i, j, null);
				break;
				
			
			}
		}
		
	}
	
	public void setMap(ArrayList<ArrayList<String>> map1)
	{
		map = new ArrayList<ArrayList<String>>(map1);
		
	}
	
	public void setObjectives(ArrayList<Position> obj)
	{
		objectives = new ArrayList<Position>(obj);
		
	}
	
	public void setCharacters(ArrayList<Position> obj)
	{
		characters = new ArrayList<Position>(obj);
		
	}

	
}
