package com.rivera.duckling.repository;

import com.rivera.duckling.entity.Order;
import com.rivera.duckling.entity.Summary;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {

    @Aggregation(pipeline = {
            "{ $group: { _id: null, totalSales: { $sum: '$totalCost' }, totalDucklingSold: { $sum: '$quantity' }, bestSellingDuckling: { $first: '$duckling' }, salesByCountry: { $addToSet: { country: '$shipping.countryDestination', totalSales: '$totalCost' } } } }",
            "{ $project: { _id: 0, totalSales: 1, totalDucklingSold: 1, bestSellingDuckling: 1, salesByCountry: 1 } }"
    })
    Summary getSummaryMetrics();
}
