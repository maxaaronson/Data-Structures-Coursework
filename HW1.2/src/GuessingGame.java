import java.util.Random;
import java.util.Scanner;


public class GuessingGame {
	
	static int secretNumber;
	static int currentGuess;
	static int numGuesses;
	final static int LOWER_BOUND = 1;
	final static int HIGHER_BOUND = 1000;
	static Random random;
	static Scanner scan;
	static boolean isFound;
	

	public static void main(String[] args) {
		
		numGuesses = 0;
		currentGuess = 0;
		isFound = false;
		random = new Random();
		scan = new Scanner(System.in);
		
		secretNumber = random.nextInt(HIGHER_BOUND) + LOWER_BOUND; // excludes 0 and includes 1000
		System.out.println("I'm thinking of a number between "
				+ LOWER_BOUND + " and " + HIGHER_BOUND);
		
		
		while (!isFound){
			
			try{	
				currentGuess = scan.nextInt();
			
				if (!isValidGuess(currentGuess)){
					System.out.println("That was not a valid guess");
					numGuesses++;
				}
				else {
					int i = isCorrectGuess(currentGuess);
					numGuesses++;
					if (i == -1){
						System.out.print("Guess was too low\n");
					}
					else if (i == 1){
						System.out.print("Guess was too high\n");
					}
					else if (i == 0){
						System.out.println("That's Correct!");
						System.out.println("That took " + numGuesses + " turns");
						System.out.println("Thanks for playing!");
						System.exit(0);
						}
					}
				}
			catch (Exception e){
				System.out.println("That was not a valid guess");
				scan.nextLine();
			}
			
			
		}
	}


	private static int isCorrectGuess(int currentGuess2) {
		if (currentGuess < secretNumber){
			return -1;
		}
		else if (currentGuess > secretNumber){
			return 1;
		}
		else {
			return 0;
		}
	}


	private static boolean isValidGuess(int currentGuess2) {
		if (currentGuess < 1 || currentGuess > 1000){
		return false;
		}
		else {
			return true;
		}
	}

}
