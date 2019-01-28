
public class Stack {

	private int count;
	private Queen bottom;
	private Queen top;
	
	public Stack(){
		bottom = new Queen(1, 1, null, null);
		top = bottom;
		count = 1;
	}
	
	public void push(int row, int col){
		// create a new queen and make it the top of the stack
		Queen newQueen = new Queen(row, col, top, null);  
		top.setNext(newQueen);
		top = newQueen;
		count++;
	}
	
	public void pop(){
		// set top to reference element below top, then set the top element equal to null
		top = top.getPrevious();
		top.setNext(null);
		count--;
	}
	
	
	public void display(){
		// iterates from the bottom of the stack to the top
		Queen iterator = bottom;
		
		while(iterator != null){
			System.out.print("+---+---+---+---+---+---+---+---+\n");
			for (int i = 1; i < 9; i++){
				
				if (i == iterator.getRow()){
					System.out.print("| Q ");
				}
				else {
					System.out.print("|   ");
				}
			}
			System.out.print("|  " + iterator.getRow() + "," + iterator.getCol());
			System.out.print("\n");
			iterator = iterator.getNext();
			
		}
		System.out.println("+---+---+---+---+---+---+---+---+");
		System.out.println();
	}
	

	public boolean checkConflict() {
		// checks if position of top queen shares any row, column or diagonal
		// with any other queen on the stack
		Queen iterator = top;
		for (int i = 1; i < count; i++){
			iterator = iterator.getPrevious();
			
			if (top.getRow() == iterator.getRow()){ // check horizontal
				return true;
			}
			if (top.getCol() == iterator.getCol()){  // check vertical
				return true;
			}
			if (Math.abs(top.getRow()-iterator.getRow()) == // check diagonal
					Math.abs(top.getCol()-iterator.getCol())){
				return true;
			}
		}
		return false;
	}

	public int getCount() {
		return count;
	}
}
