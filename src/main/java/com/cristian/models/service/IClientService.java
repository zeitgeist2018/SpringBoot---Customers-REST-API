package com.cristian.models.service;

import java.util.List;

import com.cristian.models.entity.Client;

public interface IClientService {

	public List<Client> findAll();
	
	public List<Client> findAllOrderByDateDesc();
	
	public Client findById(Long id);
	
	public Client save(Client client);
	
	public void delete(Long id);
	
	
}
