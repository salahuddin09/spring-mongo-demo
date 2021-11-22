package com.demo.springmongo.service;

import java.util.List;

import com.demo.springmongo.model.User;
import com.demo.springmongo.projection.CountryAggregation;
import com.demo.springmongo.projection.UserAggregation;

public interface IUserService {
	
	void saveUser(User user);

	List<User> findUsersByCountry(String country);

	List<UserAggregation> groupByCountry();

	List<CountryAggregation> countByCountry();
}
