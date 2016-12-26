package com.restdev.test;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class DeveloperClientTest {

	public static void main(String[] args) {
		Client client = Client.create();
		 WebResource webResource = client.resource("http://localhost:8080/restDev/v1/developer/last");
		 ClientResponse clientResponse = webResource.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		 System.out.println(" Get client response ====> ");
		 String output = clientResponse.getEntity(String.class);
		 System.out.println(" Lol :::> "+output);
		 }

}
