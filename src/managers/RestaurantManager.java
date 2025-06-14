package managers;

import java.util.ArrayList;
import java.util.List;

import models.Restaurant;

public class RestaurantManager {
    private static RestaurantManager instance;
    private List<Restaurant> restaurants = new ArrayList<>();

    private RestaurantManager() {
    }

    public static RestaurantManager getInstance() {
        if (instance == null) {
            instance = new RestaurantManager();
        }
        return instance;
    }

    public void addRestaurant(Restaurant restaurant) {
        if (restaurants != null) {
            restaurants.add(restaurant);
        }
    }

    public List<Restaurant> searchByLocation(String location) {
        List<Restaurant> result = new ArrayList<>();
        location = location.toLowerCase();
        if (restaurants != null) {
            for (Restaurant restaurant : restaurants) {
                if (restaurant.getAddress().toLowerCase().contains(location)) {
                    result.add(restaurant);
                }
            }
        }
        return result;
    }

}
