package com.core.fullstack.userdataapi.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "userdata")
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserData implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id	
	Long id;
	
	String name;
	int age;
	Long mobile;
	String email;
	String gender;
	String nationality;

}
