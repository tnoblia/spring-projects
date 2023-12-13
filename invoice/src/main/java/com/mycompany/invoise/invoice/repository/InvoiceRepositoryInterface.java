package com.mycompany.invoise.invoice.repository;

import org.springframework.data.repository.CrudRepository;

import com.mycompany.invoise.core.entity.invoice.Invoice;

public interface InvoiceRepositoryInterface extends CrudRepository<Invoice,Long>{
	//@EntityGraph(value = "invoice.customer", type=EntityGraph.EntityGraphType.FETCH)
//	public Iterable<Invoice> findAll();
//	public Invoice create(Invoice invoice);
//	public List<Invoice> list();
//	public Invoice getById(Long number);
}