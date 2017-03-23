package dkeep.gui;



import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MapSize extends JDialog{
	private static final long serialVersionUID = 1L;
	private Menu window;
	
	MapSize(){
		this.setEnabled(true);
		this.setModal(true);
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
		    	else CreateMaze.construir(Integer.parseInt(box.getText()));
	    	 MapSize.this.setVisible(false);
	    	
	      }
	    });
		this.getContentPane().add(panel);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
	}
}
