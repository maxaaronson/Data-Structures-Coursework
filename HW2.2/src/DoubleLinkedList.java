/*  Max Aaronson
 *  HW 2, part 2
 */


public class DoubleLinkedList {

	private Node head;
	private Node tail;
	private int counter;
	
	public DoubleLinkedList(){
		counter = 0;
		head = new Node();  // dummy head node
		tail = new Node();  // dummy tail node
		head.setNext(tail);
		tail.setPrevious(head);
	}
	
	public void addToEnd(String a, String b, String c){
		
		Node temp = tail.getPrevious();
		Node newNode = new Node();
		newNode.setA(a);
		newNode.setB(b);
		newNode.setC(c);
		newNode.setPrevious(temp);  
		temp.setNext(newNode);
		newNode.setNext(tail);
		tail.setPrevious(newNode);
		counter++;
	}
	
	public void addToStart(String a, String b, String c){
		
		Node temp = head.getNext();
		Node newNode = new Node();
		newNode.setA(a);
		newNode.setB(b);
		newNode.setC(c);
		newNode.setPrevious(head);  
		head.setNext(newNode);
		newNode.setNext(temp);
		temp.setPrevious(newNode);
		counter++;
	}
	
	public String toString(){
		if(counter == 0){
			return "Empty list";
		}
		else{
			Node iterator = head.getNext();  // starts after head
			String outString = "List: ";
			for (int i = 1; i < counter; i++){
				outString+= iterator.getA() + " " + iterator.getB() + " "
						+ iterator.getC();  
				iterator = iterator.getNext();
			}
			return outString;
		}
	}

	public boolean removeElement(int position) {  // position is relative to head
		if (counter == 0){
			return false;
		}
		Node iterator = head.getNext();
		for (int i = 0; i < position; i++){  // loop stops at desired position
			iterator = iterator.getNext();
		}
		Node prev = iterator.getPrevious();
		Node next = iterator.getNext();
		// remove references to node that is being deleted
		prev.setNext(next);
		next.setPrevious(prev);
		return true;
	}
}
