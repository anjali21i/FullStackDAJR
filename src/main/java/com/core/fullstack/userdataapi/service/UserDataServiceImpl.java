package com.core.fullstack.userdataapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.fullstack.userdataapi.dto.UserRequest;
import com.core.fullstack.userdataapi.entities.UserData;
import com.core.fullstack.userdataapi.repository.UserDataRepo;

@Service
public class UserDataServiceImpl implements UserDataService {

	@Autowired
	UserDataRepo repo;

	@Override
	public List<UserData> getAllUsers() throws Exception {
		return repo.findAll();
	}

	@Override
	public UserData saveUser(UserRequest request) throws Exception {
		if (request != null) {
			UserData userData = UserData.build(0L, request.getName(), request.getAge(), request.getMobile(),
					request.getEmail(), request.getGender(), request.getNationality());
			return repo.save(userData);
		}
		return null;
	}

	@Override
	public UserData getUserById(Long id) throws Exception {
		return repo.findById(id).get();
	}

}
