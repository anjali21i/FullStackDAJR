package com.core.fullstack.java8feature.streams;

import java.util.ArrayList;
import java.util.List;

import com.core.fullstack.Beans.Employee;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StreamTest {
	
	public static void main(String args[]) {
		StreamTest val = new StreamTest();
		Employee emp= new Employee(); 
		List<Employee> dd = val.getData(emp);
		
	}
	
	public List<Employee>  getData(Employee emp) {
		log.info("inside creating bean :");
		List<Employee> list = new ArrayList();
		Employee emp1 = new Employee();
		emp1.setEmpId(emp.getEmpId());
		emp1.setEmpEmail(emp.getEmpEmail());
		emp1.setMobile(emp.getMobile());
		emp1.setEmpName(emp.getEmpName());
		list.add(emp1);
		return list;
	}
}
