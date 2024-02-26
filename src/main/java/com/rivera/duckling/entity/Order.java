package com.rivera.duckling.entity;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class Order {

    @Id
    private String id;

    private final Duckling duckling;

    private final Integer quantity;
    private final Double cost;
    private final Double quantityDiscount;
    private final Double materialCost;
    private final Double shippingModeCost;
    private final Double destinationCost;
    private final Double totalCost;

    private final Packaging packaging;

    private final Shipping shipping;

    private Order(Builder builder) {
        this.id = builder.id;
        this.duckling = builder.duckling;
        this.quantity = builder.quantity;
        this.cost = builder.cost;
        this.quantityDiscount = builder.quantityDiscount;
        this.materialCost = builder.materialCost;
        this.shippingModeCost = builder.shippingModeCost;
        this.destinationCost = builder.destinationCost;
        this.totalCost = builder.totalCost;
        this.packaging = builder.packaging;
        this.shipping = builder.shipping;
    }

    public String getId() {
        return id;
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

    public static class Builder {

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

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder duckling(Duckling duckling) {
            this.duckling = duckling;
            return this;
        }

        public Builder quantity(Integer quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder cost(Double cost) {
            this.cost = cost;
            return this;
        }

        public Builder quantityDiscount(Double quantityDiscount) {
            this.quantityDiscount = quantityDiscount;
            return this;
        }

        public Builder materialCost(Double materialCost) {
            this.materialCost = materialCost;
            return this;
        }

        public Builder destinationCost(Double destinationCost) {
            this.destinationCost = destinationCost;
            return this;
        }

        public Builder shippingModeCost(Double shippingModeCost) {
            this.shippingModeCost = shippingModeCost;
            return this;
        }

        public Builder totalCost(Double totalCost) {
            this.totalCost = totalCost;
            return this;
        }

        public Builder packaging(Packaging packaging) {
            this.packaging = packaging;
            return this;
        }

        public Builder shipping(Shipping shipping) {
            this.shipping = shipping;
            return this;
        }

        public Order build() {
            validate();
            return new Order(this);
        }

        private void validate() {
            Objects.requireNonNull(duckling, "Duckling should not be null");
            Objects.requireNonNull(quantity, "Quantity should not be null");
        }
    }

}