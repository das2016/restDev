package com.restdev.core;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Skander.Bachouche
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Developer {

	@XmlElement(name = "firstname")
	private String nom;
	@XmlElement(name = "lastname")
	private String prenom;

	/*
	 * Constructor
	 */
	/**
	 * 
	 */
	public Developer() {
		super();
	}

	/**
	 * @param nom
	 * @param prenom
	 */
	public Developer(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

}
