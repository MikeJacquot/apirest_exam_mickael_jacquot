package com.humanbooster.apirest_exam_mickael_jacquot.repository;

import com.humanbooster.apirest_exam_mickael_jacquot.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car,Long> {

    List<Car> findAll();

    Car findCarById(Long id);





}
