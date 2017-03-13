package dkeep.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import dkeep.logic.*;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.JSlider;
import java.awt.Component;
import java.awt.Rectangle;

public class GameFrame {

	private JFrame frmMaze;
	private Logic game;
	private JTextArea board;
	private JLabel lblcurretnState;
	private JLabel mazeSize;
	private JButton btnExit;
	private JButton newGame;
	private JButton btnExitToMenu;
	private GamePanel graphicsPanel;
	private JSlider drakeNumber;
	private JComboBox<String> gameMode;
	private JButton btnRandomMaze;
	private JButton btnNext;



	/**
	 * Create the application.
	 */
	public GameFrame() {
		initialize();
		try {
			frmMaze.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	}
	

	

	

	


}
