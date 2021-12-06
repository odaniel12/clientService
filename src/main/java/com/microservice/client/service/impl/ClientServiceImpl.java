package com.microservice.client.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.client.model.Client;
import com.microservice.client.model.TypeClient;
import com.microservice.client.repo.ClientRepo;
import com.microservice.client.service.ClientService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepo repo;
	
	@Override
	public Flux<Client> findAll() {
		return repo.findAll();
	}
	
	@Override
	public Mono<Client> findById(String id) {
		return repo.findById(id);
	}
	
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
				Flux.error(e);
			}
			
			return Flux.just(false);
			
		});
	}
	
	@Override
	public Mono<Client> createClient(Client client) {
		
		Mono<Boolean> validateTypeClient = validateTypeClient(client.getTypeclient().toString()).next();
		
		return validateTypeClient.flatMap(mapper -> {
			if(mapper) {
				return repo.save(client);
			}else {
				return Mono.empty();
			}
		});
		
	}
	
	@Override
	public Mono<Client> updateClient(Client client, String id) {
		return repo.findById(id).flatMap(acc -> {
			acc.setName(client.getName());
			acc.setTypeclient(client.getTypeclient());
			acc.setDni(client.getDni());
			acc.setRuc(client.getRuc());
			return repo.save(acc);
		}).switchIfEmpty(Mono.empty());
	}
	
	@Override
	public Mono<Void> deleteClient(String id) {
		try {
			return repo.findById(id).flatMap(acc -> {
				return repo.delete(acc);
			});
		} catch (Exception e) {
			// TODO: handle exception
			return Mono.error(e);
		}
	}
	
	@Override
	public Mono<Client> findByDni(String dni) {
		return repo.findByDni(dni);
	}
	
	@Override
	public Mono<Boolean> existClient(String id) {
		return repo.existsById(id);
	}
	
}
