package discrepancies;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class WebUtilities {
	
	//Method that returns the query results as an HTML formatted presentation
	public static String resultStringLooper (String[] IncomingArray) {
		String FormattedResults =
				"<table align=\"center\" cellspacing=\"0\" cellpadding=\"3\" width=\"500\">"+
				"<tr>"+
				"<td align=\"right\"><b>Job control number:</b></td><td align=\"left\">"+IncomingArray[0]+"</td>"+
				"</tr>"+
				"<tr>"+
				"<td align=\"right\"><b>Time & Date:</b></td><td align=\"left\">"+IncomingArray[1]+","+IncomingArray[2]+"</td>"+
				"</tr>"+
				"<tr>"+
				"<td align=\"right\"><b>Initiator:</b></td><td align=\"left\">"+IncomingArray[3]+"</td>"+
				"</tr>"+
				"<tr>"+
				"<td align=\"right\"><b>Initiator rank:</b></td><td align=\"left\">"+IncomingArray[4]+"</td>"+
				"</tr>"+
				"<tr>"+
				"<td align=\"right\"><b>Aircraft tail number:</b></td><td align=\"left\">"+IncomingArray[5]+"</td>"+
				"</tr>"+
				"<tr>"+
				"<td align=\"right\"><b>Workcenter:</b></td><td align=\"left\">"+IncomingArray[6]+"</td>"+
				"</tr>"+
				"<tr>"+
				"<td align=\"right\"><b>Discrepancy code:</b></td><td align=\"left\">"+IncomingArray[7]+"</td>"+
				"</tr>"+
				"<tr>"+
				"<td align=\"right\"><b>Job status:</b></td><td align=\"left\">"+IncomingArray[8]+"</td>"+
				"</tr>"+
				"<tr>"+
				"<td align=\"right\"><b>Aircraft status:</b></td><td align=\"left\">"+IncomingArray[9]+"</td>"+
				"</tr>"+
				"<tr>"+
				"<td align=\"center\" colspan=\"2\">&nbsp;</td>"+
				"</tr>"+
				"<tr>"+
				"<td align=\"center\" colspan=\"2\"><b>Discrepancy Details:</b></td>"+
				"</tr>"+
				"<tr>"+
				"<td align=\"center\" colspan=\"2\">"+
				"<textarea id=\"form-textarea\" readonly=\"readonly\">"+
				IncomingArray[10]+
				"</textarea>"+
				"</td>"+
				"</tr>"+
				"<tr>"+
				"<td align=\"center\" colspan=\"2\">"+
				"<form action=\"edit_form.jsp\" method=\"post\">"+
				"<input type=\"hidden\" value=\""+IncomingArray[0]+"\" name=\"jcn\" />"+
				"<input id=\"form-button\" type=\"submit\" value=\"Update Discrepancy\">"+
				"</form>"+
				"</td>"+
				"</tr>"+
				"</table>"+
				"<hr>";
		return FormattedResults;
	}
	//Method to return the database results as an edit-able form
	public static String resultFormLooper (String[] IncomingArray) {
		// Logic to display the job status for the current entry
		String job_status = IncomingArray[9];
		String job_status_options = null;
		if (job_status.equals("Not Worked")) {
			job_status_options =
				"<option selected value=\"Not Worked\">Not worked</option>"+
				"<option value=\"In Work\">In work</option>"+
				"<option value=\"Wating Parts\">Waiting for parts</option>"+
				"<option value=\"Completed\">Completed</option>";
		}
		else if (job_status.equals("In Work")) {
			job_status_options =
					"<option value=\"Not Worked\">Not worked</option>" +
			  		"<option selected value=\"In Work\">In work</option>" +
			  		"<option value=\"Waiting Parts\">Waiting for parts</option>" +
			  		"<option value=\"Completed\">Completed</option>";
		}
		else if (job_status.equals("Waiting Parts")) {
			job_status_options =
					"<option value=\"Not Worked\">Not worked</option>" +
			 		"<option value=\"In Work\">In work</option>" +
			  		"<option selected value=\"Waiting Parts\">Waiting for parts</option>" +
			  		"<option value=\"Completed\">Completed</option>";
		}
		else if (job_status.equals("Completed")) {
			job_status_options =
					"<option value=\"Not Worked\">Not worked</option>" +
			  		"<option value=\"In Work\">In work</option>" +
			  		"<option value=\"Waiting Parts\">Waiting for parts</option>" +
			  		"<option selected value=\"Completed\">Completed</option>";
		}
		
		// Logic to display the aircraft status for the current entry
		String ac_status = IncomingArray[10];
		String ac_status_options = null;
		if (ac_status.equals("Up")) {
			ac_status_options =
					"<option selected value=\"Up\">Up</option>" +
			  		"<option value=\"Down\">Down</option>";
		}
		else if (ac_status.equals("Down")) {
			ac_status_options =
					"<option value=\"Up\">Up</option>" +
			  		"<option selected value=\"Down\">Down</option>";
		}
		// Logic to display the discrepancy code status for the current entry
		String disc_code = IncomingArray[8];
		String disc_code_options = null;
		if (disc_code.equals("001")) {
			disc_code_options = 
				"<option selected value=\"001\">001</option>" +
				"<option value=\"002\">002</option>" +
				"<option value=\"003\">003</option>" +
				"<option value=\"004\">004</option>" +
				"<option value=\"005\">005</option>" +
				"<option value=\"006\">006</option>" +
				"<option value=\"007\">007</option>" +
				"<option value=\"008\">008</option>" +
				"<option value=\"009\">009</option>" +
				"<option value=\"010\">010</option>";
		}
		else if (disc_code.equals("002")) {
			disc_code_options = 
				"<option value=\"001\">001</option>" +
				"<option selected value=\"002\">002</option>" +
				"<option value=\"003\">003</option>" +
				"<option value=\"004\">004</option>" +
				"<option value=\"005\">005</option>" +
				"<option value=\"006\">006</option>" +
				"<option value=\"007\">007</option>" +
				"<option value=\"008\">008</option>" +
				"<option value=\"009\">009</option>" +
				"<option value=\"010\">010</option>";
		}
		
		else if (disc_code.equals("003")) {
			disc_code_options = 
				"<option value=\"001\">001</option>" +
				"<option value=\"002\">002</option>" +
				"<option selected value=\"003\">003</option>" +
				"<option value=\"004\">004</option>" +
				"<option value=\"005\">005</option>" +
				"<option value=\"006\">006</option>" +
				"<option value=\"007\">007</option>" +
				"<option value=\"008\">008</option>" +
				"<option value=\"009\">009</option>" +
				"<option value=\"010\">010</option>";
		}
		else if (disc_code.equals("004")) {
			disc_code_options = 
				"<option value=\"001\">001</option>" +
				"<option value=\"002\">002</option>" +
				"<option value=\"003\">003</option>" +
				"<option selected value=\"004\">004</option>" +
				"<option value=\"005\">005</option>" +
				"<option value=\"006\">006</option>" +
				"<option value=\"007\">007</option>" +
				"<option value=\"008\">008</option>" +
				"<option value=\"009\">009</option>" +
				"<option value=\"010\">010</option>";
		}
		else if (disc_code.equals("005")) {
			disc_code_options = 
				"<option value=\"001\">001</option>" +
				"<option value=\"002\">002</option>" +
				"<option value=\"003\">003</option>" +
				"<option value=\"004\">004</option>" +
				"<option selected value=\"005\">005</option>" +
				"<option value=\"006\">006</option>" +
				"<option value=\"007\">007</option>" +
				"<option value=\"008\">008</option>" +
				"<option value=\"009\">009</option>" +
				"<option value=\"010\">010</option>";
		}
		else if (disc_code.equals("006")) {
			disc_code_options = 
				"<option value=\"001\">001</option>" +
				"<option value=\"002\">002</option>" +
				"<option value=\"003\">003</option>" +
				"<option value=\"004\">004</option>" +
				"<option value=\"005\">005</option>" +
				"<option selected value=\"006\">006</option>" +
				"<option value=\"007\">007</option>" +
				"<option value=\"008\">008</option>" +
				"<option value=\"009\">009</option>" +
				"<option value=\"010\">010</option>";
		}
		else if (disc_code.equals("007")) {
			disc_code_options = 
				"<option value=\"001\">001</option>" +
				"<option value=\"002\">002</option>" +
				"<option value=\"003\">003</option>" +
				"<option value=\"004\">004</option>" +
				"<option value=\"005\">005</option>" +
				"<option value=\"006\">006</option>" +
				"<option selected value=\"007\">007</option>" +
				"<option value=\"008\">008</option>" +
				"<option value=\"009\">009</option>" +
				"<option value=\"010\">010</option>";
			}
		else if (disc_code.equals("008")) {
			disc_code_options = 
				"<option value=\"001\">001</option>" +
				"<option value=\"002\">002</option>" +
				"<option value=\"003\">003</option>" +
				"<option value=\"004\">004</option>" +
				"<option value=\"005\">005</option>" +
				"<option value=\"006\">006</option>" +
				"<option value=\"007\">007</option>" +
				"<option selected value=\"008\">008</option>" +
				"<option value=\"009\">009</option>" +
				"<option value=\"010\">010</option>";
			}
		else if (disc_code.equals("009")) {
			disc_code_options = 
				"<option value=\"001\">001</option>" +
				"<option value=\"002\">002</option>" +
				"<option value=\"003\">003</option>" +
				"<option value=\"004\">004</option>" +
				"<option value=\"005\">005</option>" +
				"<option value=\"006\">006</option>" +
				"<option value=\"007\">007</option>" +
				"<option value=\"008\">008</option>" +
				"<option selected value=\"009\">009</option>" +
				"<option value=\"010\">010</option>";
			}
		
		else if (disc_code.equals("010")) {
			disc_code_options = 
				"<option value=\"001\">001</option>" +
				"<option value=\"002\">002</option>" +
				"<option value=\"003\">003</option>" +
				"<option value=\"004\">004</option>" +
				"<option value=\"005\">005</option>" +
				"<option value=\"006\">006</option>" +
				"<option value=\"007\">007</option>" +
				"<option value=\"008\">008</option>" +
				"<option value=\"009\">009</option>" +
				"<option selected value=\"010\">010</option>";
			}
		//The combined results returned as an HTML form
		String FormattedResults =
			"<form action=\"edit_function.jsp\" method=\"post\">"+
			"<table align=\"center\" cellspacing=\"0\" cellpadding=\"3\" width=\"500\">"+
			"<tr>"+
			"<td align=\"right\"><b>Job control number:</b></td><td align=\"left\">" +
			"<input id=\"form-text-complete\" type=\"text\" value=\""+IncomingArray[1]+"\" name=\"jcn\" readonly=\"readonly\"/>" +
			"</td>"+
			"</tr>"+
			"<tr>"+
			"<td align=\"right\"><b>Creation Date:</b></td><td align=\"left\">" +
			"<input id=\"form-text-complete\" type=\"text\" value=\""+IncomingArray[2]+"\" name=\"date\" readonly=\"readonly\"/>" +
			"</td>"+
			"</tr>"+
			"<tr>"+
			"<td align=\"right\"><b>Creation Time:</b></td><td align=\"left\">" +
			"<input id=\"form-text-complete\" type=\"text\" value=\""+IncomingArray[3]+"\" name=\"time\" readonly=\"readonly\"/>" +
			"</td>"+
			"</tr>"+
			"<tr>"+
			"<td align=\"right\"><b>Job Initiator:</b></td><td align=\"left\">" +
			"<input id=\"form-text-complete\" type=\"text\" value=\""+IncomingArray[4]+"\" name=\"init_name\" readonly=\"readonly\"/>" +
			"</td>"+
			"</tr>"+
			"<tr>"+
			"<td align=\"right\"><b>Initiator Rank:</b></td><td align=\"left\">" +
			"<input id=\"form-text-complete\" type=\"text\" value=\""+IncomingArray[5]+"\" name=\"init_rank\" readonly=\"readonly\"/>" +
			"</td>"+
			"</tr>"+
			"<tr>"+
			"<td align=\"right\"><b>Aircraft:</b></td><td align=\"left\">" +
			"<input id=\"form-text-complete\" type=\"text\" value=\""+IncomingArray[6]+"\" name=\"aircraft\" readonly=\"readonly\"/>" +
			"</td>"+
			"</tr>"+
			"<tr>"+
			"<td align=\"right\"><b>Workcenter:</b></td><td align=\"left\">" +
			"<input id=\"form-text-complete\" type=\"text\" value=\""+IncomingArray[7]+"\" name=\"workcenter\" readonly=\"readonly\"/>" +
			"</td>"+
			"</tr>"+
			"<tr>"+
			"<td align=\"right\"><b>Disc Code:</b></td><td align=\"left\">" +
			"<select id=\"form-text\" name=\"disc_code\">"+disc_code_options +"</select>" +
			"<br>" +
			"<a href=\"\" onclick=\"return false\" class=\"tooltip\">(Workcenter descriptions)" +
			"<span>" +
			"001: Scheduled maintenance<br>" +
			"002: Unscheduled inspection<br>" +
			"003: Corrosion<br>" +
			"004: Avionics hardware<br>" +
			"005: Avionics software<br>" +
			"006: Consumable<br>" +
			"007: Wiring<br>" +
			"008: Life support<br>" +
			"009: Structure damage<br>" +
			"010: No discrepancy<br></span></a>" +
			"</td>"+
			"</tr>"+
			"<tr>"+
			"<td align=\"right\"><b>Job status:</b></td><td align=\"left\">" +
			"<select id=\"form-text\" name=\"job_status\">"+
			job_status_options +
			"</select>" +
			"</td>" +
			"</tr>" +
			"<tr>" +
			"<td align=\"right\"><b>Aircraft Status:</b></td><td align=\"left\">" +
			"<select id=\"form-text\" name=\"ac_status\">"+ac_status_options +"</select>" +
			"</td>" +
			"</tr>" +
			"<tr>" +
			"<td align=\"center\" colspan=\"2\">&nbsp;</td>"+
			"</tr>" +
			"<tr>" +
			"<td align=\"center\" colspan=\"2\"><b>Discrepancy Details:</b></td>" +
			"</tr>" +
			"<tr>" +
			"<td align=\"center\" colspan=\"2\">" +//limiting the maximum character to 255
			"<textarea id=\"form-textarea\" name=\"discrepancy\" onKeyDown=\"limitText(this.form.discrepancy,this.form.countdown,255);\""+
			"onKeyUp=\"limitText(this.form.limitedtextarea,this.form.countdown,255);\">"+
			IncomingArray[11]+
			"</textarea>"+
			"<font size=\"1\"><br>You have <input id=\"form-text-small\" readonly type=\"text\" name=\"countdown\" size=\"3\" value=\"0\"> characters left.</font>" +
			"<br>" +
			"</td>" +
			"</tr>" +
			"<tr>" +
			"<td align=\"center\" colspan=\"2\">" +
			"<input id=\"form-button\" type=\"submit\" value=\"Update\">" +
			"</td>" +
			"</tr>" +
			"</table>" +
			"</form>" +
			"<hr>";
		return FormattedResults;
	}
	
	//Returns the database results in a tabular report format
	public static String resultReportLooper (String[] IncomingArray) {
		String longDisc = IncomingArray[10];
		String shortDisc = longDisc.substring(0, 15);
		String StatusColor = null;
		String ac_status= IncomingArray[9];
		
		//logic for displaying the aircraft status accordingly
		if (ac_status.equals ("Down")) {
			StatusColor = "red";
			}
		else {
			StatusColor= "green";
			}
		String FormattedResults =
			"<td align=\"center\"><font size=\"1\">"+IncomingArray[0]+"</font></td>" +
			"<td align=\"center\"><font size=\"1\">"+IncomingArray[1]+","+IncomingArray[2]+"</font></td>" +
			"<td align=\"center\"><font size=\"1\">"+IncomingArray[3]+"</font></td>" +
			"<td align=\"center\"><font size=\"1\">"+IncomingArray[4]+"</font></td>" +
			"<td align=\"center\"><font size=\"1\">"+IncomingArray[5]+"</font></td>" +
			"<td align=\"center\"><font size=\"1\">"+IncomingArray[6]+"</font></td>" +
			"<td align=\"center\"><font size=\"1\">"+IncomingArray[7]+"</font></td>" +
			"<td align=\"center\"><font size=\"1\">"+IncomingArray[8]+"</font></td>" +
			"<td align=\"center\"><font size=\"1\"  color=\""+StatusColor+"\">"+IncomingArray[9]+"</font></td>" +
			"<td align=\"center\"><font size=\"1\">"+shortDisc+"...</font></td>";
		return FormattedResults;
		}
	
	//Returns the current date in yyyy-MM-dd format
	public static String CurrentDate (String blank) {
		DateFormat UseFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date CurrentDate = Calendar.getInstance().getTime();       
		String ReturnDate = UseFormat.format(CurrentDate);
		return ReturnDate;
		}
	
	//Returns the current time in HH:mm:ss format
	public static String CurrentTime (String blank) {
		DateFormat tf = new SimpleDateFormat("HH:mm:ss");
		Date CurrentTime = Calendar.getInstance().getTime();       
		String ReturnTime = tf.format(CurrentTime);
		return ReturnTime;
		}
	}
