package models;

import java.util.List;
import java.util.ArrayList;

public class Restaurant {
    private static int nextRestaurantId = 0;
    private int restaurantId;
    private String name;
    private String address;
    private List<MenuItem> menuItems;

    public Restaurant(String name, String address) {
        this.restaurantId = ++nextRestaurantId;
        this.name = name;
        this.address = address;
        this.menuItems = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void addMenuItem(MenuItem menuItem) {
        this.menuItems.add(menuItem);
    }
}
