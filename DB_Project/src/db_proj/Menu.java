package db_proj;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu
{
	static Scanner sc = new Scanner(System.in);
	static String input = "";

	public static void execute(String sql){


	}

	public static void addPassenger(){
		Passenger p = new Passenger();
		System.out.print("First Name: ");
		p.firstName = sc.nextLine();
		System.out.print("Last Name: ");
		p.lastName = sc.nextLine();
		System.out.print("Social Security Number: ### only");
		p.ssn = Integer.parseInt(sc.nextLine());
		System.out.print("Age: ");
		p.age = Integer.parseInt(sc.nextLine());
		System.out.print("Street: ");
		p.street = sc.nextLine();
		System.out.print("Apartment Number: ");
		p.aptNum = sc.nextLine();
		System.out.print("City: ");
		p.city = sc.nextLine();
		System.out.print("State: ");
		p.state = sc.nextLine();
		System.out.print("Zip-code: ");
		p.zip = Integer.parseInt(sc.nextLine());
		System.out.print("Phone #: ");
		p.telNum = sc.nextLine();
		System.out.print("Email: ");
		p.email = sc.nextLine();
		System.out.print("Flight Number: ");
		p.flightNum = sc.nextLine();
		System.out.print("Flight Date: (XXXX/XX/XX) (year,mon,day)");
		input = sc.nextLine();
		String[] date = input.split("/");
		Date fDate = new Date(Integer.parseInt(date[0]) - 1900, Integer.parseInt(date[1]) -1, Integer.parseInt(date[2]));
		p.flightDate = fDate;		   
		System.out.print("Reservation Status: ");
		p.reservationStat = sc.nextLine();
		System.out.print("Baggage Info: ");
		p.baggageInfo = sc.nextLine();
		System.out.print("Seat Number: ");
		p.seatNum = sc.nextLine();
		System.out.print("Flight Class: ");
		p.flightClass = sc.nextLine();
		System.out.print("Amount Paid : ");
		p.amountPaid = Integer.parseInt(sc.nextLine());
		System.out.println("\f");
		System.out.println("Summary");
		System.out.println("-----------------");
		System.out.println(p);
		System.out.println("1 - Save\n2 - Edit");
		input = sc.nextLine();
		if(input.equals("1"))
			try {
				SqlCommands.addPassenger(p);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Passenger could not be added.");
			}
		else if(input.equals("2"))
			System.out.println("Edit");




	}

	public static void passengerMenu(Passenger p, int ssn){

		System.out.println("Please select what you would like to edit");
		System.out.println("1 - First Name");
		System.out.println("2 - Last Name ");
		System.out.println("3 - SSN ");
		System.out.println("4 - Age");
		System.out.println("5 - Street ");
		System.out.println("6 - Apartment Number ");
		System.out.println("7 - City");
		System.out.println("8 - State ");
		System.out.println("9 - Zip ");
		System.out.println("10 - Telephone Number");
		System.out.println("11 - Email ");
		System.out.println("12 - Flight Number");
		System.out.println("13 - Flight Date");
		System.out.println("14 - Reservation Status ");
		System.out.println("15 - Baggage Info ");
		System.out.println("16 - Seat Number");
		System.out.println("17 - Flight Class");
		System.out.println("18 - Amount Paid");
		String choice = sc.nextLine();
		
		System.out.println("Enter in what you would like to change about choice " + choice);
		String change = sc.nextLine();

		if(choice.equals("1")){
			p.firstName = change;
		}
		else if(choice.equals("2")){
			p.lastName = change;
		}
		else if(choice.equals("3")){
			p.ssn = Integer.parseInt(change);
		}
		else if(choice.equals("4")){
			p.age = Integer.parseInt(change);
		}
		else if(choice.equals("5")){
			p.street = change;
		}
		else if(choice.equals("6")){
			p.aptNum = change;
		}
		else if(choice.equals("7")){
			p.city = change;
		}
		else if(choice.equals("8")){
			p.state = change;
			
		}
		else if(choice.equals("9")){
			p.zip = Integer.parseInt(change);
				
		}
		else if(choice.equals("10")){
			p.telNum = change;
		}
		else if(choice.equals("11")){
			p.email = change;
		}
		else if(choice.equals("12")){
			p.flightNum  = change;
		}
		else if(choice.equals("13")){
			
			String[] date = input.split("/");
			Date fDate = new Date(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
			p.flightDate = fDate;		   
			
		}
		else if(choice.equals("14")){

			p.reservationStat = change;
			
		}
		else if(choice.equals("15")){

			p.baggageInfo = change;											
		}
		else if(choice.equals("16")){
			p.seatNum = change;
		}
		else if(choice.equals("17")){
			p.flightClass = change;
		}
		else if(choice.equals("18")){
			p.amountPaid = Integer.parseInt(change);
				
		}
		try 
		{
			SqlCommands.updatePassenger(p, ssn);
		}
		catch(Exception e){
			System.out.println(e);
		}
		System.out.println(SqlCommands.getPassenger(ssn));
	}
	
	public static void updatePassenger(){
		
		do{
			
			
			//System.out.print("\n\f");
			System.out.println("Please select the way you want to select the passenger");
			System.out.println("1 - Search for specific passenger's SSN.");
			System.out.println("2 - Display list of all passengers' first/last name and SSN's from a flight number");
			System.out.println("0 - Go back to main menu.");
			input = sc.nextLine();

			if(input.equals("1")){
				/*	Need to write code to search given the SSN given SqlCommands info
			   	 *
				 */			
				
				
				System.out.println("You picked 1");
				
				// Request SSN
				System.out.print("Enter Social Security Number: ### only \n");
				int ssnIn = Integer.parseInt(sc.nextLine());
				
				//Search for SSN in Table
				Passenger p = SqlCommands.getPassenger(ssnIn);
				
				if (p.ssn == 0){
					System.out.println("Could not find passenger");
					
				}else{
					System.out.println("\fYou've selected the following passenger: ");
					System.out.println(p);
					
				}
				passengerMenu(p, ssnIn);
				
			}
			else if(input.equals("2")){
				/*	Need to access SqlCommands.java function that will find all first/last names and ssn's
				 * 	Then display them
				 * 	Then have the user input the one they want to select from the list
				 * 	
				 * 
				 */
				System.out.println("You picked 2");
				
				System.out.print("Enter in flight number: ### only");
				int fNum = Integer.parseInt(sc.nextLine());
			
				ArrayList<String> list = SqlCommands.getListOfPassengers(fNum);
				for(String s : list){
					System.out.println(s);
				}
				input= "1";
			}
		}
		while(!input.equals("0"));
		System.out.println("Back to main menu");

	}

	public static void addFlight(){
		Flight f = new Flight();
		System.out.print("Flight Number: ");
		f.flightNum = Integer.parseInt(sc.nextLine());
		System.out.print("Flight date (XX/XX/XXXX)(year,mon,day): ");
		input = sc.nextLine();
		String[] date = input.split("/");
		Date fDate = new Date(Integer.parseInt(date[0]) - 1900, Integer.parseInt(date[1]) -1, Integer.parseInt(date[2]));
		f.flightDate = fDate;

		System.out.print("Aircraft Type: ");
		f.aircraftType = sc.nextLine();
		System.out.print("Source City: ");
		f.sourceCity = sc.nextLine();
		System.out.print("Source State: ");
		f.sourceState = sc.nextLine();
		System.out.print("departure Hour: ");
		f.depHour = Integer.parseInt(sc.nextLine());
		System.out.print("departure Minute: ");
		f.depMin = Integer.parseInt(sc.nextLine());
		System.out.print("departure Date (XX/XX/XXXX) : ");

		input = sc.nextLine();
		String[] ddate = input.split("/");

		Date dDate = new Date(Integer.parseInt(date[0]) - 1900, Integer.parseInt(date[1]) -1, Integer.parseInt(date[2]));
		f.depDate = dDate;


		System.out.print("depination City: ");
		f.depCity = sc.nextLine();
		System.out.print("depination State: ");
		f.depState = sc.nextLine();
		System.out.print("Arrival Hour: ");
		f.arrivalHour = Integer.parseInt(sc.nextLine());
		System.out.print("Arrival Minute: ");
		f.arrivalMin = Integer.parseInt(sc.nextLine());
		System.out.print("Arrival Date: ");

		input = sc.nextLine();
		String[] adate = input.split("/");

		Date aDate = new Date(Integer.parseInt(date[0]) - 1900, Integer.parseInt(date[1]) -1, Integer.parseInt(date[2]));
		f.arrivalDate = aDate;


		System.out.print("Arrival City: ");
		f.arrivalCity = sc.nextLine();
		System.out.print("Arrival State: ");
		f.arrivalState = sc.nextLine();
		System.out.print("Number of Seats Booked: ");
		f.numSeatsBooked = Integer.parseInt(sc.nextLine());
		System.out.print("Passengers on Board: ");
		f.numPassengersOnBoard = Integer.parseInt(sc.nextLine());
		System.out.println("\f");
		System.out.println("Summary");
		System.out.println("-----------------");
		System.out.println(f);
		System.out.println("1 - Save\n2 - Edit");
		input = sc.nextLine();
		if(input.equals("1"))
			try {
				SqlCommands.addFlight(f);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else if(input.equals("2"))
			System.out.println("Edit");


	}

	

	public static void updateFlight(){


		do{
			System.out.print("\n\f");
			System.out.println("Please select the way you want to select your flight number");
			System.out.println("1 - Search for specific flight number.");
			System.out.println("2 - Display list of all flight numbers.");
			System.out.println("0 - Go back to main menu.");
			input = sc.nextLine();

			if(input.equals("1")){
				/*	Need to write code to search given the number
			   System.out.println("Enter Flight Number of the flight you wish to edit: ");
			   int toEditFlightNum = Integer.parseInt(sc.nextLine());
				 */
				System.out.println("You picked 1");
			}
			else if(input.equals("2")){
				/*	Need to access SqlCommands.java function that will find all flight numbers
				 * 	Then display them
				 * 	Then have the user input the one they want to select from the list
				 * 	
				 * 
				 */
				System.out.println("You picked 2");
			}
		}
		while(!input.equals("0"));
		System.out.println("Back to main menu");

	}





	public static void main(String[] args){

		updatePassenger();
/*
		do{
			System.out.println("\f");
			System.out.println("Welcome to Flight Manager Beta");
			System.out.println("1 - Add a new passenger.");
			System.out.println("2 - Edit existing passenger information.");
			System.out.println("3 - Add a new flight.");
			System.out.println("4 - Edit existing flight information.");
			System.out.println("0 - Exit.");
			input = sc.nextLine();

			if(input.equals("1"))
				addPassenger();
			else if(input.equals("2"))
				updatePassenger();
			else if(input.equals("3"))
				addFlight();
			else if(input.equals("4"))
				updateFlight();
		}
		while(!input.equals("0"));
		System.out.println("Program ended.");
*/
	}

}


