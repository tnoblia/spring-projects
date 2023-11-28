package com.mycompany.invoise.core.repository.memory;

//import java.util.ArrayList;
//import java.util.List;
//
//import com.mycompany.invoise.core.entity.Invoice;
//import com.mycompany.invoise.core.repository.InvoiceRepositoryInterface;
////@Repository est une annotation fille de @Component (c'est exactement la même annotation en fait)
////La seule différence est que @Repository est une annotation plus explicite (mais pas de différence techniquement)
////@Repository
//public class InvoiceRepositoryMemory implements InvoiceRepositoryInterface{
//	
//	private static List<Invoice> invoices = new ArrayList<>();
//	
//	public Invoice create(Invoice invoice) {
//		invoices.add(invoice);
//		System.out.println("Invoice added with number : " + invoice.getNumber() + " for " + invoice.getCustomerName());
//		return invoice;
//	}
//	
//	public List<Invoice> list(){
//		throw new UnsupportedOperationException();
//		}
//
//	public Invoice getById(String number) {
//		Invoice invoice = new Invoice();
//		invoice.setCustomerName("Client random");
//		invoice.setNumber(number);
//		invoice.setOrderNumber("ENV_00345");
//		return invoice;
//	}
//}
