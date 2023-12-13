package com.mycompany.invoise.invoice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mycompany.invoise.core.entity.customer.Address;
import com.mycompany.invoise.core.entity.customer.Customer;
import com.mycompany.invoise.core.entity.invoice.Invoice;
import com.mycompany.invoise.invoice.service.InvoiceServiceInterface;

                //@RestController au lieu de @Controller permet d'éviter de mettre des @ResponseBody devant chaque fonction
@RestController //Mais @@ResponseBody a été gardé ici pour l'exemple
@RequestMapping("/invoice")
public class InvoiceResource {
	
	private InvoiceServiceInterface invoiceService;
	private RestTemplate restTemplate;

	public InvoiceResource(@Autowired InvoiceServiceInterface invoiceService,
			@Autowired RestTemplate restTemplate) {
		this.invoiceService = invoiceService;
		this.restTemplate = restTemplate;
	}
	
	@GetMapping("/{id}")
	public Invoice get(@PathVariable("id") Long id) { 
	    Invoice invoice =  invoiceService.getInvoiceByNumber(id);
	    Customer customer = restTemplate.getForObject("http://customer-service/customer/"+invoice.getIdCustomer(),
				Customer.class);
	    customer.setAddress(restTemplate.getForObject("http://customer-service/address/"+customer.getAddress().getId(),
				Address.class));
	    invoice.setCustomer(customer);
	    return invoice;
	}

	@GetMapping
	public Iterable<Invoice> list() { 
		Iterable<Invoice> invoices = invoiceService.getInvoiceList();
		//restTemplate instancié dans l'invoiceApp.
		//restTemplate contacte le microService customer via son url et récupère le résultat
		//Qu'il met dans une classe customer.Class
		invoices.forEach(invoice ->{
			invoice.setCustomer(restTemplate.getForObject("http://customer-service/customer/"+invoice.getIdCustomer(),
					Customer.class));
		});
		return invoices;
	}

	
	
	
	
	
	
	//************Getters and setters**************
	public InvoiceServiceInterface getInvoiceService() {
		return invoiceService;
	}

	public void setInvoiceService(InvoiceServiceInterface invoiceService) {
		this.invoiceService = invoiceService;
	}

	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
}
