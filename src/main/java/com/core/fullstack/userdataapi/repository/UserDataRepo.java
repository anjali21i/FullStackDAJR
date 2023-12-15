package com.core.fullstack.userdataapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.core.fullstack.userdataapi.entities.UserData;

public interface UserDataRepo extends JpaRepository<UserData, Long> {

}
