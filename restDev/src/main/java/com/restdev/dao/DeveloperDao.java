package com.restdev.dao;

import java.net.URISyntaxException;
import java.util.List;

import com.restdev.core.Developer;
import com.restdev.exception.DeveloperException;

/**
 * 
 * @author Skander.Bachouche
 *
 */
public interface DeveloperDao {

	/**
	 * Add new developer
	 * 
	 * @param developer
	 * @return
	 */
	Developer add(Developer developer);

	/**
	 * Update Developer
	 * 
	 * @param developer
	 * @return
	 */
	Developer update(Developer developer);

	/**
	 * Delete developer
	 * 
	 * @param developer
	 */
	void delete(Developer developer);

	/**
	 * Delete developer
	 * 
	 * @param developer
	 * @throws DeveloperException
	 */
	void delete(Long id) throws URISyntaxException, DeveloperException;

	/**
	 * Get All Developer
	 * 
	 * @return
	 */
	List<Developer> getAllDeveloper();

	/**
	 * getDeveloperName
	 * 
	 * @return
	 */
	Developer getDeveloperName();

	/**
	 * Get Developer By name and lastName
	 * 
	 * @param first
	 * @param last
	 * @return
	 */
	Developer getDeveloper(String first, String last);

	/**
	 * Get Developer By Id
	 * 
	 * @param id
	 * @return
	 */
	Developer getDeveloperById(Long id);
}
