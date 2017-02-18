import java.util.Scanner;

public class Hero {
	
	public int cordX;
	public int cordY;
	public int cordX_temp;
	public int cordY_temp;
	
	
	public void movement()
	{
		Scanner sc = new Scanner(System.in);
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
	
	public Hero()
	{
		cordX = 1;
		cordY = 1;
		cordX_temp = 1;
		cordY_temp = 1;
		
	}

}
