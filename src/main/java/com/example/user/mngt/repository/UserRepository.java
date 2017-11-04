package com.example.user.mngt.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.example.user.mngt.domain.User;
import com.example.user.mngt.model.Response;

@Repository
public class UserRepository {

	private static Map<Integer, User> users = new HashMap<Integer, User>();
	private static int counter = 100;

	public Response createUser(User user) {
		Response response = new Response();
		for (Entry<Integer, User> entry : users.entrySet()) {
			User temp = entry.getValue();
			if (user.getEmail().equals(temp.getEmail()) && temp.isActive()) {
				response.setResMsg("Email id already exists !!");
				return response;
			}
		}
		counter++;
		user.setId(counter);
		users.put(counter, user);
		response.setUserId(String.valueOf(counter));
		response.setResMsg("User created successfully !!");
		return response;
	}

	public Response updateUser(int userId, User user) {
		Response response = new Response();
		User temp = users.get(userId);
		response.setUserId(String.valueOf(userId));
		if (temp != null) {
			temp.setPinCode(user.getPinCode());
			temp.setBirthDate(user.getBirthDate());
			response.setResMsg("User updated successfully !!");
		} else {
			response.setResMsg("UserId does't found !!");
		}
		return response;
	}

	public Response deleteUser(int userId) {
		Response response = new Response();
		User temp = users.get(userId);
		response.setUserId(String.valueOf(userId));
		if (temp != null) {
			temp.setActive(false);
			response.setResMsg("User deleted successfully !!");
		} else {
			response.setResMsg("UserId does't found !!");
		}
		return response;
	}

	public Set<Entry<Integer, User>> getUsers() {
		return users.entrySet();
	}

	public User getUser(int userId) {
		return users.get(userId);
	}

}
