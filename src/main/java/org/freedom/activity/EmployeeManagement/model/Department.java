package org.freedom.activity.EmployeeManagement.model;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Department {

	private int dept_id;
	private String dept_name;
	private String dept_location;
	private int dept_size;
	private String dept_expertise;
	private Map<Long, Employee> deptEmployeeMap = new HashMap<>();

	public Department(int dept_id, String dept_name, String dept_location, int dept_size, String dept_expertise,
			Map<Long, Employee> deptEmployeeMap) {
		super();
		this.dept_id = dept_id;
		this.dept_name = dept_name;
		this.dept_location = dept_location;
		this.dept_size = dept_size;
		this.dept_expertise = dept_expertise;
		this.deptEmployeeMap = deptEmployeeMap;
	}
	
	public Department() {
		super();
	}

	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getDept_location() {
		return dept_location;
	}

	public void setDept_location(String dept_location) {
		this.dept_location = dept_location;
	}

	public int getDept_size() {
		return dept_size;
	}

	public void setDept_size(int dept_size) {
		this.dept_size = dept_size;
	}

	public String getDept_expertise() {
		return dept_expertise;
	}

	public void setDept_expertise(String dept_expertise) {
		this.dept_expertise = dept_expertise;
	}

	
	
@XmlTransient	
	public Map<Long, Employee> getDeptEmployeeMap() {
		return deptEmployeeMap;
	}

	public void setDeptEmployeeMap(Map<Long, Employee> deptEmployeeMap) {
		this.deptEmployeeMap = deptEmployeeMap;
	}

	

}
