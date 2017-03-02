package dkeep.cli;
import java.util.*;
import dkeep.logic.Logic;
import dkeep.logic.Character;
import pair.Pair;


public class Cli {
	
	Logic game;
	
	public static void main (String[] args)
	{
		Cli cl= new Cli();
		cl.game();
		
	}
	
	public Cli()
	{
		game = new Logic(0);
		
	}
	
	private void ClearScreen()
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
	
	private void game()
	{
		do{
			returnMap(game.getMap().getMap(),game.getLevel());
			game = game.movementH(UserInput());
			game.movementV();
			
		}while(!game.wonGame() && !game.isOver());
		returnMap(game.getMap().getMap(), game.getLevel());
		if(game.wonGame())
			System.out.println("    Congratulations!!   \n");
		else
			System.out.println("    Game Over!!   \n");
		
	}
	
	private void returnMap(char[][] map,int level)
	{
		ClearScreen();
		for(Character p : game.getCharacters())
			for(Pair<int[],String> c : p.getPrint())
				map[c.getFirst()[0]][c.getFirst()[1]] = c.getSecond().charAt(0);
		
		for (int i=0;i < map.length ; i++)
		{
			for(int k=0;k < map[i].length;k++)
			{
				System.out.print(map[i][k] + " ");
			}
		}
		
		
	}
	

}
