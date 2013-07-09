<!--Java content-->
<%@ page import="discrepancies.*" %>
<%@ page import="javax.xml.rpc.ServiceException" %>
<%@ page import="java.net.*" %>
<%@ page import="java.rmi.RemoteException" %>
<%
// Extracting form information
String SearchCriteria = "jcn";
String SearchContent = request.getParameter("jcn");
				
// Assigning the form info into an array & variable setup
String OutboundPacket[] = {SearchCriteria, SearchContent};
String DisplayContent = null;
String[] ReturnedArray;
URL endpoint = null;
try {
	// Connection to the web service
	endpoint = new URL
	("http://localhost:7001/maintenance/ViewDiscService?WSDL");
	ViewDiscService svc = new ViewDiscServiceLocator();
	ViewDisc submit = svc.getViewDiscPort(endpoint);
	
	// Calling the WS methods with the arrayed input fields as arguments
	ReturnedArray = submit.viewDisc(OutboundPacket);
	
	// Logic to throw an error if the return is null
	if (ReturnedArray == null) {
		DisplayContent = "No Matches found!";
		}
	// If the array is populated, the FormLooper class is called
	// Using that array as the argument, where it will be HTML
	// Formatted into a form for the user to edit
	else {
		DisplayContent = WebUtilities.resultFormLooper(ReturnedArray);
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
		<script language="javascript" type="text/javascript">
		function limitText(limitField, limitCount, limitNum) {
			if (limitField.value.length > limitNum) {
				limitField.value = limitField.value.substring(0, limitNum);
				}
			else {
				limitCount.value = limitNum - limitField.value.length;
				}
			}
		</script>
	</head>
	<body>
		<div id="blank">
			<a href="logout.jsp"><i>Click here to log out of the system</i></a>
		</div>
		<div id="frame">
			<div id="title">Discrepancies</div>
			<div id="sub-title-top">Update Entry</div>
			<div id="content-middle-centered">
				<!-- Formatted query result -->
				<%=DisplayContent%>
				<!-- Formatted query result -->
				<br>
			</div>
			<div id="sub-title-bottom">
				<a href="view_form.jsp">Search again</a><br>
				<a href="mainmenu.jsp">Return to the main menu</a>
			</div>
		</div>
	</body>
</html>