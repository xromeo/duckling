package com.rivera.duckling.validate;

import com.rivera.duckling.exception.BusinessException;
import com.rivera.duckling.exception.ErrorModel;
import com.rivera.duckling.model.DucklingDto;
import com.rivera.duckling.model.OrderDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class OrderValidator {
    public static void check(OrderDto orderDto) {
        if (Objects.isNull(orderDto.getQuantity()) || orderDto.getQuantity() < 1) {
            List<ErrorModel> errorModelList = new ArrayList<>();
            errorModelList.add(new ErrorModel("INVALID_ARGUMENT", "Quantity property is mandatory and must be positive"));
            throw new BusinessException(errorModelList);
        }

        if (Objects.isNull(orderDto.getColor()) || orderDto.getColor().isEmpty()) {
            List<ErrorModel> errorModelList = new ArrayList<>();
            errorModelList.add(new ErrorModel("INVALID_ARGUMENT", "Color property is mandatory and the value must be [RED|GREEN|YELLOW|BLACK]"));
            throw new BusinessException(errorModelList);
        }

        if (Objects.isNull(orderDto.getSize())) {
            List<ErrorModel> errorModelList = new ArrayList<>();
            errorModelList.add(new ErrorModel("INVALID_ARGUMENT", "Size property is mandatory and the value must be [XLARGE|LARGE|MEDIUM|SMALL|XSMALL]"));
            throw new BusinessException(errorModelList);
        }

        if (Objects.isNull(orderDto.getCountryDestination()) || orderDto.getCountryDestination().isEmpty()) {
            List<ErrorModel> errorModelList = new ArrayList<>();
            errorModelList.add(new ErrorModel("INVALID_ARGUMENT", "Country Destination is mandatory"));
            throw new BusinessException(errorModelList);
        }

        if (Objects.isNull(orderDto.getShippingMode())) {
            List<ErrorModel> errorModelList = new ArrayList<>();
            errorModelList.add(new ErrorModel("INVALID_ARGUMENT", "Shipping Mode is mandatory"));
            throw new BusinessException(errorModelList);
        }
    }

    public static void checkUpdate(DucklingDto ducklingDto) {
        if (Objects.isNull(ducklingDto.getQuantity()) || ducklingDto.getQuantity() < 1) {
            List<ErrorModel> errorModelList = new ArrayList<>();
            errorModelList.add(new ErrorModel("INVALID_ARGUMENT", "Quantity property is mandatory and must be positive"));
            throw new BusinessException(errorModelList);
        }

        if (Objects.isNull(ducklingDto.getPrice()) || ducklingDto.getPrice() < 0) {
            List<ErrorModel> errorModelList = new ArrayList<>();
            errorModelList.add(new ErrorModel("INVALID_ARGUMENT", "Price property is mandatory and must be positive"));
            throw new BusinessException(errorModelList);
        }
    }
}
