package db_proj;

public class Passenger {
// random text
	public String firstName;
	public String lastName;
	public String ssn;
	public String age;
	public String street;
	public String aptNum;
	public String city;
	public String state;
	public String zip;
	public String telNum;
	public String email;
	public String flightNum;
	public String flightDate;
	public String reservationStat;
	public String baggageInfo;
	public String seatNum;
	public String flightClass;
	public String amountPaid;
	
	public Passenger(){
		
	}
	
	public String toString(){
		String s = "";
		s += "First Name:" + this.firstName + "\n";
		s += "Last Name:" + this.lastName + "\n";
		s += "First Name:" + this.ssn + "\n";
		s += "Age: " + this.age + "\n";
		s += "Street" + this.street + "\n";
		s += "Apartment Number: " + this.aptNum + "\n";
		s += "City: " + this.city + "\n";
		s += "State: " + this.state + "\n";
		s += "Zip: " + this.zip + "\n";
		s += "Phone Number: " + this.telNum + "\n";
		s += "Email: " + this.email + "\n";
		s += "Flight Number: " + this.flightNum + "\n";
		s += "Flight Date: " + this.flightDate + "\n";
		s += "Reservation Status: " + this.reservationStat + "\n";
		s += "Baggage Information: " + this.baggageInfo + "\n";
		s += "Seat Number: " + this.seatNum + "\n";
		s += "Flight Class" + this.flightClass + "\n";
		s += "Amount Paid: " + this.amountPaid + "\n";
		return s;
		
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Passenger Petey = new Passenger();
		Petey.city = "Lava City";
		System.out.println(Petey);
	}

}
