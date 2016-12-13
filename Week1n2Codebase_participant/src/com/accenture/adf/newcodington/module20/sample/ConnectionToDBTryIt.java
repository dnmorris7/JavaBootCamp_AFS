package com.accenture.adf.newcodington.module20.sample;

/**
 * Topic : JDBC
 * 
 * Instructions : 
 * 1. Use JDBC API to obtain a DataBase connection to Participant database
 * 2. Code as per the TODOs 
 * 
 *
 */

import java.sql.*;

public class ConnectionToDBTryIt {
	
	static Connection con ;

	//	This source code tries to establish a connection to a MySQL server
	//	and displays a message concerning the error if connection fails
	
	// TODO 1 Following method should create a database connection and return it. Complete the same.
	public static Connection getConnection() {
try {
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "abcd1234");
		} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		return con;
	}
	
	
	public static void main(String[] args) {
		getConnection();
		System.out.println("Connection obtained - " + con);
	}
}
