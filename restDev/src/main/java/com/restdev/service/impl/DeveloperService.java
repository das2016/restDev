package com.restdev.service.impl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.restdev.core.Developer;

/**
 * 
 * @author Skander.Bachouche
 *
 */
@Path("developer")
public class DeveloperService {

	/**
	 * 
	 */
	public DeveloperService() {
		super();
	}

	/**
	 * 
	 */
	@Path("name")
	@GET
	@Produces("application/json")
	public Developer getDeveloperName() {
		return new Developer("skan", "bachouche");
	}

	/**
	 * 
	 * @param first
	 * @param last
	 * @return
	 */
	@Path("{first}-{last}")
	@GET
	@Produces("application/xml")
	public Developer getDeveloper(@PathParam("first") String first, @PathParam("last") String last) {
		return new Developer(first, last);
	}

}
