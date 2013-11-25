//package db_proj;
import java.sql.*;
import java.util.ArrayList;

public class SqlCommands {
	
	static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";  
	static final String DB_URL = "jdbc:oracle:thin:@oracle2.gl.umbc.edu:1521:GL";
	static final String USER = "cgadwa1"; //Please add your User ID for your Oracle Account
	static final String PASS = "babylips";  //Please add your Oracle Password

	public static boolean signIn(String username, String password){
		
		String uName = "";
		String pass = "";
		Connection conn = null;
		Statement stmt = null;
		boolean allowed = false;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			String sql = "select username, password from users";
			
			ResultSet dbUsers = stmt.executeQuery(sql);
			
				while(dbUsers.next()){
				
				uName = dbUsers.getString("username");
				pass = dbUsers.getString("password");
				if(username.equals(uName) && password.equals(pass))
					allowed = true;
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
		
		return allowed;
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
	
	
	public static Flight getFlight(int flightNum){
		Flight f = new Flight();
		Connection conn = null;
		Statement stmt = null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Executing...");
			stmt = conn.createStatement();
			String sql = "select flightNum, flightDate, aircraftType, sourceCity, sourceState, depHour, "
					+ "depMin, depDate, depCity, depState, arrivalHour, arrivalMin, arrivalDate, "
					+ "arrivalCity, arrivalState, numSeatsBooked, numPassengersOnBoard "
					+ "from flight where flightNum = "+"'"+flightNum+"'";

			ResultSet dbUsers = stmt.executeQuery(sql);

			while(dbUsers.next()){
				f.flightNum = dbUsers.getInt("flightNum");
				f.flightDate = dbUsers.getDate("flightDate");
				f.aircraftType = dbUsers.getString("aircraftType");
				f.sourceCity = dbUsers.getString("sourceCity");
				f.sourceState = dbUsers.getString("sourceState");
				f.depHour = dbUsers.getInt("depHour");
				f.depMin = dbUsers.getInt("depMin");
				f.depDate = dbUsers.getDate("depDate");
				f.depCity = dbUsers.getString("depCity");
				f.depState = dbUsers.getString("depState");
				f.arrivalHour = dbUsers.getInt("arrivalHour");
				f.arrivalMin = dbUsers.getInt("arrivalMin");
				f.arrivalDate = dbUsers.getDate("arrivalDate");
				f.arrivalCity = dbUsers.getString("arrivalCity");
				f.arrivalState = dbUsers.getString("arrivalState");
				f.numSeatsBooked = dbUsers.getInt("numSeatsBooked");
				f.numPassengersOnBoard = dbUsers.getInt("numPassengersOnBoard");

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
		return f;
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
			dbConnection = getDBConnection();
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
 
			System.out.println("Record is inserted into DBUSER table!");
 
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
 
	public static Connection getDBConnection() {
 
		Connection dbConnection = null;
 
		try {
 
			Class.forName(JDBC_DRIVER);
 
		} catch (ClassNotFoundException e) {
 
			System.out.println(e.getMessage());
 
		}
 
		try {
 
			dbConnection = DriverManager.getConnection(
                            DB_URL, USER, PASS);
			return dbConnection;
 
		} catch (SQLException e) {
 
			System.out.println(e.getMessage());
 
		}
 
		return dbConnection;
 
	}
	
	
	public static void updatePassenger(Passenger p, int sNum) throws SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		
		String insertTableSQL = "UPDATE PASSENGER"
					+ " SET firstName = ?, lastName = ?, ssn = ?, age = ?, street = ?, aptNum = ?, city = ?, "
					+ "state = ?, zip = ?, telNum = ?,  email = ?, flightNum = ?, flightDate = ?, "
					+ "reservationStat = ?, baggageInfo = ?, seatNum = ?, flightClass = ?, amountPaid = ?"
					+ " WHERE ssn = " + "'" + sNum + "'";
	
			
			try {
				
				dbConnection = getDBConnection();
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
	
	public static void removePassenger(Passenger p) throws SQLException{
		
		Connection dbConnection = null;
		PreparedStatement stmt = null;
		
		String insertTableSQL = "DELETE FROM PASSENGER WHERE ssn = " 
		+ "'" + p.ssn + "'";
		
		String updateTableSQL = "UPDATE FLIGHT SET numPassengersOnBoard = numPassengersOnBoard - 1 "
				+ "WHERE flightNum = " + "'" + p.flightNum + "'";
		
		try {
			dbConnection = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = dbConnection.prepareStatement(insertTableSQL);
			
			stmt.executeUpdate();

			System.out.println("Record was removed from PASSENGER table!");
			
			stmt = dbConnection.prepareStatement(updateTableSQL);
			
			stmt.executeUpdate();

			System.out.println("FLIGHT table was updated!");

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
	
	public static void removeFlight(int fNum) throws SQLException{
		
		Connection dbConnection = null;
		PreparedStatement stmt = null;
		
		String insertTableSQL = "DELETE FROM FLIGHT WHERE flightNum = " 
		+ "'" + fNum + "'";
		
		String secondTableSQL = "UPDATE PASSENGER SET flightNum = 0 "
				+ "WHERE flightNum = " + "'" + fNum + "'";
		
		try {
			dbConnection = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = dbConnection.prepareStatement(insertTableSQL);
		
			stmt.executeUpdate();

			System.out.println("Record was removed from FLIGHT table!");
			
			stmt = dbConnection.prepareStatement(secondTableSQL);
			
			stmt.executeUpdate();

			System.out.println("PASSENGER table was updated!");

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
		System.out.println("Signing in...");
		boolean allowed = signIn("admin","admin1234");
		if(allowed)
			System.out.println("Access Granted");
		
		System.out.println(getPassenger(123454444));
		
		Passenger p = new Passenger();
		
		p.firstName = "Heidi";
		
		p.lastName = "Gray";
		
		p.ssn = 123454444;
		
		p.age = 21;
		
		p.street = "6302 Capon Street";
		
		p.aptNum = "N/A";
		
		p.city = "Seat Pleasant";
		
		p.state = "MD";
	
		p.zip = 20743;
		
		p.telNum = "3014124031";
	
		p.email = "hegray1@umbc.edu";
	
		p.flightNum = "12345";
		
		Date fDate = new Date(113, 10, 23);
		p.flightDate = fDate;		   
		//p.flightDate = sc.nextLine();

		p.reservationStat = "Confirmed";
	
		p.baggageInfo = "3";

		p.seatNum = "13A";
	
		p.flightClass = "Economy";
	
		p.amountPaid = 5000.00;
		
		try {
			updatePassenger(p, 123454444);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
	}


}