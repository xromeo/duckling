package com.rivera.duckling.entity;

public record Shipping(
        String countryDestination,
        ShippingMode shippingMode
) {
}
