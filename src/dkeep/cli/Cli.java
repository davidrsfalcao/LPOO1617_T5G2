package dkeep.cli;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

import dkeep.logic.Logic;
import dkeep.logic.Logic.status;
import dkeep.logic.Character;
import dkeep.logic.Maze1;

/**
 * Is the base to control Command Line Interface
 * 
 * @author davidfalcao
 *
 */
public class Cli {

	private Logic game;
	private Scanner sc = new Scanner(System.in);
	private Random rand = new Random();

	/**
	 * Cli constructor
	 * 
	 */
	public Cli() {
		game = new Logic(new Maze1(), rand.nextInt(3), rand.nextInt(3)+1);
	}

	/**
	 * Cli Constructor with initialization of typeGuard and nOgres
	 * 
	 * @param typeGuard type of the guard
	 * @param nOgres number of ogres
	 */
	public Cli(int typeGuard, int nOgres)
	{
		game = new Logic(new Maze1(), typeGuard, nOgres);
	}
	
	/**
	 * Initial function
	 * 
	 * @param args arguments
	 */
	public static void main(String[] args) {
		Cli cl = new Cli();
		cl.game();

	}

	/**
	 * Read the user input
	 * 
	 * @return a key
	 */
	private char UserInput() {
		char op = sc.next().charAt(0);
		return op;

	}

	/**
	 * Main function that control all the game
	 * 
	 */
	private void game() {
		do {
			playGame();
		} while (game.condition == status.RUNNING);

		printMap(game.getMap().getMap());
		if (game.condition == status.WON) {
			clearScreen();
			System.out.println("    Congratulations!!   \n");
		} else if (game.condition == status.DEFEAT) {
			clearScreen();
			System.out.println("    Game Over!!   \n");
		}

	}

	/**
	 * Function the prints the game board on console
	 * 
	 * @param map actual map
	 */
	public void printMap(char[][] map) {
		clearScreen();
		int tam = game.getAllCharacters().size();
		ArrayList<Character> temp = game.getAllCharacters();

		for (int k = 0; k < tam; k++) {
			map[temp.get(k).getPosition().getY()][temp.get(k).getPosition().getX()] = temp.get(k).getRepresentation();
		}

		for (int i = 0; i < map.length; i++) {
			for (int k = 0; k < map[i].length; k++) {
				System.out.print(map[i][k] + " ");
			}
			System.out.println();
		}

	}

	/**
	 * Print some newlines to clean console
	 * 
	 */
	private void clearScreen() {
		for (int i = 0; i < 20; i++) {
			System.out.println();
		}
	}

	/**
	 * Call all functions to move the characters in the game and the 
	 * functions to check if the hero atack, die or win
	 * 
	 */
	private void playGame()
	{
		printMap(game.getMap().getMap());
		game = game.moveHero(UserInput());
		game.atack_villains();
		game.moveAllVillains();
		game.atack_villains();
		game.Over();
	}
	
}
