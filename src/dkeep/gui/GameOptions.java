package dkeep.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

public class GameOptions extends JDialog {


	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private int tempGuard;
	private int tempOgre;


	/**
	 * Create the dialog.
	 */
	public GameOptions(Menu window, int guard_type, int nOgres) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(false);
		setBounds(100, 100, 359, 162);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height
				/ 2 - this.getSize().height / 2);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblGuar = new JLabel("Guard personality");
		lblGuar.setBounds(33, 28, 138, 16);
		lblGuar.setFont(new Font("Courier", Font.PLAIN, 11));
		contentPanel.add(lblGuar);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(183, 22, 126, 27);
		comboBox.setFont(new Font("Courier", Font.PLAIN, 11));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Rookie", "Drunken", "Suspicious"}));
		comboBox.setSelectedIndex(guard_type);
		contentPanel.add(comboBox);
		
		
		JLabel lblNumberOfOgres = new JLabel("Number of ogres");
		lblNumberOfOgres.setBounds(33, 66, 146, 16);
		lblNumberOfOgres.setFont(new Font("Courier", Font.PLAIN, 11));
		contentPanel.add(lblNumberOfOgres);
		
		textField = new JTextField();
		textField.setBounds(183, 61, 126, 26);
		textField.setFont(new Font("Courier", Font.PLAIN, 11));
		textField.setText(nOgres + "");
		contentPanel.add(textField);
		textField.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						tempGuard = comboBox.getSelectedIndex();
						
						try {
							tempOgre  = Integer.parseInt(textField.getText());

						} catch (NumberFormatException ex) {

							JOptionPane.showMessageDialog(window, "Number of ogres invalid");
							
						}
						
						if (tempOgre <= 5 && tempOgre >0)
						{
							window.setGuardType(tempGuard);
							window.setNOgres(tempOgre);
							setVisible(false);
							window.initGame();
							
							
						}
						else {
							JOptionPane.showMessageDialog(window, "Number of ogres invalid");
							
							}
						toFront();
					}
				});
				buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						comboBox.setSelectedItem(guard_type);
						textField.setText(nOgres + "");
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
