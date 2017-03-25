package dkeep.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Dialog to chose the size of Map
 * 
 * @author davidfalcao
 *
 */
public class MapSize extends JDialog{
	private static final long serialVersionUID = 1L;
	

	/**
	 * Create the dialog.
	 */
	public MapSize(Menu window){
		
		setResizable(false);
		JPanel panel=new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setSize(200, 200);
		JLabel Label = new JLabel("Maze dimension: ");
		Label.setBounds(0,0,100,100);  
		JTextField box = new JTextField(3);
		box.setText("" + 10);
		JButton accept = new JButton("Accept");
		panel.add(Label);
		panel.add(box);
		panel.add(accept);
		accept.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e) 
	      {
	    	  if (Integer.parseInt(box.getText()) < 5 || Integer.parseInt(box.getText()) > 30)
		    	{
	    		  	JOptionPane.showMessageDialog(window, "The Maze dimension must be between 5 and 30");
		  			return;
		    	}
		    	else if (Integer.parseInt(box.getText()) >= 5 && Integer.parseInt(box.getText()) <= 30)
		    	{
		    		CreateMaze.construir(Integer.parseInt(box.getText()));
		    		setVisible(false);
		    		window.dispose();
		    	}	
	      }
	    });
		getContentPane().add(panel);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
	}
}
