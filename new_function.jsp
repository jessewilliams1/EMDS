<!--Java content-->
<%@ page import="discrepancies.*" %>
<%@ page import="javax.xml.rpc.ServiceException" %>
<%@ page import="java.net.*" %>
<%@ page import="java.rmi.RemoteException" %>
<%
// Extracting the information from the forms
String date = request.getParameter("date");
String time = request.getParameter("time");
String init_name = request.getParameter("init_name");
String init_rank = request.getParameter("init_rank");
String aircraft = request.getParameter("aircraft");
String workcenter = request.getParameter("workcenter");
String disc_code = request.getParameter("disc_code");
String job_status = request.getParameter("job_status");
String ac_status = request.getParameter("ac_status");
String discrepancy = request.getParameter("discrepancy");

// Assigning the form info into an array
String OutboundPacket[] = {date, time, init_name, init_rank, aircraft, 
		workcenter, disc_code, job_status, ac_status, discrepancy};
String DisplayContent = null;
String[] ReturnedArray;
URL endpoint = null;
try {
	//*******************************//
	// Connection to the web service //
	//*******************************//
	endpoint = new URL
	("http://localhost:7001/maintenance/NewDiscService?WSDL");
	NewDiscService svc = new NewDiscServiceLocator();
	NewDisc submit = svc.getNewDiscPort(endpoint);
	
	// Calling the WS methods with the arrayed input fields as arguments
	ReturnedArray = submit.newDisc(OutboundPacket);
	
	// Logic to throw an error if the return is null
	if (ReturnedArray == null) {
		//error message in case return is null, otherwise blank
		DisplayContent = "An error has occured!";
		}
	else {
		DisplayContent = WebUtilities.resultStringLooper(ReturnedArray);
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

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>New Entry</title>
		<link rel="stylesheet" type="text/css" href="style.css" />
	</head>
	<body>
		<div id="blank">
			<a href="logout.jsp"><i>Click here to log out of the system</i></a>
		</div>
		<div id="frame">
			<div id="title">Discrepancies</div>
			<div id="sub-title-top">New Entry Added...</div>
			<div id="content-middle-centered">
				<%=DisplayContent%><br>
			</div>
			<div id="sub-title-bottom">
				<a href="new_form.jsp">Add another entry</a><br>
				<a href="mainmenu.jsp">Return to the main menu</a>
			</div>
		</div>
	</body>
</html>