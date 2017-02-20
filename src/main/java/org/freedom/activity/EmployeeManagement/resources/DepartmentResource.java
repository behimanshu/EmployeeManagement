package org.freedom.activity.EmployeeManagement.resources;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.freedom.activity.EmployeeManagement.model.Department;
import org.freedom.activity.EmployeeManagement.service.DepartmentService;

@Path("/departments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DepartmentResource {
	private Logger logger = Logger.getLogger(DepartmentResource.class);
	DepartmentService departmentService = new DepartmentService();

	/*
	 * Standard @GET service that would handle the request to get all the
	 * departments from the database
	 */
	@GET
	public Response getDepartments() throws ClassNotFoundException, SQLException {
		GenericEntity<List<Department>> entity = new GenericEntity<List<Department>>(
				departmentService.getAllDepartments()) {
		};
		logger.info("Fetching all the departments");
		return Response.ok().entity(entity).build();
	}

	/*
	 * @GET service to get the department from the database on the basis of a
	 * particular dept_id
	 */

	@GET
	@Path("/{dept_id}")
	public Response getDepartment(@PathParam("dept_id") int dept_id) throws ClassNotFoundException, SQLException {
		logger.info("Fetching department with ID= " + dept_id);
		return Response.ok().entity(departmentService.getDepartment(dept_id)).build();
	}

	/* @POST service to create a new department row in the database */

	@POST
	public Response addDepartment(Department department) throws ClassNotFoundException, SQLException {
		Department newDepartment = departmentService.addDepartment(department);

		// This returns the right status code, along with the entity that has
		// been added
		return Response.status(Status.CREATED).entity(newDepartment).build();
	}

	/* @PUT service to update the contents of a particular department */

	@PUT
	@Path("/{dept_id}")
	public Response updateDepartment(@PathParam("dept_id") int dept_id, Department department)
			throws ClassNotFoundException, SQLException {
		department.setDept_id(dept_id);
		GenericEntity<Department> entity = new GenericEntity<Department>(
				departmentService.updateDepartment(department)) {
		};
		return Response.ok().entity(entity).build();
	}

	/* @DELETE service to delete a particular department from the database */

	@DELETE
	@Path("/{dept_id}")
	public Response removeDepartment(@PathParam("dept_id") int dept_id) throws ClassNotFoundException, SQLException {
		departmentService.removeDepartment(dept_id);
		return Response.ok().build();
	}

	/*
	 * This method would delegate the request to fetch the employees for
	 * particular dept_id, from the database
	 */

	@Path("/{dept_id}/employees")
	public EmployeeResource getDepartmentWiseEmployees() {
		return new EmployeeResource();
	}

}
