package com.rivera.duckling.controller;

import com.rivera.duckling.converter.AvailabilityConverter;
import com.rivera.duckling.converter.DucklingConverter;
import com.rivera.duckling.entity.Duckling;
import com.rivera.duckling.model.AvailabilityDto;
import com.rivera.duckling.model.DucklingDto;
import com.rivera.duckling.service.DucklingService;
import com.rivera.duckling.validate.DucklingValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/duckling")
public class DucklingController {

    private final DucklingService ducklingService;

    private final DucklingConverter ducklingConverter;

    private final AvailabilityConverter availabilityConverter;

    public DucklingController(DucklingService ducklingService, DucklingConverter ducklingConverter, AvailabilityConverter availabilityConverter) {
        this.ducklingService = ducklingService;
        this.ducklingConverter = ducklingConverter;
        this.availabilityConverter = availabilityConverter;
    }


    @PostMapping(path = "/", consumes = {"application/json"}, produces = {"application/json"})
    ResponseEntity<DucklingDto> save(@RequestBody DucklingDto ducklingDto) {
        System.out.println(ducklingDto);
        DucklingValidator.check(ducklingDto);
        Duckling duckling = ducklingConverter.dtoToEntity(ducklingDto);

        Duckling result = ducklingService.save(duckling);
        DucklingDto ducklingDtoResult = ducklingConverter.entityToDto(result);

        return new ResponseEntity<>(ducklingDtoResult, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<Void> update(@RequestBody DucklingDto ducklingDto, @PathVariable(name = "id") BigInteger id) {
        ducklingDto.setId(id);
        DucklingValidator.checkUpdate(ducklingDto);
        Duckling duckling = ducklingConverter.dtoToEntity(ducklingDto);
        Duckling updated = ducklingService.update(duckling);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/")
    ResponseEntity<List<DucklingDto>> getAll() {
        List<DucklingDto> ducklingDtoList = ducklingService.getAll().stream().map(ducklingConverter::entityToDto).collect(Collectors.toList());
        return new ResponseEntity<>(ducklingDtoList, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable(name = "id") BigInteger id) {
        ducklingService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/availability")
    ResponseEntity<AvailabilityDto> availability(@RequestBody DucklingDto ducklingDto) {

        DucklingValidator.checkAvailability(ducklingDto);
        Duckling duckling = ducklingConverter.dtoToEntity(ducklingDto);
        List<Duckling> ducklingList = ducklingService.availability(ducklingDto.getColor(), ducklingDto.getSize());

        AvailabilityDto availabilityDto = availabilityConverter.entityToDto(ducklingList);
        return new ResponseEntity<>(availabilityDto, HttpStatus.OK);
    }
}
