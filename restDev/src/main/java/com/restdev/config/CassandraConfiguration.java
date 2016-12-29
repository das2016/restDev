package com.restdev.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.Session;
import com.restdev.util.PropertiesUtil;

/**
 * 
 * @author Skander.Bachouche
 *
 */
public class CassandraConfiguration {

	public static final String HOST = PropertiesUtil.getProperty(PropertiesUtil.HOST);
	public static final String CLUSTER = PropertiesUtil.getProperty(PropertiesUtil.CLUSTER);
	public static final int PORT = Integer.parseInt(PropertiesUtil.getProperty(PropertiesUtil.PORT));

	private static final Logger LOGGER = LoggerFactory.getLogger(CassandraConfiguration.class);
	private static Cluster cluster;
	private static Session session;

	/**
	 * 
	 */
	private CassandraConfiguration() {
		super();
	}

	/**
	 * Connect to the cassandra database based on the connection configuration
	 * provided. Multiple call to this method will have no effects if a
	 * connection is already established
	 * 
	 * @param hostname
	 * @param keySpace
	 * @param port
	 */
	public static void connect(String hostname, String keySpace, int port) {
		if (session == null && cluster == null) {
			cluster = Cluster.builder().withPort(port).addContactPoints(hostname).build();
			session = cluster.connect(keySpace);
		}
		Metadata metadata = cluster.getMetadata();
		LOGGER.info("Connected to cluster: " + metadata.getClusterName() + " with partitioner: "
				+ metadata.getPartitioner());
		metadata.getAllHosts().stream().forEach((host) -> {
			System.out.println("Cassandra datacenter: " + host.getDatacenter() + " |address: " + host.getAddress()
					+ " | rack: " + host.getRack());
		});
	}

	/**
	 * Invalidate and close the session and connection to the cassandra database
	 */
	public static void shutdown() {
		LOGGER.info("Shutting down the whole cassandra cluster");
		if (null != session) {
			session.close();
		}
		if (null != cluster) {
			cluster.close();
		}
	}

	/**
	 * Get session if it exists
	 * 
	 * @return
	 */
	public static Session getSession() {
		if (session == null) {
			throw new IllegalStateException("No connection initialized");
		}
		return session;
	}

	public static void main(String[] args) {
		System.err.println("test");
		// CassandraConfiguration.connect(HOST, CLUSTER,
		// Integer.parseInt(PORT));
		// try {
		// ResultSet rs = session.execute("select * from restdev.Developer");
		// Iterator<Row> iterador = rs.iterator();
		// while (iterador.hasNext()) {
		// Row row = iterador.next();
		// LOGGER.info("Row : " + row.toString());
		// }
		//
		// } catch (Exception e) {
		// LOGGER.error("Exception occured : " + e.getMessage());
		// }
		// LOGGER.info("sessions state : " +
		// getSession().getState().getConnectedHosts());
		// shutdown();
	}
}
