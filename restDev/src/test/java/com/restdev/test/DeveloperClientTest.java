package com.restdev.test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.restdev.core.Developer;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class DeveloperClientTest {

	public static void main(String[] args) {
		deleteMethod(1L);
//		try {
//			createMethod();
//		} catch (UnsupportedEncodingException e) {
//			System.err.println(e.getMessage());
//		}
//		getMethhod(1L);
	}

	/**
	 * 
	 * @param i
	 */
	private static void deleteMethod(Long i){
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/restDev/v1/developer/deletee/"+i);
		ClientResponse clientResponse = webResource.delete(ClientResponse.class);
		String output = clientResponse.getEntity(String.class);
		System.out.println(" OUTPUT DELETE : " + output);
		System.out.println(" RESPONSE DELETE : " + clientResponse.getResponseStatus());
		System.err.println("clientResponse.getStatus() "+clientResponse.getStatus());
		if(clientResponse.getStatus()==500){
			System.err.println("");
		}
	}
	
	/**
	 * @throws UnsupportedEncodingException 
	 * 
	 */
	private static void createMethod() throws UnsupportedEncodingException{
		Client client = Client.create();
		String uri = "http://localhost:8080/restDev/v1/developer/add/{\"id\":1,\"nom\":\"skan\",\"prenom\":\"bachouche\"}";
		WebResource webResource = client.resource(uri);
		ClientResponse clientResponse = webResource.post(ClientResponse.class);
		String output = clientResponse.getEntity(String.class);
		System.out.println(" OUTPUT POST : " + output);
	}
	
	/**
	 * 
	 */
	private static void updateMethod(){
		Client client = Client.create();
		Developer developer = new Developer();
		developer.setId(1l);
		developer.setNom("skan");
		developer.setPrenom("bach");
		WebResource webResource = client.resource("http://localhost:8080/restDev/v1/developer/update");
		ClientResponse clientResponse = webResource.post(ClientResponse.class);
		String output = clientResponse.getEntity(String.class);
		System.out.println(" OUTPUT POST : " + output);
	}
	
	/**
	 * 
	 * @param id
	 */
	private static void getMethhod(Long id){
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/restDev/v1/developer/id/"+id);
		ClientResponse clientResponse = webResource.get(ClientResponse.class);
		String output = clientResponse.getEntity(String.class);
		System.out.println(" OUTPUT GET : " + output);
	}
}
