package emp.mgmt.utils;

public class DbUtils {
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DB_BASE = "jdbc:mysql://localhost:3306";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/company_new";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "1234";
	
	public static final String CREATE_SCHEMA = "CREATE SCHEMA company_new";
	public static final String CREATE_TABLE = "CREATE TABLE employee (\r\n"
			+ "_id INT NOT NULL AUTO_INCREMENT,\r\n"
			+ "name VARCHAR(30) NOT NULL,\r\n"
			+ "salary DECIMAL (7, 2) NOT NULL,\r\n"
			+ "doj DATE NOT NULL,\r\n"
			+ "is_on_leave BIT(1) NOT NULL,\r\n"
			+ "bio LONGTEXT,\r\n"
			+ "profile_image longblob,\r\n"
			+ "PRIMARY KEY (_id));";
	
	public static final String INSERT_EMPLOYEE = "INSERT INTO employee "
			+ "(name, salary, doj, is_on_leave, bio, profile_image) VALUES (?,?,?,?,?,?)";
	
	public static final String UPDATE_EMPLOYEE = 
			"UPDATE employee SET name = ?, salary = ?, doj =?, is_on_leave = ?, bio = ?, profile_image = ? WHERE _id = ?";
	
	public static final String DELETE_EMPLOYEE = "DELETE FROM employee WHERE _id = ?";
	
	public static final String GET_ONE_EMPLOYEE = "SELECT * FROM employee WHERE _id = ?";
	
	public static final String GET_ALL_EMPLOYEES = "SELECT * FROM employee";

}
