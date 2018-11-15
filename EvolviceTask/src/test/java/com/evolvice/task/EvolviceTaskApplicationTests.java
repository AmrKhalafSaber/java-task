package com.evolvice.task;


import static org.hamcrest.CoreMatchers.anything;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.evolvice.task.controller.CarController;
import com.evolvice.task.dao.CarRepository;
import com.evolvice.task.exception.ResourceNotFoundException;
import com.evolvice.task.model.Car;



@RunWith(SpringRunner.class)
@SpringBootTest
public class EvolviceTaskApplicationTests {
	@InjectMocks
	private CarController carController;
	@Mock
    private CarRepository carRepository;
    private  Car bMWCar, toyotaCar;
    List< Car> cars; 
	  @Before
	    public void setUp() {
		  MockitoAnnotations.initMocks(CarController.class);
	        bMWCar = new Car("BMW", "SUV", new Date(), "BMW 2018");
	        toyotaCar = new Car("Toyota", "SUV", new Date(), "Toyota Corolla");
	        cars = new ArrayList<>();
	        cars.add(bMWCar);
	        cars.add(toyotaCar);
	    }
	    @Test
	    public void testGetAllCars() throws Exception {
	    	
	        when(carRepository.findAll()).thenReturn(cars);
	        
	        assertEquals(cars, carController.getAllCars().getBody());
	    }
	    @Test(expected= ResourceNotFoundException.class)
	    public void testGetCar() throws Exception {
	    	
	        when(carRepository.findById(3L)).thenReturn(Optional.empty());

	        carController.getCar(3L);
	    }
	    @Test()
	    public void testCreatCar() throws Exception {
	    	
	        when(carRepository.save(bMWCar)).thenReturn(bMWCar);

	        assertEquals("BMW", carController.save(bMWCar).getBody().getBrand());
	    }	   

}
