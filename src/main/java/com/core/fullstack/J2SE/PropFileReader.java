package com.core.fullstack.J2SE;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropFileReader {
    public static void main(String[] args) {
        Properties properties = new Properties();

        try (FileInputStream fis = new FileInputStream("testconfig.properties")) {
            properties.load(fis);

            String appName = properties.getProperty("app.name");
            String appVersion = properties.getProperty("app.version");
            String appAuthor = properties.getProperty("app.author");

            System.out.println("Application Name: " + appName);
            System.out.println("Application Version: " + appVersion);
            System.out.println("Application Author: " + appAuthor);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
