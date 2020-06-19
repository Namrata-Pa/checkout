package com.retailstore.checkout.service;

import com.retailstore.checkout.controller.requestbody.ScannedProduct;
import com.retailstore.checkout.model.Bill;
import com.retailstore.checkout.model.Purchase;
import com.retailstore.checkout.repository.ProductRepository;
import com.retailstore.checkout.repository.PurchaseRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles(value = "test")
public class PurchaseServiceTest {

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Test
    public void testPurchaseService() {
        List<ScannedProduct> scannedProducts = new ArrayList<>();
        scannedProducts.add(new ScannedProduct(7, 2));

        Bill bill = new Bill(1.00, 1.00, 2.00);

        purchaseService.addToTable(scannedProducts, bill);

        // Last id in table is 104 as per data-test.sql file.
        // Increment strategy will generate next id as 105, so checking records for ID 105.
        Purchase purchase = purchaseRepository.findById(105L).orElse(new Purchase());

        // Result should match with scanned products defined in starting of this test case.
        Assert.assertEquals(purchase.getProduct().getId(), 7);
        Assert.assertEquals(purchase.getPurchasedQty(), 2);
    }
}
