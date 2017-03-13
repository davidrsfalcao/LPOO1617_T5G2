package dkeep.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import dkeep.logic.*;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.JSlider;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.RenderingHints;

public class GameFrame extends JFrame{

	private JFrame frmMaze;
	private Logic game;
	private GamePanel graphicsPanel;
	private JTextArea board;
	private JLabel lblcurretnState;
	private JButton btnExit;
	private JButton newGame;
	private JButton btnExitToMenu;
	private JSlider drakeNumber;
	private JComboBox<String> gameMode;
	private JButton btnRandomMaze;
	private JButton btnNext;



	/**
	 * Create the application.
	 */
	public void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameFrame window = new GameFrame();
					window.frmMaze.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public GameFrame(int i){}
	
	public GameFrame() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		
		frmMaze = new JFrame();
		frmMaze.setTitle("Dungeon Keep");
		frmMaze.getContentPane().setPreferredSize(new Dimension(1024, 700));
		frmMaze.pack();
		frmMaze.setVisible(true);
		BufferedImage myImage  = ImageIO.read(new File("res/a1.png"));
		Resizer a = new Resizer();
		myImage = a.resize(myImage, 1024,700);
		frmMaze.setContentPane(new ImagePanel(myImage));
		frmMaze.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMaze.getContentPane().setLayout(null);
		
		newGame = new JButton("New Game");
		newGame.setBounds(400, 211, 224, 100);
		frmMaze.getContentPane().add(newGame);
		
		btnExit = new JButton("Exit");
		btnExit.setBounds(400, 338, 224, 100);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		frmMaze.getContentPane().add(btnExit);
		
	}
	
	
}
