package dkeep.gui;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import dkeep.logic.Hero;
import dkeep.logic.Ogre;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class CreateMaze extends JPanel implements MouseListener,MouseMotionListener {
	
	private static JPanel panel;
	private static JFrame frame;
	
	private static Hero heroi = new Hero(-1,-1,false,true);
	private static ArrayList<Ogre> ogres = new ArrayList<Ogre>();
	private static Integer key[] = {-1,-1};
	private boolean herob=false;
	
	
	private static int tamanho;
	private static final long serialVersionUID = 1L;
	
	private static char[][] maze;
	
////////////////////////////////////////////////////
	
	
	private BufferedImage floor; 
	private BufferedImage wall;
	private BufferedImage keys;
	private BufferedImage hero;
	private BufferedImage ogre;
	private BufferedImage door;
	
	
/////////////////////////////////////////////////

	boolean verificaOgre(int x, int y) 
	{
		for (int i = 0; i < ogres.size(); i++) 
		{
			if (ogres.get(i).getPosition().getX() == x && ogres.get(i).getPosition().getY() == y) 
			{
				return true;
			}
		}
		return false;
	}
	

	CreateMaze(int tamanho) {

		heroi.setPosition(-1, -1);

		setSize(580,582);
		frame.setSize(580,582);
		this.addMouseListener(this);  
		CreateMaze.tamanho = tamanho;
		CreateMaze.maze = new char[tamanho][tamanho];

		for (int linha = 0; linha < tamanho; linha++) 
		{
			for (int coluna = 0; coluna < tamanho; coluna++) 
			{
				maze[linha][coluna] = ' ';
			}
		}

		for (int i = 0; i < tamanho; i++) 
		{
			maze[0][i] = 'X';
			maze[i][0] = 'X';
			maze[tamanho - 1][i] = 'X';
			maze[i][tamanho - 1] = 'X';
		}

		Elements();
		
	}
	
	void Elements() {
		
		try {
			floor = ImageIO.read(new File("res/creator/Floor.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			wall = ImageIO.read(new File("res/creator/Wall.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			keys = ImageIO.read(new File("res/creator/Key.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			hero = ImageIO.read(new File("res/creator/Hero.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			ogre= ImageIO.read(new File("res/creator/Ogre.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			door = ImageIO.read(new File("res/creator/Door.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void paintComponent(Graphics gr) {

		super.paintComponent(gr);

		Resizer res = new Resizer();
		BufferedImage temp;
		BufferedImage temp1;

		int map_size = maze.length;

		int width = (int) panel.getSize().getWidth();

		int resY = (int) Math.ceil(width / map_size);
		int resX = resY;

		frame.setSize(resX * map_size, resY * map_size + 70);

		for (int y = 0; y < maze.length; y++) {
			for (int x = 0; x < maze[y].length; x++) {
				int i = x * resX;
				int j = y * resY;

				switch (maze[y][x]) {
				// paredes

				case ' ':
					temp = res.resize(floor, resX, resY);
					gr.drawImage(temp, i, j, null);
					break;
				case 'X':
					temp = res.resize(wall, resX, resY);
					gr.drawImage(temp, i, j, null);
					break;
				case 'k':
					temp = res.resize(keys, resX, resY);
					temp1 = res.resize(floor, resX, resY);
					gr.drawImage(temp1, i, j, null);
					gr.drawImage(temp, i, j, null);
					break;
				case 'A':
					temp = res.resize(hero, resX, resY);
					temp1 = res.resize(floor, resX, resY);
					gr.drawImage(temp1, i, j, null);
					gr.drawImage(temp, i, j, null);
					break;
				case 'I':
					temp = res.resize(door, resX, resY);
					temp1 = res.resize(floor, resX, resY);
					gr.drawImage(temp1, i, j, null);
					gr.drawImage(temp, i, j, null);
					break;
				case 'O':
					temp = res.resize(ogre, resX, resY);
					temp1 = res.resize(floor, resX, resY);
					gr.drawImage(temp1, i, j, null);
					gr.drawImage(temp, i, j, null);
					break;

				}

			}

		}

	}
	

	public static void construir(int tamanho) {
		frame = new JFrame("Maze Creator");
		frame.setPreferredSize(new Dimension(600, 600));
		frame.getContentPane().setLayout(new BorderLayout());
		panel = new CreateMaze(tamanho);
		JPanel panel2 = new Options(frame);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.getContentPane().add(panel2, BorderLayout.SOUTH);
		frame.pack();
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setFocusable(true);
		frame.requestFocus();
	}

	
	public void mouseClicked(MouseEvent arg0) {
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}
	
	public void mouseReleased(MouseEvent arg0) {
	}

	public void mouseDragged(MouseEvent arg0) {
	}

	public void mouseMoved(MouseEvent arg0) {
	}
	
	public void mousePressed(MouseEvent arg0) {
		
		
		
		double x=  arg0.getX() /(getWidth() / tamanho); 
		double y=  arg0.getY() /( (getHeight() +20) / tamanho); 
		
		if (x > tamanho || y > tamanho)
			return;
		
		
		if (Options.getSelecionado() == "Wall") 
		{
			if(maze[(int) y][(int) x] == 'O'){
				for(int i = 0;i < ogres.size();i++)
				{
					if((ogres.get(i).getPosition().getX() == (int) x) && (ogres.get(i).getPosition().getY() == (int) y) )
					{
						maze[(int)y][(int)x] = 'X';
						ogres.remove(i);
					
					
					}
				
				}
			}

			if (maze[(int) y][(int) x] != 'X')
			{
				maze[(int) y][(int) x] = 'X';
			}
			else if ((int) x != 0 && (int) x != tamanho - 1 && (int) y != 0 && (int) y != tamanho - 1)
			{
				maze[(int) y][(int) x] = ' ';
			}
			
		}
	
		if (Options.getSelecionado() == "Exit")   
		{
			if (!((x == 0 && y == 0) || (x == 0 && y == tamanho - 1) || (x == tamanho - 1 && y == 0) || (x == tamanho - 1 && y == tamanho - 1)))
			{
				if ((int) x == 0 || (int) x == tamanho - 1 || (int) y == 0 || (int) y == tamanho - 1) 
				{
					if (maze[(int) y][(int) x] == 'X') 
					{
						maze[(int) y][(int) x] = 'I';
					} 
					else 
					{
						maze[(int) y][(int) x] = 'X';
					}
				}
			}
		}
		
		if (Options.getSelecionado() == "Hero") 
		{
			if (!((int) x == 0 || (int) x == tamanho - 1 || (int) y == 0 || (int) y == tamanho - 1)) 
			{
		
				if (heroi.getPosition().getX() == (int) x && heroi.getPosition().getY() == (int) y) 
				{
					heroi.setPosition(-1, -1);
					maze[(int)y][(int)x] = ' '; 
					herob=false;
				} 
				else if(!herob)
				{
					if(maze[(int) y][(int) x] == 'O'){
						for(int i = 0;i < ogres.size();i++)
						{
							if((ogres.get(i).getPosition().getX() == (int) x) && (ogres.get(i).getPosition().getY() == (int) y) )
							{
								ogres.remove(i);
							
							}
						
						}
					}
					maze[(int)y][(int)x] = 'A'; 
					heroi.setPosition((int) x, (int) y);
					herob=true;
				}
				else
				{
					if(maze[(int) y][(int) x] == 'O'){
						for(int i = 0;i < ogres.size();i++)
						{
							if((ogres.get(i).getPosition().getX() == (int) x) && (ogres.get(i).getPosition().getY() == (int) y) )
							{
								ogres.remove(i);
							
							}
						
						}
					}
					
					for (int linha = 0; linha < tamanho; linha++) 
					{
						for (int coluna = 0; coluna < tamanho; coluna++) 
						{
							if (maze[coluna][linha] == 'A')
								maze[coluna][linha] = ' ';
							
						}
					}
					
					maze[(int)y][(int)x] = 'A'; 
					heroi.setPosition((int) x, (int) y);
					
					
				}
			}
		}
		
		if (Options.getSelecionado() == "Ogre") {
			if (!((int) x == 0 || (int) x == tamanho - 1 || (int) y == 0 || (int) y == tamanho - 1)) 
			{
				if (!verificaOgre((int) x, (int) y)) 
				{
					if(ogres.size() < 5)
					{
						maze[(int)y][(int)x] = 'O';
						Ogre o = new Ogre((int) x, (int) y);
						ogres.add(o);
						
					}
					
				}
				else
				{
					for(int i = 0;i < ogres.size();i++)
					{
						if((ogres.get(i).getPosition().getX() == (int) x) && (ogres.get(i).getPosition().getY() == (int) y) )
						{
							maze[(int)y][(int)x] = ' ';
							ogres.remove(i);
							
							
						}
						
					}
					
					
				}
			}
		}
		
		if (Options.getSelecionado() == "Key") {
			if (!((int) x == 0 || (int) x == tamanho - 1 || (int) y == 0 || (int) y == tamanho - 1)) 
			{
				if (key[0] == -1) 
				{
					if(maze[(int) y][(int) x] == 'O'){
						for(int i = 0;i < ogres.size();i++)
						{
							if((ogres.get(i).getPosition().getX() == (int) x) && (ogres.get(i).getPosition().getY() == (int) y) )
							{
								ogres.remove(i);
							}
						
						}
					}
					maze[(int)y][(int)x] = 'k'; 
					key[0] = (int)x;
					key[1] = (int)y;
				} 
				else
				{
					if(maze[(int) y][(int) x] == 'O'){
						for(int i = 0;i < ogres.size();i++)
						{
							if((ogres.get(i).getPosition().getX() == (int) x) && (ogres.get(i).getPosition().getY() == (int) y) )
							{
								ogres.remove(i);

							}
						
						}
					}
					for (int linha = 0; linha < tamanho; linha++) 
					{
						for (int coluna = 0; coluna < tamanho; coluna++) 
						{
							if (maze[coluna][linha] == 'k')
								maze[coluna][linha] = ' ';
						}
					}
					
					maze[(int)y][(int)x] = 'k'; 
					key[0]=(int) x;
					key[1]= (int) y;
				}
				
			}
		}
		
		repaint();
		
	}
	
	
	public static Hero getHero() {
		return heroi;
	}
	
	public static boolean getSaida()
	{
		for (int linha = 0; linha < tamanho; linha++) 
		{
			for (int coluna = 0; coluna < tamanho; coluna++) 
			{
				if (maze[coluna][linha] == 'I')
					return true;
			}
		}
		return false;
		
	}

	public static Integer[] getKey()
	{
		return key;
		
	}

	public static char[][] getMaze() 
	{
		
		return maze;
	}
	
	static JFrame getFrame() 
	{
		return frame;
	}
	
	public static ArrayList<Ogre> getOgres()
	{
		return ogres;
		
	}

	
}


