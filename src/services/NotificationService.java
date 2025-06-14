package services;

import java.util.List;

import models.MenuItem;
import models.Order;

public class NotificationService {
    public static void notify(Order order) {
        // Send a notification to the customer
        System.out.println("\nNotification: New " + order.getOrderType() + " order placed!");
        System.out.println("---------------------------------------------");
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Customer: " + order.getUser().getName());
        System.out.println("Restaurant: " + order.getRestaurant().getName());
        System.out.println("Items Ordered:");

        List<MenuItem> items = order.getItems();
        for (MenuItem item : items) {
            System.out.println("   - " + item.getName() + " (₹" + item.getPrice() + ")");
        }

        System.out.println("Total: ₹" + order.getTotalPrice());
        System.out.println("Scheduled For: " + order.getScheduled());
        System.out.println("Payment: Done");
        System.out.println("---------------------------------------------");
    }
}
