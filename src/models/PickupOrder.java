package models;

public class PickupOrder extends Order {
    private String pickupLocation;

    public PickupOrder() {
        this.pickupLocation = "";
    }

    @Override
    public String getOrderType() {
        return "Pickup";
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }
}
