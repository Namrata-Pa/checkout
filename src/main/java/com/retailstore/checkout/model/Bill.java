package com.retailstore.checkout.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = " BILL")
public class Bill {
    @Id
    @GenericGenerator(name = "incrt", strategy = "increment")
    @GeneratedValue(generator = "incrt")
    private long id;

    private double totalCost;
    private double totalTax;
    private double totalValuation;

    public Bill() {
    }

    public Bill(long id, double totalCost, double totalTax, double totalValuation) {
        this.id = id;
        this.totalCost = totalCost;
        this.totalTax = totalTax;
        this.totalValuation = totalValuation;
    }

    public Bill(double totalCost, double totalTax, double totalValuation) {
        this.totalCost = totalCost;
        this.totalTax = totalTax;
        this.totalValuation = totalValuation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public double getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(double totalTax) {
        this.totalTax = totalTax;
    }

    public double getTotalValuation() {
        return totalValuation;
    }

    public void setTotalValuation(double totalValuation) {
        this.totalValuation = totalValuation;
    }
}
