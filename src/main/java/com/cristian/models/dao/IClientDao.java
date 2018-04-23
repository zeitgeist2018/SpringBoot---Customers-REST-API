package com.cristian.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cristian.models.entity.Client;

public interface IClientDao extends CrudRepository<Client, Long>{

	public List<Client> findAllByOrderByCreatedAtDesc();
	
}
