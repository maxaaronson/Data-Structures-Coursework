/*  Max Aaronson
 *  CS342
 *  HW2, part 1
 *  9/29/2015
 */

public class LinkedList {

	private Node head;
	private int counter;
	
	public LinkedList(){
		counter = 0;
		head = null;
	}
	
	public void addToEnd(int myInt){
		if(counter == 0){
			head = new Node();
			head.setMyInt(myInt);
			counter++;
			return;
		}
		
		Node iterator = head;
		while(iterator.getPointer() != null){  // loops until current node has null pointer
			iterator = iterator.getPointer();  // moves iterator forward one node
		}
		Node newNode = new Node();
		newNode.setMyInt(myInt);
		iterator.setPointer(newNode);  // sets pointer of second to last node to point to the new node
		counter++;
	}
	
	public String toString(){
		if(counter == 0){
			return "Empty list";
		}
		else{
			Node iterator = head;
			String outString = "List: ";
			for (int i = 0; i < counter; i++){
				outString+= iterator.getMyInt() + " ";  // adds current node's value to outString
				iterator = iterator.getPointer();
			}
			return outString;
		}
	}

	public void removeLastElement() {
		Node iterator = head;
		Node previous = null;
		while(iterator.getPointer() != null){
			previous = iterator;
			iterator = iterator.getPointer();
		}
		iterator = null;  // removes last element
		previous.setPointer(null);  // remove reference so previous node is now at the end
		counter--;
	}
}
