public class DungeonKeep {

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
	
	char[][] matriz1 = 
		   { {'X','X','X','X','X','X','X','X','X'},
			 {'I',' ',' ',' ','O',' ',' ','k','X'},
			 {'X',' ',' ',' ',' ',' ',' ',' ','X'},
			 {'X',' ',' ',' ',' ',' ',' ',' ','X'},
			 {'X',' ',' ',' ',' ',' ',' ',' ','X'},
			 {'X',' ',' ',' ',' ',' ',' ',' ','X'},
			 {'X',' ',' ',' ',' ',' ',' ',' ','X'},
			 {'X','H',' ',' ',' ',' ',' ',' ','X'},
			 {'X','X','X','X','X','X','X','X','X'},
	 };
	
	Hero heroi;
	Guard guarda;

	public void clearScreen() {
		for (int i = 0; i < 100; ++i)
			System.out.println();

	}

	public void movementG() {
		matriz[guarda.cordY][guarda.cordX] = ' ';

		guarda.position++;
		if (guarda.position > 23) {
			guarda.position = 0;
		}

		int[] moveTo = guarda.path[guarda.position];
		int x = moveTo[0];
		int y = moveTo[1];

		matriz[y][x] = 'G';
		guarda.cordX = x;
		guarda.cordY = y;

	}

	public boolean movementH_lvl1() {
		heroi.movement(); // movimento temp (condições não testadas)

		// verficar se a posição temp se encontra dentro do tabuleiro
		// em princípio seria desnecessária

		if ((heroi.cordX_temp >= 0) && (heroi.cordX_temp < 10) && (heroi.cordY_temp >= 0) && (heroi.cordY_temp < 10)) {

			if (matriz[heroi.cordY_temp][heroi.cordX_temp] == ' ') {
				matriz[heroi.cordY][heroi.cordX] = ' '; // atualiza o tabuleiro
				matriz[heroi.cordY_temp][heroi.cordX_temp] = 'H'; // atualiza o
																	// tabuleiro
				heroi.cordX = heroi.cordX_temp; // atualiza a cord X
				heroi.cordY = heroi.cordY_temp; // atualiza a cord Y
			}

			else if (matriz[heroi.cordY_temp][heroi.cordX_temp] == 'X') {
				heroi.cordX_temp = heroi.cordX; // não há movimento
				heroi.cordY_temp = heroi.cordY; // X,Y-temp invalidos
			}

			else if (matriz[heroi.cordY_temp][heroi.cordX_temp] == 'I') {
				heroi.cordX_temp = heroi.cordX; // não há movimento
				heroi.cordY_temp = heroi.cordY; // X,Y-temp invalidos
			}

			else if (matriz[heroi.cordY_temp][heroi.cordX_temp] == 'k') {
				matriz[heroi.cordY_temp][heroi.cordX_temp] = ' ';
				for (int k = 0; k <= 9; k++) {
					for (int h = 0; h <= 9; h++) {
						if (matriz[k][h] == 'I') {
							matriz[k][h] = 'S';
						}
					}
				}
				matriz[heroi.cordY][heroi.cordX] = ' '; // atualiza o tabuleiro
				matriz[heroi.cordY_temp][heroi.cordX_temp] = 'H'; // atualiza o
																	// tabuleiro
				heroi.cordX = heroi.cordX_temp; // atualiza a cord X
				heroi.cordY = heroi.cordY_temp; // atualiza a cord Y
			}

			else if (heroi.cordX_temp == 0)
				return true;

		}

		return false;

	}

