package com.retailstore.checkout.service;

import com.retailstore.checkout.model.Bill;
import com.retailstore.checkout.repository.BillRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles(value = "test")
public class BillServiceTest {

    @Autowired
    private BillService billService;

    @Autowired
    private BillRepository billRepository;

    @Test
    public void testBillService() {
        Iterable<Bill> bills = billService.getAllBills();
        List<Bill> billList = StreamSupport.stream(bills.spliterator(), false)
                                .collect(Collectors.toList());

        // data-test.sql executed and added data before the test.
        // data-test.sql : bill table has 2 records.
        Assert.assertEquals(billList.size(), 2);

        Bill bill = billService.getBillById(11L);

        // Check record in data-test.sql file for bill id 11.
        Assert.assertEquals(bill.getId(), 11);
        Assert.assertEquals(bill.getTotalCost(), 5.00,0.00);
        Assert.assertEquals(bill.getTotalTax(), 0.2, 0.00);
        Assert.assertEquals(bill.getTotalValuation(), 5.2, 0.00);
    }
}
