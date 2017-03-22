package dkeep.cli;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

import dkeep.logic.Logic;
import dkeep.logic.Logic.status;
import dkeep.logic.Character;
import dkeep.logic.Maze1;

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

	public Cli(int typeGuard, int nOgres)
	{
		game = new Logic(new Maze1(), typeGuard, nOgres);
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
	 * @param map
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

	private void playGame()
	{
		printMap(game.getMap().getMap());
		game = game.moveHero(UserInput());
		game.atack_villains();
		game.moveAllVillains();
		game.atack_villains();
		game.Over();
	}
	
	public Logic getGame()
	{
		return game;
	}
	
	public void setGame(Logic game)
	{
		this.game = game;
	}
	
	public String print(char[][] map)
	{
		String temp = new String();
		int tam = game.getAllCharacters().size();
		ArrayList<Character> temp1 = game.getAllCharacters();
		
		for (int k = 0; k < tam; k++) {
			map[temp1.get(k).getPosition().getY()][temp1.get(k).getPosition().getX()] = temp1.get(k).getRepresentation();
		}
		
		for (int i = 0; i < map.length; i++) {
			for (int k = 0; k < map[i].length; k++) {
				temp = temp + (map[i][k] + " ");
			}
			temp = temp + '\n';
		}
		
		
		
		return temp;
	}
	
	
}
