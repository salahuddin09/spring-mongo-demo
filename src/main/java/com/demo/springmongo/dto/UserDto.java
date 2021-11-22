package com.demo.springmongo.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import com.demo.springmongo.model.User;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	private String name;
	private String country;
	private String username;
	private AddressDto address;

	public User convertToUser() {
		return User.builder().country(country).createTime(LocalDateTime.now()).name(name).username(username)
				.address(address == null ? null : address.convertToAddress()).build();
	}

}
