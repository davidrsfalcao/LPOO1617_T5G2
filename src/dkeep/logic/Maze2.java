package dkeep.logic;

import java.util.ArrayList;

public class Maze2 extends Map{
	
	public Maze2(){
		MAP_SIZE = 9;
		map = new char[MAP_SIZE][MAP_SIZE];
		
		char[][]temp={{'X','X','X','X','X','X','X','X','X'} ,
					  {'I',' ',' ',' ',' ',' ',' ','K','X'} ,
					  {'X',' ',' ',' ',' ',' ',' ',' ','X'} ,
					  {'X',' ',' ',' ',' ',' ',' ',' ','X'} ,
					  {'X',' ',' ',' ',' ',' ',' ',' ','X'} ,
					  {'X',' ',' ',' ',' ',' ',' ',' ','X'} ,
					  {'X',' ',' ',' ',' ',' ',' ',' ','X'} ,
					  {'X',' ',' ',' ',' ',' ',' ',' ','X'} ,
					  {'X','X','X','X','X','X','X','X','X'} };
		
		int i = 0;
		for( char[] c : temp){
			map[i] = c;
			i++;
		}
		endPositions = new ArrayList<Position>();
		Position t1 = new Position(0,1,'S');
		endPositions.add(t1);
	}
	
	public Map nextMap(){
		return new Maze2();
	}

	public void pickUpKey(){
		this.map[1][8] = ' ';
	}

}
