/*
 * Max Aaronson
 * CS342
 * Queen Solver Project
 * 10/20/2015
 */

import java.util.Random;


public class QueenSolver {
	
	Stack queens;

	public static void main(String[] args) {
		QueenSolver solver = new QueenSolver();
		solver.run();
	}
	public void run(){
		queens = new Stack(); // initialize a stack with a queen at (1,1)
		Random r = new Random();
		
		int row = r.nextInt(8) + 1;  // randomly picks a row to start
		int col = 2; 
		
		
		while(queens.getCount() != 8){
			queens.push(row, col);  // add a queen
			

			if(queens.checkConflict()){  
				// if there is a conflict, remove all queens but the first one
				// and try again with new random row values
				while(queens.getCount() != 1){
				queens.pop();  
				col = 2;
				}
				
			}
			else {
				// if there are no conflicts, increment column by 1
				// for the next queen
				col++;
			}
			
			row = r.nextInt(8) + 1;  // next random row
			
		}
		
		queens.display();
	}



}
