package emp.mgmt.dao;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import emp.mgmt.entities.Employee;
import emp.mgmt.utils.DbUtils;

public class EmployeeDaoImpl implements EmployeeDao {

	Connection getConnection() throws Exception {

		Class.forName(DbUtils.DRIVER);

		Connection con = DriverManager.getConnection(DbUtils.DB_URL, DbUtils.USERNAME, DbUtils.PASSWORD);

		return con;
	}

	@Override
	public void createSchema() throws Exception {

		Class.forName(DbUtils.DRIVER);

		Connection con = DriverManager.getConnection(DbUtils.DB_BASE, DbUtils.USERNAME, DbUtils.PASSWORD);

		Statement stmt = con.createStatement();

		int result = stmt.executeUpdate(DbUtils.CREATE_SCHEMA);
		System.out.println("\n Result: " + result);
	}

	@Override
	public void createTable() throws Exception {
		Connection con = getConnection();
		Statement stmt = con.createStatement();
		int result = stmt.executeUpdate(DbUtils.CREATE_TABLE);
		System.out.println("\n Result: " + result);
	}

	@Override
	public int addEmployee(Employee employee) throws Exception {

		Connection con = getConnection();

		PreparedStatement pStmt = con.prepareStatement(DbUtils.INSERT_EMPLOYEE);

		pStmt.setString(1, employee.getName());
		pStmt.setDouble(2, employee.getSalary());
		pStmt.setDate(3, employee.getDateOfJoining());
		pStmt.setBoolean(4, employee.isOnLeave());
		pStmt.setString(5, employee.getBio());
		pStmt.setBlob(6, employee.getProfileImage());

		int result = pStmt.executeUpdate();

		return result;
	}

	@Override
	public int modifyEmployee(Employee employee) throws Exception {

		Connection con = getConnection();

		PreparedStatement pStmt = con.prepareStatement(DbUtils.UPDATE_EMPLOYEE);

		pStmt.setString(1, employee.getName());
		pStmt.setDouble(2, employee.getSalary());
		pStmt.setDate(3, employee.getDateOfJoining());
		pStmt.setBoolean(4, employee.isOnLeave());
		pStmt.setString(5, employee.getBio());
		pStmt.setBlob(6, employee.getProfileImage());
		pStmt.setInt(7, employee.getId());

		return pStmt.executeUpdate();
	}

	@Override
	public int removeEmployee(int empId) throws Exception {

		Connection con = getConnection();

		PreparedStatement pStmt = con.prepareStatement(DbUtils.DELETE_EMPLOYEE);

		pStmt.setInt(1, empId);

		return pStmt.executeUpdate();
	}

	@Override
	public Employee fetchEmployeeDetails(int empId) throws Exception {

		Connection con = getConnection();

		PreparedStatement pStmt = con.prepareStatement(DbUtils.GET_ONE_EMPLOYEE);

		pStmt.setInt(1, empId);

		ResultSet rSet = pStmt.executeQuery();

		Employee employee = null;

		if (rSet.next()) {

			int id = rSet.getInt("_id");
			String name = rSet.getString("name");
			double salary = rSet.getDouble("salary");
			java.sql.Date doj = rSet.getDate("doj");
			boolean leaveStatus = rSet.getBoolean("is_on_leave");
			String bio = rSet.getString("bio");
			Blob prfileBlob = rSet.getBlob("profile_image");
			InputStream profileImage = prfileBlob.getBinaryStream();

			employee = new Employee(id, name, salary, doj, bio, leaveStatus, profileImage);
		}

		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() throws Exception {

		Connection con = getConnection();

		Statement stmt = con.createStatement();

		ResultSet rSet = stmt.executeQuery(DbUtils.GET_ALL_EMPLOYEES);

		List<Employee> employees = new ArrayList<Employee>();

		while (rSet.next()) {
			int id = rSet.getInt("_id");
			String name = rSet.getString("name");
			double salary = rSet.getDouble("salary");
			java.sql.Date doj = rSet.getDate("doj");
			boolean leaveStatus = rSet.getBoolean("is_on_leave");
			String bio = rSet.getString("bio");
			Blob prfileBlob = rSet.getBlob("profile_image");
			InputStream profileImage = prfileBlob.getBinaryStream();

			employees.add(new Employee(id, name, salary, doj, bio, leaveStatus, profileImage));
		}

		return employees;
	}

}
