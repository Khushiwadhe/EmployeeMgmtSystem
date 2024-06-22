<%@page import ="emp.mgmt.utils.Utils"%>
<%@page import ="emp.mgmt.entities.Employee"%>
<%@page import ="emp.mgmt.dao.EmployeeDaoImpl"%>
<%@page import ="emp.mgmt.dao.EmployeeDao"%>
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
background-size:100%;
}
form{
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
 input, text-area{
 margin-botton: 12px;
 margin-top:5px;
 
 }
 
</style>  
</head> 
<body background="images/WhatsApp Image 2024-06-22 at 16.00.48_cb752479.jpg">
	<% 
		String id = request.getParameter("id");
		int idInt = Integer.parseInt(id);
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		Employee employee = employeeDao.fetchEmployeeDetails(idInt);
	%>

	<form  action="updateEmployee" method="post" enctype="multipart/form-data">
		<fieldset >
			<legend>Fill in details</legend>
			
			<input type="number" name="id" value="<%= employee.getId() %>" placeholder="Enter id"/><br>
			
			<input type="text" name="name" value="<%= employee.getName() %>" placeholder="Enter name"/><br>
			
			<input type="text" name="salary" value="<%= employee.getSalary() %>" placeholder="Enter new salary"/><br>
			<input type="date" value="<%= employee.getDateOfJoining() %>" name="doj"/><br>
			<input type="radio" name="leaveStatus" <%if(employee.isOnLeave()){ %> checked <% }%> value="true"/>On Leave
			<input type="radio" name="leaveStatus" <%if(!employee.isOnLeave()){ %> checked <% }%> value="false"/>Present<br>
			
			
			
			<textarea name="bio" rows="2" cols="20"><%= employee.getBio()%></textarea><br>
			
			<img id="output" src="data:image/jpg;base64,<%= Utils.displayImage(employee.getProfileImage())%>" style="width:80px;height:80px"/>
			<label for="img">Change Image</label>
			<input type="file" name="profileImage" accept="image/*" onchange="loadFile(event)" id="img"/><br /> 
			
			<input class="blue-btn" type="submit" value="Submit"/>
			<input class="blue-btn" id="red-btn" type="reset" value="Reset"/>
		</fieldset>
	
	</form>
	
	<%@include file="message.jsp" %>
	<script>
	  var loadFile = function(event) {
	    var output = document.getElementById('output');
	    output.src = URL.createObjectURL(event.target.files[0]);
	    output.onload = function() {
	      URL.revokeObjectURL(output.src) // free memory
	    }
	  };
	</script>

</body>
</html>