package dkeep.gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import dkeep.logic.Logic;

/**
 * Class that treats the save and load operations
 * 
 * @author davidfalcao
 *
 */
public class SaveLoad {
	
	/**
	 * Default constructor
	 */
	public SaveLoad(){};
	
	/**
	 * Save the games into the choosen path
	 * 
	 * @param game
	 * @param path
	 */
	public void save(Logic game, String path)
	{
		try{
			File file = new File(path);
			FileOutputStream fileOut = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(game);
			out.close();
			System.out.println("Game save as "+path);
			
		}catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Load the choosen file
	 * 
	 * @param file
	 * @return
	 */
	public Logic load(File file)
	{
		Logic game;
		try {
			FileInputStream fileIn = new FileInputStream(file);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			game = (Logic) in.readObject();
			System.out.println("Game Loaded");
			
			in.close();
			fileIn.close();
		
		} catch (IOException e) {
			System.out.println("Game not Loaded");
			e.printStackTrace();
			return null;
		}catch (ClassNotFoundException n)
		{
			System.out.println("Class not found");
			n.printStackTrace();
			return null;
		}
		return game;
		
	}

}
