package com.yash.bestcar.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.bestcar.constants.CarConstants;
import com.yash.bestcar.exception.ResourceNotFoundException;
import com.yash.bestcar.model.Car;
import com.yash.bestcar.repository.CarRepository;

/**
 * @author Yashwanth
 */
@RestController
@RequestMapping("/api")
public class CarController {

  @Autowired
  private CarRepository carRepository;

  /**
   * Get All Cars
   * 
   * @return - All cars
   */
  @GetMapping("/getAllCars")
  public List<Car> getAllCars() {
    return this.carRepository.findAll();
  }

  /**
   * Get Car By Id
   * 
   * @param carId - Car ID
   * @return - Car
   * @throws ResourceNotFoundException - Not Found
   */
  @GetMapping("/getCarById/carId/{id}")
  public ResponseEntity<Car> getCarById(@PathVariable(value = "id") final Long carId) throws ResourceNotFoundException {
    Car car =
        this.carRepository.findById(carId).orElseThrow(() -> new ResourceNotFoundException(CarConstants.ERROR + carId));
    return ResponseEntity.ok().body(car);
  }

  /**
   * Get Car By Type
   * 
   * @param carType - Car Type
   * @return - Car
   */
  @GetMapping("/getCarByType/carType/{type}")
  public List<Car> getCarByType(@PathVariable(value = "type") final String carType) {
    return this.carRepository.findByCarType(carType);
  }

  /**
   * Get Car By Name - Ignore Case
   * 
   * @param carName - Car Name
   * @return - Car
   */
  @GetMapping("/getCarNameIgnoreCase/carName/{name}")
  public List<Car> getCarNameIgnoreCase(@PathVariable(value = "name") final String carName) {
    return this.carRepository.findByCarNameIgnoreCase(carName);
  }

  /**
   * Get Car By Name - Starting With
   * 
   * @param carName - Car Name
   * @return - Car
   */
  @GetMapping("/getCarNameStartingWith/carName/{name}")
  public List<Car> getCarNameStartingWith(@PathVariable(value = "name") final String carName) {
    return this.carRepository.findByCarNameStartingWith(carName);
  }

  /**
   * Get Car By Name - Ending With
   * 
   * @param carName - Car Name
   * @return - Car
   */
  @GetMapping("/getCarNameEndingWith/carName/{name}")
  public List<Car> getCarNameEndingWith(@PathVariable(value = "name") final String carName) {
    return this.carRepository.findByCarNameEndingWith(carName);
  }

  /**
   * Get Car By Name - Containing (Word)
   * 
   * @param carNameStr - Car Name Inbetween String
   * @return - Car
   */
  @GetMapping("/getCarNameContaining/carName/{name}")
  public List<Car> getCarNameContaining(@PathVariable(value = "name") final String carNameStr) {
    return this.carRepository.findByCarNameContaining(carNameStr);
  }


  /**
   * Get All Cars Before Year
   * 
   * @param toYear - To Year
   * @return - Car
   */
  @GetMapping("/getCarToYearBefore/toYear/{toyear}")
  public List<Car> getCarToYearBefore(@PathVariable(value = "toyear") final int toYear) {
    return this.carRepository.findByCarToYearBefore(toYear);
  }


  /**
   * Get All Cars After Year
   * 
   * @param fromyear - From Year
   * @return - Car
   */
  @GetMapping("/getCarFromYearAfter/fromYear/{fromyear}")
  public List<Car> getCarFromYearAfter(@PathVariable(value = "fromyear") final int fromyear) {
    return this.carRepository.findByCarFromYearAfter(fromyear);
  }


  /**
   * Get All Cars Between Before Year and After Year
   * 
   * @param fromYear - From Year
   * @param toYear - To Year
   * @return - Car
   */
  @GetMapping("/getCarFromYearBetween/fromYear/{fromyear}/toYear/{toyear}")
  public List<Car> getCarFromYearBetween(@PathVariable(value = "fromyear") final int fromYear,
      @PathVariable(value = "toyear") final int toYear) {
    return this.carRepository.findByCarFromYearBetween(fromYear, toYear);
  }

  /**
   * Get All Cars by MPG in collection
   * 
   * @param mpgs - Collection of Mpgs
   * @return - Car
   */
  @GetMapping("/findByCarMpgIn/mpgs/{mpgs}")
  public List<Car> getCarMpgIn(@PathVariable(value = "mpgs") final Collection<Integer> mpgs) {
    return this.carRepository.findByCarMpgIn(mpgs);
  }

  /**
   * Get All Cars MPG Greater Than
   * 
   * @param carMpg - Car MPG
   * @return - Car
   */
  @GetMapping("/getCarMpgGreaterThan/mpg/{mpg}")
  public List<Car> getCarMpgGreaterThan(@PathVariable(value = "mpg") final int carMpg) {
    return this.carRepository.findByCarMpgGreaterThan(carMpg);
  }

