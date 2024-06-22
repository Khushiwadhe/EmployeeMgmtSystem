package emp.mgmt.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.mgmt.dao.EmployeeDao;
import emp.mgmt.dao.EmployeeDaoImpl;

@WebServlet("/deleteEmployee")
public class DeleteEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		int idInt = Integer.parseInt(id);
		String message = "Employee can't be deleted. Please try again";
		
		try {
			EmployeeDao employeeDao = new EmployeeDaoImpl();
			
			int result = employeeDao.removeEmployee(idInt);

			if (result > 0) {
				message = "Employee deleted successfully";
			}
		} catch (Exception e) {			
			e.printStackTrace();
		} 
		response.sendRedirect("employee_list.jsp?message="+message);
	}

}
