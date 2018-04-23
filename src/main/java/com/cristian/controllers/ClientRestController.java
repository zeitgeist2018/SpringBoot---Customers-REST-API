package com.cristian.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cristian.models.entity.Client;
import com.cristian.models.service.IClientService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins= {"*"})
public class ClientRestController {

	@Autowired
	private IClientService clientService;


	@GetMapping("/clients")
	public List<Client> index(@RequestParam(name="order", required=false) String order){
		if(order == null || !order.equals("desc")) {
			return clientService.findAll();
		}else {
			return clientService.findAllOrderByDateDesc();
		}
	}

	@GetMapping("/clients/{id}")
	public Client getClient(@PathVariable(name="id") Long id) {
		return clientService.findById(id);
	}

	@PostMapping("/clients")
	@ResponseStatus(code=HttpStatus.CREATED)
	public Client create(@RequestBody Client client) {
		return clientService.save(client);
	}

	@PutMapping("/clients/{id}")
	@ResponseStatus(code=HttpStatus.CREATED)
	public Client update(@RequestBody Client client, @PathVariable("id") Long id) {
		Client _client = clientService.findById(id);
		_client.setName(client.getName());
		_client.setSurname(client.getSurname());
		_client.setEmail(client.getEmail());
		return clientService.save(_client);
	}

	@DeleteMapping("/clients/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		clientService.delete(id);
	}
}
