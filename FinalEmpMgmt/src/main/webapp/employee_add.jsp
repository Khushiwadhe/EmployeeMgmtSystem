<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>

<!-- External Styling -->
<link href="css/style.css" type="text/css" rel="stylesheet">

<style>
body{
background-size: 80%;
}
form {
	
width:30%;
height: 50%;
background:silver ;
border: 2px solid rgb(5, 4, 3);
outline: none;
font-size: 15px;
color:black;
border-radius: 6px;
padding: 15px 15px 15px 15px;
margin:auto;
	}

input, textarea {
	margin-bottom : 10px;
}

</style>
</head>
<body background="images/WhatsApp Image 2024-06-22 at 15.42.11_ba8363ec.jpg">

	<form action="addEmployee" method="post" enctype="multipart/form-data">
		<fieldset>
			<legend>Fill in details</legend>
			<input type="text" name="name" placeholder="Enter name"/><br>
			
			<input type="text" name="salary" placeholder="Enter Salary"/><br>
			
			<input type="radio" name="leaveStatus" value="true"/>On Leave
			<input type="radio" name="leaveStatus" value="false"/>Present<br>
			
			<input type="date" name="doj"/><br>
			
			<textarea name="bio" rows="10" cols="20"></textarea><br>
			
			<input type="file" name="profileImage" /><br /> 
			
			<input class="blue-btn" type="submit" value="Submit"/>
			<input class="blue-btn" id="red-btn" type="reset" value="Reset"/>
		</fieldset>
	
	</form>
	
	<%@include file="message.jsp" %>

</body>
</html>