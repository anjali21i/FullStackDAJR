package com.core.fullstack.userdataapi.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {
	
	@NotBlank(message = "username should not be blank")
	String name;
	
	@Min(16)
	@Max(70)
	int age;
	
	@NotNull(message = "mobile should not be blank")
	@Pattern(regexp = "^\\d{10}$", message= "invalid mobile entered")
	Long mobile;
	
	@NotNull(message = "email should not be blank")
	@Email(message = "invalid email entered")
	String email;
	String gender;
	
	@NotNull(message = "enter nationality")
	String nationality;

}
