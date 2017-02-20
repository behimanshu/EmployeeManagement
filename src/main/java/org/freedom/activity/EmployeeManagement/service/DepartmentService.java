package org.freedom.activity.EmployeeManagement.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.freedom.activity.EmployeeManagement.database.DataServiceHelper;
import org.freedom.activity.EmployeeManagement.exception.DataNotFoundException;
import org.freedom.activity.EmployeeManagement.model.Department;

public class DepartmentService {

	private DataServiceHelper dataServiceHelper;

	public DepartmentService() {

		dataServiceHelper = new DataServiceHelper();
	}

	public Department departmentMapping(ResultSet deptRS) throws SQLException {
		Department department = new Department();
		department.setDept_id(deptRS.getInt("dept_id"));
		department.setDept_location(deptRS.getString("dept_location"));
		department.setDept_expertise(deptRS.getString("dept_expertise"));
		department.setDept_name(deptRS.getString("dept_name"));
		department.setDept_size(deptRS.getInt("dept_size"));
		return department;
	}

	/*
	 * This method will be called to retrieve the list of all departments in the
	 * database
	 */
	public List<Department> getAllDepartments() throws ClassNotFoundException, SQLException {
		ResultSet deptRS = dataServiceHelper.executeQuery("Select * from department");
		List<Department> departmentList = new ArrayList<>();
		while (deptRS.next()) {
			Department department = departmentMapping(deptRS);
			departmentList.add(department);
		}
		if (departmentList.isEmpty()) {
			throw new DataNotFoundException("No Departments exist in the database");
		}
		return departmentList;
	}

	/*
	 * This method will be called to retrieve a department of a particular
	 * dept_id
	 */
	public Department getDepartment(int dept_id) throws ClassNotFoundException, SQLException {

		ResultSet deptRS = dataServiceHelper.executeQuery("Select * from department where dept_id=" + dept_id);
		Department department = null;
		while (deptRS.next()) {
			department = departmentMapping(deptRS);

		}

		if (department == null) {
			throw new DataNotFoundException("Department with ID " + dept_id + " not found");

		}
		return department;
	}

	/* This method will be called to insert a new department in the database */
	public Department addDepartment(Department department) throws ClassNotFoundException, SQLException {

		String query = " insert into department (dept_name, dept_location, dept_expertise,  dept_size)"
				+ " values (?, ?, ?, ?)";

		dataServiceHelper.insertDepartmentQuery(query, department);
		return department;
	}

	/* This method will be called to update a particular department */
	public Department updateDepartment(Department department) throws ClassNotFoundException, SQLException {
		if (department.getDept_id() < 0) {
			return null;
		}
		String query = "update department set dept_name = ?, dept_location =?, dept_expertise =?, dept_size = ? WHERE dept_id="
				+ department.getDept_id();

		dataServiceHelper.insertDepartmentQuery(query, department);
		return department;
	}

	/*
	 * This method will be called to remove a particular department from the
	 * database
	 */
	public void removeDepartment(int dept_id) throws ClassNotFoundException, SQLException {

		String query = "delete from department where dept_id=?";
		dataServiceHelper.deleteDepartment(query, dept_id);

	}

}
