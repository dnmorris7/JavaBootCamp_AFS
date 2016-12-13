package com.accenture.adf.newcodington.module20.sample;

/**
 * Topic : JDBC
 * 
 * Instructions : 
 * 1. Use JDBC API to obtain a DataBase connection to Faculty database
 * 2. Code as per the TODOs 
 * 
 *
 */

import java.sql.*;

public class ConnectionToDBDemo {
	
	static Connection con ;

	//	This source code tries to establish a connection to a MySQL server
	//	and displays a message concerning the error if connection fails
	
	//Following method creates a connection and returns it
	public static Connection getConnection() {

		//TODO 1 Write JDBC code to establish a connection to the database.
			return con;
	}
	
	
	public static void main(String[] args) {
		
		//TODO 2 Call getConnection method
		
		//TODO 3 Print connection information
		
		
	}
}
