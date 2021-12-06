package com.microservice.client.repo;

import org.springframework.stereotype.Repository;

import com.microservice.client.model.TypeClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class TypeClientRepo {
	
	public Flux<Boolean> validateTypeClient(String typeclient) {
		
		TypeClient typecli = new TypeClient();
		
		Flux<String> clients = typecli.getTypeclient();
		
		return clients.flatMap(mapper -> {
			Flux<Boolean> resp;
			
			try {
				
				if(mapper.equals(typeclient)) {
					
					resp = Flux.just(true);
					return resp;
					
				}
				
			} catch (Exception e) {
				Mono.error(e);
			}
			
			return Mono.empty();
			
		});
	}
	
	public Flux<Boolean> responseValidateTypeClient(String typeclient) {
		
		Flux<Boolean> response = validateTypeClient(typeclient);
		
		return response.switchIfEmpty(Mono.just(false));
		
	}
}
