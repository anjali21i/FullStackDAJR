package com.core.fullstack.Beans;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class Office {
	
//	List<Department> depList;
	String location;
	String offCode;
	Map<String, Department> depMap;
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getOffCode() {
		return offCode;
	}
	public void setOffCode(String offCode) {
		this.offCode = offCode;
	}
	public Map<String, Department> getDepMap() {
		return depMap;
	}
	public void setDepMap(Map<String, Department> depMap) {
		this.depMap = depMap;
	}
	@Override
	public String toString() {
		return "Office [location=" + location + ", offCode=" + offCode + ", depMap=" + depMap + ", getLocation()="
				+ getLocation() + ", getOffCode()=" + getOffCode() + ", getDepMap()=" + getDepMap() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

}
