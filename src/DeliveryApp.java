import java.util.List;

import factories.NowOrderFactory;
import factories.OrderFactory;
import factories.ScheduledOrderFactory;
import managers.OrderManager;
import managers.RestaurantManager;
import models.Cart;
import models.MenuItem;
import models.Order;
import models.Restaurant;
import models.User;
import services.NotificationService;
import strategies.PaymentStrategy;

public class DeliveryApp {

    public DeliveryApp() {
        initilizeRestaurant();
    }

    public static void initilizeRestaurant() {
        Restaurant restaurant1 = new Restaurant(
                "Pizza Palace",
                "Delhi");
        restaurant1.addMenuItem(new MenuItem("P1", "Margherita Pizza", 200));
        restaurant1.addMenuItem(new MenuItem("P2", "Hawaiian Pizza", 300));

        Restaurant restaurant2 = new Restaurant(
                "Burger Kingdom",
                "Mumbai");
        restaurant2.addMenuItem(new MenuItem("B1", "Cheeseburger", 150));
        restaurant2.addMenuItem(new MenuItem("B2", "Veggie Burger", 180));
        restaurant2.addMenuItem(new MenuItem("B4", "Double Cheeseburger", 250));

        Restaurant restaurant3 = new Restaurant(
                "Sushi World",
                "Bangalore");
        restaurant3.addMenuItem(new MenuItem("S1", "California Roll", 120));
        restaurant3.addMenuItem(new MenuItem("S2", "Spicy Tuna Roll", 180));
        restaurant3.addMenuItem(new MenuItem("S3", "Salmon Nigiri", 200));

        RestaurantManager restaurantManager = RestaurantManager.getInstance();
        restaurantManager.addRestaurant(restaurant1);
        restaurantManager.addRestaurant(restaurant2);
        restaurantManager.addRestaurant(restaurant3);
        System.out.println("Restaurants initialized successfully.");
    }

    public List<Restaurant> searchRestaurants(String location) {
        return RestaurantManager.getInstance().searchByLocation(location);
    }

    void selectRestaurant(User user, Restaurant restaurant) {
        Cart cart = user.getCart();
        cart.setRestaurant(restaurant);
    }

    void addItemToCart(User user, String itemCode) {
        Restaurant restaurant = user.getCart().getRestaurant();
        if (restaurant == null) {
            System.out.println("Please select a restaurant first.");
            return;
        }
        for (MenuItem item : restaurant.getMenuItems()) {
            if (item.getCode().equals(itemCode)) {
                user.getCart().addItem(item);
                System.out.println("Added " + item.getName() + " to cart.");
                return;
            }
        }
    }

    Order checkOutNow(User user, String orderType, PaymentStrategy paymentStrategy) {
        return checkout(user, orderType, paymentStrategy, new NowOrderFactory());
    }

    Order checkOutSchedule(User user, String orderType, PaymentStrategy paymentStrategy, String scheduleTime) {
        return checkout(user, orderType, paymentStrategy, new ScheduledOrderFactory(scheduleTime));
    }

    Order checkout(User user, String orderType, PaymentStrategy paymentStrategy, OrderFactory orderFactory) {
        if (user.getCart().isEmpty()) {
            System.out.println("Cart is empty. Please add items to the cart before checking out.");
            return null;
        }

        Cart cart = user.getCart();
        Restaurant restaurant = cart.getRestaurant();
        List<MenuItem> items = cart.getItems();
        double totalAmount = cart.getTotalPrice();

        Order order = orderFactory.createOrder(user, cart, restaurant, items, paymentStrategy, totalAmount, orderType);
        OrderManager.getInstance().addOrder(order);
        return order;
    }

    void payForOrder(User user, Order order) {
        boolean isPaymentSuccessful = order.processPayment();
        if (isPaymentSuccessful) {
            NotificationService.notify(order);
            user.getCart().clear();
        }
    }

    public void printUserCart(User user) {
        System.out.println("Items in cart:");
        System.out.println("------------------------------------");
        for (MenuItem item : user.getCart().getItems()) {
            System.out.println(item.getCode() + " : " + item.getName() + " : ₹" + item.getPrice());
        }
        System.out.println("------------------------------------");
        System.out.println("Grand total : ₹" + user.getCart().getTotalPrice());
    }
}