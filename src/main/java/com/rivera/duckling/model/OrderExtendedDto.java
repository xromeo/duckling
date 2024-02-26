package com.rivera.duckling.model;

import com.rivera.duckling.entity.Duckling;
import com.rivera.duckling.entity.Packaging;
import com.rivera.duckling.entity.Shipping;

public class OrderExtendedDto {

    private String id;
    private Duckling duckling;
    private Integer quantity;
    private Double cost;
    private Double quantityDiscount;
    private Double materialCost;
    private Double shippingModeCost;
    private Double destinationCost;
    private Double totalCost;
    private Packaging packaging;
    private Shipping shipping;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Duckling getDuckling() {
        return duckling;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getCost() {
        return cost;
    }

    public Double getQuantityDiscount() {
        return quantityDiscount;
    }

    public Double getMaterialCost() {
        return materialCost;
    }

    public Double getShippingModeCost() {
        return shippingModeCost;
    }

    public Double getDestinationCost() {
        return destinationCost;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public Packaging getPackaging() {
        return packaging;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public void setDuckling(Duckling duckling) {
        this.duckling = duckling;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public void setQuantityDiscount(Double quantityDiscount) {
        this.quantityDiscount = quantityDiscount;
    }

    public void setMaterialCost(Double materialCost) {
        this.materialCost = materialCost;
    }

    public void setShippingModeCost(Double shippingModeCost) {
        this.shippingModeCost = shippingModeCost;
    }

    public void setDestinationCost(Double destinationCost) {
        this.destinationCost = destinationCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public void setPackaging(Packaging packaging) {
        this.packaging = packaging;
    }

    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }
}