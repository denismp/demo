/**
 * 
 */
package com.example.demo.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Car;
import com.example.demo.service.CarService;

/**
 * @author denisputnam
 *
 */
@RestController
//@RequestMapping( value = "/")
public class CarsController {
	private static Logger LOG = Logger.getLogger(CarsController.class);
	
	@Autowired
	protected CarService carService;
	
	@ResponseBody
	@RequestMapping(value = { "/cars" }, method = { RequestMethod.GET })
	public ResponseEntity<List<Car>> getCars(){
		LOG.info("getCars(): called...");
		
		List<Car> list = null;
		list = this.carService.createCars(10);
		if( list == null || list.isEmpty() ) {
			LOG.info("getCars(): returned a null or empty list.");
			ResponseEntity<List<Car>> rVal = new ResponseEntity<List<Car>>(list, HttpStatus.EXPECTATION_FAILED);
			return rVal;
		}
		return new ResponseEntity<List<Car>>(list, HttpStatus.OK);
	}

}

