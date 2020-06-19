package com.retailstore.checkout.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.retailstore.checkout.controller.requestbody.BillingProducts;
import com.retailstore.checkout.model.Bill;
import com.retailstore.checkout.service.BillService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.ArgumentMatchers.*;

@RunWith(SpringRunner.class)
@ActiveProfiles(value = "test")
@WebMvcTest(BillCheckoutCounter.class)
public class BillCheckoutCounterTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BillService billService;

    @Test
    public void testBillsController() throws Exception {
        List<Bill> bills = new ArrayList<>();
        Bill bill1 = new Bill(1, 1.00, 1.00, 2.00);
        Bill bill2 = new Bill(2, 2.00, 2.00, 4.00);
        Bill bill3 = new Bill(3, 3.00, 3.00, 6.00);
        bills.add(bill1);
        bills.add(bill2);

        BillingProducts billingProducts = new BillingProducts();

        when(billService.getAllBills()).thenReturn(bills);
        when(billService.getBillById(1L)).thenReturn(bill1);
        when(billService.createBill(any())).thenReturn(bill3);

        // Mapping bills
        // Request Type : GET
        this.mockMvc.perform(get("/bills")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().json("[{'id':1,'totalCost':1.00,'totalTax':1.00,'totalValuation':2.00},{'id':2,'totalCost':2.00,'totalTax':2.00,'totalValuation':4.00}]"));

        // Mapping bill/{id} test
        // Request Type : GET
        this.mockMvc.perform(get("/bill/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().json("{'id':1,'totalCost':1.00,'totalTax':1.00,'totalValuation':2.00}"));

        // Mapping cbill @RequestBody
        // Request Type : POST
        this.mockMvc.perform(MockMvcRequestBuilders.post("/cbill")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(billingProducts)))
                .andExpect(content().json("{'id':3,'totalCost':3.00,'totalTax':3.00,'totalValuation':6.00}"));
    }
}
