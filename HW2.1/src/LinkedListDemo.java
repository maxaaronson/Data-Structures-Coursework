
public class LinkedListDemo {

	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		
		list.addToEnd(5);
		list.addToEnd(7);
		list.addToEnd(0);
		list.addToEnd(4);
		list.addToEnd(7);
		list.addToEnd(3);
		list.addToEnd(90);
		list.addToEnd(20);
		list.addToEnd(-5);
		list.addToEnd(100);
		
		System.out.println(list);
		
		list.removeLastElement();
		
		System.out.println(list);
		
		list.removeLastElement();
		list.removeLastElement();
		
		System.out.println(list);
		
		list.addToEnd(7);
		
		System.out.println(list);

	}

}
