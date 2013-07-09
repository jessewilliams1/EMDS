package discrepancies;

import java.sql.*;
import javax.jws.*;

@WebService
public class ViewDisc {

	@WebMethod
	public String[] viewDisc (String[] IncomingPacket) throws Exception {
		
		// Creating the object that will be returned
		String[] ReturnArray = null;
		
		// Extracting database login info from the received argument
		String SearchCriteria = IncomingPacket[0];
		String SearchContent = IncomingPacket[1];
		
		//-----------------------------------------------------------//
		// Database connection variables, modify these to your needs //
		//-----------------------------------------------------------//
		String username = "root";								// Database user name
		String password = "13941394";							// Database password
		String db_url = "jdbc:mysql://localhost:3306/";			// Database URL
		String db_name = "maint";								// Database name
		String db_driver = "com.mysql.jdbc.Driver"; 			// JDBC Driver location
		String db_table_name = "discrepancies";					// Table being used
		Connection con = null;
		//---------------------------------------------------------//
		//------------End database connection variables------------//
		//---------------------------------------------------------//
		
		try {
			//Connecting to the database using the above stated variables
			Class.forName(db_driver).newInstance();
			con = DriverManager.getConnection(db_url+db_name, username, password);
			try {
				
				// The first query is only concerned with a COUNT command that
				// retrieves the number of rows that match the criteria. This
				// count will be used to determine the array size needed to 
				// store the returned results
				Statement st1 = con.createStatement();
				ResultSet TotalRecordCount = st1.executeQuery
				("SELECT "+SearchCriteria+", COUNT(1) as total_number FROM "+
						db_table_name+" WHERE "+SearchCriteria+"='"+SearchContent+"'");
				int TotalArraySize=0; // Initializing the size of the final array that will be returned
				String ReturnArraySize_S = null; // Initializing the size as a String that will be put into [0] of the returned array for use by the client
				
				// Extracting data from the ResultSet and setting variables values
				while (TotalRecordCount.next()) { 
					int ReturnArraySize = 0;
					ReturnArraySize = TotalRecordCount.getInt("total_number");
					int SingleRecordSize = 11; //number of columns in an entry
					TotalArraySize = ReturnArraySize*SingleRecordSize+1; // Number of columns * Number of entries with +1 for index [0] which holds the size
					ReturnArraySize_S = Integer.toString(ReturnArraySize);
				}
				
				// This second query actually extracts the data from the entries
				// and writes them to the new accordingly sized array
				Statement st2 = con.createStatement();
				ResultSet results = st2.executeQuery("SELECT * FROM "+db_table_name+" WHERE "+SearchCriteria+"='"+SearchContent+"'");
				ReturnArray = new String[TotalArraySize];
				int ArrayPosition = 1;
				while (results.next()) {
					int JobNumI = results.getInt("jcn");
					String jobnum = Integer.toString(JobNumI);
					String date = results.getString("date");
					String time = results.getString("time");
					String init_name = results.getString("init_name");
					String init_rank = results.getString("init_rank");
					String aircraft = results.getString("aircraft");
					String workcenter = results.getString("workcenter");
					String disc_code = results.getString("disc_code");
					String job_status = results.getString("job_status");
					String ac_status = results.getString("ac_status");
					String disc = results.getString("disc");

					// Putting the information values into an array to be 
					// returned with incremental increased to ensure values are
					// stored in-line and not overwritten
					ReturnArray[0] = ReturnArraySize_S;
					ReturnArray[ArrayPosition] = jobnum;
					ArrayPosition++;
					ReturnArray[ArrayPosition] = date;
					ArrayPosition++;
					ReturnArray[ArrayPosition] = time;
					ArrayPosition++;
					ReturnArray[ArrayPosition] = init_name;
					ArrayPosition++;
					ReturnArray[ArrayPosition] = init_rank;
					ArrayPosition++;
					ReturnArray[ArrayPosition] = aircraft;
					ArrayPosition++;
					ReturnArray[ArrayPosition] = workcenter;
					ArrayPosition++;
					ReturnArray[ArrayPosition] = disc_code;
					ArrayPosition++;
					ReturnArray[ArrayPosition] = job_status;
					ArrayPosition++;
					ReturnArray[ArrayPosition] = ac_status;
					ArrayPosition++;
					ReturnArray[ArrayPosition] = disc;
					ArrayPosition++;
					}
			
					// Closing the database connection
					con.close();
					
			} catch (SQLException s) {
					s.printStackTrace();}
			} catch (Exception e){
				e.printStackTrace();}
			
			// Returning the array of results
			return ReturnArray;
			}
	}