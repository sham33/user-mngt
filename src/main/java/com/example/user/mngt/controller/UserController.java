package com.example.user.mngt.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.mngt.domain.User;
import com.example.user.mngt.model.Response;
import com.example.user.mngt.model.ValidationField;
import com.example.user.mngt.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<?> getUsers() {
		return ResponseEntity.ok(service.getUsers());
	}

	@PostMapping
	public ResponseEntity<?> createUser(@Valid @RequestBody User user, Errors errors) {
		if (errors.hasErrors()) {
			List<ValidationField> errorsList = new ArrayList<ValidationField>();
			for (ObjectError error : errors.getAllErrors()) {
				ValidationField field = new ValidationField();
				field.setField(error.getObjectName());
				field.setMessage(error.getDefaultMessage());
				field.setCode(error.getCode());
				errorsList.add(field);
			}
			Response response = new Response();
			response.setResMsg("Invalid request inputs !!");
			response.setUserId(String.valueOf(user.getId()));
			response.setValErrors(errorsList);
			return ResponseEntity.ok(response);
		}
		return ResponseEntity.ok(service.createUser(user));
	}

	@PutMapping("/{userId}")
	public ResponseEntity<?> updateUser(@PathVariable("userId") int userId, @RequestBody User user) {
		return ResponseEntity.ok(service.updateUser(userId, user));
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable("userId") int userId) {
		return ResponseEntity.ok(service.deleteUser(userId));
	}

}
