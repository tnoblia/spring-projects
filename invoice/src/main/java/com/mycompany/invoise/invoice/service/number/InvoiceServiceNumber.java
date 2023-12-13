package com.mycompany.invoise.invoice.service.number;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mycompany.invoise.core.entity.customer.Customer;
import com.mycompany.invoise.core.entity.invoice.Invoice;
import com.mycompany.invoise.invoice.repository.InvoiceRepositoryInterface;
import com.mycompany.invoise.invoice.service.InvoiceServiceInterface;


@Service
public class InvoiceServiceNumber  implements InvoiceServiceInterface{
	
	private final InvoiceRepositoryInterface invoiceRepository;
	//private final CustomerRepositoryInterface customerRepository;
	
	public InvoiceServiceNumber(@Autowired InvoiceRepositoryInterface invoiceRepository)
			//,@Autowired CustomerRepositoryInterface customerRepository) 
	{
		this.invoiceRepository = invoiceRepository;
		//this.customerRepository = customerRepository;
	}

	
//	public void setInvoiceRepository( InvoiceRepositoryInterface invoiceRepository) {
//		this.invoiceRepository = invoiceRepository;
//	}
	
	public Invoice createInvoice(Invoice invoice) {
		return new Invoice();
	}

	/*
	@Transactional //*
	public Invoice createInvoice(Invoice invoice) {
		//*tx.begin
		customerRepository.save(invoice.getCustomer());
		return invoiceRepository.save(invoice);//*si une exception est levée entre begin et commit
		//*alors toutes les transactions sont annulées.
		//*tx.commit
	}*/
	
	public Iterable<Invoice> getInvoiceList(){
		return invoiceRepository.findAll();
//		Iterable<Invoice> invoices =  invoiceRepository.findAll();
//		//Ceci permet d'initialiser (déproxifier) le client de chaque facture.
//		invoices.forEach(invoice -> invoice.getCustomer().getName());
//		return invoices;
	}
	
	public Invoice getInvoiceByNumber(Long number) {
		//long longNumber = Long.valueOf(number);
		return invoiceRepository.findById(number).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
}
}
