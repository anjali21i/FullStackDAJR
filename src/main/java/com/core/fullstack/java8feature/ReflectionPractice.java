package com.core.fullstack.java8feature;

import java.lang.Class;
import java.lang.reflect.*;

class Animal {
}

class Dog extends Animal {
  public void display() {
    System.out.println("I am a dog.");
  }
}

public class ReflectionPractice {
  public static void main(String[] args) {
    try {
      Dog d1 = new Dog();
      Class obj = d1.getClass();
      String name = obj.getName();
      System.out.println("Name: " + name);
      int modifier = obj.getModifiers();
      String mod = Modifier.toString(modifier);
      System.out.println("Modifier: " + mod);
      Class superClass = obj.getSuperclass();
      System.out.println("Superclass: " + superClass.getName());
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}

class Person {
    private String name;
    private int age;
}


//public void givenObject_whenGetsFieldNamesAtRuntime_thenCorrect() {
//    Object person = new Person();
//    Field[] fields = person.getClass().getDeclaredFields();
//
//    List<String> actualFieldNames = getFieldNames(fields);
//
//    assertTrue(Arrays.asList("name", "age")
//      .containsAll(actualFieldNames));
//}





