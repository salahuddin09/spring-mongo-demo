package com.demo.springmongo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.demo.springmongo.dto.OrderDto;
import com.demo.springmongo.service.IOrderService;

@RestController
@RequestMapping("api/order") 
public class OrderController {
	@Autowired
	private IOrderService orderService;

	@PostMapping
	public ResponseEntity<?> saveOrder(@RequestBody OrderDto orderDto) {
		orderService.saveOrder(orderDto.convertToOrder());
		return ResponseEntity.ok(true);
	}

	@GetMapping("{userId}")
	public ResponseEntity<?> getOrdersOfUser(@PathVariable String userId) {
		return ResponseEntity.ok(orderService.ordersOfUser(userId));
	}
}