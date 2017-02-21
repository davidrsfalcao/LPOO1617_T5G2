import java.util.Scanner;

public class Hero {
	
	public int cordX;
	public int cordY;
	public int cordX_temp;
	public int cordY_temp;
	public boolean have_key;
	private Scanner sc;
	
	
	private void movement()
	{
		sc = new Scanner(System.in);
		char option = sc.next().charAt(0);

		if ('w' == option) {
			cordY_temp = cordY_temp - 1; // up position
		}

		if ('s' == option) {
			cordY_temp = cordY_temp + 1; // down position
		}

		if ('a' == option) {
			cordX_temp = cordX_temp - 1; // left position
		}

		if ('d' == option) {
			cordX_temp = cordX_temp + 1; // right position
		}
			
	}
	
	public boolean movement_lvl1(char [][] matriz) {
		movement(); // movimento temp (condições não testadas)

		// verficar se a posição temp se encontra dentro do tabuleiro
		// em princípio seria desnecessária

		if ((cordX_temp >= 0) && (cordX_temp < 10) && (cordY_temp >= 0) && (cordY_temp < 10)) {

			if (matriz[cordY_temp][cordX_temp] == ' ') {
				matriz[cordY][cordX] = ' '; // atualiza o tabuleiro
				matriz[cordY_temp][cordX_temp] = 'H'; // atualiza o
																	// tabuleiro
				cordX = cordX_temp; // atualiza a cord X
				cordY = cordY_temp; // atualiza a cord Y
			}

			else if (matriz[cordY_temp][cordX_temp] == 'X') {
				cordX_temp = cordX; // não há movimento
				cordY_temp = cordY; // X,Y-temp invalidos
			}

			else if (matriz[cordY_temp][cordX_temp] == 'I') {
				cordX_temp = cordX; // não há movimento
				cordY_temp = cordY; // X,Y-temp invalidos
			}

			else if (matriz[cordY_temp][cordX_temp] == 'k') {
				matriz[cordY_temp][cordX_temp] = ' ';
				for (int k = 0; k <= 9; k++) {
					for (int h = 0; h <= 9; h++) {
						if (matriz[k][h] == 'I') {
							matriz[k][h] = 'S';
						}
					}
				}
				matriz[cordY][cordX] = ' '; // atualiza o tabuleiro
				matriz[cordY_temp][cordX_temp] = 'H'; // atualiza o
																	// tabuleiro
				cordX = cordX_temp; // atualiza a cord X
				cordY = cordY_temp; // atualiza a cord Y
			}

			else if (cordX_temp == 0)
				return true;

		}

		return false;

	}
	
	public boolean movement_lvl2(char [][] matriz1)
	{
		movement(); // movimento temp (condições não testadas)

		// verficar se a posição temp se encontra dentro do tabuleiro
		// em princípio seria desnecessária

		if ((cordX_temp >= 0) && (cordX_temp < 9) && (cordY_temp >= 0) && (cordY_temp < 9)) {

			if (matriz1[cordY_temp][cordX_temp] == ' ') {
				matriz1[cordY][cordX] = ' '; // atualiza o tabuleiro
				
				if (have_key) {
					matriz1[cordY_temp][cordX_temp] = 'K';
				}
				else {
					matriz1[cordY_temp][cordX_temp] = 'H';
				}
				
				
				cordX = cordX_temp; // atualiza a cord X
				cordY = cordY_temp; // atualiza a cord Y
			}

			else if (matriz1[cordY_temp][cordX_temp] == 'X') {
				cordX_temp = cordX; // não há movimento
				cordY_temp = cordY; // X,Y-temp invalidos
			}
			else if ((matriz1[cordY_temp][cordX_temp] == 'I') ) {
				if (have_key) {
					matriz1[cordY_temp][cordX_temp] = 'S';
				}
				cordX_temp = cordX; // não há movimento
				cordY_temp = cordY; // X,Y-temp invalidos
			}

			else if (matriz1[cordY_temp][cordX_temp] == 'I') {
				cordX_temp = cordX; // não há movimento
				cordY_temp = cordY; // X,Y-temp invalidos
			}
			
						
			else if (matriz1[cordY_temp][cordX_temp] == 'k') {
				matriz1[cordY][cordX] = ' '; // atualiza o tabuleiro
				matriz1[cordY_temp][cordX_temp] = 'K'; 
				have_key = true;
				cordX = cordX_temp; // atualiza a cord X
				cordY = cordY_temp; // atualiza a cord Y
			}

			else if (cordX_temp == 0)
				return true;

		}

		return false;
	}
	
	public Hero()
	{
		cordX = 1;
		cordY = 1;
		cordX_temp = 1;
		cordY_temp = 1;
		have_key = false;
		
	}

}
