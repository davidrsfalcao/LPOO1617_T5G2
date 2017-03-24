package dkeep.gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dkeep.logic.Logic;
import dkeep.logic.Maze3;


public class Options extends JPanel {

	private static final long serialVersionUID = 1L;
	static JComboBox<String> opcoes;
	
	private Menu menu;
	private Menu window;
	private Logic game;

	 
	public Options(JFrame frame)
	{
		JButton jogar = new JButton("Play the Maze");
		jogar.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {  
	  		 
	    	Maze3 maze = new Maze3();
		  		
	  		if(!CreateMaze.getSaida())
	  		{
	  			JOptionPane.showMessageDialog(window, "The Maze doesn't have a Exit");
	  			return;
	  		}
	  		else if(CreateMaze.getHero().getPosition().getX() == -1)
	  		{
	  			JOptionPane.showMessageDialog(window, "The Maze doesn't have a Hero");
	  			return;
	  		}
	  		else if(CreateMaze.getKey()[0] == -1)
	  		{
	  			JOptionPane.showMessageDialog(window, "The Maze doesn't have a Key");
	  			return;
	  		}

	  		
	  		maze.setMap(CreateMaze.getMaze());
	  		game = new Logic(maze,1,CreateMaze.getOgres().size());
	  		for(int i=0;i < CreateMaze.getOgres().size();i++)
	  		{
	  			game.setOgre(CreateMaze.getOgres().get(i));
	  		}
	  		
	  		CreateMaze.clearOgres();

	  		window = new Menu();
	  		window.initGame(game);
	  		frame.dispose();

	      }   
	    });
		
		JButton voltar = new JButton("Quit to Menu");
		voltar.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
		     	Options.this.setVisible(false);
		     	CreateMaze.getFrame().dispose();
		     	menu = new Menu();
				menu.start();	
	      }
	    });
		
		
		opcoes = new JComboBox<String>();
		opcoes.addItem("Exit");
		opcoes.addItem("Wall");
		opcoes.addItem("Hero");
		opcoes.addItem("Key");
		opcoes.addItem("Ogre");
		this.add(jogar);
		this.add(voltar);
		this.add(opcoes);
	}
	
	public void close()
	{
		setVisible(false);
	}
	
	public static String getSelecionado()
	{
		return (String)opcoes.getSelectedItem();
	}
	
	

}
