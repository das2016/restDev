package com.restdev.service;

import java.net.URISyntaxException;

import javax.json.JsonObject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.restdev.core.Developer;
import com.restdev.exception.DeveloperException;

/**
 * 
 * @author Skander.Bachouche
 *
 */
@Path("developer")
@Produces(MediaType.APPLICATION_JSON)
public interface DeveloperService {

	/**
	 * Add new developer
	 * 
	 * @param developer
	 * @return
	 */
	Response add(Developer developer);

	/**
	 * Update Developer
	 * 
	 * @param developer
	 * @return
	 */
	Response update(Developer developer);

	/**
	 * Delete developer
	 * 
	 * @param developer
	 */
	Response delete(Developer developer);

	/**
	 * Delete developer
	 * 
	 * @param developer
	 * @throws DeveloperException 
	 */
	@DELETE
	@Path("delete/{id}")
	Response delete(@PathParam("id") Long id) throws URISyntaxException, DeveloperException;

	/**
	 * Get All Developer
	 * 
	 * @return
	 */
	Response getAllDeveloper();

	/**
	 * getDeveloperName
	 * 
	 * @return
	 */
	@Path("name")
	@GET
	Response getDeveloperName();

	/**
	 * getDeveloperName
	 * 
	 * @param http
	 * @return
	 */
	@Path("last")
	@GET
	JsonObject getDeveloperName(@Context HttpHeaders http);

	/**
	 * getDeveloper
	 * 
	 * @param first
	 * @param last
	 * @return
	 */
	@Path("{first}-{last}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	Response getDeveloper(@PathParam("first") String first, @PathParam("last") String last);
}
