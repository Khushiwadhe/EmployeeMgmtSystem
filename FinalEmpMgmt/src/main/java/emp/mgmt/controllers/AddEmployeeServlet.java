package emp.mgmt.controllers;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import emp.mgmt.dao.EmployeeDao;
import emp.mgmt.dao.EmployeeDaoImpl;
import emp.mgmt.entities.Employee;

@MultipartConfig(maxFileSize = 1600000)
@WebServlet("/addEmployee")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Data get
		String name = request.getParameter("name");
		String salary = request.getParameter("salary");
		String leaveStatus = request.getParameter("leaveStatus");
		String doj = request.getParameter("doj");
		String bio = request.getParameter("bio");
		Part imagePart = request.getPart("profileImage");

		// Data validate
		System.out.println(name);
		System.out.println(salary);
		System.out.println(leaveStatus);
		System.out.println(doj);
		System.out.println(bio);

		// Conversion
		double sal = Double.parseDouble(salary);
		boolean leave = Boolean.parseBoolean(leaveStatus);
		java.sql.Date dateOfJoining = java.sql.Date.valueOf(doj);
		InputStream profileImage = imagePart.getInputStream();

		// Create Employee object
		Employee employee = new Employee(name, sal, dateOfJoining, bio, leave, profileImage);

		// Insert employee data in db

		try {
			EmployeeDao employeeDao = new EmployeeDaoImpl();

			int result = employeeDao.addEmployee(employee);

			if (result > 0) {
				response.sendRedirect("employee_list.jsp?message=Employee Added Successfully");
			} else {
				response.sendRedirect("employee_add.jsp?message=Employee can't be added. Try Again");
			}

		} catch (Exception e) {
			response.sendRedirect("employee_add.jsp?message=Employee can't be added. Try Again");
			e.printStackTrace();
		}
	}

}
