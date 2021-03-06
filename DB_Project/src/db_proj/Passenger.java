package db_proj;

import java.sql.Date;
import java.util.*;

public class Passenger {

	public String firstName;
	public String lastName;
	public int ssn = 0;
	public int age;
	public String street;
	public String aptNum;
	public String city;
	public String state;
	public int zip;
	public String telNum;
	public String email;
	public String flightNum;
	public Date flightDate;
	public String reservationStat;
	public String baggageInfo;
	public String seatNum;
	public String flightClass;
	public double amountPaid;
	
	public Passenger(){
	
	}
	
	public String toString(){
		String s = "";
		s += "First Name:               " + this.firstName + "\n";
		s += "Last Name:                " + this.lastName + "\n";
		s += "Social Security Number:   " + this.ssn + "\n";
		s += "Age:                      " + this.age + "\n";
		s += "Street:                   " + this.street + "\n";
		s += "Apartment Number:         " + this.aptNum + "\n";
		s += "City:                     " + this.city + "\n";
		s += "State:                    " + this.state + "\n";
		s += "Zip:                      " + this.zip + "\n";
		s += "Phone Number:             " + this.telNum + "\n";
		s += "Email:                    " + this.email + "\n";
		s += "Flight Number:            " + this.flightNum + "\n";
		s += "Flight Date:              " + (this.flightDate) + "\n";		
		s += "Reservation Status:       " + this.reservationStat + "\n";
		s += "Baggage Information:      " + this.baggageInfo + "\n";
		s += "Seat Number:              " + this.seatNum + "\n";
		s += "Flight Class:             " + this.flightClass + "\n";
		s += "Amount Paid:              " + this.amountPaid + "\n";
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
