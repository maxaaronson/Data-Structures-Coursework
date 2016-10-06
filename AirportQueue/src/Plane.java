
public class Plane {
	private int timeInQueue;  // tracks how long a plan has been waiting in queue
	private Plane next;
	private Plane previous;
	
	public int getTimeInQueue() {
		return timeInQueue;
	}
	public void setTimeInQueue(int timeInAir) {
		this.timeInQueue = timeInAir;
	}
	public Plane getNext() {
		return next;
	}
	public void setNext(Plane next) {
		this.next = next;
	}
	public Plane getPrevious() {
		return previous;
	}
	public void setPrevious(Plane previous) {
		this.previous = previous;
	}
}
