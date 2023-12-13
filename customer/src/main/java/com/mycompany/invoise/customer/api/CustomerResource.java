package com.mycompany.invoise.customer.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.mycompany.invoise.core.entity.customer.Customer;
import com.mycompany.invoise.customer.repository.CustomerRepositoryInterface;

                //@RestController au lieu de @Controller permet d'éviter de mettre des @ResponseBody devant chaque fonction
@RestController //Mais @@ResponseBody a été gardé ici pour l'exemple
@RequestMapping("/customer")
public class CustomerResource {
	
	private CustomerRepositoryInterface customerRepository;
	
	public CustomerResource(@Autowired CustomerRepositoryInterface customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	@GetMapping("/{id}")
	public Customer get(@PathVariable("id") Long id) { 
	    return customerRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

}
