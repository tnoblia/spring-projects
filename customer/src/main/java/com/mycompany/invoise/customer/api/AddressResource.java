package com.mycompany.invoise.customer.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.mycompany.invoise.core.entity.customer.Address;
import com.mycompany.invoise.customer.repository.AddressRepositoryInterface;

                //@RestController au lieu de @Controller permet d'éviter de mettre des @ResponseBody devant chaque fonction
@RestController //Mais @@ResponseBody a été gardé ici pour l'exemple
@RequestMapping("/address")
public class AddressResource {
	
	private AddressRepositoryInterface addressRepository;
	
	public AddressResource(@Autowired AddressRepositoryInterface addressRepository) {
		this.addressRepository = addressRepository;
	}
	
	@GetMapping("/{id}")
	public Address get(@PathVariable("id") Long id) { 
	    return addressRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

}
