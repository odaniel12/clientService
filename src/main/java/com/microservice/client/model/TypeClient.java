package com.microservice.client.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Flux;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeClient {
	
	private Flux<String> typeclient = Flux.just("PERSONAL", "EMPRESARIAL");

	public Flux<String> getTypeclient() {
		return typeclient;
	}

	public void setTypeclient(Flux<String> typeclient) {
		this.typeclient = typeclient;
	}
	
	
	
}
