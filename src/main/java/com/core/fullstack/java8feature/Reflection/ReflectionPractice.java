package com.core.fullstack.java8feature.Reflection;

import static org.junit.Assert.assertTrue;

import java.lang.Class;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import lombok.Data;

@Data
class Animal {
	 private String name;
	 private int age;
}

interface Mammel {
	void display();
}


class Dog extends Animal implements Mammel{
	 public String breed;
	 
	 @Override
	 public void display() {
		System.out.println("I am a dog.");
	 }
	 
	 public String getName(String name) {
		 return name;
	 }
}

public class ReflectionPractice {

	private static List<String> getFieldNames(Field[] fields) {
		List<String> fieldNames = new ArrayList<>();
		for (Field field : fields)
			fieldNames.add(field.getName());
		return fieldNames;
	}
	
	@Test
	public void givenObject_whenGetsFieldNamesAtRuntime_thenCorrect() {
	    Object dog = new Dog();
	    Field[] fields = dog.getClass().getDeclaredFields();

	    List<String> actualFieldNames = getFieldNames(fields);

	    assertTrue(Arrays.asList("name", "age")
	      .containsAll(actualFieldNames));
	}

	public static void main(String[] args) {
		try {
			Dog d1 = new Dog();
			Class<? extends Dog> obj = d1.getClass();

			String name = obj.getName();
			System.out.println("Name: " + name);
			
			int modifier = obj.getModifiers();
			String mod = Modifier.toString(modifier);
			System.out.println("Modifier: " + mod);
			
			Class<?> superClass = obj.getSuperclass();
			System.out.println("Superclass: " + superClass.getName());
			
			Field[] fields = d1.getClass().getDeclaredFields();
			System.out.println("fields: " + fields);
			
			Field field1 = d1.getClass().getField("breed");
			System.out.println("field1: " + field1);
			
			List<String> actualFieldNames = getFieldNames(fields);
			System.out.println("actualFieldNames: " + actualFieldNames);
			
			Class<?>[] animalInterfaces = obj.getInterfaces();
			System.out.println("animalInterfaces: " + animalInterfaces) ;
			
			Method[] getDetail = d1.getClass().getDeclaredMethods();
			System.out.println("getDetail: " + getDetail);
					
			Method method = d1.getClass().getMethod("display");
			Method method2 = d1.getClass().getMethod("getName");
			
			System.out.println("method: " + method);
			System.out.println("method2: " + method2);

			int modifi = method2.getModifiers();
			System.out.println("modifi: " + modifi);
	        System.out.println("Modifier: " + Modifier.toString(modifi));
	        
	        System.out.println(" method2m ReturnType: " +  method2.getReturnType());
	       
	       
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
