package com.retailstore.checkout.service;

import com.retailstore.checkout.model.Product;
import com.retailstore.checkout.repository.ProductRepository;
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
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testProductService() {
        Iterable<Product> products = productService.getAllProducts();
        List<Product> productList = StreamSupport.stream(products.spliterator(), false)
                .collect(Collectors.toList());

        // data-test.sql executed and added data before the test.
        // data-test.sql : product table has 7 records.
        Assert.assertEquals(productList.size(), 7);

        Product product = productService.getProductById(5L);

        // Check record in data-test.sql file for Product Id 5.
        Assert.assertEquals(product.getId(), 5);
        Assert.assertEquals(product.getProductName(), "test 5");
        Assert.assertEquals(product.getProductCategory(), "B");
        Assert.assertEquals(product.getProductRate(), 5.00, 0.00);
        Assert.assertEquals(product.getTotalQty(), 150);
    }
}
