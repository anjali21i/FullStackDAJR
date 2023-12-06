package com.core.fullstack.userdataapi.service;

import java.util.List;

import com.core.fullstack.userdataapi.dto.UserRequest;
import com.core.fullstack.userdataapi.entities.UserData;

public interface UserDataService {

	List<UserData> getAllUsers() throws Exception;

	UserData saveUser(UserRequest request) throws Exception;

	UserData getUserById(Long id) throws Exception;

}
