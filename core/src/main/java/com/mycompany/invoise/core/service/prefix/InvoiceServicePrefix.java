package com.mycompany.invoise.core.service.prefix;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mycompany.invoise.core.entity.Invoice;
import com.mycompany.invoise.core.repository.InvoiceRepositoryInterface;
import com.mycompany.invoise.core.service.InvoiceServiceInterface;

//@Service
public class InvoiceServicePrefix implements InvoiceServiceInterface{
	
	
	public InvoiceServicePrefix(@Autowired InvoiceRepositoryInterface invoiceRepository) {
		this.invoiceRepository = invoiceRepository;
	}
	
	@Value("${invoice.lastNumber}")
	private long lastNumber;
	@Value("${invoice.prefix}")
	private String prefix;
	
	//@Autowired
	private final InvoiceRepositoryInterface invoiceRepository;
	
	
	public Invoice createInvoice(Invoice invoice) {
		//invoice.setNumber(this.prefix+String.valueOf(++lastNumber));
		invoiceRepository.save(invoice);
		return invoice;
	}
	
	
	public long getLastNumber() {
		return lastNumber;
	}

	public void setLastNumber(long lastNumber) {
		this.lastNumber = lastNumber;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	public InvoiceRepositoryInterface getInvoiceRepository() {
		return invoiceRepository;
	}

//	public void setInvoiceRepository(InvoiceRepositoryInterface invoiceRepository) {
//		this.invoiceRepository = invoiceRepository;
//	}

	public Iterable<Invoice> getInvoiceList(){
		return invoiceRepository.findAll();
	}
	
	public Invoice getInvoiceByNumber(String number) {
		long longNumber = Long.valueOf(number);
		return invoiceRepository.findById(longNumber).orElseThrow();
	};
	

}
