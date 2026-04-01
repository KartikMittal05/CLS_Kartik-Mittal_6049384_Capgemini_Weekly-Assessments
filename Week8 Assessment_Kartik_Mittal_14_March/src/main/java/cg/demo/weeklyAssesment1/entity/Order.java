package cg.demo.weeklyAssesment1.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name="abes_order")
public class Order {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="order_id")
    private int orderId;

    @Temporal(TemporalType.DATE)
    @Column(name="order_date")
    private Date orderDate;

    @Column(name="order_amt")
    private double orderAmt;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    public Order() {}

    public int getOrderId() {
        return orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getOrderAmt() {
        return orderAmt;
    }

    public void setOrderAmt(double orderAmt) {
        this.orderAmt = orderAmt;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}