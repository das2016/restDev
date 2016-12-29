package com.restdev.dao.impl;

import java.net.URISyntaxException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.restdev.config.CassandraConfiguration;
import com.restdev.core.Developer;
import com.restdev.dao.DeveloperDao;
import com.restdev.exception.DeveloperException;
import com.restdev.util.DateUtil;

/**
 * 
 * @author Skander.Bachouche
 *
 */
public class DeveloperDaoImpl implements DeveloperDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeveloperDaoImpl.class);

    /*
     * (non-Javadoc)
     * 
     * @see com.restdev.dao.DeveloperDao#add(com.restdev.core.Developer)
     */
    @Override
    public Developer add(Developer developer) {
	try {
	    CassandraConfiguration.connect(CassandraConfiguration.HOST, CassandraConfiguration.CLUSTER,
		    CassandraConfiguration.PORT);
	    CassandraConfiguration.getSession()
		    .execute("INSERT INTO Developer (ID, NOM, PRENOM, DATE_RECRUTEMENT)" + "VALUES ('"
			    + developer.getId() + "','" + developer.getNom() + "','" + developer.getPrenom() + "','"
			    + DateUtil.dateToString(developer.getDateRecrutement()) + "');");
	} catch (Exception e) {
	    LOGGER.error(" Exception is thrown in add developer : " + e.getMessage());
	} finally {
	    CassandraConfiguration.shutdown();
	}
	return developer;
    }

    @Override
    public Developer update(Developer developer) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void delete(Developer developer) {
	// TODO Auto-generated method stub

    }

    @Override
    public void delete(Long id) throws URISyntaxException, DeveloperException {
	// TODO Auto-generated method stub

    }

    @Override
    public List<Developer> getAllDeveloper() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Developer getDeveloperName() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Developer getDeveloper(String first, String last) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Developer getDeveloperById(Long id) {
	// TODO Auto-generated method stub
	return null;
    }

}
