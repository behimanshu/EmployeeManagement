package org.freedom.activity.EmployeeManagement.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {

	private long emp_id;
	private String emp_lname;
	private String emp_fname;
	private String emp_email;
	private long emp_phone;
	private String emp_gender;
	private int emp_age;
	private long emp_YOJ;
	
	public Employee(long emp_id, String emp_lname, String emp_fname, String emp_email, long emp_phone,
			String emp_gender, int emp_age, long emp_YOJ) {
		super();
		this.emp_id = emp_id;
		this.emp_lname = emp_lname;
		this.emp_fname = emp_fname;
		this.emp_email = emp_email;
		this.emp_phone = emp_phone;
		this.emp_gender = emp_gender;
		this.emp_age = emp_age;
		this.emp_YOJ = emp_YOJ;
	}
	public Employee()
	{
		
	}

	public long getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(long emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_lname() {
		return emp_lname;
	}

	public void setEmp_lname(String emp_lname) {
		this.emp_lname = emp_lname;
	}

	public String getEmp_fname() {
		return emp_fname;
	}

	public void setEmp_fname(String emp_fname) {
		this.emp_fname = emp_fname;
	}

	public String getEmp_email() {
		return emp_email;
	}

	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}

	public long getEmp_phone() {
		return emp_phone;
	}

	public void setEmp_phone(long emp_phone) {
		this.emp_phone = emp_phone;
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

	public long getEmp_YOJ() {
		return emp_YOJ;
	}

	public void setEmp_YOJ(long emp_YOJ) {
		this.emp_YOJ = emp_YOJ;
	}
	
	
	
	
	
	
}
