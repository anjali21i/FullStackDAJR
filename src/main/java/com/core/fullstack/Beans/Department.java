package com.core.fullstack.Beans;

import java.util.List;

import lombok.Data;

@Data
public class Department {
	
	String depCode;
	List<Employee> empList;
	String depHead;
	public String getDepCode() {
		return depCode;
	}
	public void setDepCode(String depCode) {
		this.depCode = depCode;
	}
	public List<Employee> getEmpList() {
		return empList;
	}
	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}
	public String getDepHead() {
		return depHead;
	}
	public void setDepHead(String depHead) {
		this.depHead = depHead;
	}
	@Override
	public String toString() {
		return "Department [depCode=" + depCode + ", empList=" + empList + ", depHead=" + depHead + ", getDepCode()="
				+ getDepCode() + ", getEmpList()=" + getEmpList() + ", getDepHead()=" + getDepHead() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
