package com.restdev.service;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.restdev.core.Developer;

/**
 * 
 * @author Skander.Bachouche
 *
 */
@Path("service")
public class RestService {

	/**
	 * Hello world test method
	 * 
	 * @return
	 */
	@Path("/hello")
	@GET
	@Produces("application/xml")
	public Developer helloWorld() {
		return new Developer("test", "test");
	}

	@Path("/test")
	@GET
	@Produces("text/plain")
	@Consumes("application/xml")
	public JsonObject test() {
		return Json.createObjectBuilder().add("name", "skan").build();
	}

}
