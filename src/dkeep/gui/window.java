package dkeep.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class window {

	private JFrame frmDun;
	private JTextField Board;
	private JTextField textNOgres;

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
		
		Board = new JTextField();
		Board.setEditable(false);
		Board.setBounds(23, 88, 312, 270);
		frmDun.getContentPane().add(Board);
		Board.setColumns(10);
		
		JButton btnUp = new JButton("Up");
		btnUp.setEnabled(false);
		btnUp.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		btnUp.setBounds(406, 178, 91, 29);
		frmDun.getContentPane().add(btnUp);
		
		JButton btnDown = new JButton("Down");
		btnDown.setEnabled(false);
		btnDown.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		btnDown.setBounds(406, 241, 91, 29);
		frmDun.getContentPane().add(btnDown);
		
		JButton btnLeft = new JButton("Left");
		btnLeft.setEnabled(false);
		btnLeft.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		btnLeft.setBounds(347, 211, 84, 29);
		frmDun.getContentPane().add(btnLeft);
		
		JButton btnRight = new JButton("Right");
		btnRight.setEnabled(false);
		btnRight.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		btnRight.setBounds(459, 211, 84, 29);
		frmDun.getContentPane().add(btnRight);
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnRight.setEnabled(true);
				btnLeft.setEnabled(true);
				btnDown.setEnabled(true);
				btnUp.setEnabled(true);
				
			}
		});
		btnNewGame.setBounds(387, 121, 117, 29);
		frmDun.getContentPane().add(btnNewGame);
		
		JLabel lblNOgres = new JLabel("Number of ogres");
		lblNOgres.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblNOgres.setBounds(23, 22, 102, 16);
		frmDun.getContentPane().add(lblNOgres);
		
		textNOgres = new JTextField();
		textNOgres.setBounds(126, 16, 59, 26);
		frmDun.getContentPane().add(textNOgres);
		textNOgres.setColumns(10);
		
		JLabel lblGuardPersonality = new JLabel("Guard personality");
		lblGuardPersonality.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblGuardPersonality.setBounds(23, 59, 102, 16);
		frmDun.getContentPane().add(lblGuardPersonality);
		
		JComboBox comboBoxGuardPersonality = new JComboBox();
		comboBoxGuardPersonality.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		comboBoxGuardPersonality.setModel(new DefaultComboBoxModel(new String[] {"Rookie", "Drunken", "Suspicious"}));
		comboBoxGuardPersonality.setBounds(126, 54, 117, 27);
		frmDun.getContentPane().add(comboBoxGuardPersonality);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		btnExit.setBounds(387, 330, 117, 29);
		frmDun.getContentPane().add(btnExit);
		
		JLabel lblStatus = new JLabel("You can start a new game");
		lblStatus.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblStatus.setBounds(33, 370, 183, 16);
		frmDun.getContentPane().add(lblStatus);
	}
}
