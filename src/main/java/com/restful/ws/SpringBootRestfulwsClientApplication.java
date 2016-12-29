package com.restful.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;

import com.restful.ws.service.RestClient;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {EmbeddedServletContainerAutoConfiguration.class, WebMvcAutoConfiguration.class})
public class SpringBootRestfulwsClientApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringBootRestfulwsClientApplication.class, args);
		
		RestClient restfulClient = new RestClient();
		
		restfulClient.postEntity();
		restfulClient.getEntity();
		restfulClient.updateEntity();
		restfulClient.deleteEntity();
	}
}
