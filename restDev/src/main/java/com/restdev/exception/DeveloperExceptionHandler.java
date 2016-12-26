package com.restdev.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * 
 * @author Skander.Bachouche
 *
 */
public class DeveloperExceptionHandler implements ExceptionMapper<DeveloperException> {

	/**
	 * 
	 */
	@Override
	public Response toResponse(DeveloperException exception) {
		return Response.status(Status.BAD_REQUEST).entity(new ErrorMessage(exception.getMessage()))
				.type(MediaType.APPLICATION_JSON).build();

	}

}
