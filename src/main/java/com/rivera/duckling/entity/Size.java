package com.rivera.duckling.entity;

public enum Size {
    XLARGE("XLarge"),
    LARGE("Large"),
    MEDIUM("Medium"),
    XSMALL("XSmall"),
    SMALL("Small");

    private final String name;

    Size(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
