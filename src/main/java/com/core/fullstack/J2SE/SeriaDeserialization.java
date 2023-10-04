package com.core.fullstack.J2SE;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.core.fullstack.Beans.UserData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SeriaDeserialization {

	static ObjectMapper objectMapper = new ObjectMapper();

	public static String serialization(UserData userD) throws JsonProcessingException {
		String jsonString = objectMapper.writeValueAsString(userD);
		byte[] data  = objectMapper.writeValueAsBytes(userD);
		return jsonString;
	}

	public static UserData deserialization(String jsonData) throws JsonMappingException, JsonProcessingException {

		String jsonString = "{ \"name\": \"John\", \"age\": 30, \"add\": \"Delhi\" }";
		UserData obj = objectMapper.readValue(jsonString, UserData.class);

		UserData obj2 = objectMapper.readValue(jsonData, UserData.class);
		System.out.println("obj2: "+ obj2);
		return obj;

	}
	
	public static void readWriteJSONToFile() throws StreamReadException, DatabindException, IOException {
		// Read from file
//		FileWriter file = new FileWriter("../userdata.json");
		
		UserData yourObject = objectMapper.readValue(new File("../userdata.json"), UserData.class);
		System.out.println("yourObject : "+ yourObject);
		// Write to file
		objectMapper.writeValue(new File("../output.json"), yourObject);
	}
	

	public static void main(String args[]) {

		try {
			UserData d = new UserData();
			d.setName("Anjali");
			d.setAdd("Jaunpur");
			d.setAge(4);
			System.out.println("object d:: " + d);
			try {
				String sdata = serialization(d);
				System.out.println("sdata:: " + sdata);
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				UserData data = deserialization("{ \"name\": \"John\", \"age\": 30, \"add\": \"Delhi\" }");
				System.out.println("ddata:: " + data);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//file json reader writer
		try {
			System.out.println("inside file reader call");
			readWriteJSONToFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}