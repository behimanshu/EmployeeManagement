package org.freedom.activity.EmployeeManagement.exception;

import java.sql.SQLException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.freedom.activity.EmployeeManagement.model.ErrorMessage;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

/* A Generic ExceptionMapper class to deal with MySQLIntegrityConstraintViolationException*/

@Provider
public class MySQLIntegrityConstraintViolationExceptionMapper
		implements ExceptionMapper<MySQLIntegrityConstraintViolationException> {

	@Override
	public Response toResponse(MySQLIntegrityConstraintViolationException ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 500, "http://stackoverflow.com/");
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorMessage).type(MediaType.APPLICATION_JSON)
				.build();
	}

}
