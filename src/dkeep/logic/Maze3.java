package dkeep.logic;

import java.util.ArrayList;

public class Maze3 extends Map {
	
	 
		public Maze3(){ 
		}
		
		public void setMap(char[][] map)
		{
			this.map=map;
			this.MAP_SIZE= map[0].length;
			ArrayList<Integer> hero = new ArrayList<Integer>();
			
			for(int i=0;i < MAP_SIZE;i++)
			{
				for(int j=0;j < MAP_SIZE;j++) 
				{
					if(map[i][j] == 'A')
					{
						hero.add(j); //posX
						hero.add(i); //posY
						hero.add(0); //has_key
						hero.add(1); //is_armed
						map[i][j] = ' ';
					}
					
					if(map[i][j] == 'k')
					{
						key = new Position(j,i,'k');
						key.setType(2);
						
					}
					if(map[i][j] == 'I')
					{
						
						endPositions = new ArrayList<Position>();
						Position t1 = new Position(j,i,'S');
						endPositions.add(t1);
						
					}
					if(map[i][j] == 'O')
					{
						map[i][j] = ' ';
					}
			
			    }
			}
			
			ArrayList<Integer> guard = new ArrayList<Integer>();
			guard.add(0); //posX
			guard.add(0); //posY
			guard.add(0); //playing
			
			ArrayList<Integer> ogre = new ArrayList<Integer>();
			ogre.add(0); //playing
			
			
			
			initValues.add(hero);
			initValues.add(guard);
			initValues.add(ogre);
			
			
		}
		
		/**
		 * Returns the next map
		 * 
		 * @return next map
		 */
		public Map nextMap(){
			return null;
		}

		/**
		 * Removes the key from the map
		 * 
		 */
		public void pickUpKey(){
			map[1][7] = ' ';
			key.changeTo(-10, -10);
		}

		@Override
		protected void setObjectives() {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected void setHero() {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected void setGuard() {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected void setOgres() {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected void setMap() {
			// TODO Auto-generated method stub
			
		}

}
