package com.humanbooster.apirest_exam_mickael_jacquot.controller;

import com.humanbooster.apirest_exam_mickael_jacquot.model.Car;
import com.humanbooster.apirest_exam_mickael_jacquot.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarRepository cr;

    @GetMapping("")
    public List<Car> getAll() {
        return this.cr.findAll();
    }

    @GetMapping(value = "{Cars}", produces = {"application/json"})
    public Car getOne(@PathVariable(name = "Cars", required = false) Car Car) {
        if (Car == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No such Car");
        }

        return Car;
    }

    @PostMapping(value="",produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<Car> createCar(@Valid @RequestBody Car Car) {

        this.cr.save(Car);
        return new ResponseEntity<Car>(Car, HttpStatus.CREATED);

    }

}
