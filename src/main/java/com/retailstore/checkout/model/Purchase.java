package com.retailstore.checkout.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "PURCHASE")
public class Purchase {
    @Id
    @GenericGenerator(name = "incrt", strategy = "increment")
    @GeneratedValue(generator = "incrt")
    private long id;

    @OneToOne
    @JoinColumn(name = "PURCHASEDID")
    private Product product;

    private long purchasedQty;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "BILLID", referencedColumnName = "ID", insertable = false, updatable = false)
    private Bill bill;

    public Purchase() {
    }

    public Purchase(long id, Product product, long purchasedQty, Bill bill) {
        this.id = id;
        this.product = product;
        this.purchasedQty = purchasedQty;
        this.bill = bill;
    }

    public Purchase(Product product, long purchasedQty, Bill bill) {
        this.product = product;
        this.purchasedQty = purchasedQty;
        this.bill = bill;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getPurchasedId() {
        return product;
    }

    public void setPurchasedId(Product product) {
        this.product = product;
    }

    public long getPurchasedQty() {
        return purchasedQty;
    }

    public void setPurchasedQty(long purchasedQty) {
        this.purchasedQty = purchasedQty;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @JsonIgnore
    public Bill getBillId() {
        return bill;
    }

    @JsonIgnore
    public void setBillId(Bill bill) {
        this.bill = bill;
    }
}
