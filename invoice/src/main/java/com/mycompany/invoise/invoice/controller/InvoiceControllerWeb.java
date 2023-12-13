package com.mycompany.invoise.invoice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.invoise.invoice.service.InvoiceServiceInterface;



@Controller
@RequestMapping("/home")
public class InvoiceControllerWeb {
	
	
	public InvoiceControllerWeb(@Autowired InvoiceServiceInterface invoiceService) {
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
//	
//	@PostMapping("create")
//	public String createInvoice(@Valid @ModelAttribute InvoiceForm invoiceForm, BindingResult results, Model model) {
//		if (results.hasErrors()) {
//			model.addAttribute("invoiceForm", invoiceForm);
//			return "invoice-create-form";
//		}
//		Invoice invoice = new Invoice();
//		Customer customer = new Customer(); 
//		customer.setName(invoiceForm.getCustomerName());
//		
//		invoice.setOrderNumber(invoiceForm.getOrderNumber());
//		Address address = new Address(
//				invoiceForm.getStreetName(),
//				invoiceForm.getStreetNumber(),
//				invoiceForm.getCity(),
//				invoiceForm.getZipCode(),
//				invoiceForm.getCountry());
//		customer.setAddress(address);
//		invoice.setCustomer(customer);
//        invoiceService.createInvoice(invoice);
//	    return "invoice-created";
//	}
	 
	
	@GetMapping("") //cherche automatiquement une page invoice-home.html
	public ModelAndView displayHome() { //met automatiquement un attribut "invoices" dans le httprequest.
		ModelAndView mv = new ModelAndView("invoice-home");
		//mv.addObject("invoices", invoiceService.getInvoiceList()); //la récupération des infos est désormais effectuée via js
		return mv; // met la liste invoices dans l'attribut invoices de l'httprequest, l'httprequest est ensuite envoyé à la page.
		
	}
	
	
	//cours 35 pour la deuxième manière de faire
/*	@GetMapping("/{id}")
	public String displayInvoice(@PathVariable("id") String number, Model model) { 
	    model.addAttribute("invoice", invoiceService.getInvoiceByNumber(number));
    return "invoice-details"; 
		
	}*/
//	
//	@GetMapping("/create-form")
//	public String displayInvoiceCreateForm(@ModelAttribute Invoice invoice) { 
//		return "invoice-create-form"; 
//	}*/
//	
//	@GetMapping("/create-form")
//	public String displayInvoiceCreateForm(Model model) { 
//	    model.addAttribute("invoiceForm", new InvoiceForm());
//	    return "invoice-create-form"; 
//	}

}
