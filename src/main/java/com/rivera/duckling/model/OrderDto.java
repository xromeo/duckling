package com.rivera.duckling.model;

import com.rivera.duckling.entity.*;
import org.springframework.data.annotation.Id;

public class OrderDto {

    private String color;
    private Size size;
    private Integer quantity;
    private String countryDestination;
    private ShippingMode shippingMode;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCountryDestination() {
        return countryDestination;
    }

    public void setCountryDestination(String countryDestination) {
        this.countryDestination = countryDestination;
    }

    public ShippingMode getShippingMode() {
        return shippingMode;
    }

    public void setShippingMode(ShippingMode shippingMode) {
        this.shippingMode = shippingMode;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
               "color='" + color + '\'' +
               ", size=" + size +
               ", quantity=" + quantity +
               ", countryDestination='" + countryDestination + '\'' +
               ", shippingMode=" + shippingMode +
               '}';
    }
}