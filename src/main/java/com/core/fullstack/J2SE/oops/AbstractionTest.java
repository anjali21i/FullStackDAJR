package com.core.fullstack.J2SE.oops;

import java.util.ArrayList;

abstract class Animal {

    protected String type;
    private String size;
    private double weight;

    public Animal(String type, String size, double weight) {
        this.type = type;
        this.size = size;
        this.weight = weight;
    }

    public abstract void move(String speed);
    public abstract void makeNoise();

}

class Dog extends Animal {

    public Dog(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {
        if (speed.equals("slow")) {
            System.out.println(type + " walking");
        } else {
            System.out.println(type + " running");
        }
    }

    @Override
    public void makeNoise() {
        if (type == "Wolf") {
            System.out.print("Howling! ");
        } else {
            System.out.print("Woof! ");
        }
    }
}

class Fish extends Animal {
    public Fish(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {
        if (speed.equals("slow")) {
            System.out.println(type + " lazily swimming");
        } else {
            System.out.println(type + " darting frantically");
        }
    }

    @Override
    public void makeNoise() {
        if (type == "Goldfish") {
            System.out.print("swish ");
        } else {
            System.out.print("splash ");
        }
    }
}

public class AbstractionTest {

    public static void main(String[] args) {
//        Animal animal = new Animal("animal", "big", 100);
    	
        Dog dog = new Dog("Wolf", "big", 100 );
        dog.makeNoise();
        doAnimalStuff(dog);

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(dog);
        animals.add(new Dog("German Shepard", "big", 150));
        animals.add(new Fish("Goldfish", "small", 1));
        animals.add(new Fish("Barracuda", "big", 75));
        animals.add(new Dog("Pug", "small", 20));

        for (Animal animal : animals) {
            doAnimalStuff(animal);
        }
        
        Animal animals2 = new Fish("Goldfish", "small", 1);
    }

    private static void doAnimalStuff(Animal animal) {

        animal.makeNoise();
        animal.move("slow");
    }

}