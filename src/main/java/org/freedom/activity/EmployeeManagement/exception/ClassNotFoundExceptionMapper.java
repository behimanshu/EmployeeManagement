package org.freedom.activity.EmployeeManagement.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.freedom.activity.EmployeeManagement.model.ErrorMessage;

/* A Generic ExceptionMapper class to deal with ClassNotFoundException*/
@Provider
public class ClassNotFoundExceptionMapper implements ExceptionMapper<ClassNotFoundException> {

	@Override
	public Response toResponse(ClassNotFoundException ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 500, "http://stackoverflow.com/");
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorMessage).type(MediaType.APPLICATION_JSON)
				.build();
	}

}
