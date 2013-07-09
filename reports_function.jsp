<!--Java content-->
<%@ page import="discrepancies.*" %>
<%@ page import="javax.xml.rpc.ServiceException" %>
<%@ page import="java.net.*" %>
<%@ page import="java.rmi.RemoteException" %>
<!--End Java content-->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Search results</title>
</head>
<body>
<center>
<table width="920" cellspacing="0" cellpadding="0" border="0">
<tr>
<td width="460" align="left">
<a href="reports_mainmenu.jsp"><font size="4" color="black"><<< Back to reports menu</font></a>
<td width="460" align="right">
<input type="button"
  onClick="window.print()"
  value="Print this report"/>
</td>
</tr>
</table>
<table width="920" cellspacing="1" cellpadding="2" border="1" bordercolor="#fff">
<tr bgcolor="#000">  
<td width="68" align="center"><font size="1" color="#fff"><b>JCN</b></font></td>
<td width="68" align="center"><font size="1" color="#fff"><b>Date & Time</b></font></td>
<td width="68" align="center"><font size="1" color="#fff"><b>Initiator</b></font></td>
<td width="68" align="center"><font size="1" color="#fff"><b>Rank</b></font></td>
<td width="68" align="center"><font size="1" color="#fff"><b>Aircraft</b></font></td>
<td width="68" align="center"><font size="1" color="#fff"><b>Workcenter</b></font></td>
<td width="68" align="center"><font size="1" color="#fff"><b>Code</b></font></td>
<td width="68" align="center"><font size="1" color="#fff"><b>Job Status</b></font></td>
<td width="68" align="center"><font size="1" color="#fff"><b>Jet Status</b></font></td>
<td width="308" align="center"><font size="1" color="#fff"><b>Discrepancy</b></font></td>
</tr>
<!--Java content-->
<%
// Extracting the information from the forms
String SearchCriteria = request.getParameter("searchcriteria");
String SearchContent = request.getParameter("searchcontent");

// Assigning the form info into an array
String OutboundArray[] = {SearchCriteria, SearchContent};
String DisplayContent = null;
String RowBackground = null;
String[] ReturnedArray;
URL endpoint = null;
try {
	//*******************************//
	// Connection to the web service //
	//*******************************//
	endpoint = new URL
	("http://localhost:7001/maintenance/ViewDiscService?WSDL");
	ViewDiscService svc = new ViewDiscServiceLocator();
	ViewDisc submit = svc.getViewDiscPort(endpoint);
	
	// Calling the WS methods with the arrayed input fields as arguments
	ReturnedArray = submit.viewDisc(OutboundArray);
	
	// Logic to throw an error if the return is null
	if (ReturnedArray == null) {
		//error message in case return is null, otherwise blank
		DisplayContent = "An Error has occured!";
		}
	else {
		//Retrieving array size from index 0
		String RecordCountS = ReturnedArray[0];
		int RecordCount = Integer.parseInt(RecordCountS);
		int ArrayPosition = 0;
		
		//Creating an array of 11 to hold a single result
		String SingleResult[] = new String[11];
		for (int i = 0; i < RecordCount; i++ ){
			ArrayPosition++;
			SingleResult[0] = ReturnedArray[ArrayPosition];
			ArrayPosition++;
			SingleResult[1] = ReturnedArray[ArrayPosition];
			ArrayPosition++;
			SingleResult[2] = ReturnedArray[ArrayPosition];
			ArrayPosition++;
			SingleResult[3] = ReturnedArray[ArrayPosition];
			ArrayPosition++;
			SingleResult[4] = ReturnedArray[ArrayPosition];
			ArrayPosition++;
			SingleResult[5] = ReturnedArray[ArrayPosition];
			ArrayPosition++;
			SingleResult[6] = ReturnedArray[ArrayPosition];
			ArrayPosition++;
			SingleResult[7] = ReturnedArray[ArrayPosition];
			ArrayPosition++;
			SingleResult[8] = ReturnedArray[ArrayPosition];
			ArrayPosition++;
			SingleResult[9] = ReturnedArray[ArrayPosition];
			ArrayPosition++;
			SingleResult[10] = ReturnedArray[ArrayPosition];
			
			// external looper class is called to format results into HTML
			DisplayContent = WebUtilities.resultReportLooper(SingleResult);
			if (i % 2 ==0) {
				RowBackground = "#CCCCCC";
			}
			else {
				RowBackground = "#B8B8B8";
			}
			%>
			<!--End Java content-->
			
			<!--Display of a single result in HTML format within the loop-->
			<tr bgcolor="<%=RowBackground%>">
			<%=DisplayContent%>
			</tr>

			<!--Java content-->
			<%
			//Finishing the loop and ending the catch statements
			}									
		}										
	} catch (MalformedURLException e) {			
		e.printStackTrace();
	} catch (ServiceException e) {
		e.printStackTrace();
	} catch (RemoteException e) {
		e.printStackTrace();
		}
			%>
<!--End Java content-->
</table>
</body>
</html>