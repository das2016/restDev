package com.restdev.service.impl;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.restdev.config.cassandra.CassandraUtil;
import com.restdev.core.Developer;
import com.restdev.exception.DeveloperException;
import com.restdev.service.DeveloperService;
import com.restdev.util.PropertiesUtil;

/**
 * 
 * @author Skander.Bachouche
 *
 */
public class DeveloperServiceImpl implements DeveloperService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DeveloperServiceImpl.class);

	/**
	 * 
	 */
	public DeveloperServiceImpl() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.restdev.service.DeveloperService#getDeveloperName()
	 */
	@Override
	public Response getDeveloperName() {
		return Response.ok().entity(new Developer("first", "bachouche")).build();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.restdev.service.DeveloperService#getDeveloperName(javax.ws.rs.core.
	 * HttpHeaders)
	 */
	@Override
	public JsonObject getDeveloperName(@Context HttpHeaders http) {
		Json.createObjectBuilder().add("lastName", "skander").build();
		throw new RuntimeException("all dev are in the conf");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.restdev.service.DeveloperService#getDeveloper(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Response getDeveloper(@PathParam("first") String first, @PathParam("last") String last) {
		System.err.println("Read properties : " + PropertiesUtil.getProperty("cassandra.host"));
		return Response.ok().entity(new Developer(first, last)).build();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.restdev.service.DeveloperService#add(com.restdev.core.Developer)
	 */
	@Override
	public Response add(Developer developer) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.restdev.service.DeveloperService#update(com.restdev.core.Developer)
	 */
	@Override
	public Response update(Developer developer) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.restdev.service.DeveloperService#delete(com.restdev.core.Developer)
	 */
	@Override
	public Response delete(Developer developer) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.restdev.service.DeveloperService#delete(java.lang.Long)
	 */
	@Override
	public Response delete(@PathParam("id") Long id) throws URISyntaxException, DeveloperException {
		try {

		} catch (RuntimeException e) {
			throw new RuntimeException("Cannot delete Developer there is no database yet");
		}
		return Response.ok().build();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.restdev.service.DeveloperService#getAllDeveloper()
	 */
	@Override
	public Response getAllDeveloper() {
		List<Developer> developers = new ArrayList<Developer>();
		try (Session session = CassandraUtil.getSession()) {
			ResultSet rs = session.execute("select * from developer");
			Iterator<Row> iterator = rs.iterator();
			while (iterator.hasNext()) {
				Row row = iterator.next();
				developers.add((Developer) row);
			}
		} catch (Exception e) {
			LOGGER.error("Exception in GetList Developer : " + e.getMessage());
		}
		return Response.ok().build();
	}
}
