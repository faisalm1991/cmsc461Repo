package db_proj;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class Menu
{
   static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDrive";  
   static final String DB_URL = "jdbc:oracle:thin:@oracle2.gl.umbc.edu:1521:GL";
   static final String USER = "cgadwa1"; //Please add your User ID for your Oracle Account
   static final String PASS = "babylips";  //Please add your Oracle Password
   static Scanner sc = new Scanner(System.in);
   static String input;
   
   public static void execute(String sql){
	   
	   
	   Connection conn = null;
	   Statement stmt = null;
	   try
	   {
	      Class.forName("oracle.jdbc.driver.OracleDriver");
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	      System.out.println("Executing...");
	      stmt = conn.createStatement();
	      stmt.executeUpdate(sql);
	      System.out.println("Action done!");
	   }catch(SQLException se){
	      se.printStackTrace();
	   }catch(Exception e){
	     e.printStackTrace();
	   }finally{
	       try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	      }
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }
	   }
	   
   }
   
   public static void addPassenger(){
		//Passenger p = new Passenger();
	   System.out.print("First Name: ");
	   input = sc.nextLine();
	   
	   
	   
   }
   
   public static void updatePassenger(){
	   
	   
   }
      
   public static void addFlight(){
		Flight f = new Flight();
	   System.out.print("Flight Number: ");
	   f.flightNum = sc.nextInt();
	   System.out.print("Flight date (XX/XX/XXXX): ");
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
	   System.out.print("Destination Hour: ");
	   f.destHour = sc.nextInt();
	   System.out.print("Destination Minute: ");
	   f.destMin = sc.nextInt();
	   System.out.print("Destination Date (XX/XX/XXXX) : ");
	    
	   input = sc.nextLine();
	   String[] ddate = input.split("/");
	   
	   Date dDate = new Date(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
	   f.destDate = dDate;
	   
	   
	   System.out.print("Destination City: ");
	   f.destCity = sc.nextLine();
	   System.out.print("Destination State: ");
	   f.destState = sc.nextLine();
	   System.out.print("Arrival Hour: ");
	   f.arrivalHour = sc.nextInt();
	   System.out.print("Arrival Minute: ");
	   f.arrivalMin = sc.nextInt();
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
	   f.numSeatsBooked = sc.nextInt();
	   System.out.print("Passengers on Board: ");
	   f.numPassengersOnBoard = sc.nextInt();
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
   public static void updateFlight(){
	   
	   Flight f = new Flight();
	   
	   //ask flight number 
	   
	   System.out.print("Flight Number: ");
	   f.flightNum = sc.nextInt();
	   
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
		f.destHour =rs.getInt("destHour");
		f.destMin = rs.getInt("destMin");
		f.destDate = rs.getDate("destDate");
		f.destCity = rs.getString("destCity");
		f.destState =rs.getString("destState");
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
				+ ", destHour = ?"
				+ ", destMin = ?"
				+ ", destDate = ?"
				+ ", destState = ?"
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
			preparedStatement.setInt(6, f.destHour);
			preparedStatement.setInt(7, f.destMin);
			preparedStatement.setDate(8, f.destDate);
			preparedStatement.setString(9, f.destCity);
			preparedStatement.setString(10, f.destState);
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
	   System.out.println("Program ended");
	   

	   
	   	   
   }

}


