package model;

public class Car {
	
	private String teamName;
	private int whichCar;
	private double bestTime;

	public Car(String teamName, int whichCar, double bestTime) {
		this.teamName = teamName;
		this.whichCar = whichCar;
		this.bestTime = bestTime;
	}
	
	public String getTeamName() {
		return teamName;
		
	}
	
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	public int getWhichCar() {
		return whichCar;
	}
	
	public void setWhichCar(int whichCar) {
		this.whichCar = whichCar;
	}
	
	public double getBestTime() {
		return bestTime;
	}
	
	public void setBestTime(double bestTime) {
		this.bestTime = bestTime;
	}
	
}
