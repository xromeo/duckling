package com.rivera.duckling.service;

import com.rivera.duckling.entity.Duckling;
import com.rivera.duckling.entity.Size;
import com.rivera.duckling.exception.BusinessException;
import com.rivera.duckling.exception.ErrorModel;
import com.rivera.duckling.exception.NotFoundException;
import com.rivera.duckling.repository.DucklingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DucklingService {

    private static final Logger logger = LoggerFactory.getLogger(DucklingService.class);

    private final DucklingRepository ducklingRepository;

    public DucklingService(DucklingRepository ducklingRepository) {
        this.ducklingRepository = ducklingRepository;
    }

    public Duckling save(Duckling duckling) {
        List<Duckling> ducklingList = ducklingRepository.
                getDucklingByColorAndSizeAndPrice(
                        duckling.getColor(),
                        duckling.getSize(),
                        duckling.getPrice()
                );

        if (!ducklingList.isEmpty()) {
            duckling.setQuantity(ducklingList.get(0).getQuantity() + duckling.getQuantity());
            duckling.setId(ducklingList.get(0).getId());
        }
        return ducklingRepository.save(duckling);
    }

    public Duckling update(Duckling duckling) {
        Optional<Duckling> ducklingOptional = ducklingRepository.findById(duckling.getId());

        if (ducklingOptional.isEmpty()) {
            throw new NotFoundException();
        }

        Duckling currentDuckling = ducklingOptional.get();
        currentDuckling.setPrice(duckling.getPrice());
        currentDuckling.setQuantity(currentDuckling.getQuantity() + duckling.getQuantity());
        return ducklingRepository.save(currentDuckling);
    }

    public Duckling getById(BigInteger id) {
        Optional<Duckling> ducklingOptional = ducklingRepository.findById(id);

        if (ducklingOptional.isEmpty()) {
           throw new NotFoundException();
        }

        return ducklingOptional.get();
    }

    public List<Duckling> getAll(){
        return ducklingRepository.getDucklingByActive(Boolean.TRUE);
    }

    public void delete(BigInteger id){
        Optional<Duckling> ducklingOptional = ducklingRepository.findById(id);

        if (ducklingOptional.isEmpty()) {
            List<ErrorModel> errorModelList = new ArrayList<>();
            errorModelList.add(new ErrorModel("NOT_FOUND", "Duckling not found"));
            throw new BusinessException(errorModelList);
        }

        Duckling currentDuckling = ducklingOptional.get();
        currentDuckling.setActive(Boolean.FALSE);
        ducklingRepository.save(currentDuckling);
    }

    public List<Duckling> availability(String color, Size size) {
        return ducklingRepository.getDucklingByColorAndSize(color, size);
    }

}
