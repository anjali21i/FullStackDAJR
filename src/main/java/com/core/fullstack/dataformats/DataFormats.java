package com.core.fullstack.dataformats;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.json.JSONParser;

import com.core.fullstack.Beans.Department;
import com.core.fullstack.Beans.Employee;
import com.core.fullstack.Beans.EmployeeData;
import com.core.fullstack.Beans.Office;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

class Root {
	ArrayList<EmployeeData> dList;
}

@Slf4j
public class DataFormats {
	
	static String dd = "{\n"
			+ "  \"EmployeeData\": [\n"
			+ "      {\n"
			+ "        \"id\": \"1\",\n"
			+ "        \"firstName\": \"Tom\",\n"
			+ "        \"lastName\": \"Cruise\"\n"
			+ "      },\n"
			+ "      {\n"
			+ "        \"id\": \"2\",\n"
			+ "        \"firstName\": \"Maria\",\n"
			+ "        \"lastName\": \"Sharapova\"\n"
			+ "      },\n"
			+ "      {\n"
			+ "        \"id\": \"3\",\n"
			+ "        \"firstName\": \"James\",\n"
			+ "        \"lastName\": \"Bond\"\n"
			+ "  	}\n"
			+ "	]\n"
			+ "}";
	
	static String myJsonString = "{\n"
			+ "  \"EmployeuueData\": [\n"
			+ "    {\n"
			+ "      \"userId\": \"rirani\",\n"
			+ "      \"jobTitleName\": \"Developer\",\n"
			+ "      \"firstName\": \"Romin\",\n"
			+ "      \"lastName\": \"Irani\",\n"
			+ "      \"preferredFullName\": \"Romin Irani\",\n"
			+ "      \"employeeCode\": \"E1\",\n"
			+ "      \"region\": \"CA\",\n"
			+ "      \"phoneNumber\": \"408-1234567\",\n"
			+ "      \"emailAddress\": \"romin.k.irani@gmail.com\"\n"
			+ "    },\n"
			+ "    {\n"
			+ "      \"userId\": \"nirani\",\n"
			+ "      \"jobTitleName\": \"Developer\",\n"
			+ "      \"firstName\": \"Neil\",\n"
			+ "      \"lastName\": \"Irani\",\n"
			+ "      \"preferredFullName\": \"Neil Irani\",\n"
			+ "      \"employeeCode\": \"E2\",\n"
			+ "      \"region\": \"CA\",\n"
			+ "      \"phoneNumber\": \"408-1111111\",\n"
			+ "      \"emailAddress\": \"neilrirani@gmail.com\"\n"
			+ "    },\n"
			+ "    {\n"
			+ "      \"userId\": \"thanks\",\n"
			+ "      \"jobTitleName\": \"Program Directory\",\n"
			+ "      \"firstName\": \"Tom\",\n"
			+ "      \"lastName\": \"Hanks\",\n"
			+ "      \"preferredFullName\": \"Tom Hanks\",\n"
			+ "      \"employeeCode\": \"E3\",\n"
			+ "      \"region\": \"CA\",\n"
			+ "      \"phoneNumber\": \"408-2222222\",\n"
			+ "      \"emailAddress\": \"tomhanks@gmail.com\"\n"
			+ "    }\n"
			+ "  ]\n"
			+ "}";

	
	public static void main(String[] args) {

//		JsonParser parser = new JsonParser();
		ObjectMapper om = new ObjectMapper();
		try {
			Root root = om.readValue(dd, Root.class);
			
			System.out.println("root :---"+ root.toString());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {     
//            Object obj = parser.parse(new FileReader("c:\\EmployeeData.json"));
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		Office office = new Office();
		
		Department dep = new Department();
		List<Employee> dataL = new ArrayList();
		for(int i=0; i<2; i++) {
			
			Employee emp = new Employee();
			emp.setEmpEmail("aa"+i+"@ii");
			emp.setEmpId("jkj"+i);
			emp.setEmpName("jjj");
//			emp.setJobTitle("sede");
			emp.setMobile("978766543"+i);
//			emp.setRegionCode("sds8"+i);
			dataL.add(emp);
//			System.out.println("emp :---"+ emp.toString());
		}
		
		dep.setEmpList(dataL);
		dep.setDepCode("drrrr");
		dep.setDepHead("www");
		
		office.setLocation("DD");
		Map<String, Department> depmp = new HashMap();
		depmp.put("ABC", dep);
		depmp.put("uyhh", dep);
		
		office.setDepMap(depmp);
		
//		System.out.println("emp list :---"+ dataL);
		System.out.println("office :---"+ office.toString());
		 Object obj = new Object();
		 obj  = dep;
		 System.out.println("obj d:---"+ obj);
		 obj  = office;
		System.out.println("obj :---"+ obj);
		
	}
}
