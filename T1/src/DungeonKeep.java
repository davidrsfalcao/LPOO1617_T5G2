public class DungeonKeep {


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
	 
	 for(char[] mat: matriz)
	 {
		 for (char mat1: mat)
		 {
			 System.out.print(mat1);
		 }
		 System.out.print('\n');
		 
	 }
	 
	}
	 
	
}
