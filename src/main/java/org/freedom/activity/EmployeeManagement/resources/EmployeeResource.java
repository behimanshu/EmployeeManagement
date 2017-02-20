package org.freedom.activity.EmployeeManagement.resources;

import java.sql.SQLException;
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
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.freedom.activity.EmployeeManagement.model.Department;
import org.freedom.activity.EmployeeManagement.model.Employee;
import org.freedom.activity.EmployeeManagement.resources.beans.EmployeeFilterBean;
import org.freedom.activity.EmployeeManagement.service.EmployeeService;

public class EmployeeResource {
	GenericEntity entity;
	EmployeeService employeeService = new EmployeeService();
	private Logger logger = Logger.getLogger(EmployeeResource.class);

	/*
	 * @GET service to fetch the employee content of a particular department
	 * from the database
	 */

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmployees(@BeanParam EmployeeFilterBean employeeBean)
			throws ClassNotFoundException, SQLException {

		/* Checks if the GET query consists of any filter related to emp_YOJ */
		if (employeeBean.getEmp_YOJ() > 0) {

			entity = new GenericEntity<List<Employee>>(
					employeeService.getEmployeesByYOJ(employeeBean.getDept_id(), employeeBean.getEmp_YOJ())) {
			};
			logger.info("Fetching employee details of queried year of joining");
			return Response.ok().entity(entity).build();
		}

		// *Checks if the GET query consists of any filter related to
		// emp_gender*/
		if (employeeBean.getEmp_gender() != null) {
			entity = new GenericEntity<List<Employee>>(
					employeeService.getEmployeesByGender(employeeBean.getDept_id(), employeeBean.getEmp_gender())) {
			};
			logger.info("Fetching employee details of queried gender");
			return Response.ok().entity(entity).build();
		}
		/* Checks if the GET query consists of any filter related to emp_age */
		if (employeeBean.getEmp_age() > 0) {

			entity = new GenericEntity<List<Employee>>(
					employeeService.getEmployeesByAge(employeeBean.getDept_id(), employeeBean.getEmp_age())) {
			};
			logger.info("Fetching employee details of the queried age");
			return Response.ok().entity(entity).build();
		}
		/* Checks if the GET query consists of any paginated request */
		if (employeeBean.getStart() >= 0 && employeeBean.getSize() > 0) {

			entity = new GenericEntity<List<Employee>>(employeeService.getAllEmployeesPaginated(
					employeeBean.getDept_id(), employeeBean.getStart(), employeeBean.getSize())) {
			};
			logger.info("Fetching employee details that match the paginated request");
			return Response.ok().entity(entity).build();
		}

		entity = new GenericEntity<List<Employee>>(employeeService.getAllEmployees(employeeBean.getDept_id())) {
		};
		logger.info("Fetching all employee details");
		return Response.ok().entity(entity).build();

	}

	/*
	 * @GET service to fetch the employee content of a particular emp_id from
	 * the database
	 */

	@GET
	@Path("/{emp_id}")
	@Produces(MediaType.APPLICATION_JSON)

	public Response getEmployee(@BeanParam EmployeeFilterBean employeeBean)
			throws ClassNotFoundException, SQLException {

		entity = new GenericEntity<Employee>(
				employeeService.getEmployee(employeeBean.getDept_id(), employeeBean.getEmp_id())) {
		};
		logger.info("Fetching the detail of employee " + employeeBean.getEmp_id());
		return Response.ok().entity(entity).build();
	}

	/* @POST service to create a new employee in a particular department */

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addEmployee(@BeanParam EmployeeFilterBean employeeBean, Employee employee)
			throws ClassNotFoundException, SQLException {

		entity = new GenericEntity<Employee>(employeeService.addEmployee(employeeBean.getDept_id(), employee)) {
		};
		return Response.ok().entity(entity).build();

	}

	/*
	 * @PUT service to update a particular employee in a particular department
	 */

	@PUT
	@Path("/{emp_id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateEmployee(@BeanParam EmployeeFilterBean employeeBean, Employee employee)
			throws ClassNotFoundException, SQLException {
		employee.setEmp_id(employeeBean.getEmp_id());

		entity = new GenericEntity<Employee>(employeeService.updateEmployee(employeeBean.getDept_id(), employee)) {
		};
		return Response.ok().entity(entity).build();

	}

	/* @DELETE service to delete a particular employee from a department */

	@DELETE
	@Path("/{emp_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeEmployee(@BeanParam EmployeeFilterBean employeeBean)
			throws ClassNotFoundException, SQLException {
		employeeService.removeEmployee(employeeBean.getDept_id(), employeeBean.getEmp_id());
		return Response.ok().build();
	}

}
