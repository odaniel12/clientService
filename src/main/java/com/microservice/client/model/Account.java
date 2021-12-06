package com.microservice.client.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Account {
	
	private String id;
	
	private String typeaccount;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTypeaccount() {
		return typeaccount;
	}

	public void setTypeaccount(String typeaccount) {
		this.typeaccount = typeaccount;
	} 
	
	
}
