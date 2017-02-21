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
	Ogre ogre;

	//funções gerais
	public void clearScreen() {
		for (int i = 0; i < 100; ++i)
			System.out.println();

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

	
	// funções nível 2
	
	public int colisionHO() {
		int capture = 0; // 1 for yes and 0 for no
		// zona de captura do ogre

		int[][] catch_zone = { { ogre.cordX - 1, ogre.cordY - 1 }, { ogre.cordX - 1, ogre.cordY },
				{ ogre.cordX - 1, ogre.cordY + 1 }, { ogre.cordX, ogre.cordY - 1 },
				{ ogre.cordX + 1, ogre.cordY - 1 }, { ogre.cordX + 1, ogre.cordY },
				{ ogre.cordX + 1, ogre.cordY + 1 }, { ogre.cordX, ogre.cordY + 1 },
				{ ogre.cordX, ogre.cordY }, };

		for (int[] cords : catch_zone) {
			if ((cords[0] == heroi.cordX) && (cords[1] == heroi.cordY)) {
				capture = 1;
				break;
			}

		}

		return capture;
	}
	
	public int level2() {
		
		heroi.cordX = 1;
		heroi.cordY = 7;
		heroi.cordX_temp = 1;
		heroi.cordY_temp = 7;
		
		boolean fim = false;

		while (!fim) {

			draw(matriz1);

			if (heroi.movement_lvl2(matriz1)) {
				return 1;
			}
			ogre.movement(matriz1);
			if (colisionHO() == 1) {
				return 0;
			}


		}

		return 0;
	}

	
	// funções nível 1
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
	
	public int level1() {

		boolean fim = false;

		while (!fim) {

			draw(matriz);

			if (heroi.movement_lvl1(matriz)) {
				return 0;
			}
			guarda.movement(matriz);
			
			if (colisionHG() == 1) {
				return 1;
			}

		}

		return 1;

	}

	
	// função inicial
	public static void main(String[] args) {
		DungeonKeep game = new DungeonKeep();
		Hero H = new Hero(); // inicialização
		game.heroi = H; // do heroi
		Guard G = new Guard(); // inicialização
		game.guarda = G; // do guarda
		Ogre ogre = new Ogre();
		game.ogre = ogre;

		if (game.level1() == 0) {
			if (game.level2() == 0) {
				game.clearScreen();
				System.out.println("\t\tPERDEU");

			}
			else
			{
				game.clearScreen();
				System.out.println("\t\tGANHOU");
			}
		} else {
			game.clearScreen();
			System.out.println("\t\tPERDEU");
		}

	}

}
