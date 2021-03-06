/**
 * 
 */
package com.example.demo.entity;

import java.io.Serializable;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.SequenceGenerator;

/**
 * @author denisputnam
 *
 */
@Entity
public class Car implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2473284426444955536L;
	
//	@Id
//	@SequenceGenerator(name = "CAR_CARID_GENERTOR", sequenceName="CAR_ID_SEQ", initialValue = 0, allocationSize = 1)
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CAR_CARID_GENERATOR")
//	@Column(name = "ID")
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String vin;
	private String brand;
	private Integer year;
	private String color;
	private Integer price;
	private Boolean sold;
	
	public Car() {
		
	}
	
	public Car( String vin, String brand, Integer year, String color, Integer price , Boolean sold ) {
		this.id = null;
		this.vin = vin;
		this.brand = brand;
		this.year = year;
		this.color = color;
		this.sold = sold;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Boolean getSold() {
		return sold;
	}
	public void setSold(Boolean sold) {
		this.sold = sold;
	}


}
