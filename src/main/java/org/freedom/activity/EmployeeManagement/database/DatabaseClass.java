package org.freedom.activity.EmployeeManagement.database;

import java.util.HashMap;
import java.util.Map;

import org.freedom.activity.EmployeeManagement.model.Department;
import org.freedom.activity.EmployeeManagement.model.Employee;

public class DatabaseClass {
	
	private static Map<Long, Employee> employeeMap = new HashMap<>();
	private static Map<Long, Department> departmentMap = new HashMap<>();
	
	
	public static Map<Long, Employee> getEmployees()
	{
		return employeeMap;
		
	}
	
	public static Map<Long, Department> getDepartments()
	{
		return departmentMap;
		
	}
	

}
