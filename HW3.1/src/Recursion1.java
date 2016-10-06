/*
 * Max Aaronson
 * CS342
 * HW3
 * Problem 1
 */


public class Recursion1 {

	public static void main(String[] args) {
		
		Recursion1 r = new Recursion1();
		r.run();

	}
	
	public void run(){
		asteriskRecurse(4, 1);  // n is first input.  The other is a counter 
	}

	public void asteriskRecurse(int num, int counter) {
		// counter will go from 1 up to num recursively
		printAsterisks(counter);
		if (num == counter){
			printAsterisks(counter);
		}
		else {
			asteriskRecurse(num, counter+1);
			printAsterisks(counter);
		}
	}
	
	public void printAsterisks(int counter){  // prints input number of *'s on a line
		for (int i = 0; i<counter; i++){
			System.out.print("*");
		}
		System.out.print("\n");
	}

}
