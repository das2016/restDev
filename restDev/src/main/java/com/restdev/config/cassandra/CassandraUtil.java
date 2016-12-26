package com.restdev.config.cassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.restdev.util.PropertiesUtil;

/**
 * 
 * @author Skander.Bachouche
 *
 */
public class CassandraUtil {

	/**
	 * 
	 * @return
	 */
	public static Session getSession() {
		String host = PropertiesUtil.getProperty(PropertiesUtil.HOST);
		Cluster cluster = Cluster.builder().addContactPoint(host).build();
		return cluster.connect(PropertiesUtil.CLUSTER);

	}
	
	
}
