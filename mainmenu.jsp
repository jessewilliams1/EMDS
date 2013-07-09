<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Discrepancies main menu</title>
		<link rel="stylesheet" type="text/css" href="style.css" />
	</head>
	<body>
		<div id="blank">
			<a href="logout.jsp"><i>Click here to log out of the system</i></a>
		</div>
		<div id="frame">
			<div id="title">Welcome to the main menu, you are logged in as <%= request.getRemoteUser() %></div>
			<div id="sub-title-top">Please choose an action below</div>
			<div id="content-middle-centered"><a href="view_form.jsp">View discrepancies</a></div>
			<div id="content-middle-centered"><a href="new_form.jsp">Create a new discrepancy</a></div>
			<div id="content-middle-centered"><a href="reports_mainmenu.jsp">Reports Menu</a></div>
			<div id="sub-title-bottom"></div>
		</div>
	</body>
</html>