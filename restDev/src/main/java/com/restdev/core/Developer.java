package com.restdev.core;

import java.io.IOException;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author Skander.Bachouche
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Developer {

	@XmlElement(name = "id")
	private Long id;
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

	/**
	 * static factory method for JSON Object Mapper
	 * 
	 * @param jsonString
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
//	@JsonCreator
	public static Developer fromString(String jsonString) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Developer developer = null;
		developer = mapper.readValue(jsonString, Developer.class);
		return developer;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Developer [nom=" + nom + ", prenom=" + prenom + "]";
	}
	

	/*
	 * Getter and setter
	 */


	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom
	 *            the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}
