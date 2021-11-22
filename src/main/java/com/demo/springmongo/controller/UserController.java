package com.demo.springmongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.demo.springmongo.dto.UserDto;
import com.demo.springmongo.service.IUserService;

@RestController
@RequestMapping("api/user") 
public class UserController {
	@Autowired
	private IUserService userService;

	@PostMapping
	public ResponseEntity<?> saveUser(@RequestBody UserDto userDto) {
		userService.saveUser(userDto.convertToUser());
		return ResponseEntity.ok(true);
	}

	@GetMapping("country/{country}")
	public ResponseEntity<?> findByCountry(@PathVariable String country) {
		return ResponseEntity.ok(userService.findUsersByCountry(country));
	}

	@GetMapping("count-by-country")
	public ResponseEntity<?> countByCountry() {
		return ResponseEntity.ok(userService.countByCountry());
	}

	@GetMapping("group-by-country")
	public ResponseEntity<?> groupByCountry() {
		return ResponseEntity.ok(userService.groupByCountry());
	}
}