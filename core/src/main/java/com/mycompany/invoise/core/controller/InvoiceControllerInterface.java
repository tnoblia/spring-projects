package com.mycompany.invoise.core.controller;

import org.springframework.web.servlet.ModelAndView;

import com.mycompany.invoise.core.entity.invoice.Invoice;

public interface InvoiceControllerInterface {
	public String createInvoice(Invoice invoice);
	public ModelAndView displayHome() ;
	public ModelAndView displayInvoice(String number);
}
