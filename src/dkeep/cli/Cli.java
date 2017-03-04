package dkeep.cli;
import java.util.*;
import dkeep.logic.Logic;
import dkeep.logic.Character;
import dkeep.logic.Maze1;


public class Cli {
	
	Logic game;
	
	public static void main (String[] args)
	{
		Cli cl= new Cli();
		cl.game();
		
	}
	
	public Cli()
	{
		game = new Logic(0, new Maze1());
		
	}
	
	private void clearScreen()
	{
		for(int i=0;i < 20;i++)
		{
			System.out.println();
		}
	}
	
	private char UserInput()
	{
		
		Scanner sc = new Scanner(System.in);
		char op = sc.next().charAt(0);
		return op;
		
	}
	
	private void game() {
		do {
			printMap(game.getMap().getMap(), game.getLevel());
			game = game.moveHero(UserInput());
			game.moveAllVillains();

		} while (!game.wonGame()  && !game.Over() );
		printMap(game.getMap().getMap(), game.getLevel());
		if (game.wonGame())
		{
			clearScreen();
			System.out.println("    Congratulations!!   \n");
		}
		else
		{
			clearScreen();
			System.out.println("    Game Over!!   \n");
		}

	}
	
	private void printMap(char[][] map,int level)
	{
		clearScreen();	
		int tam = game.getAllCharacters().size();
		ArrayList<Character> temp = game.getAllCharacters();
		
		for(int k = 0; k < tam; k++)
		{
			map[temp.get(k).getPosition().getY()][temp.get(k).getPosition().getX()] = temp.get(k).getRepresentation();
		}
		
		for (int i=0;i < map.length ; i++)
		{
			for(int k=0;k < map[i].length;k++)
			{
				System.out.print(map[i][k] + " ");
			}
			System.out.println();
		}
		
		
	}
	

}
