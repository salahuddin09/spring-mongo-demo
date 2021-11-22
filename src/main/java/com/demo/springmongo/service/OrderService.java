package com.demo.springmongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.springmongo.model.Order;
import com.demo.springmongo.repository.IOrderRepository;


@Service
public class OrderService implements IOrderService {
	@Autowired
	private IOrderRepository orderRepository;

	@Override
	public void saveOrder(Order order) {
		orderRepository.save(order);
	}

	@Override
	public List<Order> ordersOfUser(String userId) {
		return orderRepository.findByUserId(userId);
	}
}