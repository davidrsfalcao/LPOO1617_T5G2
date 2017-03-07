package dkeep.cli;

import java.util.Scanner;
import java.util.ArrayList;
import dkeep.logic.Logic;
import dkeep.logic.Logic.status;
import dkeep.logic.Character;
import dkeep.logic.Maze1;

public class Cli {

	private Logic game;
	Scanner sc = new Scanner(System.in);

	/**
	 * Cli constructor
	 * 
	 */
	public Cli() {
		game = new Logic(new Maze1());
	}

	/**
	 * Initial function
	 * 
	 * @param args
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
	public void game() {
		do {
			printMap(game.getMap().getMap());
			game = game.moveHero(UserInput());
			game.atack_villains();
			game.moveAllVillains();
			game.atack_villains();
			game.Over();

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
	 * @param map
	 */
	private void printMap(char[][] map) {
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

	public Logic getGame()
	{
		return game;
	}
	
}
