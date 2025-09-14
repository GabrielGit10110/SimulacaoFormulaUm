package view;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

import controller.FormulaUmCtrl;
import model.Car;

public class FormulaUm {
	
	private static final String[] teamNames = {
			"Mercedes", "Ferrari", "Mazda",
			"Red Bull Racing", "Alpine",
			"McLaren", "Williams"
			
	};
	
	public static Car[] results = new Car[14]; // creates 14 car objects in an array

	public static void main(String[] args) {
		ArrayList<FormulaUmCtrl> threads = new ArrayList<>();
		Semaphore[] oneCarPerTeam = new Semaphore[7];
		Semaphore fiveCarsOnTheTrack = new Semaphore(5); // one semaphore with 5 permissions
		int position = 0;
		
		for (int i = 0; i < oneCarPerTeam.length; i++) {
			oneCarPerTeam[i] = new Semaphore(1); // I'm going to create a new semaphore for each of the teams
			
		}
		
		for (int teams = 0; teams < teamNames.length; teams++) {
			for (int cars = 1; cars <= 2; cars++) {
				FormulaUmCtrl newTeam = new FormulaUmCtrl(
								teamNames[teams], 
								cars,
								oneCarPerTeam[teams], 
								fiveCarsOnTheTrack,
								results,
								position
								
						);
				threads.add(newTeam);
				newTeam.start();
				position++;
				
			}
		}
		
		waitForThreadsToEnd(threads); // didn't know I needed that, makes sense
		sortResults(results); // sort all the cars based on their best times
		printPodium(results); // prints the podium

	}
	
	private static void waitForThreadsToEnd(ArrayList<FormulaUmCtrl> threads) {
		for (FormulaUmCtrl thread : threads) {
			try {
				thread.join();

			} catch (Exception e) {
				System.err.println(e.getMessage());
				
			}
		}

	}
	
	private static void sortResults(Car[] results) {
		Car aux = new Car("", 0, 0);
		for (int i = 0; i < results.length; i++) {
			for (int j = (i+1); j < results.length; j++) {
				if (results[i].getBestTime() > results[j].getBestTime()) {
					aux = results[i];
					results[i] = results[j];
					results[j] = aux;

				}
				
			}
		}
		
	}
	
	private static void printPodium(Car[] results) {
		StringBuilder builder = new StringBuilder("\n=== RESULTADO FINAL d_( ° u *)_b ===\n\n");
		int position = 1;
		String adjustTime = "";
		for (Car c : results) {
			adjustTime = String.format("%.4f", c.getBestTime()); // adjust time to -> 0.0004
			builder.append("Equipe ").append(c.getTeamName()).append(" com o carro: ");
			builder.append(c.getWhichCar()).append(" - chegou em ").append(position);
			builder.append("° lugar").append(" com o tempo de: ").append(adjustTime);
			builder.append(" segundos");

			if (position == 1) {
				builder.append(" Vencendo a corrida! Parabens\n");

			} else {
				builder.append("\n");
				
			}

			position++;

		}
		builder.append("\n ========= FIM DA CORRIDA (GRACAS AO BOM DEUS) ========= ");
		System.out.println(builder.toString());
		
	}

}
