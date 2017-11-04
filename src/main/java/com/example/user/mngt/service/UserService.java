package com.example.user.mngt.service;

import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.user.mngt.domain.User;
import com.example.user.mngt.model.Response;
import com.example.user.mngt.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public Response createUser(User user) {
		return repository.createUser(user);
	}

	public Response updateUser(int userId, User user) {
		return repository.updateUser(userId, user);
	}

	public Response deleteUser(int userId) {
		return repository.deleteUser(userId);
	}

	public Set<Entry<Integer, User>> getUsers() {
		return repository.getUsers();
	}

	public User getUser(int userId) {
		return repository.getUser(userId);
	}

}
