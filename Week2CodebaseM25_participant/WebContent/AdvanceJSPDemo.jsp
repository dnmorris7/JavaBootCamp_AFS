<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADF 2.0 Java</title>
<!-- Linking to the CSS file  -->
<link rel="stylesheet" type="text/css" href="css/CssDemo.css">

<!-- Javascript function to register the student  -->
<script language="javascript" src="DemoJs.js"></script>
</head>
<body>
	<center>
		<h1>ADF Java School</h1>
		
			<!--  TODO 1 Add a form action to NextJSPDemo.jsp  -->
			
		<hr>
		<form action = "NextJSPDemo.jsp" method="post">
			<table border=1>
				<thead>
					<b>Student Registration Form</b>
				</thead>
				<tr>
					<td>Enter Student Id</td>
					<td><input type="text" id="sid" name="studentId" /></td>
				</tr>
				<tr>
					<td>Enter Student Name</td>
					<td><input type="text" id="sname" name="studentName" /></td>
				</tr>
				<tr>
					<td>Enter Course Id</td>
					<td><input type="text" id="cid" name="courseId" /></td>
				</tr>

				<tr>
					<td><input id="mybtn" type="submit" value="Add Student" onclick="addStudent()"></td>
				</tr>
			</table>
			<br />

		</form>
	</center>
</body>
</html>