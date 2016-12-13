function validateForm() {
	var eid = document.getElementById("eid").value;
	var ename = document.getElementById("ename").value;
	var did = document.getElementById("did").value;
	
	if (eid.length == 0) {
		alert("Enter employee id");
		return false;
	} else if (ename.length == 0) {
		alert("Enter your name");
		return false;
	} else if (did.length == 0)	{
		alert("Enter department id");
		return false;		
	}
	
	alert("Registering " + ename + " ...");
	return true;
}
