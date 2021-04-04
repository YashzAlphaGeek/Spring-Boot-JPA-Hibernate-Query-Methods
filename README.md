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
