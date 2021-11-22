package com.demo.springmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.springmongo.model.Order;

public interface IOrderRepository extends MongoRepository<Order, String> {
	List<Order> findByUserId(String userId);
}