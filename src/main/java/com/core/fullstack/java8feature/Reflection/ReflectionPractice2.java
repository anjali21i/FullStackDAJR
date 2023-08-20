package com.core.fullstack.java8feature.Reflection;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

class Person {
    private String name;
    private int age;
}


public class ReflectionPractice2 {

	private static List<String> getFieldNames(Field[] fields) {
	    List<String> fieldNames = new ArrayList<>();
	    for (Field field : fields)
	    	fieldNames.add(field.getName());
	    return fieldNames;
	}

	@Test
	public void givenObject_whenGetsFieldNamesAtRuntime_thenCorrect() {
	    Object person = new Person();
	    Field[] fields = person.getClass().getDeclaredFields();

	    List<String> actualFieldNames = getFieldNames(fields);

	    assertTrue(Arrays.asList("name", "age")
	      .containsAll(actualFieldNames));
	}
}
