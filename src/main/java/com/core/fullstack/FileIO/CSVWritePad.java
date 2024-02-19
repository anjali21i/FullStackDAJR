package com.core.fullstack;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CSVWritePad {
	
    public static void main(String[] args) {
        // JDBC URL, username, and password
    	String url = "jdbc:mysql://localhost:3306/shop_store?zeroDateTimeBehavior=convertToNull";
        String user = "root";
        String password = "Root@1234";
    	
        // SQL query to select all records from the emp table
        String query = "select itemid, itemname, itemgroup, itemtype from items limit 1";

        try (
            // Establish database connection
            Connection connection = DriverManager.getConnection(url, user, password);
            // Prepare statement
            PreparedStatement statement = connection.prepareStatement(query);
            // Execute query and get result set
            ResultSet resultSet = statement.executeQuery();
            // Create FileWriter to write to CSV file
            FileWriter csvWriter = new FileWriter("/home/anjaligupta/Documents/MyWorkspaces/csvFile/items.csv");
        ) {
            // Write CSV header
            csvWriter.append("itemid,itemname,itemgroup, itemtype\n");

            // Iterate over result set and write data to CSV file
            while (resultSet.next()) {
                int itemid = resultSet.getInt("itemid");
                String itemname = resultSet.getString("itemname");
                String itemgroup = resultSet.getString("itemgroup");
                String itemtype = resultSet.getString("itemtype");
                csvWriter.append(String.valueOf(itemid)).append(",").append(itemname).append(",").append(String.valueOf(itemgroup)).append(String.valueOf(itemtype)).append("\n");
            }

            System.out.println("Data has been written to emp_details.csv successfully!");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

}
