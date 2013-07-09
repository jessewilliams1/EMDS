<!--Java content-->
<%@ page import="discrepancies.*" %>
<%
String blank = "blank";
String CurrentDate = WebUtilities.CurrentDate(blank);
String CurrentTime = WebUtilities.CurrentTime(blank);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Create a new discrepancy</title>
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
			<div id="title">Create a new discrepancy</div>
			<div id="sub-title-top">Please enter the information below then hit submit</div>
			<div id="content-middle-centered">
				<form action="new_function.jsp" method="post">
				<table align="center" cellspacing="0" cellpadding="3" width="450">
					<tr>
						<td align="right"><b>Creation Date:</b></td>
						<td align="left"><input id="form-text" type="text" name="date" value="<%=CurrentDate%>" readonly="readonly"/></td>
					</tr>
					<tr>
						<td align="right"><b>Creation Time:</b></td>
						<td align="left"><input id="form-text" type="text" name="time" value="<%=CurrentTime%>" readonly="readonly"/></td>
					</tr>
					<tr>
						<td align="right"><b>Initiator:</b></td>
						<td align="left"><input id="form-text" type="text" name="init_name" /></td>
					</tr>
					<tr>
						<td align="right"><b>Initiator rank:</b></td>
						<td align="left"><input id="form-text" type="text" name="init_rank" maxlength="5" /></td>
					</tr>
					<tr>
						<td align="right"><b>Aircraft tail number:</b></td>
						<td align="left">
							<select id="form-text" name="aircraft">
								<option value="200">200</option>
								<option value="201">201</option>
								<option value="202">202</option>
								<option value="204">204</option>
								<option value="206">206</option>
								<option value="207">207</option>
								<option value="209">209</option>
								<option value="210">210</option>
								<option value="211">211</option>
								<option value="212">212</option>						
							</select>
						</td>
					</tr>
					<tr>
						<td align="right"><b>Workcenter:</b></td>
						<td align="left">
							<select id="form-text" name="workcenter">
								<option value="110">110</option>
								<option value="120">120</option>
								<option value="125">125</option>
								<option value="135">135</option>
								<option value="210">210</option>
								<option value="220">220</option>
								<option value="230">230</option>
								<option value="310">310</option>
								<option value="320">320</option>							
							</select><br>
							<a href="" onclick="return false" class="tooltip">(Workcenter descriptions)
							<span>
							110: Powerplants<br>
							120: Airframes<br>
							125: Corrosion control<br>
							135: Egress<br>
							210: Avionics<br>
							220: Electricians<br>
							230: Ordnance<br>
							310: Line<br>
							320: Troubleshooters<br></span></a>
						</td>
					</tr>
					<tr>
						<td align="right"><b>Discrepancy code:</b></td>
						<td align="left">
							<select id="form-text" name="disc_code">
								<option value="001">001</option>
								<option value="002">002</option>
								<option value="003">003</option>
								<option value="004">004</option>
								<option value="005">005</option>
								<option value="006">006</option>
								<option value="007">007</option>
								<option value="008">008</option>
								<option value="009">009</option>
								<option value="010">010</option>								
							</select><br>
							<a href="" onclick="return false" class="tooltip">(Discrepancy code descriptions)
							<span>
							001: Scheduled maintenance<br>
							002: Unscheduled inspection<br>
							003: Corrosion<br>
							004: Avionics hardware<br>
							005: Avionics software<br>
							006: Consumable<br>
							007: Wiring<br>
							008: Life support<br>
							009: Structure damage<br>
							010: No discrepancy<br></span></a>
						</td>
					</tr>
					<tr>
						<td align="right"><b>Job status:</b></td>
						<td align="left">
							<select id="form-text" name="job_status">
								<option value="Not Worked">Not Worked</option>
								<option value="In Work">In Work</option>
								<option value="Waiting Parts">Waiting Parts</option>
								<option value="Completed">Completed</option>
							</select>
						</td>
					</tr>
					<tr>
						<td align="right"><b>Aircraft status:</b></td>
						<td align="left">
							<select id="form-text" name="ac_status">
								<option value="Up">Up</option>
								<option value="Down">Down</option>
							</select>
						</td>
					</tr>
					<tr>
						<td align="center" colspan="2">&nbsp;</td>
					</tr>
					<tr>
						<td align="center" colspan="2"><b>Discrepancy Details:</b></td>
					</tr>
					<tr>
						<td align="center" colspan="2">
							<textarea id="form-textarea" name="discrepancy" onKeyDown="limitText(this.form.discrepancy,this.form.countdown,255);" onKeyUp="limitText(this.form.limitedtextarea,this.form.countdown,255);"></textarea>
							<font size="1"><br>You have <input id="form-text-small" readonly type="text" name="countdown" size="3" value="255"> characters left.</font>
							<br>
							<br>
							<input id="form-button" type="submit" value="Create">
						</td>
					</tr>
					<tr>
						<td align="center" colspan="2">&nbsp;</td>
					</tr>
				</table>
				</form>
			</div>
			<div id="sub-title-bottom">
				<a href="mainmenu.jsp">Return to the main menu</a>
			</div>
		</div>
	</body>
</html>



