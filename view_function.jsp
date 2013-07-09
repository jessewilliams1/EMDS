<!--Java content-->
<%@ page import="discrepancies.*" %>
<%@ page import="javax.xml.rpc.ServiceException" %>
<%@ page import="java.net.*" %>
<%@ page import="java.rmi.RemoteException" %>
<%	// Extracting the information from the forms
	String SearchCriteria = request.getParameter("searchcriteria");
	String SearchContent = request.getParameter("searchcontent");
	
	// Assigning the form info into an array
	String OutboundArray[] = {SearchCriteria, SearchContent};
	String DisplayContent = null;
	String ErrorMessage = null;
	String[] ReturnedArray = null;
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
			ErrorMessage = "No Matches found!";
			}
		else {
			ErrorMessage = "&nbsp;";
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
		<title>Search results</title>
		<link rel="stylesheet" type="text/css" href="style.css" />
	</head>
	<body>
		<div id="blank">
			<a href="logout.jsp"><i>Click here to log out of the system</i></a>
		</div>
		<div id="frame">
			<div id="title">View discrepancies</div>
			<div id="sub-title-top">Search results:</div>
			<div id="content-middle-centered">
				<!--Java content-->
				<%	//Retrieving array size from index 0
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
						DisplayContent = WebUtilities.resultStringLooper(SingleResult);
				%>
				<!--End Java content-->
							
				<!--Display of a single result in HTML format within the loop-->
				<%=DisplayContent%>
				<%} %>
				<%=ErrorMessage%>
			</div>
			<div id="sub-title-bottom">
				<a href="view_form.jsp">Search again</a><br>
				<a href="mainmenu.jsp">Return to the main menu</a>
			</div>
		</div>
	</body>
</html>