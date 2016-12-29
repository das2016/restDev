package com.restdev.service;

import java.net.URISyntaxException;

import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
@Consumes(MediaType.APPLICATION_JSON)
public interface DeveloperService {

	/**
	 * Add new developer
	 * 
	 * @param developer
	 * @return
	 */
	@POST
	@Path("add/{developer}")
	Response add(@PathParam("developer") Developer developer);

	/**
	 * Update Developer
	 * 
	 * @param developer
	 * @return
	 */
	@PUT
	@Path("update/{developer}")
	Response update(@PathParam("developer") Developer developer);

	/**
	 * Delete developer
	 * 
	 * @param developer
	 */
	@DELETE
	@Path("delete/{developer}")
	Response delete(@PathParam("developer") Developer developer);

	/**
	 * Delete developer
	 * 
	 * @param developer
	 * @throws DeveloperException
	 */
	@DELETE
	@Path("delete/id/{id}")
	Response delete(@PathParam("id") Long id) throws URISyntaxException, DeveloperException;

	/**
	 * Get All Developer
	 * 
	 * @return
	 */
	@GET
	@Path("all")
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
	 * Get Developer
	 * 
	 * @param first
	 * @param last
	 * @return
	 */
	@Path("{first}-{last}")
	@GET
	Response getDeveloper(@PathParam("first") String first, @PathParam("last") String last);

	/**
	 * Get Developer By Id
	 * 
	 * @param id
	 * @return
	 */
	@Path("id/{id}")
	@GET
	Response getDeveloperById(@PathParam("id") Long id);

}
