package com.retailstore.checkout.service;

import com.retailstore.checkout.controller.requestbody.ScannedProduct;
import com.retailstore.checkout.model.Bill;
import com.retailstore.checkout.model.Product;
import com.retailstore.checkout.model.Purchase;
import com.retailstore.checkout.repository.ProductRepository;
import com.retailstore.checkout.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private ProductRepository productRepository;

    // Saving all items in purchase table
    public void addToTable(List<ScannedProduct> scannedProductList, Bill bill) {
        scannedProductList.stream().forEach(s -> {
            Optional<Product> product = productRepository.findById(s.getProductId());
            product.ifPresent(p -> purchaseRepository.save(new Purchase(
                    null, s.getQty(), bill)));
        });
    }
}
