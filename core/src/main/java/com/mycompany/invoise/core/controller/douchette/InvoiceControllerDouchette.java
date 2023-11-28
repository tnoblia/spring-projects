package com.mycompany.invoise.core.controller.douchette;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.invoise.core.controller.InvoiceControllerInterface;
import com.mycompany.invoise.core.entity.Invoice;
import com.mycompany.invoise.core.service.InvoiceServiceInterface;

//@Controller
public class InvoiceControllerDouchette implements InvoiceControllerInterface{
	
	public InvoiceControllerDouchette(@Autowired InvoiceServiceInterface invoiceService) {
		this.invoiceService = invoiceService;
	}
private final InvoiceServiceInterface invoiceService;
	
	public InvoiceServiceInterface getInvoiceService() {
		return invoiceService;
	}

	public String createInvoice(Invoice invoice) {
	    invoiceService.createInvoice(invoice);
	    return null;
	}

	@Override
	public ModelAndView displayHome() {
		// A FAIRE TTMS
		return null;
	}

	@Override
	public ModelAndView displayInvoice(String number) {
		// TODO Auto-generated method stub
		return null;
	}

}
