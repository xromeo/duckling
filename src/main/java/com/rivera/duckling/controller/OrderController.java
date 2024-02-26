package com.rivera.duckling.controller;

import com.rivera.duckling.converter.OrderConverter;
import com.rivera.duckling.entity.Order;
import com.rivera.duckling.model.OrderDto;
import com.rivera.duckling.model.OrderExtendedDto;
import com.rivera.duckling.service.OrderProcessorService;
import com.rivera.duckling.validate.OrderValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {

    private final OrderProcessorService orderProcessorService;
    private final OrderConverter orderConverter;

    public OrderController(OrderProcessorService orderProcessorService, OrderConverter orderConverter) {
        this.orderProcessorService = orderProcessorService;
        this.orderConverter = orderConverter;
    }


    @PostMapping(path = "/", consumes = {"application/json"}, produces = {"application/json"})
    ResponseEntity<OrderExtendedDto> save(@RequestBody OrderDto orderDto) {
        System.out.println(orderDto);
        OrderValidator.check(orderDto);

        Order order = orderProcessorService.process(
                orderDto.getSize(),
                orderDto.getColor(),
                orderDto.getQuantity(),
                orderDto.getShippingMode(),
                orderDto.getCountryDestination()
        );

        OrderExtendedDto orderExtendedDto = orderConverter.entityToDto(order);

        return new ResponseEntity<>(orderExtendedDto, HttpStatus.CREATED);
    }
}
