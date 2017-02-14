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
	 
	 boolean fim = false;
	 
	 while(!fim)
	 {
		 int x1 = position[0];
		 int y1 = position[1];
		 draw(matriz);
		 
		 Scanner sc = new Scanner(System.in);
		 char option = sc.next().charAt(0);
		 
		 if ('w' == option)
		 {
			 x1 = x1 - 1;
		 }
		 
		 if ('s' == option)
		 {
			 x1 = x1 + 1;
		 }
		 
		 if ('a' == option)
		 {
			 y1 = y1 - 1;
		 }
		 
		 if ('d' == option)
		 {
			y1 = y1 + 1;
		 }
		 
		 if ((0 <= x1) && (x1<=9) && (0 <= y1) && (y1<=9))
		 {
				
				int x = position[0];
				int y = position[1];
				

				if (matriz[x1][y1] == ' ') {
					matriz[x][y] = ' ';
					matriz[x1][y1] = 'H';
					position[0] = x1;
					position[1] = y1;

				}

				else if (matriz[x1][y1] == 'X') {
					// não faz nada
				}
				
				else if (matriz[x1][y1] == 'I')
				{
					// não faz nada
				}
				
				else if (matriz[x1][y1] == 'G')
				{
					System.out.println("\n\n\n\n\n\n\n\n\nPERDEU");
					fim = true;
					
				}
				
				else if (matriz[x1][y1] == 'k')
				{
					 for(int k = 0; k<=9; k++)
					 {
						 for (int h=0; h<=9;h++)
						 {
							 if (matriz[k][h] == 'I')
							 {
								 matriz[k][h] = 'S';
							 }
						 }
					 }
				}
				else if (matriz[x1][y1] == 'S')
				{
					System.out.println("\n\n\n\n\n\n\n\n\nGANHOU");
					fim = true;
				}

		 }
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
	 }
	 
	}
	 
	
}
