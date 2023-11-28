package com.mycompany.invoise.core.service.number;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.invoise.core.entity.Invoice;
import com.mycompany.invoise.core.repository.InvoiceRepositoryInterface;
import com.mycompany.invoise.core.service.InvoiceServiceInterface;

@Service
public class InvoiceServiceNumber  implements InvoiceServiceInterface{
	
	public InvoiceServiceNumber(@Autowired InvoiceRepositoryInterface invoiceRepository) {
		this.invoiceRepository = invoiceRepository;
	}
	
	private final InvoiceRepositoryInterface invoiceRepository;
	
	public InvoiceRepositoryInterface getInvoiceRepository() {
		return invoiceRepository;
	}

	public Invoice createInvoice(Invoice invoice) {
		invoiceRepository.save(invoice);
		return invoice;
	}
	
	public Iterable<Invoice> getInvoiceList(){
		return invoiceRepository.findAll();
	}
	
	public Invoice getInvoiceByNumber(String number) {
		long longNumber = Long.valueOf(number);
		return invoiceRepository.findById(longNumber).orElseThrow();
	};
}
