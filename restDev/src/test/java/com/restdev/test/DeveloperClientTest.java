package com.restdev.test;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import com.restdev.core.Developer;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class DeveloperClientTest {

    public static void main(String[] args) {
try {
    createMethod();
} catch (UnsupportedEncodingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
    }

    /**
     * 
     * @param i
     */
    private static void deleteMethod(Long i) {
	Client client = Client.create();
	WebResource webResource = client.resource("http://localhost:8080/restDev/v1/developer/delete/id/" + i);
	ClientResponse clientResponse = webResource.delete(ClientResponse.class);
	String output = clientResponse.getEntity(String.class);
	System.out.println(" OUTPUT DELETE : " + output);
	System.out.println(" RESPONSE DELETE : " + clientResponse.getResponseStatus());
	System.err.println("clientResponse.getStatus() " + clientResponse.getStatus());
    }

    /**
     * @throws UnsupportedEncodingException
     * 
     */
    private static void createMethod() throws UnsupportedEncodingException {
	Client client = Client.create();
	String uri = "http://localhost:8080/restDev/v1/developer/add/";
	WebResource webResource = client.resource(uri);
	Developer developer = new Developer();
	developer.setDateRecrutement(new Date());
	developer.setNom("nom");
	developer.setPrenom("prenom");
	developer.setId(1L);
	ClientResponse clientResponse = webResource.post(ClientResponse.class,developer);
	String output = clientResponse.getEntity(String.class);
	System.out.println(" OUTPUT POST : " + output);
    }

    /**
     * 
     */
    private static void updateMethod() {
	Client client = Client.create();
	Developer developer = new Developer();
	developer.setId(1l);
	developer.setNom("skan");
	developer.setPrenom("bach");
	WebResource webResource = client.resource("http://localhost:8080/restDev/v1/developer/update");
	ClientResponse clientResponse = webResource.post(ClientResponse.class,
		"{\"id\":1,\"nom\":\"skan\",\"prenom\":\"bachouche\"}");
	String output = clientResponse.getEntity(String.class);
	System.out.println(" OUTPUT POST : " + output);
    }

    /**
     * 
     * @param id
     */
    private static void getMethhod(Long id) {
	Client client = Client.create();
	WebResource webResource = client.resource("http://localhost:8080/restDev/v1/developer/id/" + id);
	ClientResponse clientResponse = webResource.get(ClientResponse.class);
	String output = clientResponse.getEntity(String.class);
	System.out.println(" OUTPUT GET : " + output);
    }
}
