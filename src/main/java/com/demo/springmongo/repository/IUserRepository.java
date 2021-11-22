package com.demo.springmongo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.demo.springmongo.model.User;
import com.demo.springmongo.projection.CountryAggregation;
import com.demo.springmongo.projection.UserAggregation;

public interface IUserRepository extends MongoRepository<User, String> {
	// findBy + fieldName
	Optional<User> findByUsername(String username);

	// value: where condition
	// fields: select items: 1 => include, 0 => exclude
	// sort: 1 => ASC, -1 => DESC
	@Query(value = "{ country: ?0 }", fields = "{ name: 1, _id: 0 }", sort = "{ name: -1 }")
	List<User> findByCountryAsCustom(String country);

	// select country, sum(1) = count(*) from users group by country
	@Aggregation("{ $group: { _id : $country, total : { $sum : 1 } } }")
	List<CountryAggregation> countByCountry();

	// select country, [names] from user group by country
	@Aggregation("{ $group: { _id : $country, names : { $addToSet : $name } } }")
	List<UserAggregation> groupByCounty();
}