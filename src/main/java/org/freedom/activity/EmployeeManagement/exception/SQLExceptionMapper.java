package org.freedom.activity.EmployeeManagement.exception;

import java.sql.SQLException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.freedom.activity.EmployeeManagement.model.ErrorMessage;

/* A Generic ExceptionMapper class to deal with SQLException*/

@Provider
public class SQLExceptionMapper implements ExceptionMapper<SQLException> {

	@Override
	public Response toResponse(SQLException ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 500, "http://stackoverflow.com/");
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorMessage).type(MediaType.APPLICATION_JSON)
				.build();
	}

}
