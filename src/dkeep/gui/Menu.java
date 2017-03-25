package dkeep.gui;


import java.io.File;
import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import dkeep.logic.Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

/**
 * Window of menu initial
 * 
 * 
 * @author davidfalcao
 *
 */
public class Menu extends JFrame{

	private static final long serialVersionUID = 1L;

	private JLabel authors;
	private JButton btnNewGame;
	private JButton btnExit;
	private JButton btnMaze;
	private JButton btnLoad;
	private JDialog options;
	private JDialog map_size;
	private int guardType = 0; 
	private int nOgres = 3;

	/**
	 * Constructor
	 */
	public Menu(){
		setResizable(false);
		setTitle("Dungeon Keep");
		pack();
		BufferedImage myImage = null;
		try {
			myImage = ImageIO.read(new File("res/Menu.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Resizer a = new Resizer();
		myImage = a.resize(myImage, 1024,700);
		setContentPane(new ImagePanel(myImage));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		authors = new JLabel("David && Pedro 2017");
		authors.setForeground(Color.WHITE);
		authors.setFont(new Font("Osaka", Font.PLAIN, 15));
		authors.setBounds(850, 650, 200, 50);
		getContentPane().add(authors);
		
		options = new GameOptions(this, guardType, nOgres);
		map_size = new MapSize(this);
		
		
		setUpButtons();
		addButtons();
		
	}

	/**
	 * Initialization of buttons
	 * 
	 */
	private void setUpButtons() {
		// Play Game 
		btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				options.setVisible(true);
				options.toFront();

			}
		});

		// Exit 
		btnExit = new JButton("Quit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String msg = "Are you sure you want to quit?";
				int res = JOptionPane.showConfirmDialog(rootPane, msg);

				if (res == JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});
		
		//Create Maze
		btnMaze = new JButton("Create Maze");
		btnMaze.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				map_size.setVisible(true);

			}
		});
		
		btnLoad = new JButton("Load Game");
		btnLoad.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				
			    JFileChooser chooser = new JFileChooser();
			    FileNameExtensionFilter filter = new FileNameExtensionFilter("SER file", "ser");
			    chooser.setFileFilter(filter);
			    int returnVal = chooser.showOpenDialog(getParent());
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			    	SaveLoad sv = new SaveLoad();
			    	initGame(sv.load(chooser.getSelectedFile()));
			    }
				
			}
		});
	
	
	}
	
	/**
	 * Display the buttons
	 * 
	 */
	private void addButtons() {
		btnNewGame.setBounds(400, 300, 224, 50);
		getContentPane().add(btnNewGame);
		
		btnLoad.setBounds(400, 360, 224, 50);
		getContentPane().add(btnLoad);
		
		btnMaze.setBounds(400, 420, 224, 50);
		getContentPane().add(btnMaze);
		
	
		btnExit.setBounds(400, 480, 224, 50);
		getContentPane().add(btnExit);
		

		
		
		
		
		
		
	}
	
	/**
	 * Start the window
	 * 
	 */
	public void start() {
		setSize(1024, 720);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2
				- getSize().height / 2);

		setVisible(true);
	}
	
	/**
	 * Redefine the type of the guard
	 * 
	 * @param type
	 */
	public void setGuardType(int type)
	{
		guardType = type;	
	}
	
	/**
	 * Redefine the number of ogres
	 * 
	 * @param n number
	 */
	public void setNOgres(int n)
	{
		nOgres = n;	
	}

	/**
	 * Initialization of the game
	 * 
	 */
	public void initGame(){
		setVisible(false);
		GameFrame game = new GameFrame(new Menu(), guardType, nOgres);
		game.start();
	}
	
	/**
	 * Initialization fo the game with the status chosen
	 * 
	 * @param game1 game
	 */
	public void initGame(Logic game1)
	{
		setVisible(false);
		GameFrame game = new GameFrame(new Menu(), guardType, nOgres);
		setUpButtons();
		addButtons();
		game.setGame(game1);
		game.start();
	}
	
}
