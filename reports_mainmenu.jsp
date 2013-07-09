<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Reports menu</title>
		<link rel="stylesheet" type="text/css" href="style.css" />
	</head>
	<body>
		<div id="blank">
			<a href="logout.jsp"><i>Click here to log out of the system</i></a>
		</div>
		<div id="frame">
			<div id="title">Welcome to the reports menu</div>
			<div id="sub-title-top">Please choose a reporting option below</div>
			<div id="content-middle-centered">
				<form action="reports_function.jsp" method="post">
					<input type="hidden" name="searchcriteria" value="job_status">
					<input type="hidden" name="searchcontent" value="Not Worked">
					<input id="form-button" type="submit" value="Jobs not yet worked">
				</form>
			</div>
			<div id="content-middle-centered">
				<form action="reports_function.jsp" method="post">
					<input type="hidden" name="searchcriteria" value="job_status">
					<input type="hidden" name="searchcontent" value="In Work">
					<input id="form-button" type="submit" value="Currently being worked">
				</form>
			</div>
			<div id="content-middle-centered">
				<form action="reports_function.jsp" method="post">
					<input type="hidden" name="searchcriteria" value="job_status">
					<input type="hidden" name="searchcontent" value="Waiting Parts">
					<input id="form-button" type="submit" value="Waiting for part delivery">
				</form>
			</div>
			<div id="content-middle-centered">
				<form action="reports_function.jsp" method="post">
					<input type="hidden" name="searchcriteria" value="job_status">
					<input type="hidden" name="searchcontent" value="Completed">
					<input id="form-button" type="submit" value="Completed jobs">
				</form>
			</div>
			<div id="sub-title-bottom">
				<a href="mainmenu.jsp">Return to the main menu</a>
			</div>
		</div>
	</body>
</html>