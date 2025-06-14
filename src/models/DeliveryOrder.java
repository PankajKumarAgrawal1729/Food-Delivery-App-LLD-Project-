package models;

public class DeliveryOrder extends Order {
    private String deliveryAddress;

    public DeliveryOrder() {
        this.deliveryAddress = "";
    }

    @Override
    public String getOrderType() {
        return "Delivery";
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
}
