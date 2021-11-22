package com.demo.springmongo.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import com.demo.springmongo.model.Order;


@Getter
@NoArgsConstructor
public class OrderDto {
	private String name;
	private String userId;

	public Order convertToOrder() {
		return Order.builder().orderName(name).userId(userId).orderTime(LocalDateTime.now()).build();
	}
}