package com.rivera.duckling.entity;

import org.springframework.data.annotation.Id;

import java.math.BigInteger;
import java.time.LocalDate;


public class Duckling {

    @Id
    private BigInteger id;

    private String color;

    private Size size;

    private Double price;

    private Integer quantity;

    private Boolean active;

    private String provider;

    private String countryOrigin;

    private LocalDate productionDate;

    private LocalDate purchaseDate;

    public Duckling() {
        this.active = true;
    }

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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
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
        return "Duckling{" +
               "id=" + id +
               ", color='" + color + '\'' +
               ", size='" + size + '\'' +
               ", price=" + price +
               ", quantity=" + quantity +
               ", active=" + active +
               ", provider='" + provider + '\'' +
               ", countryOrigin='" + countryOrigin + '\'' +
               ", productionDate=" + productionDate +
               ", purchaseDate=" + purchaseDate +
               '}';
    }
}
