package com.restdev.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Skander.Bachouche
 *
 */
public class PropertiesUtil {

	public static final Logger LOGGER = LoggerFactory.getLogger(PropertiesUtil.class);
	public static final String HOST = "cassandra.host";
	public static final String CLUSTER = "cassandra.cluster";
	public static final String APPLICATION_PROPERTIES = "application.properties";

	private static Properties properties = new Properties();
	private static InputStream input = PropertiesUtil.class.getClassLoader().getResourceAsStream(APPLICATION_PROPERTIES);

	/**
	 * 
	 * @param property
	 * @return
	 */
	public static String getProperty(String property) {
		try {
			properties.load(input);
		} catch (IOException exception) {
			LOGGER.error("IOException PropertiesUtil getProperty error : " + exception.getMessage());
		} finally {
			validateInpuStream();
		}
		return properties.getProperty(property);
	}

	/**
	 * Validate inputStream and close it
	 */
	private static void validateInpuStream() {
		if (input != null) {
			try {
				input.close();
			} catch (IOException exception) {
				LOGGER.error("IOException PropertiesUtil validateInpuStream error : " + exception.getMessage());
			}
		}
	}
}
