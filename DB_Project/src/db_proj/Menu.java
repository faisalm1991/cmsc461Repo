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
	   f.flightNum = sc.nextLine();
	   System.out.print("Flight Date: ");
	   f.flightDate = sc.nextLine();
	   System.out.print("Aircraft Type: ");
	   f.aircraftType = sc.nextLine();
	   System.out.print("Source City: ");
	   f.sourceCity = sc.nextLine();
	   System.out.print("Source State: ");
	   f.sourceState = sc.nextLine();
	   System.out.print("Destination Hour: ");
	   f.destHour = sc.nextLine();
	   System.out.print("Destination Minute: ");
	   f.destMin = sc.nextLine();
	   System.out.print("Destination Date: ");
	   f.destDate = sc.nextLine();
	   System.out.print("Destination City: ");
	   f.destCity = sc.nextLine();
	   System.out.print("Destination State: ");
	   f.destState = sc.nextLine();
	   System.out.print("Arrival Hour: ");
	   f.arrivalHour = sc.nextLine();
	   System.out.print("Arrival Minute: ");
	   f.arrivalMin = sc.nextLine();
	   System.out.print("Arrival Date: ");
	   f.arrivalDate = sc.nextLine();
	   System.out.print("Arrival City: ");
	   f.arrivalCity = sc.nextLine();
	   System.out.print("Arrival State: ");
	   f.arrivalState = sc.nextLine();
	   System.out.print("Number of Seats Booked: ");
	   f.numSeatsBooked = sc.nextLine();
	   System.out.print("Passengers on Board: ");
	   f.numPassengersOnBoard = sc.nextLine();
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

	   System.out.print("Flight Number: ");
	   input = sc.nextLine();
	   
	   execute("update flight "
	   		+ " set flightDate = " 
			+ "aircraftType =  "
	   		+ "source "
	   		+ " "
	   		+ " "
	   		+ " "
	   		+ " "
	   		+ " "
	   		+ " "
	   		+ " "
	   		+ " "
	   		+ " "
	   		+ " "
	   		+ " "
	   		+ " "
	   		+ " "
	   		+ " "
	   		
	   		+ " where flightNum = " + input);
	 
	   /*
	   flightDate date not null,
	   aircraftType varchar(50) not null,
	   sourceCity varchar(50) not null,
	   sourceState varchar(2) not null,
	   destHour number (2,0) not null,
	   destMin number (2,0) not null,
	   destDate date not null,
	   destCity varchar(50) not null,
	   destState varchar(2) not null,
	   arrivalHour number(2,0) not null,
	   arrivalMin number(2,0) not null,
	   arrivalDate date not null,
	   arrivalCity varchar(50) not null,
	   arrivalState varchar(2) not null,
	   numSeatsBooked number(3,0) not null,
	   numPassengersOnBoard number (3,0) not null,
   
   */
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


