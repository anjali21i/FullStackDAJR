package com.core.fullstack.Beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	private String empName;
	private String empId;
	private String empEmail;
	private String mobile;
//	private String jobTitle;
//	private String regionCode;
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
//	public String getJobTitle() {
//		return jobTitle;
//	}
//	public void setJobTitle(String jobTitle) {
//		this.jobTitle = jobTitle;
//	}
//	public String getRegionCode() {
//		return regionCode;
//	}
//	public void setRegionCode(String regionCode) {
//		this.regionCode = regionCode;
//	}
//	@Override
//	public String toString() {
//		return "Employee [empName=" + empName + ", empId=" + empId + ", empEmail=" + empEmail + ", mobile=" + mobile
//				+ ", jobTitle=" + jobTitle + ", regionCode=" + regionCode + ", getEmpName()=" + getEmpName()
//				+ ", getEmpId()=" + getEmpId() + ", getEmpEmail()=" + getEmpEmail() + ", getMobile()=" + getMobile()
//				+ ", getJobTitle()=" + getJobTitle() + ", getRegionCode()=" + getRegionCode() + ", getClass()="
//				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
//	}
//	
	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", empId=" + empId + ", empEmail=" + empEmail + ", mobile=" + mobile
				+ ", getEmpName()=" + getEmpName() + ", getEmpId()=" + getEmpId() + ", getEmpEmail()=" + getEmpEmail()
				+ ", getMobile()=" + getMobile() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
  
}
