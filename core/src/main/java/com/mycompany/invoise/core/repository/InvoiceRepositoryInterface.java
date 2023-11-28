package com.mycompany.invoise.core.repository;

import org.springframework.data.repository.CrudRepository;

import com.mycompany.invoise.core.entity.Invoice;

public interface InvoiceRepositoryInterface extends CrudRepository<Invoice,Long>{
//	public Invoice create(Invoice invoice);
//	public List<Invoice> list();
//	public Invoice getById(String number);
}