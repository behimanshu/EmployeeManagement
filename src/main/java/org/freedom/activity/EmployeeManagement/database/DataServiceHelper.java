package org.freedom.activity.EmployeeManagement.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.freedom.activity.EmployeeManagement.model.Department;
import org.freedom.activity.EmployeeManagement.model.Employee;

public class DataServiceHelper {
	private static Logger logger = Logger.getLogger(DataServiceHelper.class);
	public static DataServiceHelper dataServiceHelper = null;
	private Connection con = null;
	DataSource dataSource = null;
	InitialContext initialContext = null;
	public static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/freedomfinancialdatabase";
	public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";

	/**
	 * 
	 * This method is used to create an object for the given DAO class name.
	 */

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER_NAME);
		con = (Connection) DriverManager.getConnection(DB_URL, "root", "");
		return con;
	}

	// This method would close the connection and the assign the value to null,
	// to save memory

	public void closeConnection() throws SQLException {
		if (isConnectionOpen()) {
			con.close();
			con = null;
		}
	}

	// This method checks if the connection is open prior to creating a new
	// connection

	public boolean isConnectionOpen() {
		return (con != null);
	}

	/*
	 * This Singleton pattern approach with single object instance of
	 * DataServiceHelper, will be used to access the methods of this class
	 * 
	 */
	public static DataServiceHelper getInstance() {
		if (dataServiceHelper == null) {
			dataServiceHelper = new DataServiceHelper();
		}
		return dataServiceHelper;
	}

	/* This method would be called to perform generic update query */

	public void executeUpdateQuery(String query) throws SQLException, ClassNotFoundException {
		Connection con = getConnection();
		Statement stmt = con.createStatement();
		stmt.execute(query);
		closeConnection();
	}

	/*
	 * This method would be called to insert a new department into the database
	 */

	public void insertDepartmentQuery(String query, Department department) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		PreparedStatement statement = con.prepareStatement(query);
		statement.setString(1, department.getDept_name());
		statement.setString(2, department.getDept_location());
		statement.setString(3, department.getDept_expertise());
		statement.setInt(4, department.getDept_size());
		boolean response = statement.execute();
		if(response)
			logger.info("Successfully inserted department details");
		else
			logger.error("Oops! something went wrong while inserting department details");
		closeConnection();
	}

	/* This method would insert a new employee into a concerned department */

	public void insertEmployeeQuery(String query, Employee employee, int dept_id, boolean flag)
			throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		PreparedStatement statement = con.prepareStatement(query);
		statement.setString(1, employee.getEmp_lname());
		statement.setString(2, employee.getEmp_fname());
		statement.setString(3, employee.getEmp_email());
		statement.setDouble(4, employee.getEmp_phone());
		statement.setString(5, employee.getEmp_gender());
		statement.setInt(6, employee.getEmp_age());
		statement.setInt(7, employee.getEmp_YOJ());
		if (flag) {
			statement.setInt(8, dept_id);
		} else {
			statement.setInt(8, employee.getDept_id());
		}
		boolean response = statement.execute();
		if(response)
			logger.info("Successfully inserted employee details");
		else
			logger.error("Oops! something went wrong while inserting employee details");
		closeConnection();
	}

	/* This method would be called to delete a particular department */

	public void deleteDepartment(String query, int dept_id) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		PreparedStatement statement = con.prepareStatement(query);
		statement.setInt(1, dept_id);
		boolean response = statement.execute();
		if(response)
			logger.info("Successfully deleted department details");
		else
			logger.error("Oops! something went wrong while deleting department details");
		closeConnection();
	}

	/*
	 * This method would be called to delete a particular employee from a
	 * department
	 */

	public void deleteEmployee(String query, int emp_id) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		PreparedStatement statement = con.prepareStatement(query);
		statement.setInt(1, emp_id);
		boolean response = statement.execute();
		if(response)
			logger.info("Successfully deleted employee details");
		else
			logger.error("Oops! something went wrong while deleting employee details");
		closeConnection();
	}

	public ResultSet executeQuery(String query) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		// closeConnection();
		return rs;
	}
}