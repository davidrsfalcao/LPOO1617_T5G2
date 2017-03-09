package dkeep.gui;
import dkeep.cli.Cli;
import dkeep.logic.Logic;
import dkeep.logic.Logic.status;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DropMode;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Color;

public class window {

	private JFrame frmDun;
	private Cli cli;
	private JButton btnNewGame = new JButton("New Game");
	private JLabel lblStatus = new JLabel("You can start a new game");
	private JButton btnUp = new JButton("Up");
	private JButton btnDown = new JButton("Down");
	private JButton btnLeft = new JButton("Left");
	private JButton btnRight = new JButton("Right");
	private JTextField textNOgres = new JTextField();
	private JComboBox comboBoxGuardPersonality = new JComboBox();
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window window = new window();
					window.frmDun.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDun = new JFrame();
		frmDun.setResizable(false);
		frmDun.setTitle("Dungeon Keep");
		frmDun.setBounds(100, 100, 549, 422);
		frmDun.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDun.getContentPane().setLayout(null);
		
		JTextArea board = new JTextArea();
		board.setBackground(Color.WHITE);
		board.setForeground(Color.BLACK);
		board.setFont(new Font("Courier", Font.PLAIN, 25));
		board.setEditable(false);
		board.setBounds(23, 101, 290, 257);
		frmDun.getContentPane().add(board);
		
		
		// Botão status
		lblStatus.setFont(new Font("Courier", Font.PLAIN, 11));
		lblStatus.setBounds(33, 370, 183, 16);
		frmDun.getContentPane().add(lblStatus);
		
		
		// Botão UP
		btnUp.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				if (cli.getGame().condition == status.RUNNING) {
					cli.play('w');
					board.setText(cli.print(cli.getGame().getMap().getMap()));
				}
				
				if (cli.getGame().condition != status.RUNNING)
				{
					lblStatus.setText("You can start a new game");
					btnNewGame.setEnabled(true);
					btnDown.setEnabled(false);
					btnUp.setEnabled(false);
					btnLeft.setEnabled(false);
					btnRight.setEnabled(false);
					textNOgres.setEnabled(true);
					textNOgres.setText("");
					comboBoxGuardPersonality.setEnabled(true);
					comboBoxGuardPersonality.setSelectedIndex(0);
					
				}
				
