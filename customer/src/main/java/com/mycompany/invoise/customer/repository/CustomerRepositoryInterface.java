package com.mycompany.invoise.customer.repository;

import org.springframework.data.repository.CrudRepository;

import com.mycompany.invoise.core.entity.customer.Customer;

public interface CustomerRepositoryInterface extends CrudRepository<Customer,Long>{
//	public Iterable<Customer> findAll();
//	public Invoice create(Invoice invoice);
//	public List<Invoice> list();
//	public Invoice getById(String number);
}