package com.retailstore.checkout.repository;

import com.retailstore.checkout.model.Product;
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
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    /*
    This test is being run on test database setup by schema-test.sql and data-test.sql files.
    As you per data into data-test.sql, test case should work as expected.
    */
    @Test
    public void billRepositoryTest() {
        Product product = productRepository.findById(6L).orElse(new Product(0,"Zero","OOO","A",0.00,0));

        Assert.assertEquals(product.getId(), 6);
        Assert.assertEquals(product.getProductCategory(), "C");
        Assert.assertEquals(product.getProductName(), "test 6");
        Assert.assertEquals(product.getScannedId(), "6");
        Assert.assertEquals(product.getProductRate(), 6.00, 0.00);
        Assert.assertEquals(product.getTotalQty(), 250);
    }
}
