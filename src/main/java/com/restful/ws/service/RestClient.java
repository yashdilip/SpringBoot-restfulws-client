package com.restful.ws.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.restful.ws.model.Customer;

import ch.qos.logback.core.net.SyslogOutputStream;

public class RestClient {
	RestTemplate restTemplate;
	
	public RestClient(){
		restTemplate = new RestTemplate();
	}
	
	public void getEntity(){
		System.out.println("Begin /GET request");
		String getUrl = "http://localhost:8080/get?id=1&name='Dilip'&age=20";
		
		ResponseEntity<Customer> getResponse = restTemplate.getForEntity(getUrl, Customer.class);
		
		if(getResponse.getBody()!=null){
			System.out.println("Response for GET request: "+ getResponse.getBody().toString());
		}else{
			System.out.println("Response for GET request: "+ getResponse.getStatusCodeValue());
		}
	}
	
	public void postEntity(){
		System.out.print("Begin /POST request");
		String postUrl = "http://localhost:8080/post";
		
		Customer customer = new Customer(123, "Dilip", 23);
		ResponseEntity<String> postResponse = restTemplate.postForEntity(postUrl, customer, String.class);
		System.out.println("Response for POST request: "+ postResponse.getBody());
	}
	
	public void updateEntity(){
		System.out.println("Begin /PUT request");
		String putUrl = "http://localhost:8080/put/2";
		
		Customer putCustomer = new Customer("Bust", 23);
		restTemplate.put(putUrl, putCustomer);
		
	}
	
	public void deleteEntity(){
	    System.out.println("Begin /DELETE request");
	    String deleteUl = "http://localhost:8080/delete/1";
	    restTemplate.delete(deleteUl);
	}
}
