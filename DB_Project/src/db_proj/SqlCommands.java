
import java.sql.*;
import java.util.ArrayList;

public class SqlCommands {
	
	static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDrive";  
	static final String DB_URL = "jdbc:oracle:thin:@oracle2.gl.umbc.edu:1521:GL";
	static final String USER = "cgadwa1"; //Please add your User ID for your Oracle Account
	static final String PASS = "babylips";  //Please add your Oracle Password

	public static String signIn(String username, String password){
		
		String uName = "";
		Connection conn = null;
		Statement stmt = null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Executing...");
			stmt = conn.createStatement();
			String sql = "select username from users where username = '" + username + "'";
			System.out.println(sql);
			ResultSet dbUsers = stmt.executeQuery(sql);
			
				dbUsers.next();
				System.out.println("boo");
				uName = dbUsers.getString("username");
				

			System.out.println(uName);
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
		
		return uName;
	}
	
	public static ArrayList<String> getListOfPassengers(){
		String fName = "";
		String lName = "";
		int ssn;
		ArrayList<String> passList = new ArrayList<String>();
		Connection conn = null;
		Statement stmt = null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Executing...");
			stmt = conn.createStatement();
			String sql = "select firstName, lastName, ssn from passenger";
			System.out.println(sql);
			ResultSet dbUsers = stmt.executeQuery(sql);
			
				while(dbUsers.next()){
				fName = dbUsers.getString("firstName");
				lName = dbUsers.getString("lastName");
				ssn = dbUsers.getInt("ssn");
				String s = fName +" "+ lName +" "+ ssn;
				passList.add(s);
				
				}

			
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
		
		return passList;
		
		
	}
	
	public static ArrayList<String> getListOfFlights(){
		
		int flightNumb;
		
		ArrayList<String> flightList = new ArrayList<String>();
		Connection conn = null;
		Statement stmt = null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Executing...");
			stmt = conn.createStatement();
			String sql = "select flightNum from flight";
			System.out.println(sql);
			ResultSet dbUsers = stmt.executeQuery(sql);
			
				while(dbUsers.next()){
				flightNumb = dbUsers.getInt("flightnum");
				String s = "" + flightNumb;
				flightList.add(s);
				
				}

			
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
		
		return flightList;
				
		
	}
	
	


	public static void main(String[] args){
	
		ArrayList<String> list = getListOfFlights();
			for(String s : list){
				System.out.println(s);
			}
	
	}


}