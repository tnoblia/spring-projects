//package com.mycompany.invoise.core.controller.web;
//
//import java.util.List;
//import java.util.Scanner;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.mycompany.invoise.core.controller.InvoiceControllerInterface;
//import com.mycompany.invoise.core.entity.Invoice;
//import com.mycompany.invoise.core.service.InvoiceServiceInterface;
//
//@Controller
//public class InvoiceControllerWeb implements InvoiceControllerInterface {
//	
//	
//	public InvoiceControllerWeb(@Autowired InvoiceServiceInterface invoiceService) {
//		this.invoiceService = invoiceService;
//	}
//	
//	//@Autowired ne passe pas forcément par le setter de la fonction.
//	//Si on veut utiliser le setter pour le wiring, il faut mettre
//	//@Autowired au niveau du setter.
//	//@Autowired
//	private final InvoiceServiceInterface invoiceService;
//	
//	public InvoiceServiceInterface getInvoiceService() {
//		return invoiceService;
//	}
//
//	public void createInvoice() {
//		Invoice invoice = new Invoice();
//		Scanner scanner = new Scanner(System.in);
//	    System.out.println( "What is the customer name (web)" );
//	    String customerName = scanner.nextLine();
//	    invoice.setCustomerName(customerName);
//        invoiceService.createInvoice(invoice);
//	    scanner.close();
//	}
//	
//	
//	@RequestMapping("/invoice-home") //cherche automatiquement une page invoice-home.html
//	public @ModelAttribute("invoices") List<Invoice> displayHome() { //met automatiquement un attribut "invoices" dans le httprequest.
//		List<Invoice> invoices=invoiceService.getInvoiceList();
//		return invoices; // met la liste invoices dans l'attribut invoices de l'httprequest, l'httprequest est ensuite envoyé à la page.
//		
//	}
//	
//
//}
