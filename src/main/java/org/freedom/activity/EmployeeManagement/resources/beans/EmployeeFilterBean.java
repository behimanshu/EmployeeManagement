package org.freedom.activity.EmployeeManagement.resources.beans;

import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

/*Common Bean class to keep a track of all the @Params called in the API call*/

public class EmployeeFilterBean {
	private @PathParam("dept_id") int dept_id;
	private @PathParam("emp_id") int emp_id;
	private @QueryParam("emp_YOJ") int emp_YOJ;
	private @QueryParam("emp_gender") String emp_gender;
	private @QueryParam("emp_age") int emp_age;
	private @QueryParam("start") int start;
	private @QueryParam("size") int size;
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public int getEmp_YOJ() {
		return emp_YOJ;
	}
	public void setEmp_YOJ(int emp_YOJ) {
		this.emp_YOJ = emp_YOJ;
	}
	public String getEmp_gender() {
		return emp_gender;
	}
	public void setEmp_gender(String emp_gender) {
		this.emp_gender = emp_gender;
	}
	public int getEmp_age() {
		return emp_age;
	}
	public void setEmp_age(int emp_age) {
		this.emp_age = emp_age;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	
	
	
	
	
}
