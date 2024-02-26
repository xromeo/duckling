package com.rivera.duckling.converter;

import com.rivera.duckling.entity.Order;
import com.rivera.duckling.model.OrderExtendedDto;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter {

    public OrderExtendedDto entityToDto(Order order){
        OrderExtendedDto orderExtendedDto = new OrderExtendedDto();
        orderExtendedDto.setId(order.getId());
        orderExtendedDto.setDuckling(order.getDuckling());
        orderExtendedDto.setQuantity(order.getQuantity());
        orderExtendedDto.setCost(order.getCost());
        orderExtendedDto.setQuantityDiscount(order.getQuantityDiscount());
        orderExtendedDto.setMaterialCost(order.getMaterialCost());
        orderExtendedDto.setShippingModeCost(order.getShippingModeCost());
        orderExtendedDto.setDestinationCost(order.getDestinationCost());
        orderExtendedDto.setTotalCost(order.getTotalCost());

        orderExtendedDto.setPackaging(order.getPackaging());
        orderExtendedDto.setShipping(order.getShipping());

        return orderExtendedDto;
    }
}
