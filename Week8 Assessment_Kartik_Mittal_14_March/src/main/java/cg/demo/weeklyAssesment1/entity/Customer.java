package cg.demo.weeklyAssesment1.entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name="abes_customer")
public class Customer {

    @Id
    @Column(name="customer_id")
    private int customerId;

    @Column(name="customer_name", nullable=false)
    private String customerName;

    @OneToMany(mappedBy="customer", cascade=CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();

    public Customer() {}

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
