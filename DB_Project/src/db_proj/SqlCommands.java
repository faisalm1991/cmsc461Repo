package db_proj;
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
	
	public static ArrayList<String> getListOfPassengers(int fNum){
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
			String sql = "select firstName, lastName, ssn from passenger where flightNum = '" + fNum + "'";
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
	
	public static Passenger getPassenger(int ssn){
		Passenger p = new Passenger();
		Connection conn = null;
		Statement stmt = null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Executing...");
			stmt = conn.createStatement();
			String sql = "select firstName, lastName, ssn, age, street, aptNum, city, state, zip, telNum, email, flightNum, flightDate, reservationStat, baggageInfo, seatNum, flightClass, amountPaid from passenger where ssn = "+"'"+ssn+"'";
			
			ResultSet dbUsers = stmt.executeQuery(sql);
			
				while(dbUsers.next()){
					
					p.firstName  = dbUsers.getString("firstName");
					p.lastName = dbUsers.getString("lastName");
					p.ssn = dbUsers.getInt("ssn");
					p.age = dbUsers.getInt("age");
					p.street = dbUsers.getString("street");
					p.aptNum = dbUsers.getString("aptNum");
					p.city = dbUsers.getString("city");
					p.state = dbUsers.getString("state");
					p.zip = dbUsers.getInt("zip");
					p.telNum = dbUsers.getString("telNum");
					p.email = dbUsers.getString("email");
					p.flightNum = dbUsers.getString("flightNum");
					p.flightDate = dbUsers.getDate("flightDate");
					p.reservationStat = dbUsers.getString("reservationStat");
					p.baggageInfo = dbUsers.getString("baggageInfo");
					p.seatNum = dbUsers.getString("seatNum");
					p.flightClass = dbUsers.getString("flightClass");
					p.amountPaid = dbUsers.getDouble("amountPaid");
				
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
		
		
		
		
		return p;
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
	
	
	public static void addPassenger(Passenger p) throws SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
			
			String insertTableSQL = "INSERT INTO PASSENGER"
					+ "(firstName, lastName, ssn, age, street, aptNum, city, "
					+ "state, zip, telNum,  email, flightNum, flightDate, "
					+ "reservationStat, baggageInfo, seatNum, flightClass, amountPaid) VALUES"
					+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
			
			try {
				
				dbConnection = DriverManager.getConnection(DB_URL, USER, PASS);
				preparedStatement = dbConnection.prepareStatement(insertTableSQL);
	 
				preparedStatement.setString(1, p.firstName);
				preparedStatement.setString(2, p.lastName);
				preparedStatement.setInt(3, p.ssn);
				preparedStatement.setInt(4, p.age);
				preparedStatement.setString(5, p.street);
				preparedStatement.setString(6, p.aptNum);
				preparedStatement.setString(7, p.city);
				preparedStatement.setString(8, p.state);
				preparedStatement.setInt(9, p.zip);
				preparedStatement.setString(10, p.telNum);
				preparedStatement.setString(11, p.email);
				preparedStatement.setString(12, p.flightNum);
				preparedStatement.setDate(13, p.flightDate);
				preparedStatement.setString(14, p.reservationStat);
				preparedStatement.setString(15, p.baggageInfo);
				preparedStatement.setString(16, p.seatNum);
				preparedStatement.setString(17, p.flightClass);
				preparedStatement.setDouble(18, p.amountPaid);
				
				// execute insert SQL stetement
				preparedStatement.executeUpdate();
	 
				System.out.println("Record is inserted into PASSENGER table!");
			
			} catch (SQLException e) {
				
				System.out.println(e.getMessage());
		
			} finally {
				
				if (preparedStatement != null) {
					preparedStatement.close();
				}
	 
				if (dbConnection != null) {
					dbConnection.close();
				}
				
			}
		
	}
	
	
	public static void updatePassenger(Passenger p, int sNum) throws SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		
		String insertTableSQL = "UPDATE PASSENGER"
					+ "SET firstName = ?, lastName = ?, ssn = ?, age = ?, street = ?, aptNum = ?, city = ?, "
					+ "state = ?, zip = ?, telNum = ?,  email = ?, flightNum = ?, flightDate = ?, "
					+ "reservationStat = ?, baggageInfo = ?, seatNum = ?, flightClass = ?, amountPaid = ?"
					+ "WHERE ssn = ?";
	
			
			try {
				
				dbConnection = DriverManager.getConnection(DB_URL, USER, PASS);
				preparedStatement = dbConnection.prepareStatement(insertTableSQL);
	 
				preparedStatement.setString(1, p.firstName);
				preparedStatement.setString(2, p.lastName);
				preparedStatement.setInt(3, p.ssn);
				preparedStatement.setInt(4, p.age);
				preparedStatement.setString(5, p.street);
				preparedStatement.setString(6, p.aptNum);
				preparedStatement.setString(7, p.city);
				preparedStatement.setString(8, p.state);
				preparedStatement.setInt(9, p.zip);
				preparedStatement.setString(10, p.telNum);
				preparedStatement.setString(11, p.email);
				preparedStatement.setString(12, p.flightNum);
				preparedStatement.setDate(13, p.flightDate);
				preparedStatement.setString(14, p.reservationStat);
				preparedStatement.setString(15, p.baggageInfo);
				preparedStatement.setString(16, p.seatNum);
				preparedStatement.setString(17, p.flightClass);
				preparedStatement.setDouble(18, p.amountPaid);
				preparedStatement.setInt(19, sNum);
				
				
				// execute insert SQL stetement
				preparedStatement.executeUpdate();
	 
				System.out.println("Record is inserted into PASSENGER table!");
			
			} catch (SQLException e) {
				
				System.out.println(e.getMessage());
		
			} finally {
				
				if (preparedStatement != null) {
					preparedStatement.close();
				}
	 
				if (dbConnection != null) {
					dbConnection.close();
				}
				
			}
		
	}
	
	
	
	public static void addFlight(Flight f) throws SQLException{

		Connection dbConnection = null;
		PreparedStatement stmt = null;

		String insertTableSQL = "INSERT INTO FLIGHT"
				+ "(flightNum, flightDate, aircraftType, sourceCity, sourceState, depHour, depMin,"
				+ " depDate, depCity, depState, arrivalHour, arrivalMin, arrivalDate, arrivalCity,"
				+ " arrivalState, numSeatsBooked, numPassengersOnBoard) values"
				+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


		try {
			dbConnection = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = dbConnection.prepareStatement(insertTableSQL);

			stmt.setInt(1, f.flightNum);
			stmt.setDate(2, f.flightDate);
			stmt.setString(3, f.aircraftType);
			stmt.setString(4, f.sourceCity);
			stmt.setString(5, f.sourceState);
			stmt.setInt(6, f.depHour);
			stmt.setInt(7, f.depMin);
			stmt.setDate(8, f.depDate);
			stmt.setString(9, f.depCity);
			stmt.setString(10, f.depState);
			stmt.setInt(11, f.arrivalHour);
			stmt.setInt(12, f.arrivalHour);
			stmt.setDate(13, f.arrivalDate);
			stmt.setString(14, f.arrivalCity);
			stmt.setString(15, f.arrivalState);
			stmt.setInt(16, f.numSeatsBooked);
			stmt.setInt(17, f.numPassengersOnBoard);

			stmt.executeUpdate();

			System.out.println("Record is inserted into FLIGHT table!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (stmt != null) {
				stmt.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}
		}
	}
	
	
	
	
	public static void updateFlight(Flight f) throws SQLException{

		Connection dbConnection = null;
		PreparedStatement stmt = null;

		String insertTableSQL = "UPDATE FLIGHT SET flightNum = ?, flightDate = ?, aircraftType = ?, "
				+ "sourceCity = ?, sourceState = ?, depHour = ?, depMin = ?, depDate = ?, depCity = ?, "
				+ "depState = ?, arrivalHour = ?, arrivalMin = ?, arrivalDate = ?, arrivalCity = ?, "
				+ "arrivalState = ?, numSeatsBooked = ?, numPassengersOnBoard = ?"
				+ " WHERE flightNum = ?";		
		try {
			dbConnection = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = dbConnection.prepareStatement(insertTableSQL);

			stmt.setInt(1, f.flightNum);
			stmt.setDate(2, f.flightDate);
			stmt.setString(3, f.aircraftType);
			stmt.setString(4, f.sourceCity);
			stmt.setString(5, f.sourceState);
			stmt.setInt(6, f.depHour);
			stmt.setInt(7, f.depMin);
			stmt.setDate(8, f.depDate);
			stmt.setString(9, f.depCity);
			stmt.setString(10, f.depState);
			stmt.setInt(11, f.arrivalHour);
			stmt.setInt(12, f.arrivalHour);
			stmt.setDate(13, f.arrivalDate);
			stmt.setString(14, f.arrivalCity);
			stmt.setString(15, f.arrivalState);
			stmt.setInt(16, f.numSeatsBooked);
			stmt.setInt(17, f.numPassengersOnBoard);

			stmt.executeUpdate();

			System.out.println("Record is inserted into FLIGHT table!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (stmt != null) {
				stmt.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}
		}
	}


	public static void main(String[] args){
	/*
		ArrayList<String> list = getListOfFlights();
			for(String s : list){
				System.out.println(s);
			}
	*/
		System.out.println(getPassenger(123456789));
		
	}


}