package com.mycompany.invoise.core.service.number;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.invoise.core.entity.Invoice;
import com.mycompany.invoise.core.repository.CustomerRepositoryInterface;
import com.mycompany.invoise.core.repository.InvoiceRepositoryInterface;
import com.mycompany.invoise.core.service.InvoiceServiceInterface;

@Service
public class InvoiceServiceNumber  implements InvoiceServiceInterface{
	
	public InvoiceServiceNumber(@Autowired InvoiceRepositoryInterface invoiceRepository,
			@Autowired CustomerRepositoryInterface customerRepository) {
		this.invoiceRepository = invoiceRepository;
		this.customerRepository = customerRepository;
	}
	
	private final InvoiceRepositoryInterface invoiceRepository;
	@Autowired
	private final CustomerRepositoryInterface customerRepository;
	
	public InvoiceRepositoryInterface getInvoiceRepository() {
		return invoiceRepository;
	}

	@Transactional //*
	public Invoice createInvoice(Invoice invoice) {
		//*tx.begin
		customerRepository.save(invoice.getCustomer());
		return invoiceRepository.save(invoice);//*si une exception est levée entre begin et commit
		//*alors toutes les transactions sont annulées.
		//*tx.commit
	}
	
	public Iterable<Invoice> getInvoiceList(){
		return  invoiceRepository.findAll();
//		Iterable<Invoice> invoices =  invoiceRepository.findAll();
//		//Ceci permet d'initialiser (déproxifier) le client de chaque facture.
//		invoices.forEach(invoice -> invoice.getCustomer().getName());
//		return invoices;
	}
	
	public Invoice getInvoiceByNumber(String number) {
		long longNumber = Long.valueOf(number);
		return invoiceRepository.findById(longNumber).orElseThrow();
	};
}
