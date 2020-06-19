package com.retailstore.checkout.repository;

import com.retailstore.checkout.model.Bill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends CrudRepository<Bill, Long> {
}
