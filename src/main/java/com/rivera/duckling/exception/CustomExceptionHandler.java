package com.rivera.duckling.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<List<ErrorModel>> handleBusinessException(BusinessException businessException) {
        System.out.println("BusinessException is thrown");
        return new ResponseEntity<List<ErrorModel>>(businessException.getErrors(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorModel>> handleFieldValidation(MethodArgumentNotValidException methodArgumentNotValidException) {
        // System.out.println("MethodArgumentNotValidException is thrown");
        logger.info("MethodArgumentNotValidException is thrown");
        List<ErrorModel> errorModelList = new ArrayList<>();
        List<FieldError> fieldErrorList = methodArgumentNotValidException.getFieldErrors();
        fieldErrorList.stream().forEach(fieldError -> errorModelList.add(new ErrorModel(fieldError.getField(), fieldError.getDefaultMessage())));
        return new ResponseEntity<List<ErrorModel>>(errorModelList, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<List<ErrorModel>> handleEnumFieldValidation(HttpMessageNotReadableException httpMessageNotReadableException) {
        // System.out.println("MethodArgumentNotValidException is thrown");
        logger.info("HttpMessageNotReadableException is thrown");
        List<ErrorModel> errorModelList = new ArrayList<>();
        String message = httpMessageNotReadableException.getMessage();
        errorModelList.add(new ErrorModel("ENUM_INVALID", message));
        return new ResponseEntity<List<ErrorModel>>(errorModelList, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Void> handleEnumFieldValidation(NotFoundException notFoundException) {
        // System.out.println("MethodArgumentNotValidException is thrown");
        logger.info("NotFoundException is thrown");
      return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
}
