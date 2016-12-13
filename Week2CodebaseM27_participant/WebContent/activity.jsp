<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADF 2.0 Java</title>
<script type="text/javascript">
function validateForm()
{
var museumid=document.forms["form1"]["museumid"].value;
var museumname=document.forms["form1"]["museumname"].value;
var museumtype=document.forms["form1"]["museumtype"].value;
var buildingid=document.forms["form1"]["buildingid"].value;
if(museumid==null || museumid=="")
{
  alert("Please provide Museum ID");
  return false;
}
if(museumname==null || museumname=="")
{
alert("Please provide Museum Name");
return false;
}
if(museumtype==null || museumtype=="")
{
alert("Please provide Museum Type");
return false;
}
if(buildingid==null || buildingid=="")
{
alert("Please provide Building ID as B002");
return false;
}
}
</script>
</head>

<body>
	<form name="form1" method="post" action="museuminsert.htm" onsubmit="return validateForm()">
		<table>
			<tr><th>Museum Table Data</th></tr>
			<tr>
				<td>Enter MuseumId</td>
				<td><input type="text" name="museumid"></td>
			</tr>
			<tr>
				<td>Enter Museum Name</td>
				<td><input type="text" name="museumname"></td>
			</tr>
			<tr>
				<td>Enter Museum Type</td>
				<td><input type="text" name="museumtype"></td>
			</tr>
			<tr>
				<td>Enter Building ID</td>
				<td> <input type="text" name="buildingid" value="B002"></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="Insert Record"></input></td>				
			</tr>
			<tr>
				<td colspan="2" align="right">${MESSAGE}</td>
			</tr>
		</table>		 
		
	</form>
</body>
</html>