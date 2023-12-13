package com.mycompany.invoise.customer.repository;

import org.springframework.data.repository.CrudRepository;

import com.mycompany.invoise.core.entity.customer.Address;

public interface AddressRepositoryInterface extends CrudRepository<Address,Long>{
//	public Iterable<Customer> findAll();
//	public Invoice create(Invoice invoice);
//	public List<Invoice> list();
//	public Invoice getById(String number);
}