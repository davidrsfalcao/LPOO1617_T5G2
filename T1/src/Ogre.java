import java.util.Random;

public class Ogre {
	
	public int cordX;
	public int cordY;
	public int cordX_temp;
	public int cordY_temp;
	boolean have_key;
	public int x_club;
	public int y_club;
	
	public void moviment_club(char [][] matriz)
	{
		Random gerador = new Random();
		int numero = gerador.nextInt(4);
		matriz[y_club][x_club] = ' ';
		int x_temp = x_club;
		int y_temp = y_club;
		
		switch(numero)
		{
		case 0:
			x_temp = cordX - 1; // left
			y_temp = cordY;
			break;
			
		case 1:
			x_temp = cordX + 1;
			y_temp = cordY; // right
			break;
			
		case 2:
			x_temp = cordX;
			y_temp = cordY + 1; // down
			break;
			
		case 3:
			x_temp = cordX;
			y_temp = cordY - 1; // up
			
		}
		
		if (matriz[y_temp][x_temp] == ' ')
		{
			matriz[y_temp][x_temp] = '*';
			
			if (matriz[y_club][x_club] == '*'){
				matriz[y_club][x_club] = ' ';
			}
			
			x_club = x_temp;
			y_club = y_temp;
		}
		
	}

	private void movement(){
		
		Random gerador = new Random();
		int numero = gerador.nextInt(4);
		
		
		switch(numero)
		{
		case 0:
			cordX_temp--;  // move left
			break;
			
		case 1:
			cordX_temp++; // move right
			break;
			
		case 2:
			cordY_temp--; // move down
			break;
			
		case 3:
			cordY_temp++; // move up
			
		}
		
	}

	public void movement(char[][] matriz1)
	{
		movement();
		if ((matriz1[cordY_temp][cordX_temp] == ' ') && (matriz1[cordY][cordX] == '$') ) {
			matriz1[cordY][cordX] = 'k'; // atualiza o tabuleiro
			matriz1[cordY_temp][cordX_temp] = 'O'; // atualiza o tabuleiro
														
			cordX = cordX_temp; // atualiza a cord X
			cordY = cordY_temp; // atualiza a cord Y
		}
		
		else if (matriz1[cordY_temp][cordX_temp] == ' ' ) {
			matriz1[cordY][cordX] = ' '; // atualiza o tabuleiro
			matriz1[cordY_temp][cordX_temp] = 'O'; // atualiza o tabuleiro
														
			cordX = cordX_temp; // atualiza a cord X
			cordY = cordY_temp; // atualiza a cord Y
		}
		
		else if (matriz1[cordY_temp][cordX_temp] == 'X') {
			cordX_temp = cordX; // não há movimento
			cordY_temp = cordY; // X,Y-temp invalidos
		}
		else if (matriz1[cordY_temp][cordX_temp] == 'I') {
			cordX_temp = cordX; // não há movimento
			cordY_temp = cordY; // X,Y-temp invalidos
		}
		else if (matriz1[cordY_temp][cordX_temp] == 'k') {
			matriz1[cordY][cordX] = ' '; // atualiza o tabuleiro
			matriz1[cordY_temp][cordX_temp] = '$'; // atualiza o tabuleiro
														
			cordX = cordX_temp; // atualiza a cord X
			cordY = cordY_temp; // atualiza a cord Y
		}
		moviment_club(matriz1);
		
	}
		
	public Ogre()
	{
		cordX = 4;
		cordY = 1;
		cordX_temp = 4;
		cordY_temp = 1;
		have_key = false;
		x_club = 7;
		y_club = 7;
		
		
	}
	
	
}
