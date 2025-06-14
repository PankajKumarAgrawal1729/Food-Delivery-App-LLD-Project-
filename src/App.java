import java.util.List;

import models.Order;
import models.Restaurant;
import models.User;
import strategies.UpiPaymentStrategy;

public class App {
    public static void main(String[] args) throws Exception {
        DeliveryApp deliveryApp = new DeliveryApp();

        // Create users
        User user1 = new User(101, "Alice", "Delhi");
        System.out.println("User: " + user1.getName() + " is active.");

        List<Restaurant> restaurants = deliveryApp.searchRestaurants("Delhi");

        if (restaurants.isEmpty()) {
            System.out.println("No restaurants found in the specified location.");
            return;
        }

        System.out.println("Restaurants found in Delhi:");
        for (Restaurant restaurant : restaurants) {
            System.out.println(" - " + restaurant.getName());
        }

        // Select a restaurant
        Restaurant selectedRestaurant = restaurants.get(0);
        deliveryApp.selectRestaurant(user1, selectedRestaurant);
        System.out.println("Selected Restaurant: " + selectedRestaurant.getName());

        // Add items to cart
        deliveryApp.addItemToCart(user1, "P1");
        deliveryApp.addItemToCart(user1, "P2");

        deliveryApp.printUserCart(user1);

        // Place an order
        Order order = deliveryApp.checkOutNow(user1, "Delivery", new UpiPaymentStrategy("alice@upi"));
        if (order != null) {
            System.out.println("Order placed successfully. Order ID: " + order.getOrderId());
            deliveryApp.payForOrder(user1, order);
        } else {
            System.out.println("Failed to place the order.");
        }
    }
}
