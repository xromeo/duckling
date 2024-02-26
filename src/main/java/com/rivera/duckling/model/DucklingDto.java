package com.rivera.duckling.model;


import com.rivera.duckling.entity.Size;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigInteger;
import java.time.LocalDate;


public class DucklingDto {

    private BigInteger id;

    private String color;

    @NotNull(message = "Size is mandatory")
    private Size size;

    @NotNull(message = "Price is mandatory")
    @Positive(message = "Price must be a positive number")
    private Double price;

    @NotNull(message = "Quantity is mandatory")
    @Positive(message = "Quantity must be a positive number")
    private Integer quantity;

    private String provider;

    @NotNull(message = "Country Origin is mandatory")
    @NotBlank(message = "Country Origin is mandatory")
    private String countryOrigin;

    @NotNull(message = "Production Date is mandatory")
    private LocalDate productionDate;

    @NotNull(message = "Purchase Date is mandatory")
    private LocalDate purchaseDate;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

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

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getCountryOrigin() {
        return countryOrigin;
    }

    public void setCountryOrigin(String countryOrigin) {
        this.countryOrigin = countryOrigin;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public String toString() {
        return "DucklingDto{" +
               "id=" + id +
               ", color='" + color + '\'' +
               ", size=" + size +
               ", price=" + price +
               ", quantity=" + quantity +
               ", provider='" + provider + '\'' +
               ", countryOrigin='" + countryOrigin + '\'' +
               ", productionDate=" + productionDate +
               ", purchaseDate=" + purchaseDate +
               '}';
    }
}
