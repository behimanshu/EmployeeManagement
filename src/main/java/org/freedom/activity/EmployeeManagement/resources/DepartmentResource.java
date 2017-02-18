package org.freedom.activity.EmployeeManagement.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.freedom.activity.EmployeeManagement.model.Department;
import org.freedom.activity.EmployeeManagement.service.DepartmentService;

@Path("/departments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DepartmentResource {

DepartmentService departmentService = new DepartmentService();
	
	
	@GET
	public List<Department> getDepartments()
	{
		return departmentService.getAllDepartments();
	}
	
	
	@GET
	@Path("/{dept_id}")
	public Department getDepartment(@PathParam("dept_id") long dept_id)
	{
		return departmentService.getDepartment(dept_id);
		
	}
	
	@POST
	public Response addDepartment(Department department)
	{
		Department newDepartment = departmentService.addDepartment(department);
		
		//This returns the right status code, along with the entity that has been added
		return Response.status(Status.CREATED)		
				       .entity(newDepartment)
				       .build();
	}
	
	
	@PUT
	@Path("/{dept_id}")
	public Department updateDepartment(@PathParam("dept_id") Long dept_id, Department department)
	{
		department.setDept_id(dept_id);
		return departmentService.updateDepartment(department);
	}
	
	@DELETE
	@Path("/{dept_id}")
	public void removeDepartment(@PathParam("dept_id") Long dept_id)
	{
		departmentService.removeDepartment(dept_id);
	}
	
	@Path("/{dept_id}/employees")
	public EmployeeResource getDepartmentWiseEmployees()
	{
		return new EmployeeResource();
	}
	
	
}
