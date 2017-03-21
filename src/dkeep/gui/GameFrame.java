package dkeep.gui;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dkeep.logic.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;


public class GameFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	private JButton btnNewGame;
	private JButton btnBackMenu;
	private JButton btnQuitGame;
	private JPanel buttonsPanel;
	private JPanel buttonsPanel1;
	private JButton btnUp;
	private JButton btnDown;
	private JButton btnLeft;
	private JButton btnRight;
	private GamePanel gamePanel;
	private Menu menu;
	private Logic game;
	
	private int guardType;
	private int nOgres;

	/**
	 * Class constructor.
	 * 
	 * @throws IOException
	 */
	public GameFrame(Menu menu, int guardType, int nOgres) {
		setTitle("Dungeon Explorer");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setResizable(false);
		
		game = new Logic(new Maze1(), guardType, nOgres);
		this.menu = menu;
		this.nOgres = nOgres;
		this.guardType = guardType;

		gamePanel = new GamePanel();
		gamePanel.setBackground(new Color(30,65,39));
		buttonsPanel = new JPanel(new GridLayout());
		buttonsPanel1 = new JPanel(new GridLayout(4, 1, 0, 10));

		setUpButtons();
		getContentPane().setLayout(new BorderLayout(0, 0));
		addButtons();
		getContentPane().add(gamePanel);
		

	}

	private void close()
	{
		this.dispose();
		
	}

	private void setUpButtons() {
		// Play Game button
		btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String msg = "Do you want to start a new game?";
				int res = JOptionPane.showConfirmDialog(rootPane, msg);

				if (res == JOptionPane.YES_OPTION) {
					setSize(1024, 600);

					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					setLocation(dim.width / 2 - getSize().width / 2, dim.height
							/ 2 - getSize().height / 2);

					// starting new game with new options
					game = new Logic(new Maze1(), guardType, nOgres);
					gamePanel.setMap(game.getMapGui());
					gamePanel.setObjectives(game.getObjectivesGui());;
					gamePanel.setCharacters(game.getCharactersGui());
					gamePanel.repaint();
					
					
				}
				requestFocusInWindow();
				
			}
		});


		// Back to menu
		btnBackMenu = new JButton("Back to Menu");
		btnBackMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String msg = "Are you sure you want to go back to menu?";
				int res = JOptionPane.showConfirmDialog(rootPane, msg);

				if (res == JOptionPane.YES_OPTION){
					
					close();
					menu = new Menu();
					menu.start();	
				}
				requestFocusInWindow();
					
			}
		});
		
		// Quit Game button
		btnQuitGame = new JButton("Quit");
		btnQuitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String msg = "Are you sure you want to quit?";
				int res = JOptionPane.showConfirmDialog(rootPane, msg);

				if (res == JOptionPane.YES_OPTION){
					System.exit(0);
				}
				requestFocusInWindow();
					
			}
		});
	
		btnUp = new JButton("Up");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				updateGame('w');
				requestFocusInWindow();
					
			}
		});
		
		btnDown = new JButton("Down");
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				updateGame('s');
				requestFocusInWindow();
					
			}
		});
		
		btnLeft = new JButton("Left");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				updateGame('a');
				requestFocusInWindow();
					
			}
		});
		
		btnRight = new JButton("Right");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				updateGame('d');
				requestFocusInWindow();
					
			}
		});
	
	
	
	}

	private void addButtons() {

		
		
		gamePanel.add(btnNewGame,BorderLayout.NORTH);
		gamePanel.add(btnBackMenu,BorderLayout.NORTH);
		gamePanel.add(btnQuitGame,BorderLayout.NORTH);
		
		

		
		buttonsPanel1.add(btnUp);
		buttonsPanel1.add(btnLeft);
		buttonsPanel1.add(btnRight);
		buttonsPanel1.add(btnDown);
		
		buttonsPanel1.setPreferredSize(new Dimension(50, 20));
		
		add(buttonsPanel1, BorderLayout.WEST);
		
		
		
	}

	/**
	 * Starts the game window.
	 */
	public void start() {
		setSize(1024, 600);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2
				- getSize().height / 2);

		setVisible(true);
		requestFocusInWindow();
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				keyMovement(e);
			}
		});
		
		gamePanel.setMap(game.getMapGui());
		
		
		 /* TESTAR O MAPA GUI*/
		/*
		for (ArrayList<String> temp :game.getMapGui())
		{
			System.out.println(temp);
		}
		*/
			

		gamePanel.setObjectives(game.getObjectivesGui());;
		gamePanel.setCharacters(game.getCharactersGui());
		gamePanel.repaint();
		
	}

	private void keyMovement(KeyEvent e) {
		char key;
		key = e.getKeyChar();
		

		if (key == 'w') {
			updateGame('w');
		} else if (key == 's') {
			updateGame('s');
		} else if (key == 'a') {
			updateGame('a');
		} else if (key == 'd') {
			updateGame('d');
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			updateGame('d');
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			updateGame('a');
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			updateGame('w');
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			updateGame('s');
		}
	}

	private void updateGame(char i)
	{
		game = game.moveHero(i);
		game.atack_villains();
		game.moveAllVillains();
		game.atack_villains();
		game.Over();
		gamePanel.setMap(game.getMapGui());
		gamePanel.setObjectives(game.getObjectivesGui());
		gamePanel.setCharacters(game.getCharactersGui());
		gamePanel.repaint();
		
	}

	
}