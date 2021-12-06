package com.microservice.client.repo;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.microservice.client.model.Client;

import reactor.core.publisher.Mono;

@Service
public class WebClientRepo {

	
	public final WebClient webclient = WebClient.create("http://localhost:8082");
	
	public Mono<Client> validateDni(String dni) {
		
		Mono<Client> clientmono = webclient.get().uri("/client/findbydni/"+dni).retrieve().bodyToMono(Client.class);
		
		return clientmono.flatMap(item -> {
			return clientmono;
		});
		
	}
	
	public String validateDniString(String dni) {
		
		String dni2 = "xd";
		
		return dni2;
	}
	
}
