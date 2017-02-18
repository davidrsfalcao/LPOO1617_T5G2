public class Guard {
	
	public int cordX;
	public int cordY;
	public int position;
	public int[][] path = {{8,1},{7,1},{7,2},{7,3},{7,4},{7,5},{6,5},{5,5},{4,5},
						   {3,5},{2,5},{1,5},{1,6},{2,6},{3,6},{4,6},{5,6},{6,6},
						   {7,6},{8,6},{8,5},{8,4},{8,3},{8,2}};
	
	public Guard()
	{
		cordX = 8;
		cordY = 1;
		position = 0;
		
	}
	

}
