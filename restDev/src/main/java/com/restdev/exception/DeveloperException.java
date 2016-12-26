package com.restdev.exception;

import java.io.Serializable;

/**
 * 
 * @author Skander.Bachouche
 *
 */
public class DeveloperException extends Exception implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public DeveloperException() {
		super();
	}

	/**
	 * 
	 * @param message
	 */
	public DeveloperException(String message) {
		super(message);
	}

	/**
	 * 
	 * @param message
	 * @param e
	 */
	public DeveloperException(String message, Exception e) {
		super(message, e);
	}

}
