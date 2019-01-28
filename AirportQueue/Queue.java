
public class Queue {

	private Plane head;
	private Plane tail;
	private int counter;
	
	public Queue(){
		counter = 0;
		head = new Plane();  // dummy head node
		tail = new Plane();  // dummy tail node
		head.setNext(tail);
		tail.setPrevious(head);
	}
	
	public void add(){
		
		Plane temp = tail.getPrevious();
		Plane p = new Plane();
		p.setTimeInQueue(0);
		p.setPrevious(temp); 
		p.setNext(tail);
		temp.setNext(p);
		tail.setPrevious(p);
		counter++;
	}

	public void remove(Plane p) { // remove element by reference
		if (counter == 0){
			return;
		}

		// remove references to node that is being deleted
		Plane prev = p.getPrevious();
		Plane next = p.getNext();
		prev.setNext(next);
		next.setPrevious(prev);
		counter--;
	}
	
	public int removeFirst() {  // remove front element and return timeInQueue

		Plane p = head.getNext();
		int t = p.getTimeInQueue();
		head.setNext(p.getNext());
		p = p.getNext();
		p.setPrevious(head);
		counter--;
		return t;
	}

	public boolean isEmpty() {
		if (head.getNext() == tail){
			return true;
		}
		else {
			return false;
		}
	}
	
	public void updateTimeInQueue(){
		Plane p = head;
		while (p.getNext() != tail){
			p = p.getNext();
			p.setTimeInQueue(p.getTimeInQueue() + 1);
		}
	}
	
	public int checkForCrashes() {
		int newCrashes = 0;
		int t;
		Plane p = head;
		while (p.getNext() != tail){
			p = p.getNext();
			t = p.getTimeInQueue();
			if (t > 3){
				remove(p);  // remove any crashed planes
				newCrashes++;
			}
		}
		return newCrashes;
	}

}

