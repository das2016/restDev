package com.restdev.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * 
 * @author Skander.Bachouche
 *
 */
@Provider
public class RuntimeExceptionHandler implements ExceptionMapper<RuntimeException> {

	/**
	 * 
	 */
	@Override
	public Response toResponse(RuntimeException exception) {
		return Response.status(Status.INTERNAL_SERVER_ERROR).header("x-reason", exception.getMessage()).build();
	}

}
