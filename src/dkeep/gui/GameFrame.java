package dkeep.gui;


import dkeep.logic.GameConfig;

import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Toolkit;

public class GameFrame extends JFrame {

	private JButton btnNewGame;
	private JButton btnOptions;
	private JButton btnQuitGame;
	private JPanel buttonsPanel;
	private JPanel buttonsPanel2;
	//private GamePanel gamePanel;
	private GameConfig gameConfig;
	private JDialog options;

	public GameFrame() throws IOException {
		setTitle("Dungeon Explorer");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		//gamePanel = new GamePanel();
		buttonsPanel = new JPanel();
		buttonsPanel2 = new JPanel();
		gameConfig = new GameConfig();
		//options = new OptionsDialog(this, gamePanel, gameConfig);
		//saveLoad = new SaveLoadDialog(this, gamePanel);

		setUpButtons();
		getContentPane().setLayout(new BorderLayout(0, 0));
		addButtons();
		//getContentPane().add(gamePanel);
		
	}
	
	 
	private void setUpButtons() {
		// Play Game button
		btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { {
					setSize(642, 598);

					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					setLocation(dim.width / 2 - getSize().width / 2, dim.height
							/ 2 - getSize().height / 2);

					// starting new game with new options
					//gamePanel.startNewGame(gameConfig);
				}
			}
		});


		// Options button
		btnOptions = new JButton("Options");
		btnOptions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				options.setVisible(true);
			}
		});

		// Quit Game button
		btnQuitGame = new JButton("Quit");
		btnQuitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String msg = "Are you sure you want to quit?";
				int res = JOptionPane.showConfirmDialog(rootPane, msg);

				if (res == JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});
	}
	
	
	private void addButtons() {
		buttonsPanel.setLayout(new GridLayout(1, 3));
		buttonsPanel.add(btnNewGame);


		buttonsPanel2.setLayout(new GridLayout(1, 2));
		buttonsPanel2.add(btnOptions);
		buttonsPanel2.add(btnQuitGame);

		getContentPane().add(buttonsPanel, BorderLayout.NORTH);
		getContentPane().add(buttonsPanel2, BorderLayout.SOUTH);
	}
	
	public void init() {
		setSize(534, 401);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);

		setVisible(true);
	}
}
