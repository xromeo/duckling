package com.rivera.duckling.converter;

import com.rivera.duckling.entity.Duckling;
import com.rivera.duckling.model.DucklingDto;
import org.springframework.stereotype.Component;

@Component
public class DucklingConverter {
    public Duckling dtoToEntity(DucklingDto ducklingDto){
        Duckling duckling = new Duckling();
        duckling.setColor(ducklingDto.getColor());
        duckling.setPrice(ducklingDto.getPrice());
        duckling.setSize(ducklingDto.getSize());
        duckling.setQuantity(ducklingDto.getQuantity());
        duckling.setCountryOrigin(ducklingDto.getCountryOrigin());
        duckling.setProductionDate(ducklingDto.getProductionDate());
        duckling.setPurchaseDate(ducklingDto.getPurchaseDate());
        duckling.setProvider(ducklingDto.getProvider());
        duckling.setId(ducklingDto.getId());
        return duckling;
    }

    public DucklingDto entityToDto(Duckling duckling){
        DucklingDto ducklingDto = new DucklingDto();
        ducklingDto.setColor(duckling.getColor());
        ducklingDto.setPrice(duckling.getPrice());
        ducklingDto.setSize(duckling.getSize());
        ducklingDto.setQuantity(duckling.getQuantity());
        ducklingDto.setCountryOrigin(duckling.getCountryOrigin());
        ducklingDto.setProductionDate(duckling.getProductionDate());
        ducklingDto.setPurchaseDate(duckling.getPurchaseDate());
        ducklingDto.setProvider(duckling.getProvider());
        ducklingDto.setId(duckling.getId());
        return ducklingDto;
    }

}
