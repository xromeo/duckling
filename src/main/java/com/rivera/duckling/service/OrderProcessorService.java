package com.rivera.duckling.service;

import com.rivera.duckling.entity.*;
import com.rivera.duckling.exception.NotFoundException;
import com.rivera.duckling.repository.DucklingRepository;
import com.rivera.duckling.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.rivera.duckling.common.Constant.*;

@Service
public class OrderProcessorService {

    private final DucklingRepository ducklingRepository;

    private final OrderRepository orderRepository;

    public OrderProcessorService(DucklingRepository ducklingRepository, OrderRepository orderRepository) {
        this.ducklingRepository = ducklingRepository;
        this.orderRepository = orderRepository;
    }

    public Order process(Size size, String color, Integer quantity, ShippingMode shippingMode, String countryDestination) {

        List<Duckling> ducklingList = ducklingRepository.getDucklingByColorAndSize(color, size);
        if (ducklingList.isEmpty()) {
            throw new NotFoundException();
        }

        Duckling duckling = ducklingList.get(0);

        Packaging packaging = PackagingCreation.createPackaging(
                size,
                shippingMode
        );

        Shipping shipping = new Shipping(
                countryDestination,
                shippingMode
        );

        double baseTotalCost = calculateBaseTotalCost(quantity, duckling.getPrice());
        double quantityDiscount = calculateQuantityDiscount(quantity, baseTotalCost);
        double materialCost = calculatePackageCost(packaging, baseTotalCost);
        double destinationCost = calculateDestinationCost(shipping.countryDestination(), baseTotalCost);
        double shippingModeCost = calculateShippingCost(shipping.shippingMode(), quantity);

        double totalCost = baseTotalCost + quantityDiscount + materialCost + destinationCost + shippingModeCost;

        Order order = new Order.Builder()
                .duckling(duckling)
                .quantity(quantity)
                .cost(baseTotalCost)
                .quantityDiscount(quantityDiscount)
                .materialCost(materialCost)
                .shippingModeCost(shippingModeCost)
                .destinationCost(destinationCost)
                .totalCost(totalCost)
                .shipping(shipping)
                .packaging(packaging)
                .build();

        return orderRepository.save(order);
    }

    private static double calculateBaseTotalCost(Integer quantity, Double price) {
        return price * quantity;
    }

    private static double calculateQuantityDiscount(Integer quantity, double totalCost) {
        // Aplicar descuento del 20% si el pedido es mayor a 100 unidades
        return quantity > 100 ? -totalCost * 0.2 : 0;
    }

    private static double calculatePackageCost(Packaging packaging, double totalCost) {
        // Lógica para calcular el costo del paquete según el tipo de material
        switch (packaging.getMaterial()) {
            case WOOD_MATERIAL -> {
                return 0.05 * totalCost;
            }
            case PLASTIC_MATERIAL -> {
                return 0.1 * totalCost;
            }
            case CARDBOARD_MATERIAL -> {
                return -0.01 * totalCost; // Descuento del 1%
            }
            default ->
                    throw new IllegalArgumentException("Invalid material type in packaging: " + packaging.getMaterial());
        }
    }

    private static double calculateDestinationCost(String countryDestination, double totalCost) {
        // Lógica para calcular el costo según el país de destino
        switch (countryDestination) {
            case "USA" -> {
                return 0.18 * totalCost;
            }
            case "BOLIVIA" -> {
                return 0.13 * totalCost;
            }
            case "INDIA" -> {
                return 0.19 * totalCost;
            }
            default -> {
                return 0.15 * totalCost;
            }
        }
    }

    private static double calculateShippingCost(ShippingMode shippingMode, int quantity) {
        // Lógica para calcular el costo adicional según el modo de envío
        switch (shippingMode) {
            case SEA -> {
                return 400;
            }
            case LAND -> {
                return 10 * quantity;
            }
            case AIR -> {
                double additionalCost = 30 * quantity;
                // Aplicar descuento del 15% si el pedido excede las 1000 unidades
                if (quantity > 1000) {
                    additionalCost *= 0.85;
                }
                return additionalCost;
            }
            default -> throw new IllegalArgumentException("Shipping mode invalid: " + shippingMode);
        }
    }
}
