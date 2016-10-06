
public class Queen {
	// This is the node class of the stack
	private int col;
	private int row;
	private Queen previous;
	private Queen next;
	
	// no default constructor
	// cannot have queen at (0,0)
	public Queen(int row, int col, Queen previous, Queen next) {
		this.col = col;
		this.row = row;
		this.previous = previous;
		this.next = next;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public Queen getPrevious() {
		return previous;
	}

	public void setPrevious(Queen previous) {
		this.previous = previous;
	}
	
	public Queen getNext() {
		return next;
	}

	public void setNext(Queen next) {
		this.next = next;
	}
	
	
}
