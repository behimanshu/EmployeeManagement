package org.freedom.activity.EmployeeManagement.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.freedom.activity.EmployeeManagement.database.DataServiceHelper;
import org.freedom.activity.EmployeeManagement.database.DatabaseClass;
import org.freedom.activity.EmployeeManagement.exception.DataNotFoundException;
import org.freedom.activity.EmployeeManagement.model.Department;
import org.freedom.activity.EmployeeManagement.model.Employee;

public class EmployeeService {

	private DataServiceHelper dataServiceHelper;
	private Map<Long, Department> employeeMap = DatabaseClass.getDepartments();
	private static final Logger logger = Logger.getLogger(EmployeeService.class);

	public EmployeeService() {
		dataServiceHelper = new DataServiceHelper();
	}

	public Employee employeeMapping(ResultSet empRS) throws SQLException {
		Employee employee = new Employee();
		employee.setEmp_id(empRS.getInt("emp_id"));
		employee.setEmp_lname(empRS.getString("emp_lname"));
		employee.setEmp_fname(empRS.getString("emp_fname"));
		employee.setEmp_email(empRS.getString("emp_email"));
		employee.setEmp_phone(empRS.getDouble("emp_phone"));
		employee.setEmp_gender(empRS.getString("emp_gender"));
		employee.setEmp_age(empRS.getInt("emp_age"));
		employee.setEmp_YOJ(empRS.getInt("emp_YOJ"));
		employee.setDept_id(empRS.getInt("dept_id"));
		return employee;
	}

	/*
	 * This method will be called to gather the employee details of a particular
	 * department
	 */
	public List<Employee> getAllEmployees(int dept_id) throws ClassNotFoundException, SQLException {
		ResultSet empRS = dataServiceHelper.executeQuery("Select * from employee where dept_id=" + dept_id);

		List<Employee> employeeList = new ArrayList<>();
		while (empRS.next()) {
			Employee employee = employeeMapping(empRS);
			employeeList.add(employee);
		}

		if (employeeList.isEmpty()) {
			throw new DataNotFoundException("This department has no employees");
		}

		return employeeList;

	}

	/*
	 * This method will be called to filter the employees on the basis of their
	 * year of joining
	 */
	public List<Employee> getEmployeesByYOJ(int dept_id, int emp_YOJ) throws ClassNotFoundException, SQLException {
		ResultSet empRS = dataServiceHelper
				.executeQuery("Select * from employee where dept_id=" + dept_id + " and emp_YOJ=" + emp_YOJ);
		List<Employee> yearlyEmployeeList = new ArrayList<>();
		while (empRS.next()) {
			Employee employee = employeeMapping(empRS);
			yearlyEmployeeList.add(employee);
		}

		if (yearlyEmployeeList.isEmpty()) {
			throw new DataNotFoundException("No employees found with YOJ= " + emp_YOJ);
		}

		return yearlyEmployeeList;
	}

	/*
	 * This method will be called to filter the employees on the basis of their
	 * gender
	 */
	public List<Employee> getEmployeesByGender(int dept_id, String emp_gender)
			throws ClassNotFoundException, SQLException {
		ResultSet empRS = dataServiceHelper
				.executeQuery("Select * from employee where dept_id=" + dept_id + " and emp_gender=" + emp_gender);

		List<Employee> employeeGenderList = new ArrayList<>();
		while (empRS.next()) {
			Employee employee = employeeMapping(empRS);
			employeeGenderList.add(employee);
		}

		if (employeeGenderList.isEmpty()) {
			throw new DataNotFoundException("No employees found in Gender= " + emp_gender);
		}

		return employeeGenderList;
	}

	/*
	 * This method will be called to filter the employees on the basis of their
	 * age
	 */
	public List<Employee> getEmployeesByAge(int dept_id, int emp_age) throws ClassNotFoundException, SQLException {
		ResultSet empRS = dataServiceHelper
				.executeQuery("Select * from employee where dept_id=" + dept_id + " and emp_age=" + emp_age);
		List<Employee> agewiseEmployeeList = new ArrayList<>();
		while (empRS.next()) {
			Employee employee = employeeMapping(empRS);
			agewiseEmployeeList.add(employee);
		}

		if (agewiseEmployeeList.isEmpty()) {
			throw new DataNotFoundException("Employees with Age= " + emp_age + " are not found in this department");
		}

		return agewiseEmployeeList;
	}

	/*
	 * This method will be called to paginate the employees on the basis of
	 * start value to count of employees from the start value
	 */
	public List<Employee> getAllEmployeesPaginated(int dept_id, int start, int size)
			throws ClassNotFoundException, SQLException {
		ResultSet empRS = dataServiceHelper.executeQuery("Select * from employee where dept_id=" + dept_id);
		List<Employee> paginatedEmployeeList = new ArrayList<>();
		while (empRS.next()) {
			Employee employee = employeeMapping(empRS);
			paginatedEmployeeList.add(employee);
		}

		if (paginatedEmployeeList.isEmpty()) {
			throw new DataNotFoundException("No employees are found from entered range in this department");
		}

		return paginatedEmployeeList.subList(start, start + size);

	}

	/* This method will be called to get the employee of a particular emp_id */
	public Employee getEmployee(int dept_id, int emp_id) throws ClassNotFoundException, SQLException {
		ResultSet empRS = dataServiceHelper.executeQuery("Select * from employee where emp_id=" + emp_id);
		Employee employee = null;
		while (empRS.next()) {
			employee = employeeMapping(empRS);
			employee.setDept_id(dept_id);
		}

		if (employee == null) {
			throw new DataNotFoundException("Employee with ID " + emp_id + " not found in this department");
		}

		return employee;

	}

	/*
	 * This method will be called to add an employee into a particular
	 * department
	 */
	public Employee addEmployee(int dept_id, Employee employee) throws ClassNotFoundException, SQLException {

		boolean flag = true;
		String query = " insert into employee (emp_lname, emp_fname, emp_email, emp_phone, emp_gender, emp_age, emp_YOJ, dept_id)"
				+ " values (?, ?, ?, ?, ?, ?, ?, ?)";

		dataServiceHelper.insertEmployeeQuery(query, employee, dept_id, flag);
		employee.setDept_id(dept_id);
		return employee;

	}

	/* This method will be called to update a particular employee */
	public Employee updateEmployee(int dept_id, Employee employee) throws ClassNotFoundException, SQLException {

		String query = "update employee set emp_lname = ?, emp_fname = ?, emp_email =?, emp_phone=?, emp_gender=?,emp_age=?, emp_YOJ=?,  dept_id=? WHERE emp_id="
				+ employee.getEmp_id();
		dataServiceHelper.insertEmployeeQuery(query, employee, dept_id, false);
		employee.setDept_id(dept_id);
		return employee;
	}

	/*
	 * This method will be called to remove a particular employee from the
	 * department
	 */
	public void removeEmployee(int dept_id, int emp_id) throws ClassNotFoundException, SQLException {
		String query = "delete from employee where emp_id=?";
		dataServiceHelper.deleteEmployee(query, emp_id);

	}

}
