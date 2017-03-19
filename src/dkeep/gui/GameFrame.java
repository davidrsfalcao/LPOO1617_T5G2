package dkeep.gui;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import dkeep.logic.Logic;
import dkeep.logic.Maze1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;


public class GameFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton btnNewGame;
	private JButton btnBackMenu;
	private JButton btnQuitGame;
	private GamePanel gamePanel;
	private Menu menu;
	
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
		setResizable(false);
		
		
		this.menu = menu;
		this.nOgres = nOgres;
		this.guardType = guardType;

		gamePanel = new GamePanel();
		gamePanel.setBackground(new Color(47,67,45));

		setUpButtons();
		getContentPane().setLayout(new BorderLayout(0, 0));
		addButtons();
		getContentPane().add(gamePanel);
	}

	public void close()
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
					setSize(1024, 720);

					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					setLocation(dim.width / 2 - getSize().width / 2, dim.height
							/ 2 - getSize().height / 2);

					// starting new game with new options
					//gamePanel.startNewGame(gameConfig);
				}
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
					
			}
		});
	}

	private void addButtons() {

		btnNewGame.setBounds(10, 10, 100, 50);
		getContentPane().add(btnNewGame);
		
		btnBackMenu.setBounds(10, 70, 100, 50);
		getContentPane().add(btnBackMenu);
		
		btnQuitGame.setBounds(10, 130, 100, 50);
		getContentPane().add(btnQuitGame);
		
		
	}

	/**
	 * Starts the game window.
	 */
	public void start() {
		setSize(1024, 720);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2
				- getSize().height / 2);

		setVisible(true);
		gamePanel.repaint();
	}

}