				if (cli.getGame().condition == status.WON)
				{
					board.setText("\n\n\n\n      YOU WIN");
					
				}
				else if (cli.getGame().condition == status.DEFEAT)
				{
					board.setText("\n\n\n\n     YOU LOSE!");
					
				}
				
			}
		});
		btnUp.setEnabled(false);
		btnUp.setFont(new Font("Courier", Font.PLAIN, 11));
		btnUp.setBounds(406, 178, 91, 29);
		frmDun.getContentPane().add(btnUp);
		

		// Botão down
		btnDown.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				if (cli.getGame().condition == status.RUNNING) {
					cli.play('s');
					board.setText(cli.print(cli.getGame().getMap().getMap()));
				} 
				
				if (cli.getGame().condition != status.RUNNING)
				{
					lblStatus.setText("You can start a new game");
					btnNewGame.setEnabled(true);
					btnDown.setEnabled(false);
					btnUp.setEnabled(false);
					btnLeft.setEnabled(false);
					btnRight.setEnabled(false);
					textNOgres.setEnabled(true);
					textNOgres.setText("");
					comboBoxGuardPersonality.setEnabled(true);
					comboBoxGuardPersonality.setSelectedIndex(0);
					
				}
				
				if (cli.getGame().condition == status.WON)
				{
					board.setText("\n\n\n\n      YOU WIN");
					
				}
				else if (cli.getGame().condition == status.DEFEAT)
				{
					board.setText("\n\n\n\n     YOU LOSE!");
				}
				
			}
		});
		btnDown.setEnabled(false);
		btnDown.setFont(new Font("Courier", Font.PLAIN, 11));
		btnDown.setBounds(406, 241, 91, 29);
		frmDun.getContentPane().add(btnDown);
		
		
		// Botão left
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (cli.getGame().condition == status.RUNNING) {
					cli.play('a');
					board.setText(cli.print(cli.getGame().getMap().getMap()));
				}

				if (cli.getGame().condition != status.RUNNING)
				{
					lblStatus.setText("You can start a new game");
					btnNewGame.setEnabled(true);
					btnDown.setEnabled(false);
					btnUp.setEnabled(false);
					btnLeft.setEnabled(false);
					btnRight.setEnabled(false);
					textNOgres.setEnabled(true);
					textNOgres.setText("");
					comboBoxGuardPersonality.setEnabled(true);
					comboBoxGuardPersonality.setSelectedIndex(0);
					
				}
				
				if (cli.getGame().condition == status.WON)
				{
					board.setText("\n\n\n\n      YOU WIN");
					
				}
				else if (cli.getGame().condition == status.DEFEAT)
				{
					board.setText("\n\n\n\n     YOU LOSE!");
				}
				
			}
		});
		btnLeft.setEnabled(false);
		btnLeft.setFont(new Font("Courier", Font.PLAIN, 11));
		btnLeft.setBounds(347, 211, 84, 29);
		frmDun.getContentPane().add(btnLeft);
		
		// Botão right
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (cli.getGame().condition == status.RUNNING) {
					cli.play('d');
					board.setText(cli.print(cli.getGame().getMap().getMap()));
				} 
				
				if (cli.getGame().condition != status.RUNNING)
				{
					lblStatus.setText("You can start a new game");
					btnNewGame.setEnabled(true);
					btnDown.setEnabled(false);
					btnUp.setEnabled(false);
					btnLeft.setEnabled(false);
					btnRight.setEnabled(false);
					textNOgres.setEnabled(true);
					textNOgres.setText("");
					comboBoxGuardPersonality.setEnabled(true);
					comboBoxGuardPersonality.setSelectedIndex(0);
					
				}
				
				if (cli.getGame().condition == status.WON)
				{
					board.setText("\n\n\n\n      YOU WIN");
					
				}
				else if (cli.getGame().condition == status.DEFEAT)
				{
					board.setText("\n\n\n\n     YOU LOSE!");
				}
				
			}
		});
		btnRight.setEnabled(false);
		btnRight.setFont(new Font("Courier", Font.PLAIN, 11));
		btnRight.setBounds(459, 211, 84, 29);
		frmDun.getContentPane().add(btnRight);
		
		
		JLabel lblNOgres = new JLabel("Number of ogres");
		lblNOgres.setFont(new Font("Courier", Font.PLAIN, 11));
		lblNOgres.setBounds(23, 22, 122, 16);
		frmDun.getContentPane().add(lblNOgres);
		
		
		// Caixa n ogres
		
		textNOgres.setBounds(157, 15, 59, 26);
		frmDun.getContentPane().add(textNOgres);
		textNOgres.setColumns(10);
		
		JLabel lblGuardPersonality = new JLabel("Guard personality");
		lblGuardPersonality.setFont(new Font("Courier", Font.PLAIN, 11));
		lblGuardPersonality.setBounds(23, 59, 122, 16);
		frmDun.getContentPane().add(lblGuardPersonality);
		
		// Botão tipo de guarda
		comboBoxGuardPersonality.setFont(new Font("Courier", Font.PLAIN, 11));
		comboBoxGuardPersonality.setModel(new DefaultComboBoxModel(new String[] {"Rookie", "Drunken", "Suspicious"}));
		comboBoxGuardPersonality.setBounds(157, 53, 117, 27);
		frmDun.getContentPane().add(comboBoxGuardPersonality);
		
		// Botão novo jogo
		btnNewGame.setFont(new Font("Courier", Font.PLAIN, 11));
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				int nOgres;
				
				try {
					nOgres  = Integer.parseInt(textNOgres.getText());

				} catch (NumberFormatException ex) {

					JOptionPane.showMessageDialog(frmDun, "Number of ogres invalid");
					return;
				}
				
				if (nOgres > 5 || nOgres <0)
				{
					JOptionPane.showMessageDialog(frmDun, "Number of ogres invalid");
					return;
				}
				
				
				int guardType = comboBoxGuardPersonality.getSelectedIndex();
				textNOgres.setEnabled(false);
				comboBoxGuardPersonality.setEnabled(false);
				
				
				cli = new Cli(guardType, nOgres);
				lblStatus.setText(cli.getGame().condition.toString());
				btnRight.setEnabled(true);
				btnLeft.setEnabled(true);
				btnDown.setEnabled(true);
				btnUp.setEnabled(true);
				
				board.setText(cli.print(cli.getGame().getMap().getMap()));
				
				btnNewGame.setEnabled(false);
				
			}
		});
		btnNewGame.setBounds(387, 121, 117, 29);
		frmDun.getContentPane().add(btnNewGame);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Courier", Font.PLAIN, 11));
		btnExit.setBounds(387, 330, 117, 29);
		frmDun.getContentPane().add(btnExit);
		


	}
}
