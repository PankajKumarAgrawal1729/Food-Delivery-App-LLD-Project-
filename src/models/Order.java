package models;

import java.util.List;

import strategies.PaymentStrategy;

public abstract class Order {
    private static int nextOrderId = 0;

    protected int orderId;
    protected User user;
    protected Restaurant restaurant;
    protected List<MenuItem> items;
    protected PaymentStrategy paymentStrategy;
    protected double totalPrice;
    protected String scheduled;

    public Order() {
        this.orderId = ++nextOrderId;
        this.user = null;
        this.restaurant = null;
        this.items = null;
        this.paymentStrategy = null;
        this.scheduled = "";
        this.totalPrice = 0.0;
    }

    public boolean processPayment() {
        if (paymentStrategy == null) {
            System.out.println("Payment strategy not set.");
            return false;
        }
        paymentStrategy.pay(totalPrice);
        return true;
    }

    public abstract String getOrderType();

    public int getOrderId() {
        return orderId;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public void setItems(List<MenuItem> items) {
        this.items = items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getScheduled() {
        return scheduled;
    }

    public void setScheduled(String scheduled) {
        this.scheduled = scheduled;
    }

    
}
