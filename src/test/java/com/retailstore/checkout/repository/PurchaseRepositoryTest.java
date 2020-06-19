package com.retailstore.checkout.repository;

import com.retailstore.checkout.model.Purchase;
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
public class PurchaseRepositoryTest {

    @Autowired
    private PurchaseRepository purchaseRepository;

    /*
    This test is being run on test database setup by schema-test.sql and data-test.sql files.
     */
    @Test
    public void purchaseRepositoryTest() {
        Purchase purchase = purchaseRepository.findById(102L).orElse(new Purchase());

        Assert.assertEquals(purchase.getId(), 102);
        Assert.assertEquals(purchase.getPurchasedQty(), 1);
        Assert.assertEquals(purchase.getProduct().getId(), 3);
        Assert.assertEquals(purchase.getBillId().getId(), 11);
    }
}
