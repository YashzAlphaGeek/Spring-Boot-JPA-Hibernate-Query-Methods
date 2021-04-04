# Spring-Boot-JPA-Hibernate-Query-Methods

Spring Data JPA is one of Spring Data modules which provides different API to perform CRUD operation.The Spring Data JPA is mainly used to the development of the repository layer.
In Spring Data we can define the repository interfaces and methods to retrieve the data.

All basic queries are already implemented (for example : findById, findAll, save, delete etc)

The huge benefit is that you have all CRUD operations built-in, via single access point, in addition you are able to implement custom repositories for your complex queries.

The JPA module supports defining a query manually as String or have it being derived from the method name.Although getting a query derived from the method name is quite convenient, one might face the situation in which either the method name parser does not support the keyword one wants to use or the method name would get unnecessarily ugly.

# Derived Query Methods Structure

A derived query method name has two main components separated by the first By keyword:

+ The introducer clause like find, read, query, count, or get which tells Spring Data JPA what you want to do with the method. This clause can contain further expressions, such as Distinct to set a distinct flag on the query to be created.
+ The criteria clause that starts after the first By keyword. The first By acts as a delimiter to indicate the start of the actual query criteria. The criteria clause is where you define conditions on entity properties and concatenate them with And and Or keywords.

Generally the query creation mechanism for JPA works as described below,

## Repository

Here is my code:

	**
	*@author Yashwanth
	*/
	@Repository
	public interface CarRepository extends JpaRepository<Car, Long> {
	/**
	* Find All Cars By Type 
	* @param carType - Type
	* @return - List of Car based on provided type
	*/
	public List<Car> findByCarType(String carType);
	
	}

## Controller

Here is my code:

	/**
	* @author Yashwanth
	*/
	@RestController
	@RequestMapping("/api")
	public class CarController {

	@Autowired
	private CarRepository carRepository;

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
	}


The criteria part contains the entity-specific condition expressions of the query. We can use the condition keywords along with the entity's property names.

 List<Car> findByCarType(String carType) --> Returns List of Cars based on provided Car Type

