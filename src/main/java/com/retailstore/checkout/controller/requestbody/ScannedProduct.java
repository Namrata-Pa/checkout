package com.retailstore.checkout.controller.requestbody;

public class ScannedProduct {
    private long productId;
    private long qty;

    public ScannedProduct() {
    }

    public ScannedProduct(int productId, int qty) {
        this.productId = productId;
        this.qty = qty;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getQty() {
        return qty;
    }

    public void setQty(long qty) {
        this.qty = qty;
    }
}
