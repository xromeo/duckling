package com.rivera.duckling.validate;

import com.rivera.duckling.entity.Duckling;
import com.rivera.duckling.exception.BusinessException;
import com.rivera.duckling.exception.ErrorModel;
import com.rivera.duckling.model.DucklingDto;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class DucklingValidator {
    public static void check(DucklingDto ducklingDto){
        if(Objects.isNull(ducklingDto.getQuantity()) || ducklingDto.getQuantity() < 1 ){
            List<ErrorModel> errorModelList = new ArrayList<>();
            errorModelList.add(new ErrorModel("INVALID_ARGUMENT", "Quantity property is mandatory and must be positive"));
            throw new BusinessException(errorModelList);
        }

        if(Objects.isNull(ducklingDto.getPrice()) || ducklingDto.getPrice() < 0 ){
            List<ErrorModel> errorModelList = new ArrayList<>();
            errorModelList.add(new ErrorModel("INVALID_ARGUMENT", "Price property is mandatory and must be positive"));
            throw new BusinessException(errorModelList);
        }

        if(Objects.isNull(ducklingDto.getColor())){
            List<ErrorModel> errorModelList = new ArrayList<>();
            errorModelList.add(new ErrorModel("INVALID_ARGUMENT", "Color property is mandatory and the value must be [RED|GREEN|YELLOW|BLACK]"));
            throw new BusinessException(errorModelList);
        }

        if(Objects.isNull(ducklingDto.getSize())){
            List<ErrorModel> errorModelList = new ArrayList<>();
            errorModelList.add(new ErrorModel("INVALID_ARGUMENT", "Size property is mandatory and the value must be [XLARGE|LARGE|MEDIUM|SMALL|XSMALL]"));
            throw new BusinessException(errorModelList);
        }

        if(Objects.isNull(ducklingDto.getPurchaseDate())){
            List<ErrorModel> errorModelList = new ArrayList<>();
            errorModelList.add(new ErrorModel("INVALID_ARGUMENT", "Purchase Date is mandatory"));
            throw new BusinessException(errorModelList);
        }

        if(Objects.isNull(ducklingDto.getProductionDate())){
            List<ErrorModel> errorModelList = new ArrayList<>();
            errorModelList.add(new ErrorModel("INVALID_ARGUMENT", "Production Date is mandatory"));
            throw new BusinessException(errorModelList);
        }

        if(Objects.isNull(ducklingDto.getProvider())){
            List<ErrorModel> errorModelList = new ArrayList<>();
            errorModelList.add(new ErrorModel("INVALID_ARGUMENT", "Provider is mandatory"));
            throw new BusinessException(errorModelList);
        }

        if(Objects.isNull(ducklingDto.getCountryOrigin()) || ducklingDto.getCountryOrigin().isEmpty()){
            List<ErrorModel> errorModelList = new ArrayList<>();
            errorModelList.add(new ErrorModel("INVALID_ARGUMENT", "Country Origin property is mandatory"));
            throw new BusinessException(errorModelList);
        }

    }

    public static void checkUpdate(DucklingDto ducklingDto){
        if(Objects.isNull(ducklingDto.getQuantity()) || ducklingDto.getQuantity() < 1 ){
            List<ErrorModel> errorModelList = new ArrayList<>();
            errorModelList.add(new ErrorModel("INVALID_ARGUMENT", "Quantity property is mandatory and must be positive"));
            throw new BusinessException(errorModelList);
        }

        if(Objects.isNull(ducklingDto.getPrice()) || ducklingDto.getPrice() < 0 ){
            List<ErrorModel> errorModelList = new ArrayList<>();
            errorModelList.add(new ErrorModel("INVALID_ARGUMENT", "Price property is mandatory and must be positive"));
            throw new BusinessException(errorModelList);
        }
    }

    public static void checkAvailability(DucklingDto ducklingDto){
        if(Objects.isNull(ducklingDto.getColor()) || ducklingDto.getColor().isEmpty()){
            List<ErrorModel> errorModelList = new ArrayList<>();
            errorModelList.add(new ErrorModel("INVALID_ARGUMENT", "Color property is mandatory"));
            throw new BusinessException(errorModelList);
        }

        if(Objects.isNull(ducklingDto.getSize())){
            List<ErrorModel> errorModelList = new ArrayList<>();
            errorModelList.add(new ErrorModel("INVALID_ARGUMENT", "Size property is mandatory"));
            throw new BusinessException(errorModelList);
        }
    }
}
