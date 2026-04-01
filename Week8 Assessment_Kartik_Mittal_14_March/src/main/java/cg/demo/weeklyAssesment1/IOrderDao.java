package cg.demo.weeklyAssesment1;

import java.util.List;

import cg.demo.weeklyAssesment1.entity.Order;

public interface IOrderDao {
	public boolean addOrder(Order order,int custId);

    public Order getOrder(int orderId);

    public List<Order> getOrders(String custName);
}

