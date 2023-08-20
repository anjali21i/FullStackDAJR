package com.core.fullstack.J2SE;

public class SingletonClass {

   private static SingletonClass singleObject;  // private field that refers to the object                        
   private SingletonClass() {
      // constructor of the Singleton class
   }

   public static SingletonClass getInstance() {
	   // create only one object
	   // access the object as per our need
	   
	   singleObject = new SingletonClass();
	   return singleObject;  
   }
}

// example class 
class Database {
    private static Database dbObject;

    private Database() {      
    }
    public static Database getInstance() {
        // create object if it's not already created
        if(dbObject == null) {
        	dbObject = new Database();
        }
        // returns the singleton object
        return dbObject;
    }
    public void getConnection() {
        System.out.println("You are now connected to the database.");
    }
}

class CallerMain {
    public static void main(String[] args) {
        Database db1;
        // refers to the only object of Database
        db1= Database.getInstance();
        db1.getConnection();
    }
}