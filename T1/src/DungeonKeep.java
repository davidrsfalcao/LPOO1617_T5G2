import java.util.Scanner;

public class DungeonKeep {

	public static void draw(char[][] matriz)
	{
		 for(char[] mat: matriz)
		 {
			 for (char mat1: mat)
			 {
				 System.out.print(mat1);
			 }
			 System.out.print('\n');
			 
		 }
		
	}
	

	public static void main(String[] args)
	{
	 char[][] matriz = 
		   { {'X','X','X','X','X','X','X','X','X','X'},
			 {'X','H',' ',' ','I',' ','X',' ','G','X'},
			 {'X','X','X',' ','X','X','X',' ',' ','X'},
			 {'X',' ','I',' ','I',' ','X',' ',' ','X'},
			 {'X','X','X',' ','X','X','X',' ',' ','X'},
			 {'I',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			 {'I',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			 {'X','X','X',' ','X','X','X','X',' ','X'},
			 {'X',' ','I',' ','I',' ','X','k',' ','X'},
			 {'X','X','X','X','X','X','X','X','X','X'}
	 };
	 
	 int position[] = {1,1};
	 int position_temp[] = position;
	 
	 boolean fim = false;
	 
	 while(!fim)
	 {
		 draw(matriz);
		 
		 Scanner sc = new Scanner(System.in);
		 char option = sc.next().charAt(0);
		 
		 if ('w' == option)
		 {
			 position_temp[1] = position_temp[1] - 1;
		 }
		 
		 if ('s' == option)
		 {
			 position_temp[1] = position_temp[1] + 1;
		 }
		 
		 if ('a' == option)
		 {
			 position_temp[0] = position_temp[0] - 1;
		 }
		 
		 if ('d' == option)
		 {
			 position_temp[0] = position_temp[0] + 1;
		 }
		 
		 if ((0 <= position_temp[0]) && (position_temp[0]<=9) && (0 <= position_temp[1]) && (position_temp[1]<=9))
		 {
			int x = position_temp[0];
			int y = position_temp[1];
			
			if (matriz[x][y] == 'X')
			{
				position_temp = position;
			}
			
			 
			 
		 }
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
	 }
	 
	}
	 
	
}
