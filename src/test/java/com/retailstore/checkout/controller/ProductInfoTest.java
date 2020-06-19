package com.retailstore.checkout.controller;

import com.retailstore.checkout.model.Product;
import com.retailstore.checkout.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ActiveProfiles(value = "test")
@WebMvcTest(ProductInfo.class)
public class ProductInfoTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    public void testProductController() throws Exception {
        List<Product> products = new ArrayList<>();
        Product product1 = new Product(1,"FOO","HDYEH672JW","A",1.00,100);
        Product product2 = new Product(2,"BAR","JEIW677SKQ","C",1.00,100);
        products.add(product1);
        products.add(product2);

        when(productService.getAllProducts()).thenReturn(products);
        when(productService.getProductById(1L)).thenReturn(product1);

        // Mapping products
        // Request Type : GET
        this.mockMvc.perform(get("/products")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().json("[{'id':1,'productName':'FOO','scannedId':'HDYEH672JW','productCategory':'A','productRate':1.00,'totalQty':100},{'id':2,'productName':'BAR','scannedId':'JEIW677SKQ','productCategory':'C','productRate':1.00,'totalQty':100}]"));

        // Mapping product/{id} test
        // Request Type : GET
        this.mockMvc.perform(get("/product/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().json("{'id':1,'productName':'FOO','scannedId':'HDYEH672JW','productCategory':'A','productRate':1.00,'totalQty':100}"));
    }
}
