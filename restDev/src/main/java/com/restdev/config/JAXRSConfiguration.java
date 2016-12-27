package com.restdev.config;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * 
 * @author Skander.Bachouche
 *
 */
@ApplicationPath("v1")
public class JAXRSConfiguration extends Application {

	/**
	 * 
	 */
	public JAXRSConfiguration() {

	}

	// /*
	// * (non-Javadoc)
	// *
	// * @see javax.ws.rs.core.Application#getClasses()
	// */
	// @Override
	// public Set<Class<?>> getClasses() {
	// final Set<Class<?>> classes = new HashSet<Class<?>>();
	// // Features.
	// classes.add(JacksonFeature.class);
	// // Providers.
	// classes.add(JacksonJsonParamConverterProvider.class);
	// classes.add(ObjectMapperContextResolver.class);
	// // Resources.
	// classes.add(DeveloperServiceImpl.class);
	// return classes;
	// }

}
