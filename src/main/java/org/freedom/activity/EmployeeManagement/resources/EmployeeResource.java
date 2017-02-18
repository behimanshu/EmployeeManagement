package org.freedom.activity.EmployeeManagement.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.freedom.activity.EmployeeManagement.model.Employee;
import org.freedom.activity.EmployeeManagement.resources.beans.EmployeeFilterBean;
import org.freedom.activity.EmployeeManagement.service.EmployeeService;


public class EmployeeResource {

	EmployeeService employeeService = new EmployeeService();
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getEmployees(@BeanParam EmployeeFilterBean employeeBean)
	{

		
		if(employeeBean.getEmp_YOJ()>0)
		{
			return employeeService.getEmployeesByYOJ(employeeBean.getDept_id(), employeeBean.getEmp_YOJ());
		}
//		if(!emp_gender.equals(null))
//		{
//			return employeeService.getEmployeesByGender(emp_gender);
//		}
		if(employeeBean.getEmp_age()>0)
		{
			return employeeService.getEmployeesByAge(employeeBean.getDept_id(), employeeBean.getEmp_age());
		}
		
		if(employeeBean.getStart()>=0 && employeeBean.getSize()>0)
		{
			return employeeService.getAllEmployeesPaginated(employeeBean.getDept_id(), employeeBean.getStart(), employeeBean.getSize());
		}
		
		return employeeService.getAllEmployees(employeeBean.getDept_id());	
	}
	
	
	@GET
	@Path("/{emp_id}")
	@Produces(MediaType.APPLICATION_JSON)
	
	public Employee getEmployee(@BeanParam EmployeeFilterBean employeeBean)
	{
		return employeeService.getEmployee(employeeBean.getDept_id(), employeeBean.getEmp_id());
		
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Employee addEmployee(@BeanParam EmployeeFilterBean employeeBean, Employee employee)
	{
		return employeeService.addEmployee(employeeBean.getDept_id(), employee);
	}
	
	
	@PUT
	@Path("/{emp_id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Employee updateEmployee(@BeanParam EmployeeFilterBean employeeBean, Employee employee)
	{
		employee.setEmp_id(employeeBean.getEmp_id());
		return employeeService.updateEmployee(employeeBean.getDept_id(), employee);
	}
	
	@DELETE
	@Path("/{emp_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void removeEmployee(@BeanParam EmployeeFilterBean employeeBean)
	{
		employeeService.removeEmployee(employeeBean.getDept_id(), employeeBean.getEmp_id());
	}
		
}
