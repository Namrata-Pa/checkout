package com.retailstore.checkout.controller.requestbody;

import java.util.List;

public class BillingProducts {
    List<ScannedProduct> scannedProductList;

    public BillingProducts() {
    }

    public BillingProducts(List<ScannedProduct> scannedProductList) {
        this.scannedProductList = scannedProductList;
    }

    public List<ScannedProduct> getScannedProductList() {
        return scannedProductList;
    }

    public void setScannedProductList(List<ScannedProduct> scannedProductList) {
        this.scannedProductList = scannedProductList;
    }
}
