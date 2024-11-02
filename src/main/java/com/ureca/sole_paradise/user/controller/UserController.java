package com.ureca.sole_paradise.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ureca.sole_paradise.user.db.dto.UserResponseDTO;
import com.ureca.sole_paradise.user.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;  
	
	@GetMapping("/getInfo/{userId}")
	public ResponseEntity<UserResponseDTO> getMethodName(@PathVariable(name = "userId") int userId) {
		
		return new ResponseEntity<>(userService.getUserInfo(userId), HttpStatus.OK);
	}
	
}
