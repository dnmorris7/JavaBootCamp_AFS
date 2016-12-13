<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADF 2.0 Java</title>
<!-- Linking to the CSS file  -->
<link rel="stylesheet" type="text/css" href="css/CssTryIt.css">

<!-- Javascript function to validate the form -->  
<script language="javascript" src="TryJs.js"></script>
</head>
<body>
<center><h1>Employee Registration System</h1>
<hr>

	<!--  TODO 1 - set the form attributes :
				   action to NextJSPTryIt.jsp
				   method to post
				   onsubmit to return validateForm()  -->

<form>
		<table>
			<tr align="center">
				<th colspan="2">Employee Registration Form</th>
			</tr>
			<tr align="left">
				<td>Enter Employee Id</td>
				<td><input type="text" id="eid" name="employeeId" /></td>
			</tr>
			<tr align="left">
				<td>Enter Employee Name</td>
				<td><input type="text" id="ename" name="employeeName" /></td>
			</tr>
			<tr align="left">
				<td>Enter Department Id</td>
				<td><input type="text" id="did" name="departmentId" /></td>
			</tr>
		
			<tr align="center">
				<td> <input id="mybtn" type="submit" value="Add Employee" ></td>
			</tr>
		</table>
		<br/>
	
	</form>
</center>
</body>
</html>