package db_proj;
import java.sql.*;
public class jdbcExample
{
   static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDrive";  
   static final String DB_URL = "jdbc:oracle:thin:@oracle2.gl.umbc.edu:1521:GL";
   static final String USER = "cgadwa1"; //Please add your User ID for your Oracle Account
   static final String PASS = "babylips";  //Please add your Oracle Password
   
   public void addPassenger(){
	   
	   Connection conn = null;
	   Statement stmt = null;
	   try
	   {
	      Class.forName("oracle.jdbc.driver.OracleDriver");
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	      System.out.println("Creating table in given database...");
	      stmt = conn.createStatement();
	            String sql = "insert into passenger (firstName, lastName, ssn, age, street, aptNum, city, state, zip, telNum, email, flightNum, flightDate, reservationStat, baggageInfo, seatNum, flightClass, amountPaid)" 
	      +"values ('Chitra', 'Gadwal', '123606790', '22', '13829 Bison Court', 'N/A', 'Silver Spring', 'MD', '20906', '3017931034', 'cgadwa1@umbc.edu', '66666', TO_DATE( '21-DEC-2016', 'DD-MON-YYYY' ), 'Confirmed', '30', '012E', 'Economy', '400')"; 
	      stmt.executeUpdate(sql);
	      System.out.println("Added a new passenger");
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
	   System.out.println("Goodbye!"); 
	   
   }
   public void updatePassenger(){
	   
	   
   }
      
   public void addFlight(){
	   
	   
   }
   public void updateFlight(){
	   
	   
   }
   
   
   
   
   public static void main(String[] args) 
   {
	   
	   Flight newFlight = new Flight();
	   
	   newFlight.aircraftType = "type";
	   	   
}

}


