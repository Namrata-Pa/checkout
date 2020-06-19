package com.retailstore.checkout.service;

import com.retailstore.checkout.controller.exception.CustomException;
import com.retailstore.checkout.model.Product;
import com.retailstore.checkout.repository.ProductRepository;
import com.retailstore.checkout.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;

    /*
        Fetching list of all the products from the Product table.
     */
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(long id) {
        return productRepository.findById(id).orElseThrow(() ->
                new CustomException("Product is not found with Id : " + id));
    }

}
