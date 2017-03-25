package dkeep.gui;

import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import dkeep.logic.*;

/**
 * Panel that displays the game
 * 
 * @author davidfalcao
 *
 */
public class GamePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<ArrayList<String>> map = new ArrayList<ArrayList<String>>();
	private ArrayList<Position> objectives = new ArrayList<Position>();
	private ArrayList<Position> characters = new ArrayList<Position>();
	private boolean win = false;
	private boolean lose = false;
	
	
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
	
	/**
	 * Ogre representations
	 * 
	 */
	private BufferedImage ogre_front;
	private BufferedImage ogre_back;
	private BufferedImage ogreStunned_front;
	
	
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
	private BufferedImage key;
	private BufferedImage leverUp;
	private BufferedImage leverDown;
	
	/**
	 * Walls and floor representation
	 * 
	 */
	
	 // walls
	private BufferedImage wall00;  
	private BufferedImage wall01;  
	private BufferedImage wall02; 
	private BufferedImage wall03;  
	private BufferedImage wall06;  
	private BufferedImage wall07;
	private BufferedImage wallC; 
	private BufferedImage wallC1; 

	//floor		
	private BufferedImage floor;   // chao sem sombra
	private BufferedImage floors;  // chao com sombra
	
	private BufferedImage win_img; 
	private BufferedImage lose_img;
	
	private BufferedImage light1;
	private BufferedImage light2;
	private BufferedImage light3;
	private BufferedImage light4;
	private BufferedImage light5;
	private BufferedImage light6;
	private BufferedImage light7;
	private BufferedImage light8;
	private BufferedImage light9;
	
	
	/**
	 * Cosntructor
	 * Upload the images
	 * 
	 */
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
		
		try {
			 club = ImageIO.read(new File("res/ogre/Club.png"));
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
			ogreStunned_front = ImageIO.read(new File("res/ogre/OgreStunned.png"));
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
			wall01 = ImageIO.read(new File("res/walls/Wall01.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			wall02 = ImageIO.read(new File("res/walls/Wall02.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			wall03 = ImageIO.read(new File("res/walls/Wall03.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		try {
			wall06 = ImageIO.read(new File("res/walls/Wall06.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		try {
			wall07 = ImageIO.read(new File("res/walls/Wall07.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			wallC = ImageIO.read(new File("res/walls/WallC.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			wallC1 = ImageIO.read(new File("res/walls/WallC1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/**
		 * 
		 * Guard
		 * 
		 */
		try {
			guard_front = ImageIO.read(new File("res/guard/Guard.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			guard_back = ImageIO.read(new File("res/guard/GuardB.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			guard_sleep = ImageIO.read(new File("res/guard/GuardS.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		/**
		 * 
		 * Floor
		 * 
		 */
		
		
		try {
			floor = ImageIO.read(new File("res/floor/Grass.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			floors = ImageIO.read(new File("res/floor/Grass1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/**
		 * 
		 * Objectives
		 * 
		 */
		
		try {
			doorClosed = ImageIO.read(new File("res/objectives/Closed.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			key = ImageIO.read(new File("res/objectives/Key.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			leverUp = ImageIO.read(new File("res/objectives/Lever.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			leverDown = ImageIO.read(new File("res/objectives/Lever1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			key = ImageIO.read(new File("res/objectives/Key.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		try {
			lose_img = ImageIO.read(new File("res/Lose.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			win_img = ImageIO.read(new File("res/Win.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		try {
			light1 = ImageIO.read(new File("res/luz/Luz_01.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			light2 = ImageIO.read(new File("res/luz/Luz_02.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			light3 = ImageIO.read(new File("res/luz/Luz_03.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			light4 = ImageIO.read(new File("res/luz/Luz_04.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			light5 = ImageIO.read(new File("res/luz/Luz_05.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			light6 = ImageIO.read(new File("res/luz/Luz_06.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			light7 = ImageIO.read(new File("res/luz/Luz_07.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			light8 = ImageIO.read(new File("res/luz/Luz_08.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			light9 = ImageIO.read(new File("res/luz/Luz_09.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	/**
	 * Override of paintComponent
	 * 
	 */
	@Override
	public void paintComponent(Graphics gr) {
		super.paintComponent(gr); // clears the background ...		
		if (!win && !lose) {
			drawBoard(gr);
			drawObjectives(gr);
			drawCharacters(gr);
		}
		else drawEndMenu(gr);
	}
	
	/**
	 * Draw the end images (win or lose)
	 * 
	 * @param graphics
	 */
	public void drawEndMenu(Graphics gr)
	{
		BufferedImage temp;
		Resizer res = new Resizer();
		int width = (int) getSize().getWidth();
		int height = (int) getSize().getHeight();
		
		if (win)
		{
			temp = res.resize(win_img, width, height);
			gr.drawImage(temp, 0, 0, null);
		}
		else {

			temp = res.resize(lose_img, width, height);
			gr.drawImage(temp, 0, 0, null);
			
		}
		
	}

	/**
	 * Draw the game board
	 * 
	 * @param graphics
	 */
	public void drawBoard(Graphics gr)
	{
		
		int map_size = map.size();

		int width = (int) getSize().getWidth();
		int height = (int) getSize().getHeight();
		
		int resX_temp = width/((map_size*2)-1);
		int resY_temp = height/(map_size+1);
		
		int resX;
		int resY;
		
		if (resX_temp < resY_temp) {
			resX = resX_temp;
			resY = resX_temp;
		}
		else {
			resX = resY_temp;
			resY = resY_temp;
			
		}
		

		for(int y = 0;y < map.size();y++)
		{
			for (int x=0;x < map.get(y).size();x++)
			{
				int i=(map_size-(y+1)+x)*resX;
				int j=(y+1)*resY;
				
				switch(map.get(y).get(x))
				{
				//paredes
				
				case "X00":
					gr.drawImage(wall00, i, j, resX, resY, null);
					break;
					
				case "X01":
					gr.drawImage(wall01, i, j, resX, resY, null);
					break;
				case "X02":
					gr.drawImage(wall02, i, j, resX, resY, null);
					break;
					
				case "X03":
					gr.drawImage(wall03, i, j, resX, resY, null);
					break;
					
				case "X04":
					gr.drawImage(wall03, i, j, resX, resY, null);
					break;
					
				case "X05":
					gr.drawImage(wall03, i, j, resX, resY, null);
					break;
					
				case "X06":
					gr.drawImage(wall06, i, j, resX, resY, null);
					break;
					
				case "X07":
					gr.drawImage(wall07, i, j, resX, resY, null);
					break;
					
				case "X08":
					gr.drawImage(wall00, i, j, resX, resY, null);
					break;
					
				case "XC":
					gr.drawImage(wallC, i, j, resX, resY, null);
					break;
					
				case "XC1":
					gr.drawImage(wallC1, i, j, resX, resY, null);
					break;

					
				//espacos
					
				case " ":
					gr.drawImage(floor, i, j, resX, resY, null);
					break;
				case "XS":
					gr.drawImage(floors, i, j, resX, resY, null);
					break;
					
				}
				
			}
			
		}
		
	}
	
	/**
	 * Draw the characters of the game
	 * 
	 * @param graphics
	 */
	public void drawCharacters(Graphics gr)
	{		
		int map_size = map.size();

		int width = (int) getSize().getWidth();
		int height = (int) getSize().getHeight();
		
		int resX_temp = width/((map_size*2)-1);
		int resY_temp = height/(map_size+1);
		
		int resX;
		int resY;
		
		if (resX_temp < resY_temp) {
			resX = resX_temp;
			resY = resX_temp;
		}
		else {
			resX = resY_temp;
			resY = resY_temp;
			
		}
		
		for (Position pos : characters)
		{
			int x = pos.getX();
			int y = pos.getY();
			int i= (map_size-(y+1)+x)*resX;
			int j= (1+y)*resY;
			
			switch(pos.getRepresentationGui())
			{
			case "HF":
				gr.drawImage(hero_front, i, j , resX, resY, null);
				break;
				
			case "HFA":
				gr.drawImage(heroArmed_front,i, j ,resX, resY, null);
				break;
				
			case "HFK":
				gr.drawImage(heroKey_front,i, j ,resX, resY, null);
				break;
				
			case "HFAK":
				gr.drawImage(heroKeyArmed_front,i, j ,resX, resY, null);
				break;
				
			case "HB":
				gr.drawImage(hero_back,i, j ,resX, resY, null);
				break;
				
			case "HBA":
				gr.drawImage(heroArmed_back,i, j ,resX, resY, null);
				break;
				
			case "OF":
				gr.drawImage(ogre_front,i, j ,resX, resY, null);
				break;
				
			case "OFS":
				gr.drawImage(ogreStunned_front,i, j ,resX, resY, null);
				break;
				
			case "OB":
				gr.drawImage(ogre_back,i, j ,resX, resY, null);
				break;
				
			case "OBS":
				gr.drawImage(ogreStunned_front,i, j ,resX, resY, null);
				break;
				
			case "OK":
				gr.drawImage(ogre_front,i, j ,resX, resY, null);
				break;
				
			case "*":
				gr.drawImage(club,i, j ,resX, resY, null);
				break;
				
			case "$":
				gr.drawImage(club,i, j ,resX, resY, null);
				break;
				
			case "GF":
				gr.drawImage(guard_front,i, j ,resX, resY, null);
				break;
				
			case "GB":
				gr.drawImage(guard_back,i, j ,resX, resY, null);
				break;
				
			case "GFS":
				gr.drawImage(guard_sleep,i, j ,resX, resY, null);
				break;
				
			case "L1":
				gr.drawImage(light1,i, j ,resX, resY, null);
				break;
				
			case "L2":
				gr.drawImage(light2,i, j ,resX, resY, null);
				break;
				
			case "L3":
				gr.drawImage(light3,i, j ,resX, resY, null);
				break;
				
			case "L4":
				gr.drawImage(light4,i, j ,resX, resY, null);
				break;
				
			case "L5":
				gr.drawImage(light5,i, j ,resX, resY, null);
				break;
				
			case "L6":
				gr.drawImage(light6,i, j ,resX, resY, null);
				break;
				
			case "L7":
				gr.drawImage(light7,i, j ,resX, resY, null);
				break;
				
			case "L8":
				gr.drawImage(light8,i, j ,resX, resY, null);
				break;
				
			case "L9":
				gr.drawImage(light9,i, j ,resX, resY, null);
				break;
				
				
			
			}
		}
		
	}
	
	/**
	 * Draw the objective o the game
	 * 
	 * @param graphics
	 */
	public void drawObjectives(Graphics gr)
	{
		Resizer res = new Resizer();
		BufferedImage temp;
		
		int map_size = map.size();

		int width = (int) getSize().getWidth();
		int height = (int) getSize().getHeight();
		
		int resX_temp = width/((map_size*2)-1);
		int resY_temp = height/(map_size+1);
		
		
		int resX;
		int resY;
		
		if (resX_temp < resY_temp) {
			resX = resX_temp;
			resY = resX_temp;
		}
		else {
			resX = resY_temp;
			resY = resY_temp;
			
		}
		
		/*
		int resX = 1024/((map_size*2)-1);
		int resY = resX;
		*/
		
		
		for (Position pos : objectives)
		{
			int x = pos.getX();
			int y = pos.getY();
			int i= (map_size-(y+1)+x)*resX;
			int j= (1+y)*resY;
			
			switch(pos.getRepresentationGui())
			{
			case "I":
				temp = res.resize(doorClosed, resX, resY);
				gr.drawImage(temp, i, j, null);
				break;
				
			case "S":
				break;
				
			case "LU":
				temp = res.resize(leverUp, resX, resY);
				gr.drawImage(temp, i, j, null);
				break;
				
			case "LD":
				temp = res.resize(leverDown, resX, resY);
				gr.drawImage(temp, i, j, null);
				break;
				
			case "K":
				temp = res.resize(key, resX, resY);
				gr.drawImage(temp, i, j, null);
				break;
				
				
				
			}
		}
		
	}
	
	/**
	 * Redefines the board
	 * 
	 * @param map
	 */
	public void setMap(ArrayList<ArrayList<String>> map1)
	{
		map = new ArrayList<ArrayList<String>>(map1);
		
	}
	
	/**
	 * Redefines the objectives
	 * 
	 * @param objectives
	 */
	public void setObjectives(ArrayList<Position> obj)
	{
		objectives = new ArrayList<Position>(obj);
		
	}
	
	/**
	 * Redefines the characters
	 * 
	 * @param characters
	 */
	public void setCharacters(ArrayList<Position> obj)
	{
		characters = new ArrayList<Position>(obj);
		
	}
	
	/**
	 * Set the game as won
	 * 
	 * @param status
	 */
	public void setWin(boolean status)
	{
		win = status;
	}
	
	/**
	 * Set the game as lost
	 * 
	 * @param status
	 */
	public void setLose(boolean status)
	{
		lose = status;
	}
	
}
