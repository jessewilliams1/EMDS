package discrepancies;

import java.sql.*;

import javax.jws.*;

@WebService
public class UpdateDisc {
	
	@WebMethod
	public String[] updateDisc (String[] IncomingPacket) throws Exception {
		
		// Creating the object that will be returned
		String[] ReturnArray = new String[11];
		
		// Extracting variables to be written
		String n_jcn = IncomingPacket[0];
		String n_date = IncomingPacket[1];
		String n_time = IncomingPacket[2];
		String n_init_name = IncomingPacket[3];
		String n_init_rank = IncomingPacket[4];
		String n_aircraft = IncomingPacket[5];
		String n_workcenter = IncomingPacket[6];
		String n_disc_code = IncomingPacket[7];
		String n_job_status = IncomingPacket[8];
		String n_ac_status = IncomingPacket[9];
		String n_discrepancy = IncomingPacket[10];
		
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
			//Connecting to the database
			Class.forName(db_driver).newInstance();
			con = DriverManager.getConnection(db_url+db_name, username, password);
			try {
				//Inserting the customer_id argument into an SQL query
				Statement st = con.createStatement();
				st.executeUpdate(
						"UPDATE "+db_table_name+" SET date='"+n_date+
						"', time='"+n_time+"', init_name='"+n_init_name+
						"', init_rank='"+n_init_rank+"', aircraft='"+n_aircraft+
						"', workcenter='"+n_workcenter+"', disc_code='"+n_disc_code+
						"', job_status='"+n_job_status+"', ac_status='"+n_ac_status+
						"', disc='"+n_discrepancy+
						"' WHERE jcn='"+n_jcn+"'");

				//Retrieving the info that was just updated
				ResultSet results = st.executeQuery("SELECT * FROM "+db_table_name+" WHERE jcn='"+n_jcn+"'");

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
					
					//Putting the information values into an array to be returned
					ReturnArray[0] = jobnum;
					ReturnArray[1] = date;
					ReturnArray[2] = time;
					ReturnArray[3] = init_name;
					ReturnArray[4] = init_rank;
					ReturnArray[5] = aircraft;
					ReturnArray[6] = workcenter;
					ReturnArray[7] = disc_code;
					ReturnArray[8] = job_status;
					ReturnArray[9] = ac_status;
					ReturnArray[10] = disc;
					}
			
					//Closing the database connection
					con.close();
					
			} catch (SQLException s) {
					s.printStackTrace();}
			} catch (Exception e){
				e.printStackTrace();}
			
			//Returning the array
			return ReturnArray;
			}
	}