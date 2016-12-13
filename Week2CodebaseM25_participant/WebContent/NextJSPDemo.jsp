<%@ page import = "java.sql.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADF 2.0 Java</title>
</head>
<!-- Linking to the CSS file  -->
<link rel="stylesheet" type="text/css" href="css/CssDemo.css">
<body>

<%
String sql = "insert into student values(?,?,?)";
String url= "jdbc:mysql://localhost/faculty";
String user = "root";
String pass = "abcd1234";

Class.forName("com.mysql.jdbc.Drive");
Connection con = DriverManager.getConnection(url, user, pass);
PreparedStatement ps = con.prepareStatement(sql);

String sid = request.getParameter("studentId");
String sname = request.getParameter("studentName");
String cid = request.getParameter("courseId");

int addedRows= ps.executeUpdate();

%>

<%=
addedRows
%>
<!--  Create a Scriptlet to do the following
     
      TODO 1 Create a string that contains the SQL code to insert three values into the student table
      
      TODO 2 Create string variables that are assigned the connection string for the database
             a. String for the database URL
             b. String for the username
             c. String for the password
             
      TODO 3 Declare a Connection object and PreparedStatement object
      
      TODO 4 Retrieve the StudentId, StudentName and CourseId from the AdvanceJSPDemo.jsp using the
             request object 
             
      TODO 5 persist the data in the Student table using the PreparedStatement object

      TODO 6 Print number of rows added  -->

</body>
</html>