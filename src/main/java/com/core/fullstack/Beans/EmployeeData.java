package com.core.fullstack.Beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder("EmployeeData") 
public class EmployeeData {
	
	public String id;
    public String firstName;
    public String lastName;

}
