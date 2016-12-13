<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADF 2.0 Java</title>
</head>
<body>

	<!--  TODO 1 Using JSP Declaration and Scriptlet, write code to print A-Z. 
             Hint : initialize a variable to A and go until Z using a for loop -->

	<%!char mychar = 'A';%>

	<%
		for (; mychar <= 'Z'; mychar++) {
	%>
	<%=mychar%>
	<%
		}
	%>
</body>
</html>