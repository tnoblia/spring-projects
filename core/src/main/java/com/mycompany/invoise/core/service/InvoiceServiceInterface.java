package com.mycompany.invoise.core.service;

import java.util.List;

import com.mycompany.invoise.core.entity.Invoice;
import com.mycompany.invoise.core.repository.InvoiceRepositoryInterface;

public interface InvoiceServiceInterface {
	
	public Invoice createInvoice(Invoice invoice);
	public InvoiceRepositoryInterface getInvoiceRepository();
	public Iterable<Invoice> getInvoiceList();
	public Invoice getInvoiceByNumber(String number);
	
}
