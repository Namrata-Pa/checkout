package com.retailstore.checkout.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.retailstore.checkout.controller.requestbody.BillingProducts;
import com.retailstore.checkout.model.Bill;
import com.retailstore.checkout.service.BillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BillCheckoutCounter {

    private static final Logger logger = LoggerFactory.getLogger(BillCheckoutCounter.class);

    @Autowired
    private BillService billService;

    @RequestMapping(value = "/bills", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Bill>> getAllBills() {
        return new ResponseEntity<>(billService.getAllBills(), HttpStatus.OK);
    }

    @RequestMapping(value = "/bill/{id}", method = RequestMethod.GET)
    public ResponseEntity<Bill> getBillById(@PathVariable Long id) {
        return new ResponseEntity<>(billService.getBillById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/cbill", method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bill> createBill(@RequestBody BillingProducts billingProducts) throws JsonProcessingException {
        return new ResponseEntity<>(billService.createBill(billingProducts.getScannedProductList()), HttpStatus.OK);
    }
}
