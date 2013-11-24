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
		System.out.print("Flight Date: (XX/XX/XXXX)");
		input = sc.nextLine();
		String[] date = input.split("/");
		Date fDate = new Date(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
		p.flightDate = fDate;		   
		//p.flightDate = sc.nextLine();

		System.out.print("Reservation Status: ");
		p.reservationStat = sc.nextLine();
		System.out.print("Baggage Info: ");
		p.baggageInfo = sc.nextLine();
		System.out.print("Seat Number: ");
		p.seatNum = sc.nextLine();
		System.out.print("Flight Class: ");
		p.flightClass = sc.nextLine();
		System.out.print("Amount Paid : ");
		p.amountPaid = sc.nextDouble();
		System.out.println("\f");
		System.out.println("Summary");
		System.out.println("-----------------");
		System.out.println(p);
		System.out.println("1 - Save\n2 - Edit");
		input = sc.nextLine();
		if(input.equals("1"))
			System.out.println("Saved");
		else if(input.equals("2"))
			System.out.println("Edit");




	}

	public static void updatePassenger(){
		do{
			System.out.print("\n\f");
			System.out.println("Please select the way you want to select the passenger");
			System.out.println("1 - Search for specific passenger's SSN.");
			System.out.println("2 - Display list of all passengers' first/last name and SSN's.");
			System.out.println("0 - Go back to main menu.");
			input = sc.nextLine();

			if(input.equals("1")){
				/*	Need to write code to search given the SSN given SqlCommands info
			   	 *
				 */			
				
				System.out.println("You picked 1");
				
				// Request SSN
				System.out.print("Enter Social Security Number: ### only");
				int ssnIn = Integer.parseInt(sc.nextLine());
				
				//Search for SSN in Table

				
			}
			else if(input.equals("2")){
				/*	Need to access SqlCommands.java function that will find all first/last names and ssn's
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

	public static void addFlight(){
		Flight f = new Flight();
		System.out.print("Flight Number: ");
		f.flightNum = Integer.parseInt(sc.nextLine());
		System.out.print("Flight date (XX/XX/XXXX)(year,mon,day): ");
		input = sc.nextLine();
		String[] date = input.split("/");
		Date fDate = new Date(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
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

		Date dDate = new Date(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
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

		Date aDate = new Date(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
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
			System.out.println("Saved");
		else if(input.equals("2"))
			System.out.println("Edit");


	}

	/*
	 * Commenting out because Faze says sql stuff is moving to SqlCommands.java
	 * 
   public static void updateFlight(){

	   Flight f = new Flight();

	   //ask flight number 

	   System.out.print("Flight Number: ");
	   f.flightNum = Integer.parseInt(sc.nextLine());

	   //using the flight number, gather info about flight and store in flight object f
	   Connection dbConnection = null;
	   Statement stmt = null;
	   try {
		dbConnection = DriverManager.getConnection(DB_URL, USER, PASS);
		stmt = dbConnection.createStatement();
		String sql = "SELECT * from flight where flightNum = " + f.flightNum;
		ResultSet rs = stmt.executeQuery(sql);

		f.flightNum = rs.getInt("flightNum");
		f.flightDate = rs.getDate("flightDate");
		f.aircraftType = rs.getString("aircraftType");
		f.sourceCity =rs.getString("sourceCity");
		f.sourceState = rs.getString("sourceState");
		f.depHour =rs.getInt("depHour");
		f.depMin = rs.getInt("depMin");
		f.depDate = rs.getDate("depDate");
		f.depCity = rs.getString("depCity");
		f.depState =rs.getString("depState");
		f.arrivalHour = rs.getInt("arrivalHour");
		f.arrivalMin =rs.getInt("arrivalMin");
		f.arrivalDate = rs.getDate("arrivalDate");
		f.arrivalCity = rs.getString("arrivalCity");
		f.arrivalState = rs.getString("arrivalState");
		f.numSeatsBooked = rs.getInt("numSeatsBooked");
		f.numPassengersOnBoard = rs.getInt("numPassengersOnBoard");


	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}


	   //ask user what they want to update and store values in flight object f


	   //update info for flight in SQL database

		PreparedStatement preparedStatement = null;

		String updateTableSQL = "UPDATE flight "
				+ "SET flightNum = ?"
				+ ", flightDate = ?  "
				+ ", aircraftType = ?"
				+ ", sourceCity = ?"
				+ ", sourceState = ?"
				+ ", depHour = ?"
				+ ", depMin = ?"
				+ ", depDate = ?"
				+ ", depState = ?"
				+ ", arrivalHour = ?"
				+ ", arrivalMin = ?"
				+ ", arrivalDate = ?"
				+ ", arrivalCity = ?"
				+ ", arrivalState = ?"
				+ ", numSeatsBooked = ?"
				+ ", numPassengersOnBoard = ?"
                + " WHERE USER_ID = ?";


		try {

			preparedStatement = dbConnection.prepareStatement(updateTableSQL);

			preparedStatement.setInt(1, f.flightNum);
			preparedStatement.setDate(2, f.flightDate);
			preparedStatement.setString(3, f.aircraftType);
			preparedStatement.setString(4, f.sourceCity);
			preparedStatement.setString(5, f.sourceState);
			preparedStatement.setInt(6, f.depHour);
			preparedStatement.setInt(7, f.depMin);
			preparedStatement.setDate(8, f.depDate);
			preparedStatement.setString(9, f.depCity);
			preparedStatement.setString(10, f.depState);
			preparedStatement.setInt(11, f.arrivalHour);
			preparedStatement.setInt(12, f.arrivalMin);
			preparedStatement.setDate(13, f.arrivalDate);
			preparedStatement.setString(14, f.arrivalCity);
			preparedStatement.setString(15, f.arrivalState);
			preparedStatement.setInt(16, f.numSeatsBooked);
			preparedStatement.setInt(17, f.numPassengersOnBoard);


			// execute insert SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("Record is inserted into DBUSER table!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}


   }*/

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

	}

}


