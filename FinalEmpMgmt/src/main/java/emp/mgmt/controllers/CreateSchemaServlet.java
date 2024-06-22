package emp.mgmt.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.mgmt.dao.EmployeeDao;
import emp.mgmt.dao.EmployeeDaoImpl;

@WebServlet("/createSchema")
public class CreateSchemaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDao employeeDao = new EmployeeDaoImpl();

		try {
			employeeDao.createSchema();
			response.sendRedirect("index.jsp?message=Schema Created Sucessfully");
		} catch (Exception e) {
			response.sendRedirect("index.jsp?message=Schema Creation Failed");
			e.printStackTrace();
		}
	}

}
