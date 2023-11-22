package com.core.fullstack.J2SE;

public class InterfaceAbstraction {
	
	public static void main(String[] args) {

        Bird bird = new Bird();
        Animals animal = bird;
        FlightEnabled flier = bird;
        Trackable tracked = bird;

        animal.move();
//        flier.move();
//        tracked.move();

        flier.takeOff();
        flier.fly();
        tracked.track();
        flier.land();
    }
}

interface FlightEnabled {

    void takeOff();
    void land();
    void fly();

}

interface Trackable {

    void track();
}

abstract class Animals {

    public abstract void move();
}

class Bird extends Animals implements FlightEnabled, Trackable {

    @Override
    public void move() {
        System.out.println("Flaps wings");
    }

    @Override
    public void takeOff() {
        System.out.println(getClass().getSimpleName() + " is taking off");
    }

    @Override
    public void land() {
        System.out.println(getClass().getSimpleName() + " is landing");
    }

    @Override
    public void fly() {
        System.out.println(getClass().getSimpleName() + " is flying");
    }

    @Override
    public void track() {
        System.out.println(getClass().getSimpleName() + "'s coordinates recorded");
    }
}

