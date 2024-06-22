package emp.mgmt.dao;

import java.util.List;

import emp.mgmt.entities.Employee;

public interface EmployeeDao {

	void createSchema() throws Exception;

	void createTable() throws Exception;

	int addEmployee(Employee employee) throws Exception;

	int modifyEmployee(Employee employee) throws Exception;

	int removeEmployee(int empId) throws Exception;

	Employee fetchEmployeeDetails(int empId) throws Exception;

	List<Employee> getAllEmployees() throws Exception;

}
