package dkeep.gui;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dkeep.logic.*;
import dkeep.logic.Logic.status;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
	private JButton btnSave;
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
		game = new Logic(new Maze1(), guardType, nOgres);
		this.menu = menu;
		this.nOgres = nOgres;
		this.guardType = guardType;
		gamePanel = new GamePanel();
		gamePanel.setBackground(new Color(30,65,39));
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
					setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);

					// starting new game with new options
					game = new Logic(new Maze1(), guardType, nOgres);
					gamePanel.setWin(false);
					gamePanel.setLose(false);
					updateGamePanel();
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

				if (res == JOptionPane.YES_OPTION) {

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
				
				
				if (res == JOptionPane.YES_OPTION) {
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
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				int res = chooser.showSaveDialog(null);
				if (res == JFileChooser.APPROVE_OPTION) {
					
					SaveLoad sv = new SaveLoad();
					String path = chooser.getSelectedFile().getAbsolutePath()+ ".ser";
					sv.save(game, path);

				}
				
			}
		});
	
	}

	private void addButtons() {
		gamePanel.add(btnNewGame,BorderLayout.NORTH);
		gamePanel.add(btnSave,BorderLayout.NORTH);
		gamePanel.add(btnBackMenu,BorderLayout.NORTH);
		gamePanel.add(btnQuitGame,BorderLayout.NORTH);
				
		buttonsPanel1.add(btnUp);
		buttonsPanel1.add(btnLeft);
		buttonsPanel1.add(btnRight);
		buttonsPanel1.add(btnDown);
		buttonsPanel1.setPreferredSize(new Dimension(50, 20));

		add(buttonsPanel1, BorderLayout.WEST);
	}

	public void start() {
		setSize(1024, 600);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);
		setVisible(true);
		requestFocusInWindow();
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				keyMovement(e);
			}
		});
		updateGamePanel();
		gamePanel.repaint();
	}

	private void keyMovement(KeyEvent e) {
		char key;
		key = e.getKeyChar();

		if (key == 'w' || e.getKeyCode() == KeyEvent.VK_UP)
			updateGame('w');
		else if (key == 's' || e.getKeyCode() == KeyEvent.VK_DOWN)
			updateGame('s');
		else if (key == 'a' || e.getKeyCode() == KeyEvent.VK_LEFT)
			updateGame('a');
		else if (key == 'd' || e.getKeyCode() == KeyEvent.VK_RIGHT)
			updateGame('d');

	}

	private void updateGame(char i) {
		if (game.condition == status.RUNNING) {
			moveAllCharacters(i);

			if (game.condition == status.RUNNING) {
				updateGamePanel();
			} else if (game.condition == status.DEFEAT) {
				lose();
			} else if (game.condition == status.WON) {
				win();
			}
			gamePanel.repaint();
			requestFocusInWindow();
		}
	}

	private void updateGamePanel() {
		gamePanel.setMap(game.getMapGui());
		gamePanel.setObjectives(getObjectivesGui());
		gamePanel.setCharacters(getCharactersGui());

		/////// TEMPORARIO /////////////////////////////////////////////// -> APAGARRRR
		for (ArrayList<String> linha : game.getMapGui()) {
			for (String a : linha) {
				String temp;

				if (a.equals(" "))
					temp = "|    ";

				else
					switch (a.length()) {
					case 1:
						temp = "|" + a + "   ";
						break;

					case 2:
						temp = "|" + a + "  ";
						break;

					case 3:
						temp = "|" + a + " ";
						break;
						
					default:
						temp ="|" + a;
						break;
					}

				System.out.print(temp + " ");

			}

			System.out.println();
		}
		System.out.println();

	}
	
	private void moveAllCharacters(char i)
	{
		game = game.moveHero(i);
		game.atack_villains();
		game.moveAllVillains();
		game.atack_villains();
		game.Over();
	}
	
	private void win()
	{
		gamePanel.setWin(true);
		buttonsPanel1.setVisible(false);
	}
	
	private void lose()
	{
		gamePanel.setLose(true);
		buttonsPanel1.setVisible(false);
	}
	
	public void setGame(Logic game){
		this.game = game;
		
		
	}
	
	public ArrayList<Position> getCharactersGui()
	{
		ArrayList<Position> array = new ArrayList<Position>();

		array.add(new Position(game.getHero().getPosition().getX(),game.getHero().getPosition().getY(), game.getHero() + ""));

		if (game.getGuard().isPlaying()) {
			array.add(new Position(game.getGuard().getPosition().getX(),game.getGuard().getPosition().getY(), game.getGuard() + ""));
		}

		getOgresGui(array);
		
		return array;
	}
	
	public void getOgresGui(ArrayList<Position> array) {
		for (Ogre ogre : game.getOgres()) {
			if (ogre.getPosition().equals(game.getMap().getKey()))
				array.add(new Position(ogre.getPosition().getX(), ogre.getPosition().getY(), "OK"));
			else
				array.add(new Position(ogre.getPosition().getX(), ogre.getPosition().getY(), ogre + ""));

			if (ogre.getClubVisibily()) {
				array.add(new Position(ogre.getClub().getPosition().getX(), ogre.getClub().getPosition().getY(),
						ogre.getClub() + ""));

			}

		}

	}
	
	public ArrayList<Position> getObjectivesGui() {
		ArrayList<Position> array = new ArrayList<Position>();
		boolean open = false;

		for (int y = 0; y < game.getMap().getMapSize(); y++)
			for (int x = 0; x < game.getMap().getMapSize(); x++) {
				if (game.getMap().getMap()[y][x] == 'I') {
					open = false;
					array.add(new Position(x, y, "I"));
				} else if (game.getMap().getMap()[y][x] == 'S') {
					open = true;
					array.add(new Position(x, y, "S"));
				}
			}

		if (open) {
			for (Position pos : game.getMap().getEndPositions()) {
				array.add(new Position(pos.getX(), pos.getY(), "E"));
			}

			if (game.getMap().getKey().getType() == 1)
				array.add(new Position(game.getMap().getKey().getX(), game.getMap().getKey().getY(), "LD"));
			else
				array.add(new Position(game.getMap().getKey().getX(), game.getMap().getKey().getY(), "K"));
		} else {
			if (game.getMap().getKey().getType() == 1)
				array.add(new Position(game.getMap().getKey().getX(), game.getMap().getKey().getY(), "LU"));
			else
				array.add(new Position(game.getMap().getKey().getX(), game.getMap().getKey().getY(), "K"));
		}

		return array;
	}

}