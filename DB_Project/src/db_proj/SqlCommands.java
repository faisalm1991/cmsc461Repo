package db_proj;

import java.sql.*;
import java.util.ArrayList;

public class SqlCommands {
	
	static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDrive";  
	static final String DB_URL = "jdbc:oracle:thin:@oracle2.gl.umbc.edu:1521:GL";
	static final String USER = "cgadwa1"; //Please add your User ID for your Oracle Account
	static final String PASS = "babylips";  //Please add your Oracle Password

	public ArrayList<String> getListOfUsers(){
		
		ArrayList<String> usersList = new ArrayList<String>();
		Connection conn = null;
		Statement stmt = null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Executing...");
			stmt = conn.createStatement();
			ResultSet dbUsers=  stmt.executeQuery("SELECT USERNAME, PASSWORD from USERS");
			usersList = new ArrayList<String>();
			while(dbUsers.next()){
				usersList.add(dbUsers.getString("username"));
		    }
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
		
		return usersList;
	}
	
	public ArrayList getListOfPassengers(){
		
		
		return null;
		
		
	}
	
	public ArrayList getListOfFlights(){
		
		
		return null;
		
		
	}
	
	
}
