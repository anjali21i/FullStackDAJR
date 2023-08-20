package com.core.fullstack.J2SE;

class PolygonC {
    public void display() {
        System.out.println("Inside the Polygon class");
    }
}
interface PolygonI {
    public void display();
}

class AnonymousDemo {
    public void createClass() {
        // creation of anonymous class extending class Polygon
        PolygonC pC = new PolygonC() {
            public void display() {
                System.out.println("Inside an anonymous class.");
            }
        };
        pC.display();

        // anonymous class implementing interface
        PolygonI pI = new PolygonI() {
            public void display() {
                System.out.println("Inside an anonymous class.");
            }
        };
        pI.display();
    }
}

class Main {
    public static void main(String[] args) {
        AnonymousDemo an = new AnonymousDemo();
        an.createClass();

    }
}