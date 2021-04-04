package com.yash.bestcar.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.bestcar.model.Car;

/**
 * @author Yashwanth
 */
@Repository
public interface CarRepository extends JpaRepository<Car, Long> {


  /**
   * Find All Cars By Type
   * 
   * @param carType - Type
   * @return - List of Car based on provided type
   */
  public List<Car> findByCarType(String carType);

  /**
   * Find All Cars By Name IgnoreCase
   * 
   * @param carName - Car Name
   * @return - List of Car based on provided name
   */
  public List<Car> findByCarNameIgnoreCase(String carName);

  /**
   * Find All Cars By Name Starting With
   * 
   * @param carName - Car Name
   * @return - List of Car based on provided name
   */
  public List<Car> findByCarNameStartingWith(String carName);

  /**
   * Find All Cars By Name Starting With
   * 
   * @param carNameStr - Car Name String
   * @return - List of Car based on provided name
   */
  public List<Car> findByCarNameContaining(String carNameStr);

  /**
   * Find All Cars By Name Ending With
   * 
   * @param carName - Car Name
   * @return - List of Car based on provided name
   */
  public List<Car> findByCarNameEndingWith(String carName);

  /**
   * Find All Cars By Type and Color
   * 
   * @param carType - Type
   * @param carColor - Color
   * @return - List of Car based on provided type
   */
  public List<Car> findByCarTypeAndCarColor(String carType, String carColor);


  /**
   * Find All Cars MPG Greater Than
   * 
   * @param carMpg - Car Miles per Galon
   * @return - List of Car based on Galon
   */
  public List<Car> findByCarMpgGreaterThan(int carMpg);

  /**
   * Find All Cars MPG Greater Than And Equal
   * 
   * @param carMpg - Car Miles per Galon
   * @return - List of Car based on Galon
   */
  public List<Car> findByCarMpgGreaterThanEqual(int carMpg);


  /**
   * Find All Cars MPG Less Than
   * 
   * @param carMpg - Car Miles per Galon
   * @return - List of Car based on Galon
   */
  public List<Car> findByCarMpgLessThan(int carMpg);

  /**
   * Find All Cars MPG Less Than And Equal
   * 
   * @param carMpg - Car Miles per Galon
   * @return - List of Car based on Galon
   */
  public List<Car> findByCarMpgLessThanEqual(int carMpg);


  /**
   * Find All Cars MPG In Collection
   * 
   * @param mpgs - mpgs
   * @return - List car with MPG
   */
  public List<Car> findByCarMpgIn(Collection<Integer> mpgs);


  /**
   * Find All Cars To Year Before
   * 
   * @param carToYear - Car Start Year
   * @return - List of Car based on From Year
   */
  public List<Car> findByCarToYearBefore(int carToYear);


  /**
   * Find All Cars From Year After
   * 
   * @param carFromYear - Car Start Year
   * @return - List of Car based on From Year
   */
  public List<Car> findByCarFromYearAfter(int carFromYear);


  /**
   * Find All Cars Between From Year and To Year
   * 
   * @param carFromYear - Car From Year
   * @param carToYear - Car To Year
   * @return - List of Cars
   */
  public List<Car> findByCarFromYearBetween(int carFromYear, int carToYear);


  /**
   * Find All Cars By Name in Ascending
   * 
   * @param carName - Car Name
   * @return - List of Cars
   */
  public List<Car> findByCarNameOrderByCarMpgAsc(String carName);

  /**
   * Find All Cars By Name in Descending
   * 
   * @param carName - Car Name
   * @return - List of Cars
   */
  public List<Car> findByCarNameOrderByCarMpgDesc(String carName);

  /**
   * Find All Top 3 Cars
   * 
   * @param carReviewPoints - Review Points
   * @return - List of Cars
   */
  public List<Car> findTop3ByCarReviewPoints(int carReviewPoints);

}
