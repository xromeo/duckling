package com.rivera.duckling.entity;

public enum ShippingMode {
    LAND("land"),
    AIR("air"),
    SEA("sea");

    private final String name;
    ShippingMode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
