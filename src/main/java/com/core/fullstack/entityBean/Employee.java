package com.core.fullstack.Entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {

	private String empName;
	private String empId;
	private String empEmail;
	private String mobile;
	private Integer salary;
	
}
