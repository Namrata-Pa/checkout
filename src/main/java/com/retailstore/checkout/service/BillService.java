package com.retailstore.checkout.service;

import com.retailstore.checkout.controller.requestbody.ScannedProduct;
import com.retailstore.checkout.model.Bill;
import com.retailstore.checkout.model.Product;
import com.retailstore.checkout.repository.BillRepository;
import com.retailstore.checkout.repository.ProductRepository;
import com.retailstore.checkout.repository.PurchaseRepository;
import com.retailstore.checkout.util.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private ProductRepository productRepository;

    public Iterable<Bill> getAllBills() {
        return billRepository.findAll();
    }

    public Bill getBillById(Long id) {
        return billRepository.findById(id).orElse(new Bill());
    }

    public Bill createBill(List<ScannedProduct> scannedProductList) {
        // Calculate products cost and tax
        double totalCost = calTotalCost(scannedProductList);
        double totalTax = calTotalTax(scannedProductList);
        double totalValuation = totalCost + totalTax;

        // Generate bill based passing cost and tax
        Bill bill = billRepository.save(new Bill(totalCost, totalTax, totalValuation));

        // Saving all items in purchase table with bill Id
        purchaseService.addToTable(scannedProductList, bill);

        return bill;
    }

    public double calTotalCost(List<ScannedProduct> scannedProducts) {
        List<Double> cost = new ArrayList<>();
        scannedProducts.stream().forEach(s -> {
            Optional<Product> product = productRepository.findById(s.getProductId());
            product.ifPresent(p -> cost.add(p.getProductRate() * s.getQty()));
        });

        return cost.stream().mapToDouble(Double::doubleValue).sum();
    }

    public double calTotalTax(List<ScannedProduct> scannedProducts) {
        List<Double> tax = new ArrayList<>();

        // Calculate tax based on Product Category
        // Enum ProductCategory is providing levy tax percentage
        scannedProducts.stream().forEach(s -> {
            Optional<Product> product = productRepository.findById(s.getProductId());
            product.ifPresent(p -> tax.add((p.getProductRate() * ProductCategory.valueOf(p.getProductCategory()).getTaxLevy() / 100)
                    * s.getQty()));
        });

        return tax.stream().mapToDouble(Double::doubleValue).sum();
    }
}
