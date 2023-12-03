package com.core.fullstack.entitybean;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {

	private String empName;
	
	@Id
	private String empId;
	private String empEmail;
	private String mobile;
	private Integer salary;
	
}
