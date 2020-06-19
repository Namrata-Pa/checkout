package com.retailstore.checkout.model;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String productName;
    private String scannedId;
    private String productCategory;
    private double productRate;
    private int totalQty;

    @OneToOne(mappedBy = "product")
    private Purchase purchase;

    public Product() {
    }

    public Product(long id, String productName, String scannedId, String productCategory, double productRate, int totalQty) {
        this.id = id;
        this.productName = productName;
        this.scannedId = scannedId;
        this.productCategory = productCategory;
        this.productRate = productRate;
        this.totalQty = totalQty;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getScannedId() {
        return scannedId;
    }

    public void setScannedId(String scannedId) {
        this.scannedId = scannedId;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public double getProductRate() {
        return productRate;
    }

    public void setProductRate(double productRate) {
        this.productRate = productRate;
    }

    public int getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(int totalQty) {
        this.totalQty = totalQty;
    }
}
