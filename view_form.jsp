<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Search for a single discrepancy</title>
		<link rel="stylesheet" type="text/css" href="style.css" />
	</head>
	
	<body>
		<div id="blank">
			<a href="logout.jsp"><i>Click here to log out of the system</i></a>
		</div>
		<div id="frame">
			<div id="title">View a single entry</div>
			<div id="sub-title-top">Please enter the information below then hit submit</div>
				<div id="content-middle-right">
					<form action="view_function.jsp" method="post">
					<label id="form-label" for="searchcriteria">Search by:</label>
					<select id="form-text" name="searchcriteria">
						<option value="jcn">Job Number</option>
  						<option value="aircraft">Aircraft Tail Number</option>
  						<option value="init_name">Initiator</option>
  						<option value="workcenter">Workcenter</option>
					</select>
					<label id="form-label" for="searchcontent">Keyword</label>
					<input id="form-text" type="text" name="searchcontent" /> <br/>
				</div>
				<div id="content-middle-button">
					<input id="form-button" type="submit" value="Submit">
					</form>
				</div>
				<div id="sub-title-bottom">
					<a href="mainmenu.jsp">Return to the main menu</a>
				</div>
		</div>
	</body>
</html>