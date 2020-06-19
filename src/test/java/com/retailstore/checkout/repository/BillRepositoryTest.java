package com.retailstore.checkout.repository;

import com.retailstore.checkout.model.Bill;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles(value = "test")
@DataJpaTest
public class BillRepositoryTest {

    @Autowired
    private BillRepository billRepository;

    /*
    This test is being run on test database setup by schema-test.sql and data-test.sql files.
    As you per data into data-test.sql, we should get total cost as 5.00, total tax as 0.2 and total valuation as 5.2.
     */
    @Test
    public void billRepositoryTest() {
        Bill bill = billRepository.findById(11L).orElse(new Bill(0,0,0,0));

        Assert.assertEquals(bill.getTotalCost(), 5.00, 0.00);
        Assert.assertEquals(bill.getTotalTax(), 0.2, 0.00);
        Assert.assertEquals(bill.getTotalValuation(), 5.2, 0.00);
    }
}
