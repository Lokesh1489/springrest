package com.softtek.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ActorServiceConsumingRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		RestTemplate template = new RestTemplate();

		String serviceurl = "http://localhost:8081/SpringBootProj-06-SBootProviderApp1/actor/wish";

		ResponseEntity<String> response = template.getForEntity(serviceurl, String.class);
 // display the recieved
		System.out.println("response body(Output)"+response.getBody());
		System.out.println("response status code value"+response.getStatusCodeValue());
		System.out.println("response status"+response.getStatusCode().name());
	}
}
