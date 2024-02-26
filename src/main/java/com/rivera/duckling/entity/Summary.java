package com.rivera.duckling.entity;

import java.util.List;

public record Summary(
        double totalSales,
        long totalDucklingSold,
        Duckling bestSellingDuckling,
        List<CountrySales> salesByCountry
) {

}
