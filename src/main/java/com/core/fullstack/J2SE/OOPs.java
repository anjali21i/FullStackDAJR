package com.core.fullstack.J2SE;

// Association Example
class Student {
    String name;

    public Student(String name) {
        this.name = name;
    }
}

class Course {
    String courseName;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    void enrollStudent(Student student) {
        System.out.println(student.name + " enrolled in " + courseName);
    }
}

// Aggregation Example
class Department {
    String departmentName;
    Course[] courses;

    public Department(String departmentName, Course[] courses) {
        this.departmentName = departmentName;
        this.courses = courses;
    }
}

// Composition Example
class Engine {
    void start() {
        System.out.println("Engine started");
    }
}

class Car {
    Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    void startCar() {
        engine.start();
        System.out.println("Car started");
    }
}

// Inheritance Example
class Animal {
    void eat() {
        System.out.println("Animal is eating");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking");
    }
}

public class OOPs {
    public static void main(String[] args) {
        // Association Example
        Student student = new Student("John");
        Course course = new Course("Java Programming");
        course.enrollStudent(student);

        // Aggregation Example
        Course[] csCourses = { new Course("Computer Networks"), new Course("Data Structures") };
        Department csDepartment = new Department("Computer Science", csCourses);

        // Composition Example
        Engine carEngine = new Engine();
        Car myCar = new Car(carEngine);
        myCar.startCar();

        // Inheritance Example
        Dog myDog = new Dog();
        myDog.eat();
        myDog.bark();
    }
}