Outcome:
 ![](https://github.com/YashzAlphaGeek/Spring-Boot-JPA-Hibernate-Query-Methods/blob/master/imgs/Database.png)
 
 ![](https://github.com/YashzAlphaGeek/Spring-Boot-JPA-Hibernate-Query-Methods/blob/master/imgs/Fetching%20Car%20By%20Type.png)
 
Please find the attached source code implemented with below mentioned Query Methods,

|HTTP Verb|	Functionality                                	|REST API's                                                                                    |Supported Keyword inside Methods Names|	Sample                                    |
|:--------|:----------------------------------------------------|:---------------------------------------------------------------------------------------------|:-------------------------------------|:------------------------------------------|
|POST     |Creating a Car                                       |http://localhost:8080/api/createCar                                                           |                                      |save(car)                                  |
|POST     |Creating Cars                                        |http://localhost:8080/api/createCars                                                          |		                      |saveAll(cars)                              |
|GET      |Get Car By Car Id                                    |http://localhost:8080/api/getCarById/carId/6                                                  |		                      |findById(carId)                            |
|PUT      |Update Car By Car Id                                 |http://localhost:8080/api/updateCarById/carId/4                                               |		                      |save(car)                                  |
|GET	  |Get All Cars                                         |http://localhost:8080/api/getAllCars                                                          |		                      |findAll()                                  |
|GET      |Get All Cars By Car Type                             |http://localhost:8080/api/getCarByType/carType/AWD(All Wheel Drive) Type                      |		                      |findByCarType(carType)                     |
|GET      |Get All Cars By Name - Ignore Case                   |http://localhost:8080/api/getCarNameIgnoreCase/carName/dodge charger                          |IgnoreCase                            |findByCarNameIgnoreCase(carName)           |
|GET      |Get All Cars By Car Name Starting With               |http://localhost:8080/api/getCarNameStartingWith/carName/dodge                                |StartingWith                          |findByCarNameStartingWith(carName)         |
|GET      |Get All Cars By Car Name Ending With                 |http://localhost:8080/api/getCarNameEndingWith/carName/charger                                |EndingWith                            |findByCarNameEndingWith(carName)           |
|GET      |Get All Cars By Car Name Containing                  |http://localhost:8080/api/getCarNameContaining/carName/Cooper                                 |Containing	                      |findByCarNameContaining(carNameStr)        |
|GET      |Get All Cars By Car Type and Car Color               |http://localhost:8080/api/getCarTypeAndColor/carType/FWD(Four Wheel Drive) Type/carColor/White|And	                              |findByCarTypeAndCarColor(carType, carColor)|
|GET      |Get All Cars To Year                                 |http://localhost:8080/api/getCarToYearBefore/toYear/2021                                      |Before                                |findByCarToYearBefore(toYear)              |
|GET      |Get All Cars From Year                               |http://localhost:8080/api/getCarFromYearAfter/fromYear/2017                                   |After                                 |findByCarFromYearAfter(fromyear)           |
|GET      |Get All Cars Year Between                            |http://localhost:8080/api/getCarFromYearBetween/fromYear/2017/toYear/2020                     |Between	                              |findByCarFromYearBetween(fromYear, toYear) |
|GET      |Get All Cars By MPG Greater Than                     |http://localhost:8080/api/getCarMpgGreaterThan/mpg/20                                         |GreaterThan                           |findByCarMpgGreaterThan(carMpg)            |
|GET      |Get All Cars By MPG Greater Than And Equal           |http://localhost:8080/api/getCarMpgGreaterThanEqual/mpg/40                                    |GreaterThanEqual                      |findByCarMpgGreaterThanEqual(carMpg)       |
|GET      |Get All Cars By MPG Less Than                        |http://localhost:8080/api/getCarMpgLessThan/mpg/60                                            |LessThan                              |	findByCarMpgLessThan(carMpg)              |
|GET      |Get All Cars By MPG Less Than And Equal              |http://localhost:8080/api/getCarMpgLessThanEqual/mpg/50                                       |LessThanEqual                         |findByCarMpgLessThanEqual(carMpg)          |
|GET      |Get All Cars By MPGS in Collection                   |http://localhost:8080/api/findByCarMpgIn/mpgs/40,60                                           |In	                              |findByCarMpgIn(mpgs)                       |
|GET      |Get All Cars By Car Name Based on Descending(Car MPG)|http://localhost:8080/api/getCarNameOrderByCarMpgDesc/carName/Hyundai Genesis                 |OrderBy                               |findByCarNameOrderByCarMpgDesc(carName)    |
|GET      |Get All Cars By Car Name Based on Ascending(Car MPG) |http://localhost:8080/api/getCarNameOrderByCarMpgAsc/carName/Hyundai Genesis                  |OrderBy                               |findByCarNameOrderByCarMpgAsc(carName)     |
|GET      |Get All Top 3 Cars Based on Review Points            |http://localhost:8080/api/getTop3ByCarReviewPoints/reviewPoint/5                              |Top3By                                |findTop3ByCarReviewPoints(carReviewPoints) |
|DELETE   |Delete a Car                                         |http://localhost:8080/api/deleteCarById/carId/10                                              |		                      |delete(car)                                |



# Supported keywords inside method names:
 + And
 + Or
 + Is,Equals
 + Between
 + LessThan
 + LessThanEqual
 + GreaterThan
 + GreaterThanEqual
 + After
 + Before
 + IsNull
 + IsNotNull,NotNull
 + Like
 + NotLike
 + StartingWith
 + EndingWith
 + Containing
 + OrderBy
 + Not
 + In
 + NotIn
 + TRUE
 + FALSE
 + IgnoreCase

By piecing the query DSL keywords together with the JPA repository generics typing, you can see how Spring Data JPA can generate the JPQL for us.

This, in turn, gets mapped to the actual SQL that will get issued against the database thanks to the JPA ORM framework.
