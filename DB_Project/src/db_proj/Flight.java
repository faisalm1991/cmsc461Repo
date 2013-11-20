package db_proj;

public class Flight {
	
	String flightNum;
	String flightDate;
	String aircraftType;
	String sourceCity;
	String sourceState;
	String destHour;
	String destMin;
	String destDate;
	String destCity;
	String destState;
	String arrivalHour;
	String arrivalMin;
	String arrivalDate;
	String arrivalCity;
	String arrivalState;
	String numSeatsBooked;
	String numPassengersOnBoard;
	
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
