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
	private BufferedImage exit;
	
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
	private BufferedImage wallC; // complemento parede 2
	private BufferedImage wallC1; // complemento parede 2

	

	//floor	
	
	private BufferedImage floor;   // chao sem sombra
	private BufferedImage floors;  // chao com sombra
	
	private BufferedImage win_img; //
	private BufferedImage lose_img;
	
	
	
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
			wall04 = ImageIO.read(new File("res/walls/Wall04.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			wall05 = ImageIO.read(new File("res/walls/Wall05.png"));
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
			lose_img = ImageIO.read(new File("res/lose.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
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
	
	public void drawEndMenu(Graphics gr)
	{
		BufferedImage temp;
		Resizer res = new Resizer();
		int width = (int) getSize().getWidth();
		int height = (int) getSize().getHeight();
		
		if (win)
		{
			
		}
		else {

			
			temp = res.resize(lose_img, width, height);
			gr.drawImage(temp, 0, 0, null);
			
		}
		
	}

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
					gr.drawImage(wall04, i, j, resX, resY, null);
					break;
					
				case "X05":
					gr.drawImage(wall05, i, j, resX, resY, null);
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
	
	public void drawCharacters(Graphics gr)
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
		
		
		
		
		
		for (Position pos : characters)
		{
			int x = pos.getX();
			int y = pos.getY();
			int i= (map_size-(y+1)+x)*resX;
			int j= (1+y)*resY;
			
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
				
			case "OK":
				temp = res.resize(ogreStunned_front, resX, resY);
				gr.drawImage(temp, i, j, null);
				break;
				
			case "*":
				temp = res.resize(club, resX, resY);
				gr.drawImage(temp, i, j, null);
				break;
				
			case "$":
				temp = res.resize(club, resX, resY);
				gr.drawImage(temp, i, j, null);
				break;
				
			case "GF":
				temp = res.resize(guard_front, resX, resY);
				gr.drawImage(temp, i, j, null);
				break;
				
			case "GB":
				temp = res.resize(guard_back, resX, resY);
				gr.drawImage(temp, i, j, null);
				break;
				
			case "GFS":
				temp = res.resize(guard_sleep, resX, resY);
				gr.drawImage(temp, i, j, null);
				break;
				
			
			}
		}
		
	}
	
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
	
	public void setWin(boolean status)
	{
		win = status;
	}
	
	public void setLose(boolean status)
	{
		lose = status;
	}
	
}
