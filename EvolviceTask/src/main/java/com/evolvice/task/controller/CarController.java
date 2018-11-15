package com.evolvice.task.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Car> getAllCars() {
       return  carRepository.findAll();
    }
    @GetMapping(path="/cars/{id}")
    public Car getCar(@PathVariable long id) {
       return  carRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Car", "id", id));
    }
    @PostMapping(path="/cars")
    public Car save(@RequestBody(required = true) @Valid Car car) {
    	return carRepository.save(car);
    }
    @DeleteMapping(path="/cars/{id}")
    public void deleteCar(@PathVariable(required = true) long id) {
    	
    	Car carToDelete = carRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Car", "id", id));
    	carRepository.delete(carToDelete);
    }
    @PutMapping(path="/cars/{id}")
    public Car UpdateCar(@PathVariable(required = true) long id,@RequestBody(required = true) @Valid Car car) {
    	carRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Car", "id", id));
    	car.setId(id);
    	return carRepository.save(car);
    }
}