	public boolean movementH_lvl2()
	{
		heroi.movement(); // movimento temp (condições não testadas)

		// verficar se a posição temp se encontra dentro do tabuleiro
		// em princípio seria desnecessária

		if ((heroi.cordX_temp >= 0) && (heroi.cordX_temp < 10) && (heroi.cordY_temp >= 0) && (heroi.cordY_temp < 10)) {

			if (matriz[heroi.cordY_temp][heroi.cordX_temp] == ' ') {
				matriz[heroi.cordY][heroi.cordX] = ' '; // atualiza o tabuleiro
				matriz[heroi.cordY_temp][heroi.cordX_temp] = 'H'; // atualiza o
																	// tabuleiro
				heroi.cordX = heroi.cordX_temp; // atualiza a cord X
				heroi.cordY = heroi.cordY_temp; // atualiza a cord Y
			}

			else if (matriz[heroi.cordY_temp][heroi.cordX_temp] == 'X') {
				heroi.cordX_temp = heroi.cordX; // não há movimento
				heroi.cordY_temp = heroi.cordY; // X,Y-temp invalidos
			}

			else if (matriz[heroi.cordY_temp][heroi.cordX_temp] == 'I') {
				heroi.cordX_temp = heroi.cordX; // não há movimento
				heroi.cordY_temp = heroi.cordY; // X,Y-temp invalidos
			}

			else if (matriz[heroi.cordY_temp][heroi.cordX_temp] == 'k') {
				matriz[heroi.cordY_temp][heroi.cordX_temp] = ' ';
				for (int k = 0; k <= 9; k++) {
					for (int h = 0; h <= 9; h++) {
						if (matriz[k][h] == 'I') {
							matriz[k][h] = 'S';
						}
					}
				}
				matriz[heroi.cordY][heroi.cordX] = ' '; // atualiza o tabuleiro
				matriz[heroi.cordY_temp][heroi.cordX_temp] = 'H'; // atualiza o
																	// tabuleiro
				heroi.cordX = heroi.cordX_temp; // atualiza a cord X
				heroi.cordY = heroi.cordY_temp; // atualiza a cord Y
			}

			else if (heroi.cordX_temp == 0)
				return true;

		}

		return false;
	}
	
	public int colisionHG() {
		int capture = 0; // 1 for yes and 0 for no
		// zona de captura do guarda

		int[][] catch_zone = { { guarda.cordX - 1, guarda.cordY - 1 }, { guarda.cordX - 1, guarda.cordY },
				{ guarda.cordX - 1, guarda.cordY + 1 }, { guarda.cordX, guarda.cordY - 1 },
				{ guarda.cordX + 1, guarda.cordY - 1 }, { guarda.cordX + 1, guarda.cordY },
				{ guarda.cordX + 1, guarda.cordY + 1 }, { guarda.cordX, guarda.cordY + 1 },
				{ guarda.cordX, guarda.cordY }, };

		for (int[] cords : catch_zone) {
			if ((cords[0] == heroi.cordX) && (cords[1] == heroi.cordY)) {
				capture = 1;
				break;
			}

		}

		return capture;
	}

	void draw(char[][] matriz) {
		clearScreen();
		for (char[] mat : matriz) {
			for (char mat1 : mat) {
				System.out.print(mat1);
			}
			System.out.println();

		}
	}

	public int level2() {
		
		heroi.cordX = 1;
		heroi.cordY = 7;
		heroi.cordX_temp = 1;
		heroi.cordX_temp = 7;
		
		boolean fim = false;

		while (!fim) {

			draw(matriz1);
			
			System.out.println("\n\nx" + heroi.cordX);
			System.out.println("\n\nx1" + heroi.cordX_temp);
			System.out.println("\n\ny" + heroi.cordY);
			System.out.println("\n\ny1" + heroi.cordY_temp);

			if (movementH_lvl2()) {
				return 0;
				
			}


		}

		return 1;
	}

	public int level1() {

		boolean fim = false;

		while (!fim) {

			draw(matriz);

			if (movementH_lvl1()) {
				return 0;
			}
			movementG();
			
			if (colisionHG() == 1) {
				return 1;
			}

		}

		return 1;

	}

	public static void main(String[] args) {
		DungeonKeep game = new DungeonKeep();
		Hero H = new Hero(); // inicialização
		game.heroi = H; // do heroi
		Guard G = new Guard(); // inicialização
		game.guarda = G; // do guarda

		if (game.level1() == 0) {
			if (game.level2() == 0) {
				game.clearScreen();
				System.out.println("\t\tPERDEU");

			}
		} else {
			game.clearScreen();
			System.out.println("\t\tPERDEU");
		}

	}

}
