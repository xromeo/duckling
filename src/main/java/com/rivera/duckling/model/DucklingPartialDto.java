package com.rivera.duckling.model;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


public class DucklingPartialDto {

    private Integer id;

    @NotNull(message = "Price is mandatory")
    @Positive(message = "Price must be a positive number")
    private Double price;

    @NotNull(message = "Quantity is mandatory")
    @Positive(message = "Quantity must be a positive number")
    private Integer quantity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
