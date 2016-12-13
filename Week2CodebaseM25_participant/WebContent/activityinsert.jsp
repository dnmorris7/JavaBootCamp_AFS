<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADF 2.0 Java</title>
<script type="text/javascript">
function isNumberKey(evt)
{
	var charCode = (evt.which) ? evt.which : event.keyCode
    if (charCode != 46 && charCode > 31 && (charCode < 48 || charCode > 57))
        return false;
     return true;
} 
</script>
</head>
<body>
	
	<form method="post" action="ZooServlet">
		<table>
			<tr>
				<td>Enter ZooID</td>
				<td><input type="text" name="zooid"></input></td>
			</tr>
			<tr>
				<td>Enter Zoo Name</td>
				<td><input type="text" name="zooname"></input></td>
			</tr>
			<tr>
				<td>Enter Animal Count</td>
				<td><input type="text" name="animalcount" onkeypress="return isNumberKey(event)"></input></td>
			</tr>
			<tr>
				<td>Enter PlaceID</td>
				<td><input type="text" name="placeid"></input></td>
			</tr>
			<tr>
				<td> <input type="submit" value="Insert Record"></td>
			</tr>
		</table>
		<br/>
		<br/>
		<% 
		String transtatus="";
		if(!session.isNew())
		{
			transtatus=session.getAttribute("STATUS").toString();
		}
		%>
		
		<h3><%= transtatus %></h3>
		
	</form>
	
</body>
</html>