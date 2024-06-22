<%@page import =" emp.mgmt.utils.Utils"%>
<%@page import ="emp.mgmt.entities.Employee"%>
<%@page import=" java.util.List"%>
<%@page import="emp.mgmt.dao.EmployeeDaoImpl"%>
<%@page import= "emp.mgmt.dao.EmployeeDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Details</title>

<!-- External Styling -->
<link href="css/style.css" type="text/css" rel="stylesheet">

<!-- Internal Styling -->
<style>
body{
background-size:100%;
background-color:silver;
}
	table, th, td {
		border: 1px solid black;
		border-collapse: collapse;
		
	}
	
	th, td {
		padding: 10px;
	}
	
	/* Element Selector */
	caption {
		margin-bottom: 15px;
		font-size: 40px;
		letter-spacing: 1px;
		color: blue;
		text-decoration:none;
		font-weight: bold;
	}
	
</style>
</head>
<body>
	
	<% 
	EmployeeDao employeeDao = new EmployeeDaoImpl();
	List<Employee> employeeList = employeeDao.getAllEmployees();
	%>

	<!-- Inline Styling -->
	<table style="margin: auto; border-radius: 15px;">
		<caption>Employee List</caption>
		<tr>	
			<th>Id</th>
			<th>Name</th>
			<th>Profile Image</th>
			<th>Salary</th>
			<th>Date of Joining</th>
			<th>Short Bio</th>
			<th>Leave Status</th>
			<th>Action</th>
		</tr>

		<%  for(Employee employee : employeeList) {  %>

		<tr>
			<td><%= employee.getId() %></td>
			<td><%= employee.getName() %></td>
			<td><img src="data:image/jpg;base64,<%= Utils.displayImage(employee.getProfileImage())%>" style="width:80px;height:80px"/></td>
			<td><%= employee.getSalary() %></td>
			<td><%= employee.getDateOfJoining() %></td>
			<td><%= employee.getBio() %></td>
			<td><%= employee.isOnLeave() %></td>
			<td>
				<a class="blue-btn" href="employee_update.jsp?id=<%= employee.getId() %>">Update</a>
				<a class="blue-btn" id="red-btn" href="deleteEmployee?id=<%= employee.getId() %>">Delete</a>
			</td>
		</tr>
		
		<%  } %>
		
		<tr>
			<td colspan="8" style="text-align: center;">
				<a class="blue-btn" href="employee_add.jsp">Add Employee</a>
			</td>
		</tr>
	</table>

	<%@include file="message.jsp" %>	

</body>
</html>