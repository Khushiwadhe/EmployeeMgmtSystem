<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<style>
body{
background-color:black;
}
.imageSet {
margin-top:2px;
margin-bottom:1px;

}
.button {
display:inline-block;
padding:8px 12px;
font-size:16px;
text-decoration :none;
border-radius:10px;
padding:10px 20px;
color:white;
background-color:blue;
border:none;
}

h1 {
		margin-bottom: 15px;
		font-size: 50px;
		letter-spacing: 1px;
		color: black;
		text-decoration:none;
		font-weight: bold;
		

</style>

</head>
<body background="images/WhatsApp Image 2024-06-22 at 15.48.01_53d7c1bb.jpg">
<h1>Employee Management System</h1><br>
<p align = "left">
<a  class="button"  id="click"  href="employee_list.jsp" >  View Employee</a>
</p>

<p align = "left">
<a  class="button"  id="click"  href="employee_add.jsp" >  Add Employee </a>
</p>




	<% 
		String message = request.getParameter("message");
	%>
	
</body>
</html>