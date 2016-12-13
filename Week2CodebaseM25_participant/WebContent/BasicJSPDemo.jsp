<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADF 2.0 Java</title>
</head>
<body>

	<!--  TODO 1 Create a JSP Comment that says "This is a JSP comment" -->
<%!
public int add(int a, int b) {
		return a + b;
	}
	%>
	
	<% 
	int result = add(10, 20); 
	%>
	
	<%= 
	"The result is" + "<br>"+result 
	%>
      <!--TODO 2 Create a method using JSP declaration that takes two numeric parameters and adds them 
             together and returns the sum.
             
      TODO 3 Create a JSP scriptlet that calls the declaration created in TODO 2 with two numeric 
             values, 10 and 20, and assigns the result to a variable.
                
      TODO 4 Create a JSP Expression that displays the result of TODO 3. -->

</body>
</html>