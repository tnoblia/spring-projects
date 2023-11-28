package com.mycompany.invoise.core.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public class Invoice {
	
	@Id
	@Column("invoice_number")
	private Long number;
	private String customerName;
	private String orderNumber;
	
	public Invoice() {
	}
	
	public Invoice(Long number, String customerName) {
		this.number = number;
		this.customerName = customerName;
	}
	
	
	public Invoice(Long number, String customerName, String orderNumber) {
		super();
		this.number = number;
		this.customerName = customerName;
		this.orderNumber = orderNumber;
	}


	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	
	

}
