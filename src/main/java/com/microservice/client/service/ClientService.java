package com.microservice.client.service;

import com.microservice.client.model.Client;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientService {
	
	public Flux<Client> findAll();
	public Mono<Client> findById(String id);
	public Mono<Client> createClient(Client client);
	public Mono<Client> updateClient(Client client, String id);
	public Mono<Void> deleteClient(String id);
	
	public Mono<Client> findByDni(String dni);
	public Mono<Boolean> existClient(String id);
	
}
