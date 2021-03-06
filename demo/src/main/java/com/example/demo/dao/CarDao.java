/**
 * 
 */
package com.example.demo.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Car;

/**
 * @author denisputnam
 *
 */
@Transactional
@Repository
public interface CarDao extends JpaRepository<Car, Long> {

}
