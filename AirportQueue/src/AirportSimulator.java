/*
 * Max Aaronson
 * CS342
 * 11/15/15
 * Project 3
 */

import java.util.Random;

public class AirportSimulator {
	
	final int RUNTIME = 10000;  // length of simulation
	final int MAXTIMEINAIR = 5;  // time until plane runs out of fuel
	final int TAKEOFFTIME = 4;  //  time it takes a plane to take off
	final int LANDTIME = 3;  //  time it takes a plane to land
	final float LANDPROBABILITY = .5f;  // probability new plane is added to landing queue
	final float TAKEOFFPROBABILITY = .5f;  // probability new plane is added to take off queue
	private int waitTime = 0;  // time that is left until runway is free again
	private int crashes = 0;
	private int takeoffs = 0;
	private int landings = 0;
	private int timeInLandingQueue = 0;
	private int timeInTakeOffQueue = 0;

	public static void main(String[] args) {
		
		AirportSimulator a = new AirportSimulator();
		a.run();

	}
	
	public void run(){
		Queue landingQueue = new Queue();
		Queue takeOffQueue = new Queue();
		
		Random r = new Random();
		float random = 0;
		
		for (int i = 0; i < RUNTIME; i++){
			
			// randomly decide for each queue if a new plane will be added
			random = r.nextFloat();  // generates a float between 0 and 1.0
			
			if (random <= LANDPROBABILITY){
				landingQueue.add();  // add new plane to the back of the queue
				
			}
			random = r.nextFloat();
			if (random <= TAKEOFFPROBABILITY){
				takeOffQueue.add();  // add new plane to the back of the queue

			}
			
			//  update the time planes have been sitting in both queues
			landingQueue.updateTimeInQueue();
			takeOffQueue.updateTimeInQueue();
			
			// check if any planes just crashed and update crash counter
			crashes += landingQueue.checkForCrashes();
			
			// check if the runway is in use
			if (isRunwayFree()){
				
				// check for any planes in landing queue
				if (!landingQueue.isEmpty()){
					// remove plane from front of queue, i.e. plane starts to land
					timeInLandingQueue += landingQueue.removeFirst();
					landings ++;
					
					// update wait time for runway
					waitTime = LANDTIME;
				}
				// check for any planes in takeoff queue
				else if (!takeOffQueue.isEmpty()){
					// remove plane from front of queue, i.e. plane starts to take off
					timeInTakeOffQueue += takeOffQueue.removeFirst();
					takeoffs ++;
					
					// update wait time for runway
					waitTime = TAKEOFFTIME;
				}
			}
			
		}
		
		double takeOffAvg = (double)timeInTakeOffQueue/(double)takeoffs;
		double landingAvg = (double)timeInLandingQueue/(double)landings;
		
		System.out.println("Simulation Complete!");
		System.out.println("Probability of new plane in takeoff queue: " + TAKEOFFPROBABILITY);
		System.out.println("Probability of new plane in landing queue: " + LANDPROBABILITY);
		System.out.println("Time to take off: " + TAKEOFFTIME +  " mins");
		System.out.println("Time to land: " + LANDTIME +  " mins");
		System.out.println("Maximum time in air before crash: " + MAXTIMEINAIR + " mins");
		System.out.println("Length of Simulation: " + RUNTIME + " mins");
		System.out.println("Results:");
		System.out.println("Total Landings: " + landings);
		System.out.println("Total Takeoffs: " + takeoffs);
		System.out.println("Total crashes: " + crashes);
		System.out.format("Average time in takeoff queue: %.2f mins \n", takeOffAvg);
		System.out.format("Average time in landing queue: %.2f mins \n", landingAvg);
		System.out.println("-----------------------------------------------------");
	}

	private boolean isRunwayFree() {
		if (waitTime == 0){
			return true;
		}
		else {
			waitTime--;
			return false;
		}
	}

	

}
