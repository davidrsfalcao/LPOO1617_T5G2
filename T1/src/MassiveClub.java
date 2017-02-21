import java.util.Random;

public class MassiveClub extends Ogre{
	
	public int x = 7;
	public int y = 7;
	
	public void moviment(int cordX, int cordY, char [][] matriz)
	{
		Random gerador = new Random();
		int numero = gerador.nextInt(4);
		matriz[y][x] = ' ';
		int x_temp = x;
		int y_temp = y;
		
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
			
			if (matriz[y][x] == '*'){
				matriz[y][x] = ' ';
			}
			
			x = x_temp;
			y = y_temp;
		}
		
	}

	
}
