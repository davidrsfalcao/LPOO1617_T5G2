package dkeep.gui;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import dkeep.logic.Logic;

public class SaveLoad {
	
	private void save(Logic game)
	{
		try{
			FileOutputStream fileOut = new FileOutputStream(System.getProperty("user.dir")+"/save.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(game);
			out.close();
			System.out.printf("Serialized data is saved in "+System.getProperty("user.dir")+"/save.ser");
			
		}catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private Logic load()
	{
		Logic game;
		try {
			FileInputStream fileIn = new FileInputStream(System.getProperty("user.dir")+"/save.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			game = (Logic) in.readObject();
			in.close();
			fileIn.close();
		
		} catch (IOException e) {
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
