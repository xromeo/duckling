package com.rivera.duckling.converter;

import com.rivera.duckling.entity.Duckling;
import com.rivera.duckling.entity.Order;
import com.rivera.duckling.model.AvailabilityDto;
import com.rivera.duckling.model.OrderExtendedDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AvailabilityConverter {

    public AvailabilityDto entityToDto(List<Duckling> ducklingList){

        if(ducklingList.isEmpty()){
            return new AvailabilityDto(Boolean.FALSE, 0);
        }

        return new AvailabilityDto(Boolean.TRUE, ducklingList.get(0).getQuantity());
    }
}
