package com.example.demo.service.impl;


import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.CarDao;
import com.example.demo.entity.Car;
import com.example.demo.service.CarService;

@Service("carService")
@Transactional(value="transactionManager")
public class CarServiceImpl implements CarService {
	
	@PersistenceContext
	private EntityManager em;
	
	//List<Car> results = this.em.cerateQuery("SELECT o FROM Car o join o.id table t WHERE t.id = :id", Car.class).setParameter("id", tableObject.getId()).getResultList();
	
	@Autowired
	private CarDao carDao;
	
	private final static String[] colors;
	
	private final static String[] brands;
	
	static {
		colors = new String[10];
		colors[0] = "Black";
		colors[1] = "White";
		colors[2] = "Green";
		colors[3] = "Red";
		colors[4] = "Blue";
		colors[5] = "Orange";
		colors[6] = "Silver";
		colors[7] = "Yellow";
		colors[8] = "Brown";
		colors[9] = "Maroon";
		
		brands = new String[10];
		brands[0] = "BMW";
		brands[1] = "Mercedes";
		brands[2] = "Volvo";
		brands[3] = "Audi";
		brands[4] = "Renault";
		brands[5] = "Fiat";
		brands[6] = "Volkswagon";
		brands[7] = "Honda";
		brands[8] = "Jaguar";
		brands[9] = "Ford";
		
	}

	@Override
	public List<Car> createCars(int size) {
		List<Car> list = this.carDao.findAll();
		if( list == null || list.isEmpty() ) {
			for( int i = 0; i < size; i++ ) {
				Car car = new Car( getRandomId(), getRandomBrand(), getRandomYear(), getRandomColor(), getRandomPrice(), getRandcomSoldState());
//				String vin, String brand, Integer year, String color, Integer price , Boolean sold 
				this.carDao.saveAndFlush(car);
				list.add(car);
			}
		}
		return list;
	}

	private Boolean getRandcomSoldState() {
		return (Math.random() > 0.5) ? true: false;
	}

	private String getRandomColor() {
		return colors[(int) (Math.random() * 10)];
	}

	private String getRandomBrand() {
		return brands[(int) (Math.random() * 10)];
	}

	private String getRandomId() {
		return UUID.randomUUID().toString().substring(0,8);
	}
	private Integer getRandomYear() {
		return (int) (Math.random() * 50 + 1960 );
	}
	
	@Override
	public int getRandomPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getRandomSoldState() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<String> getColors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getBrands() {
		// TODO Auto-generated method stub
		return null;
	}

}
