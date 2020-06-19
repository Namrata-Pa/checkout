package com.retailstore.checkout.util;

public enum ProductCategory {
    A(10),
    B(20),
    C(0);

    private int taxLevy;

    ProductCategory(int taxLevy) {
        this.taxLevy = taxLevy;
    }

    public int getTaxLevy() {
        return taxLevy;
    }
}
