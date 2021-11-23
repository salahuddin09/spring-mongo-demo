package com.demo.springmongo.service;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.demo.springmongo.dto.UserDto;
import com.demo.springmongo.model.User;
import com.demo.springmongo.repository.IUserRepository;

import java.util.List;

@SpringBootTest(properties = "spring.profiles.active:test")
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
public class UserServiceTest {
	@Autowired
	private IUserService userService;

	@Autowired
	private IUserRepository userRepository;

	@Test
	public void test_saveUser() {
		UserDto userDto = UserDto.builder().country("AUS").name("Test User - 3").username("testuser3").build();

		userService.saveUser(userDto.convertToUser());

		List<User> users = userRepository.findAll();

		Assertions.assertThat(users).hasSize(1);
	}
}
