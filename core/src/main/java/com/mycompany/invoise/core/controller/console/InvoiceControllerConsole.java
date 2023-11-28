package com.mycompany.invoise.core.controller.console;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.invoise.core.controller.InvoiceControllerInterface;
import com.mycompany.invoise.core.entity.Invoice;
import com.mycompany.invoise.core.service.InvoiceServiceInterface;

//@Controller
public class InvoiceControllerConsole implements InvoiceControllerInterface {
	
	public InvoiceControllerConsole(@Autowired InvoiceServiceInterface invoiceService) {
		this.invoiceService = invoiceService;
	}
	
	
	private final InvoiceServiceInterface invoiceService;
	
	public InvoiceServiceInterface getInvoiceService() {
		return invoiceService;
	}

	public String createInvoice(Invoice invoice) {
//		Invoice invoice = new Invoice();
//		Scanner scanner = new Scanner(System.in);
//	    System.out.println( "What is the customer name" );
//	    String customerName = scanner.nextLine();
//	    invoice.setCustomerName(customerName);
	    invoiceService.createInvoice(invoice);
//	    scanner.close();
	    return null;
	}

	@Override
	public ModelAndView displayHome() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView displayInvoice(String number) {
		// A FAIRE TTMS
		return null;
	}
	
}
