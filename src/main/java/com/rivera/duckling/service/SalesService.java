package com.rivera.duckling.service;

import com.rivera.duckling.entity.Summary;
import com.rivera.duckling.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class SalesService {

    private final OrderRepository orderRepository;

    public SalesService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Summary getSummary(){
        return orderRepository.getSummaryMetrics();
    }

}
