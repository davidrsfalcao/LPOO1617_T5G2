package dkeep.gui;

import dkeep.logic.GameConfig;

import java.io.File;
import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;

public class GameFrame extends JFrame{

	private static final long serialVersionUID = 1L;

	private GamePanel graphicsPanel;
	private JLabel authors;
	private JButton btnNewGame;
	private JButton btnExit;
	private JButton btnOptions;
	private GameConfig gameConfig;
	private JDialog options;
	private int guardType;
	private int nOgres;



	
	public GameFrame() throws IOException {
		setResizable(false);
		setTitle("Dungeon Keep");
		pack();
		BufferedImage myImage  = ImageIO.read(new File("res/a1.png"));
		Resizer a = new Resizer();
		myImage = a.resize(myImage, 1024,700);
		setContentPane(new ImagePanel(myImage));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		authors = new JLabel("David & Pedro 2017");
		authors.setForeground(Color.WHITE);
		authors.setFont(new Font("Osaka", Font.PLAIN, 15));
		authors.setBounds(850, 650, 200, 50);
		getContentPane().add(authors);
		
		graphicsPanel = new GamePanel();
		gameConfig = new GameConfig();
		options = new GameOptions(this, guardType, nOgres);
		
		
		setUpButtons();
		addButtons();
		
	}

	private void setUpButtons() {
		// Play Game button
		btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
				getContentPane().setLayout(new BorderLayout(0, 0));
				getContentPane().add(graphicsPanel);

					//graphicsPanel.startNewGame(gameConfig); <-------------------------------
				
			}
		});


		// Options button
		btnOptions = new JButton("Options");
		btnOptions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				options.setVisible(true);
				
			}
		});

		// Exit button
		btnExit = new JButton("Quit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String msg = "Are you sure you want to quit?";
				int res = JOptionPane.showConfirmDialog(rootPane, msg);

				if (res == JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});
	}
	
	
	private void addButtons() {
		btnNewGame.setBounds(400, 300, 224, 50);
		getContentPane().add(btnNewGame);
		
		btnOptions.setBounds(400, 360, 224, 50);
		getContentPane().add(btnOptions);
		
		btnExit.setBounds(400, 420, 224, 50);
		getContentPane().add(btnExit);
		
		
		
		
		
	}
	
	public void start() {
		setSize(1024, 720);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2
				- getSize().height / 2);

		setVisible(true);
	}
	
}
