/**
 * 
 */
package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Car;

/**
 * @author denisputnam
 *
 */
public interface CarService {
	public List<Car> createCars(int size);
	public int getRandomPrice();
	public boolean getRandomSoldState();
	public List<String> getColors();
	public List<String> getBrands();
}
