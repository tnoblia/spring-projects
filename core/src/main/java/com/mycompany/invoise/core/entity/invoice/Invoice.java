package com.mycompany.invoise.core.entity.invoice;


import javax.persistence.*;

import com.mycompany.invoise.core.entity.customer.Customer;

import java.util.ArrayList;
import java.util.List;


//@NamedEntityGraph(name="invoice.customer", attributeNodes = @NamedAttributeNode("customer"))
@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="INVOICE_NUMBER")
    private Long number;
    @Column(length = 13)
    private String orderNumber;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "ID_CUSTOMER", nullable = false)
    @Transient
    private Customer customer;
    private Long idCustomer;
    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "INVOICE_NUMBER", nullable = false)
    private List<InvoiceLine> lines=new ArrayList<>();

    public Invoice(Long number, String orderNumber) {
        this.number = number;
        this.orderNumber = orderNumber;
    }

    public Invoice(Long number) {
        this.number = number;
    }


    public Invoice() {
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public List<InvoiceLine> getLines() {
        return lines;
    }

    public void addLine(InvoiceLine line) {
        this.lines.add(line);
    }

    public void removeLine(InvoiceLine line) {
        this.lines.remove(line);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

	public Long getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(Long idCustomer) {
		this.idCustomer = idCustomer;
	}
}
