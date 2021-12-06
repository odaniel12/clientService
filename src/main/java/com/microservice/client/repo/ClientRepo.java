package com.microservice.client.repo;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.microservice.client.model.Client;

import reactor.core.publisher.Mono;

@Repository
public interface ClientRepo extends ReactiveMongoRepository<Client, String> {
	
	@Query("{ 'dni' : ?0 }")
	public Mono<Client> findByDni(String dni);
	
	@Query("{ 'dni' : ?0 }")
	public Mono<String> existDni(String dni);
	
}
