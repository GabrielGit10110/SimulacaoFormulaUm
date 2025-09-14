package controller;

import java.util.concurrent.Semaphore;

import model.Car;
import utils.Util;

public class FormulaUmCtrl extends Thread {
	private final String teamName;
	private int car; // which car is running now (1 or 2)
	private Semaphore oneCarPerTeam;
	private Semaphore fiveCarsOnTheTrack;
	private Car[] results; // the array with all the car objects (Team, which car and the best lap time are stored here)
	private int position;  // the unique index of every thread
	private final int laps = 3;
	private final int trackSize = 200;
	private final int timeToWait = 1000; // change this to a lower value for a faster test ( - _ -)zZ
	
	public FormulaUmCtrl(String teamName, int car,
			Semaphore oneCarPerTeam, Semaphore fiveCarsOnTheTrack,
			Car[] results, int position) {
		this.teamName = teamName;
		this.car = car;
		this.oneCarPerTeam = oneCarPerTeam;
		this.fiveCarsOnTheTrack = fiveCarsOnTheTrack;
		this.results = results;
		this.position = position;
		
	}
	
	@Override
	public void run() {
		initializeCarObjects(); // the name is self explanatory ( ° - ° )
		criticalSession(this::startTraining); // handles the try catches
	}
	
	private void initializeCarObjects() {
		if (results[position] == null) {
			results[position] = new Car(teamName, car, 0);
		}
	}
	
	private void criticalSession(Runnable method) {
		try {
			oneCarPerTeam.acquire();
			Util.printWithTimeStamps("Equipe "+teamName+" escolheu o carro: "+car);
			
			Util.printWithTimeStamps("Equipe "+teamName+" esta esperando para comecar a corrida");
			fiveCarsOnTheTrack.acquire();
			method.run();

		} catch (Exception e) {
			System.err.println(e.getMessage());
			
		} finally {
			oneCarPerTeam.release();
			fiveCarsOnTheTrack.release();
			
		}
	}
	
	private void startTraining() {
		int currentLap = 0; // how many laps have been finished
		int currentDistance = 0; // how many meters have been traveled
		int velocity = 0; // random velocity in each step
		int minDistance = 20; 
		int maxDistance = 40; // how much distance can one car travel in one second
		double trackTime = 0.0;
		double bestTime = Double.MAX_VALUE; // using this because I need to start with a BIG number (first time
											// using It, thanks DeepSeek ( ° u °)_b
		
		Util.printWithTimeStamps("Equipe "+teamName+" - Carro: "+car+
				" Comecou a corrida!");
		while (currentLap < laps) {
			while (currentDistance < trackSize) {
				velocity = Util.genRandomInteger(minDistance, maxDistance);
				trackTime += 1.0 / velocity; // tracks time based on the distance traveled in one second 
													// (1 (second) / randomDistance),
													// so the faster the car runs, the faster It arrives at the
													// end of the lap
				currentDistance += velocity; // updates the distance traveled until the car reaches the end
				Util.sleep(timeToWait); // sleeps for 1 second
				
			}
			if (trackTime < bestTime) { // updates the best time if the time taken on the last lap 
				bestTime = trackTime;   // is shorter than the previous lap

			}

			Util.printWithTimeStamps("Equipe "+teamName+" - Carro: "+car+ " Terminou uma volta em "+trackTime);

			currentDistance = 0; // resets the distance to make a new lap
			trackTime = 0; // resets the trackTime 
			currentLap++;
		}
		results[position].setTeamName(teamName); // Mercedes for example
		results[position].setWhichCar(car); // 1 or 2
		results[position].setBestTime(bestTime); // sets the best time for this car
		
		Util.printWithTimeStamps("Equipe "+teamName+" - Carro: "+car
				+" Terminou a corrida com o melhor tempo de: "+ bestTime + " segundos");
		
	}

}
