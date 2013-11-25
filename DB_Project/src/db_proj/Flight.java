//package db_proj;

import java.sql.Date;


public class Flight {
	
	int flightNum = 0;
	Date flightDate;
	String aircraftType;
	String sourceCity;
	String sourceState;
	int depHour;
	int depMin;
	Date depDate;
	String depCity;
	String depState;
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
		
		return 	 "Flight Number:       " + this.flightNum
		+ "\n" + "Flight Date:         " + this.flightDate
		+ "\n" + "Aircraft Type:       " + this.aircraftType
		+ "\n" + "Source City:         " + this.sourceCity
		+ "\n" + "Source State:        " + this.sourceState
		+ "\n" + "Departure Hour:      " + this.depHour
		+ "\n" + "Departure Minute:    " + this.depMin
		+ "\n" + "Departure Date:      " + this.depDate
		+ "\n" + "Departure City:      " + this.depCity
		+ "\n" + "Departure State:     " + this.depState
		+ "\n" + "Arrival Hour:        " + this.arrivalHour
		+ "\n" + "Arrival Min:         " + this.arrivalMin
		+ "\n" + "Arrival Date:        " + this.arrivalDate
		+ "\n" + "Arrival City:        " + this.arrivalCity
		+ "\n" + "Arrival State:       " + this.arrivalState
		+ "\n" + "Seats Booked:        " + this.numSeatsBooked
		+ "\n" + "Passengers On Board: " + this.numPassengersOnBoard;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
