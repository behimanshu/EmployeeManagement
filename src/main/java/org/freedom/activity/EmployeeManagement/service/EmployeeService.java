package org.freedom.activity.EmployeeManagement.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.freedom.activity.EmployeeManagement.database.DatabaseClass;
import org.freedom.activity.EmployeeManagement.model.Department;
import org.freedom.activity.EmployeeManagement.model.Employee;

public class EmployeeService {
	
	private Map<Long, Department> employeeMap = DatabaseClass.getDepartments();
	
//	public EmployeeService()
//	{
//		employeeMap.put(1L, new Employee(1, "Agarwal", "Him", "him.agar13@gmail.com", 9805948, "M", 24, 2015));
//		employeeMap.put(2L, new Employee(2, "Bin", "Nid", "him.13@gmail.com", 98448, "F", 24, 2015));
//	}
//	
	
	public List<Employee> getAllEmployees(long dept_id)
	{
		Map<Long, Employee> employees = employeeMap.get(dept_id).getDeptEmployeeMap();
		return new ArrayList<Employee>(employees.values());
		
//		List<Employee> employeeList = new ArrayList<>();
//		employeeList.addAll(employeeMap.values());
//		return employeeList;
	}
	
	
	public List<Employee> getEmployeesByYOJ(long dept_id, long emp_YOJ)
	{
		Map<Long, Employee> employees = employeeMap.get(dept_id).getDeptEmployeeMap();
		
		List<Employee> yearlyEmployeeList = new ArrayList<>();
		for(Employee employee:employees.values())
		{
			if(employee.getEmp_YOJ()==emp_YOJ)
			{
				yearlyEmployeeList.add(employee);
			}
		}
		return yearlyEmployeeList;
	}
	
	public List<Employee> getEmployeesByGender(long dept_id, String gender)
	{
		Map<Long, Employee> employees = employeeMap.get(dept_id).getDeptEmployeeMap();
		List<Employee> employeeGenderList = new ArrayList<>();
		for(Employee employee:employees.values())
		{
			if(employee.getEmp_gender().equals(gender))
			{
				employeeGenderList.add(employee);
			}
		}
		return employeeGenderList;
	}
	
	public List<Employee> getEmployeesByAge(long dept_id, int age)
	{
		Map<Long, Employee> employees = employeeMap.get(dept_id).getDeptEmployeeMap();	
		List<Employee> agewiseEmployeeList = new ArrayList<>();
		
		for(Employee employee:employees.values())
		{
			if(employee.getEmp_age()==age)
			{
				agewiseEmployeeList.add(employee);
			}
		}
		return agewiseEmployeeList;
	}
	
	public List<Employee> getAllEmployeesPaginated(long dept_id, int start, int size)
	{
		Map<Long, Employee> employees = employeeMap.get(dept_id).getDeptEmployeeMap();
		ArrayList<Employee> employeeList = new ArrayList<>(employees.values());
		if(start+size > employeeList.size())
		{
			return new ArrayList<Employee>();
		}
		
		return employeeList.subList(start, start+size);
		
	}
	
	public Employee getEmployee(long dept_id,long emp_id)
	{
		Map<Long, Employee> employees = employeeMap.get(dept_id).getDeptEmployeeMap();
		return employees.get(emp_id);
//		return employeeMap.get(emp_id);
	}
	
	public Employee addEmployee(long dept_id, Employee employee)
	{
		Map<Long, Employee> employees = employeeMap.get(dept_id).getDeptEmployeeMap();
		employee.setEmp_id(employees.size()+1);
		employees.put(employee.getEmp_id(), employee);
		return employee;
	}
	

	public Employee updateEmployee(long dept_id, Employee employee)
	{
		Map<Long, Employee> employees = employeeMap.get(dept_id).getDeptEmployeeMap();
		if(employee.getEmp_id()<=0)
		{
			return null;
		}
		employees.put(employee.getEmp_id(), employee);
		return employee;
	}
	
	public Employee removeEmployee(long dept_id, long emp_id)
	{
		Map<Long, Employee> employees = employeeMap.get(dept_id).getDeptEmployeeMap();
		return employees.remove(emp_id);
	}
	
}
