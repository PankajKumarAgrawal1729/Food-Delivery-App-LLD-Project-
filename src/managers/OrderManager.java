package managers;

import java.util.ArrayList;
import java.util.List;

import models.Order;

public class OrderManager {
    private static OrderManager instance;
    private List<Order> orders = new ArrayList<>();

    private OrderManager() {
        // Private constructor to prevent instantiation
    }

    public static OrderManager getInstance() {
        if (instance == null) {
            instance = new OrderManager();
        }
        return instance;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void listOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders available.");
            return;
        }
        System.out.println("\\n--- All Orders ---");
        for (Order order : orders) {
            System.out.println(order.getOrderType() + " order for " + order.getUser().getName()
                    + " | Total: ₹" + order.getTotalPrice()
                    + " | At: " + order.getScheduled());
        }
    }
}
