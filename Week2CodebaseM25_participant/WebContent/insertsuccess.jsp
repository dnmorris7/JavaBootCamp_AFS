<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADF 2.0 Java</title>
</head>
<body>
	<h2>Transaction status</h2>
	<br/>
	<% 
		String transtatus=session.getAttribute("STATUS").toString();
	%>
		
		<h3><%= transtatus %></h3>
		<br/>
		<br/>
		<a href="index.html">Home</a>
</body>
</html>