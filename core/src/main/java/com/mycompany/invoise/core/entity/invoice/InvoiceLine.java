package com.mycompany.invoise.core.entity.invoice;


import javax.persistence.*;

import com.mycompany.invoise.core.entity.product.Product;

@Entity
public class InvoiceLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Short quantity;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "ID_PRODUCT")
    @Transient
    private Product product;
    private long IdProduct;

    public InvoiceLine() {
    }

    public InvoiceLine(Short quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Short getQuantity() {
        return quantity;
    }

    public void setQuantity(Short quantity) {
        this.quantity = quantity;
    }

//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }

	public long getIdProduct() {
		return IdProduct;
	}

	public void setIdProduct(long idProduct) {
		IdProduct = idProduct;
	}
}
