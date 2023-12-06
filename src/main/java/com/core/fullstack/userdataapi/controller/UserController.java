package com.core.fullstack.userdataapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.core.fullstack.userdataapi.dto.UserRequest;
import com.core.fullstack.userdataapi.entities.UserData;
import com.core.fullstack.userdataapi.service.UserDataService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserDataService service;

	@PostMapping("register")
	public ResponseEntity<UserData> registerNewUser(@RequestBody @Valid UserRequest request) {
		try {
			return new ResponseEntity<UserData>(service.saveUser(request), HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<UserData>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/login/{id}")
	public ResponseEntity<UserData> signUpUser(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(service.getUserById(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<UserData>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/getAllData")
	public ResponseEntity<List<UserData>> loginUser() {
		try {
			return ResponseEntity.ok(service.getAllUsers());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<UserData>>(HttpStatus.NOT_FOUND);
	}

}
