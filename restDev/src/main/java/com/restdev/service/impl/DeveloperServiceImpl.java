package com.restdev.service.impl;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.restdev.config.CassandraConfiguration;
import com.restdev.core.Developer;
import com.restdev.dao.DeveloperDao;
import com.restdev.dao.impl.DeveloperDaoImpl;
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
    private DeveloperDao developerDao = new DeveloperDaoImpl();

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
    public JsonObject getDeveloperName(HttpHeaders http) {
	return Json.createObjectBuilder().add("lastName", "skander").build();
	// throw new RuntimeException("all dev are in the conf");
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.restdev.service.DeveloperService#getDeveloper(java.lang.String,
     * java.lang.String)
     */
    @Override
    public Response getDeveloper(String first, String last) {
	System.out.println("Read properties : " + PropertiesUtil.getProperty("cassandra.host"));
	return Response.ok().entity(new Developer(first, last)).build();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.restdev.service.DeveloperService#add(com.restdev.core.Developer)
     */
    @Override
    public Response add(Developer developer) {
	try {
	    developerDao.add(developer);
	} catch (Exception e) {
	    throw new RuntimeException("Developer is null");
	}
	return Response.ok().entity("entity developer added with name : " + developer.getNom()).build();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.restdev.service.DeveloperService#update(com.restdev.core.Developer)
     */
    @Override
    public Response update(Developer developer) {
	developer.setNom("updatedname");
	System.out.println("Update new dveloper :" + developer.getNom() + "___" + developer.getPrenom());
	return Response.ok().entity("entity developer updated succefully : " + developer.getNom()).build();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.restdev.service.DeveloperService#delete(com.restdev.core.Developer)
     */
    @Override
    public Response delete(Developer developer) {
	System.out.println("Delete developer entity : " + developer.getNom());
	return Response.ok().entity("deleted developer entity : " + developer).build();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.restdev.service.DeveloperService#delete(java.lang.Long)
     */
    @Override
    public Response delete(Long id) throws URISyntaxException, DeveloperException {
	System.out.println("Delete developer entity : " + id);
	return Response.ok().entity("deleted developer by id :" + id).build();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.restdev.service.DeveloperService#getAllDeveloper()
     */
    @Override
    public Response getAllDeveloper() {
	List<Developer> developers = new ArrayList<Developer>();
	try (Session session = CassandraConfiguration.getSession()) {
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

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.restdev.service.DeveloperService#getDeveloperById(java.lang.Long)
     */
    @Override
    public Response getDeveloperById(Long id) {
	Developer developer = new Developer();
	developer.setId(id);
	developer.setNom("nom");
	developer.setPrenom("prenom");
	developer.setDateRecrutement(new Date());
	LOGGER.info("get developer entity by id: " + developer.getId() + "___" + developer.getNom());
	return Response.ok().entity(developer).build();
    }
}
