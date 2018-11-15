package com.evolvice.task.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evolvice.task.dao.CarRepository;
import com.evolvice.task.exception.ResourceNotFoundException;
import com.evolvice.task.model.Car;


@RestController
@RequestMapping("/evolvice")
public class CarController {
    @Autowired
    private CarRepository carRepository;
    
   
    @GetMapping(path="/cars")
    public HttpEntity<List<Car>> getAllCars() {
       return new ResponseEntity<>(carRepository.findAll(),HttpStatus.OK);
    }
    @GetMapping(path="/cars/{id}")
    public HttpEntity<Car> getCar(@PathVariable long id) {
    	Car car=  carRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Car", "id", id));
    	return new ResponseEntity<>(car,HttpStatus.OK);
    }
    @PostMapping(path="/cars")
    public HttpEntity<Car> save(@RequestBody(required = true) @Valid Car car) {
    	return new ResponseEntity<>(carRepository.save(car),HttpStatus.CREATED);
    }
    @DeleteMapping(path="/cars/{id}")
    public HttpEntity<?> deleteCar(@PathVariable(required = true) long id) {
    	
    	Car carToDelete = carRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Car", "id", id));
    	carRepository.delete(carToDelete);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping(path="/cars/{id}")
    public HttpEntity<Car> UpdateCar(@PathVariable(required = true) long id,@RequestBody(required = true) @Valid Car car) {
    	carRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Car", "id", id));
    	car.setId(id);
    	return new ResponseEntity<>(carRepository.save(car),HttpStatus.CREATED);
    }
}