package dkeep.logic;

import java.util.ArrayList;

public class Maze1 extends Map{

	public Maze1(){
		MAP_SIZE = 10;
		char[][]temp={{'X','X','X','X','X','X','X','X','X','X'} ,
					  {'X',' ',' ',' ','I',' ','X',' ',' ','X'} ,
					  {'X','X','X',' ','X','X','X',' ',' ','X'} ,
					  {'X',' ','I',' ','I',' ','X',' ',' ','X'} ,
					  {'X','X','X',' ','X','X','X',' ',' ','X'} ,
					  {'I',' ',' ',' ',' ',' ',' ',' ',' ','X'} ,
					  {'I',' ',' ',' ',' ',' ',' ',' ',' ','X'} ,
					  {'X','X','X',' ','X','X','X','X',' ','X'} ,
					  {'X',' ','I',' ','I',' ','X','k',' ','X'} ,
					  {'X','X','X','X','X','X','X','X','X','X'} };
		int i = 0;
		for( char[] c : temp){
			this.map[i] = (char[])c.clone();
			i++;
		}
		
		Position t1 = new Position(0,5,'S');
		endPositions = new ArrayList<Position>();
		endPositions.add(t1);
		Position t2 = new Position(0,6,'S');
		endPositions.add(t2);
		
	}
	

	public Map nextMap(){
		return new Maze2();
	}
	
	public void pickUpKey(){};
	
}
	
