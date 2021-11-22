package com.demo.springmongo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.springmongo.model.User;
import com.demo.springmongo.projection.CountryAggregation;
import com.demo.springmongo.projection.UserAggregation;
import com.demo.springmongo.repository.IUserRepository;

import java.util.List;

@Service
public class UserService implements IUserService {
	@Autowired
	private IUserRepository userRepository;

	@Override
	public void saveUser(User user) {
		userRepository.save(user);
	}

	@Override
	public List<User> findUsersByCountry(String country) {
		return userRepository.findByCountryAsCustom(country);
	}

	@Override
	public List<UserAggregation> groupByCountry() {
		return userRepository.groupByCounty();
	}

	@Override
	public List<CountryAggregation> countByCountry() {
		return userRepository.countByCountry();
	}
}
