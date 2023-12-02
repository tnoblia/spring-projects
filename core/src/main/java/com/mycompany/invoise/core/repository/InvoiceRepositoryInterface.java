package com.mycompany.invoise.core.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mycompany.invoise.core.entity.Invoice;

public interface InvoiceRepositoryInterface extends CrudRepository<Invoice,Long>{
	@EntityGraph(value = "invoice.customer", type=EntityGraph.EntityGraphType.FETCH)
	public Iterable<Invoice> findAll();
//	public Invoice create(Invoice invoice);
//	public List<Invoice> list();
//	public Invoice getById(String number);
}