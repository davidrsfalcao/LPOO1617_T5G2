import java.util.Random;

public class Ogre {
	
	public int cordX;
	public int cordY;
	public int cordX_temp;
	public int cordY_temp;
	boolean have_key;
	
	public void movement(){
		
		Random gerador = new Random();
		int numero = gerador.nextInt(4);
		
		System.out.println(numero);
		
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

	public Ogre()
	{
		cordX = 4;
		cordY = 1;
		cordX_temp = 4;
		cordY_temp = 1;
		have_key = false;
		
	}
}