  /**
   * Get All Cars MPG Greater Than And Equal
   * 
   * @param carMpg - Car MPG
   * @return - Car
   */
  @GetMapping("/getCarMpgGreaterThanEqual/mpg/{mpg}")
  public List<Car> getCarMpgGreaterThanEqual(@PathVariable(value = "mpg") final int carMpg) {
    return this.carRepository.findByCarMpgGreaterThanEqual(carMpg);
  }

  /**
   * Get All Cars Less Than
   * 
   * @param carMpg - Car MPG
   * @return - Car
   */
  @GetMapping("/getCarMpgLessThan/mpg/{mpg}")
  public List<Car> getCarMpgLessThan(@PathVariable(value = "mpg") final int carMpg) {
    return this.carRepository.findByCarMpgLessThan(carMpg);
  }

  /**
   * Get All Cars Less Than And Equal
   * 
   * @param carMpg - Car MPG
   * @return - Car
   */
  @GetMapping("/getCarMpgLessThanEqual/mpg/{mpg}")
  public List<Car> getCarMpgLessThanEqual(@PathVariable(value = "mpg") final int carMpg) {
    return this.carRepository.findByCarMpgLessThanEqual(carMpg);
  }

  /**
   * Get All Cars By Type and Color
   * 
   * @param carType - Car Type
   * @param carColor - Car Color
   * @return - Car
   */
  @GetMapping("/getCarTypeAndColor/carType/{type}/carColor/{color}")
  public List<Car> getCarTypeAndColor(@PathVariable(value = "type") final String carType,
      @PathVariable(value = "color") final String carColor) {
    return this.carRepository.findByCarTypeAndCarColor(carType, carColor);
  }

  /**
   * Get All Car by Name based on Car MPG in Ascending
   * 
   * @param carName - Car Name
   * @return - Car
   */
  @GetMapping("/getCarNameOrderByCarMpgAsc/carName/{name}")
  public List<Car> getCarNameOrderByCarNameAsc(@PathVariable(value = "name") final String carName) {
    return this.carRepository.findByCarNameOrderByCarMpgAsc(carName);
  }

  /**
   * Get All Car by Name based on Car MPG in Descending
   * 
   * @param carName - Car Name
   * @return - Car
   */
  @GetMapping("/getCarNameOrderByCarMpgDesc/carName/{name}")
  public List<Car> getCarNameOrderByCarNameDesc(@PathVariable(value = "name") final String carName) {
    return this.carRepository.findByCarNameOrderByCarMpgDesc(carName);
  }

  /**
   * Get All Top 3 Cars By Review Points
   * 
   * @param carReviewPoints - Car Review Points
   * @return - Car
   */
  @GetMapping("/getTop3ByCarReviewPoints/reviewPoint/{reviewpoints}")
  public List<Car> getTop3ByCarReviewPoints(@PathVariable(value = "reviewpoints") final int carReviewPoints) {
    return this.carRepository.findTop3ByCarReviewPoints(carReviewPoints);
  }


  /**
   * Create Cars
   * 
   * @param cars - car
   * @return - List of Cars
   */
  @PostMapping("/createCars")
  public List<Car> createCars(@RequestBody final List<Car> cars) {
    return this.carRepository.saveAll(cars);
  }


  /**
   * Create Car
   * 
   * @param car - Car
   * @return - car
   */
  @PostMapping("/createCar")
  public Car createCar(@Valid @RequestBody final Car car) {
    return this.carRepository.save(car);
  }

  /**
   * Update Car By Id
   * 
   * @param carId - Car ID
   * @param carDetails - Car Details
   * @return - Car
   * @throws ResourceNotFoundException - Exception
   */
  @PutMapping("/updateCarById/carId/{id}")
  public ResponseEntity<Car> updateCar(@PathVariable(value = "id") final Long carId,
      @Valid @RequestBody final Car carDetails)
      throws ResourceNotFoundException {
    Car car =
        this.carRepository.findById(carId).orElseThrow(() -> new ResourceNotFoundException(CarConstants.ERROR + carId));
    car.setCarRank(carDetails.getCarRank());
    car.setCarName(carDetails.getCarName());
    car.setCarType(carDetails.getCarType());
    car.setCarDesc(carDetails.getCarDesc());
    car.setFeatures(carDetails.getFeatures());
    car.setCarColor(carDetails.getCarColor());
    car.setCarMpg(carDetails.getCarMpg());
    car.setCarFromYear(carDetails.getCarFromYear());
    car.setCarToYear(carDetails.getCarToYear());
    final Car updatedCar = this.carRepository.save(car);
    return ResponseEntity.ok(updatedCar);
  }

  /**
   * Delete Car By Id
   * 
   * @param carId - Car ID
   * @return - Delete Car
   * @throws ResourceNotFoundException - Exception
   */
  @DeleteMapping("/deleteCarById/carId/{id}")
  public Map<String, Boolean> deleteCar(@PathVariable(value = "id") final Long carId) throws ResourceNotFoundException {
    Car car =
        this.carRepository.findById(carId).orElseThrow(() -> new ResourceNotFoundException(CarConstants.ERROR + carId));
    this.carRepository.delete(car);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }

}
