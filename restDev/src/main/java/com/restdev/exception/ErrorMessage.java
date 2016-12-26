package com.restdev.exception;

/**
 * 
 * @author Skander.Bachouche
 *
 */
public class ErrorMessage {

	private String errorMessage;

	/*
	 * Constructor
	 */
	/**
	 * 
	 */
	public ErrorMessage() {
	}

	/**
	 * @param errorMessage
	 */
	public ErrorMessage(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}
	/*
	 * Getter and setter
	 */

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage
	 *            the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
