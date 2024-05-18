package com.core.fullstack.J2SE.exceptionhandling;

class MyException extends RuntimeException {
    MyException(String s) {
        super(s);
    }
}

class NotFoundException extends RuntimeException {
    NotFoundException(String s) {
        super(s);
    }
}

public class CustomException extends Throwable {

    public static void main(String[] args) {
        String notFound = "404";
        if(notFound.equals("404")) {
            throw new NotFoundException("Page not found!");
        } else {
            System.out.println("FOUND");
        }
    }
}
