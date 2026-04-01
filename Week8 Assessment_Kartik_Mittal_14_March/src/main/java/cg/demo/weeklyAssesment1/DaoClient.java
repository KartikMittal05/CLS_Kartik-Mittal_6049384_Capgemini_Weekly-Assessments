package cg.demo.weeklyAssesment1;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import cg.demo.weeklyAssesment1.entity.Customer;
import cg.demo.weeklyAssesment1.entity.Order;

public class DaoClient {
    static OrderDao dao = new OrderDao();
    static Scanner scan = new Scanner(System.in);
        
	public static void main(String[] args) {
		String opt = null;
		do {
			System.out.println("1-ADD, 2--VIEW BY ORDER ID, 3--VIEW BY CUSTOMER NAME");
			int mtype = scan.nextInt();
			processMenu(mtype);
			System.out.println("press y to continue");
			opt=scan.next();
		}while(opt.equalsIgnoreCase("y"));

	}
	
	public static void processMenu(int mtype) {
		switch(mtype) {
		case 1:
			addOrder();
			break;
		case 2:
			getOrder();
			break;
		case 3:
			getOrders();
			break;
		default:
			System.out.println("Invalid option");
		}
	}

	public static void addOrder() {
		 System.out.println("Enter Customer ID");
	        int cid = scan.nextInt();
	        scan.nextLine();

	        System.out.println("Enter Customer Name");
	        String cname = scan.nextLine();

	        System.out.println("Enter Order Amount");
	        double amt = scan.nextDouble();

	        Customer c = new Customer();
	        c.setCustomerId(cid);
	        c.setCustomerName(cname);

	        Order o = new Order();
	        o.setOrderAmt(amt);
	        o.setOrderDate(new Date());
	        o.setCustomer(c);

	        Boolean saved = dao.addOrder(o,cid);
	        if(saved) {
	        	System.out.println("Order inserted with ID: " + cid);
	        }
	        else {
	        	System.out.println("Customer not found");
	        }

	        
	}
	
	public static void getOrder() {
		 System.out.println("Enter Order ID");

	        int id = scan.nextInt();

	        Order o = dao.getOrder(id);

	        if(o != null) {

	            System.out.println("Order ID: " + o.getOrderId());
	            System.out.println("Amount: " + o.getOrderAmt());
	            System.out.println("Customer: " + o.getCustomer().getCustomerName());

	        } else {

	            System.out.println("Order not found");
	        }
	}
	
	public static void getOrders() {
		 scan.nextLine();

	        System.out.println("Enter Customer Name");

	        String name = scan.nextLine();

	        List<Order> list = dao.getOrders(name);

	        if(list.isEmpty()) {

	            System.out.println("No orders found");

	        } else {

	            for(Order o : list) {

	                System.out.println("------------------");
	                System.out.println("Order ID: " + o.getOrderId());
	                System.out.println("Amount: " + o.getOrderAmt());
	                System.out.println("Date: " + o.getOrderDate());
	            }
	        }
	}
 }
