package org.freedom.activity.EmployeeManagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.freedom.activity.EmployeeManagement.database.DatabaseClass;
import org.freedom.activity.EmployeeManagement.model.Department;

public class DepartmentService {

private Map<Long, Department> departmentMap = DatabaseClass.getDepartments();
	
	public DepartmentService()
	{
		departmentMap.put(1L, new Department(1, "Science", "Charlotte", 25, "Analytics"));
		departmentMap.put(2L, new Department(2, "Social", "Salisbury", 890, "Analytics"));
	}
	
	
	public List<Department> getAllDepartments()
	{
		List<Department> departmentList = new ArrayList<>();
		departmentList.addAll(departmentMap.values());
		return departmentList;
	}
	
	public Department getDepartment(Long dept_id)
	{
		return departmentMap.get(dept_id);
	}
	
	public Department addDepartment(Department department)
	{
		department.setDept_id(departmentMap.size()+1);
		departmentMap.put(department.getDept_id(), department);
		return department;
	}
	

	public Department updateDepartment(Department department)
	{
		
		if(department.getDept_id()<0)
		{
			return null;
		}
		departmentMap.put(department.getDept_id(), department);
		return department;
	}
	
	public Department removeDepartment(Long dept_id)
	{
		return departmentMap.remove(dept_id);
	}
	
	
}
