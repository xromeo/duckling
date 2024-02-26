package com.rivera.duckling.repository;

import com.rivera.duckling.entity.Duckling;
import com.rivera.duckling.entity.Size;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.math.BigInteger;
import java.util.List;

public interface DucklingRepository extends MongoRepository<Duckling, BigInteger> {

    @Query("{$and :[{color: ?0},{size: ?1},{price: ?2}] }")
    List<Duckling> getDucklingByColorAndSizeAndPrice(String color, Size size, Double price);

    @Query("{$and :[{color: ?0},{size: ?1}] }")
    List<Duckling> getDucklingByColorAndSize(String color, Size size);


    @Query("{$and :[{active: ?0}] }")
    List<Duckling> getDucklingByActive(Boolean active);
}
