package com.rivera.duckling.controller;

import com.rivera.duckling.entity.Summary;
import com.rivera.duckling.service.SalesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/sales")
public class SalesController {

    private final SalesService salesService;

    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    @GetMapping("/")
    ResponseEntity<Summary> getAll() {
        Summary summary = salesService.getSummary();
        return new ResponseEntity<>(summary, HttpStatus.OK);
    }

}
