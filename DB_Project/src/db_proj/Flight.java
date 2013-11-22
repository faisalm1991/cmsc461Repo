package db_proj;

import java.sql.Date;


public class Flight {
	
	int flightNum;
	Date flightDate;
	String aircraftType;
	String sourceCity;
	String sourceState;
	int destHour;
	int destMin;
	Date destDate;
	String destCity;
	String destState;
	int arrivalHour;
	int arrivalMin;
	Date arrivalDate;
	String arrivalCity;
	String arrivalState;
	int numSeatsBooked;
	int numPassengersOnBoard;
	
	public Flight(){

	
	}
	
	public String toString(){
		
		return  this.flightNum
		+ "\n" +this.flightDate
		+ "\n" +this.aircraftType
		+ "\n" +this.sourceCity
		+ "\n" +this.sourceState
		+ "\n" +this.destHour
		+ "\n" +this.destMin
		+ "\n" +this.destDate
		+ "\n" +this.destCity
		+ "\n" +this.destState
		+ "\n" +this.arrivalHour
		+ "\n" +this.arrivalMin
		+ "\n" +this.arrivalDate
		+ "\n" +this.arrivalCity
		+ "\n" +this.arrivalState
		+ "\n" +this.numSeatsBooked
		+ "\n" +this.numPassengersOnBoard;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
