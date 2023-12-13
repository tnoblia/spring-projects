package com.mycompany.invoise.invoice.service;

import com.mycompany.invoise.core.entity.invoice.Invoice;

public interface InvoiceServiceInterface {
	
	public Invoice createInvoice(Invoice invoice);
	public Iterable<Invoice> getInvoiceList();
	public Invoice getInvoiceByNumber(Long number);
	
}
