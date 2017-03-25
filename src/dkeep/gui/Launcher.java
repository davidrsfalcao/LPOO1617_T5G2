package dkeep.gui;

import java.io.IOException;

/**
 * Launches the game
 * 
 * @author davidfalcao
 *
 */
public class Launcher{
	
	/**
	 * Main function
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
	
		Menu window = new Menu();
		window.start();
	}

}
