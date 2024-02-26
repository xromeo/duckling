package com.rivera.duckling.service;

import com.rivera.duckling.entity.Packaging;
import com.rivera.duckling.entity.ShippingMode;
import com.rivera.duckling.entity.Size;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static com.rivera.duckling.common.Constant.*;

@Component
public class PackagingCreation {

    public static Packaging createPackaging(Size size, ShippingMode shippingMode) {
        Objects.requireNonNull(size);
        Objects.requireNonNull(shippingMode);

        String material = determineMaterial(size);
        String protection = determineProtection(shippingMode, material);

        return new Packaging.Builder()
                .material(material)
                .protection(protection)
                .build();
    }

    private static String determineMaterial(Size size) {
        switch (size) {
            case LARGE, XLARGE -> {
                return WOOD_MATERIAL;
            }
            case MEDIUM -> {
                return CARDBOARD_MATERIAL;
            }
            case SMALL, XSMALL -> {
                return PLASTIC_MATERIAL;
            }
            default -> throw new IllegalArgumentException("Invalid Duckling Size: " + size);
        }
    }

    private static String determineProtection(ShippingMode shippingMode, String material) {
        switch (shippingMode) {
            case LAND -> {
                return PLASTOFORM_BALLS_PROTECTION;
            }
            case AIR -> {
                return switch (material) {
                    case WOOD_MATERIAL, CARDBOARD_MATERIAL -> PLASTOFORM_BALLS_PROTECTION;
                    case PLASTIC_MATERIAL -> BUBBLE_PROTECTION;
                    default -> throw new IllegalArgumentException("Invalid Material: " + material);
                };
            }
            case SEA -> {
                return ABSORBENT_BALLS_PROTECTION;
            }
            default -> throw new IllegalArgumentException("Invalid Shipping Mode: " + shippingMode);
        }
    }
}
