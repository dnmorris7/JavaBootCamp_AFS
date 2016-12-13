<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADF 2.0 Java</title>
<script type="text/javascript">
function validateFields()
{
	var zooid=document.forms["inszoo"]["zooid"].value;
	var zooname=document.forms["inszoo"]["zooname"].value;
	var animalcount=document.forms["inszoo"]["animalcount"].value;
	var placeid=document.forms["inszoo"]["placeid"].value;
	if (zooid==null || zooid=="")
	 {
	  alert("Please provide Zooid");
	  return false;
	 }
	if (zooname==null || zooname=="")
	 {
	  alert("Please provide Zooname");
	  return false;
	 }
	if (zooid==animalcount || zooid==animalcount)
	 {
	  alert("Please provide animal count");
	  return false;
	 }
	if (placeid==null || placeid=="")
	 {
	  alert("Please provide Placeid");
	  return false;
	 }
	if (animalcount>500 || animalcount<1)
	 {
	  alert("Plese provide value between 1 and 500");
	  return false;
	 }
}
function isNumberKey(evt)
{
	var charCode = (evt.which) ? evt.which : event.keyCode;
    if (charCode != 46 && charCode > 31 && (charCode < 48 || charCode > 57))
        return false;
     return true;
} 
</script>
</head>
<body>
	
	<form name="inszoo" method="post" action="ZooServlet" onsubmit="return validateFields()">
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
				<td><input type="text" name="placeid" value="P001"></input></td>
			</tr>
			<tr>
				<td> <input type="submit" value="Insert Record"></td>
			</tr>
		</table>
		<br/>
		<br/>
		<a href="index.html">Home</a>
	</form>
	
</body>
</html>