package com.mvc.util;
 
import java.sql.Connection;
import java.sql.DriverManager;
 
public class DBConnection {
public static Connection createConnection()
 {
     Connection con = null;
     String url = "jdbc:mysql://localhost:3306/lost_and_found"; //MySQL URL followed by the database name
     String username = "root"; //MySQL username
     String password = ""; //MySQL password
     System.out.println("In DBConnection.java class ");
      
     try
     {
    	 Class.forName("com.mysql.cj.jdbc.Driver"); //loading MySQL drivers. This differs for database servers 
         con = DriverManager.getConnection(url, username, password); //attempting to connect to MySQL database
         System.out.println("Printing connection object "+con);
     } 
     catch (Exception e) 
     {
        e.printStackTrace();
     }   
     return con; 
 }
}