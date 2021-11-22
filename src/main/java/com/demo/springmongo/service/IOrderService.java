package com.demo.springmongo.service;

import java.util.List;

import com.demo.springmongo.model.Order;

public interface IOrderService {
	
	void saveOrder(Order order);
	
	List<Order> ordersOfUser(String userId);
}