package cg.demo.weeklyAssesment1;


import cg.demo.weeklyAssesment1.entity.Order;
import cg.demo.weeklyAssesment1.entity.Customer;
import jakarta.persistence.*;
import java.util.*;

public class OrderDao implements IOrderDao {

    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("JPA-PU");

    EntityManager em = emf.createEntityManager();

    @Override
    public boolean addOrder(Order order,int custId) {
    	
    	try {
            em.getTransaction().begin();
            Customer cust=em.find(Customer.class, custId);
            if(cust==null) {
            	    // System.out.println("Customer not found");
            	     return false;
            }
            order.setCustomer(cust);
            em.persist(order);
            em.getTransaction().commit();
            return true;
    	}
    catch(Exception e){
    	 em.getTransaction().rollback();
    	 return false;

    }
        
    }

    @Override
    public Order getOrder(int orderId) {

        return em.find(Order.class, orderId);
    }

    @Override
    public List<Order> getOrders(String custName) {

        List<Order> list = em.createQuery(
                "FROM Order o WHERE o.customer.customerName = :name",
                Order.class)
                .setParameter("name", custName)
                .getResultList();

        return list;
    }
}