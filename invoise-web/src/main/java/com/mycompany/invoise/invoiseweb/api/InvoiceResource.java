package com.mycompany.invoise.invoiseweb.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.invoise.core.entity.Invoice;
import com.mycompany.invoise.core.service.InvoiceServiceInterface;

                //@RestController au lieu de @Controller permet d'éviter de mettre des @ResponseBody devant chaque fonction
@RestController //Mais @@ResponseBody a été gardé ici pour l'exemple
@RequestMapping("/invoice")
public class InvoiceResource {
	
	
	public InvoiceResource(@Autowired InvoiceServiceInterface invoiceService) {
		this.invoiceService = invoiceService;
	}
	
	//@Autowired ne passe pas forcément par le setter de la fonction.
	//Si on veut utiliser le setter pour le wiring, il faut mettre
	//@Autowired au niveau du setter.
	//@Autowired
	private final InvoiceServiceInterface invoiceService;
	
	public InvoiceServiceInterface getInvoiceService() {
		return invoiceService;
	}
	
	@PostMapping("")
	public Invoice create(@RequestBody Invoice invoice) {
        invoiceService.createInvoice(invoice);
        return invoice;
	}
	 
	
	@GetMapping("")
	public @ResponseBody Iterable<Invoice> list() { 
		return invoiceService.getInvoiceList();
	}

	@GetMapping("/{id}")
	public @ResponseBody Invoice get(@PathVariable("id") String number) { 
	    return invoiceService.getInvoiceByNumber(number);
	}
	/*
	@GetMapping("/create-form")
	public String displayInvoiceCreateForm(Model model) { 
	    model.addAttribute("invoiceForm", new InvoiceForm());
	    return "invoice-create-form"; 
	}*/

}
