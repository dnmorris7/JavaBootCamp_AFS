package com.accenture.adf.newcodington.module20.sample;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Topic : JDBC
 * 
 * Instructions : 
 * 1. Use JDBC API to insert a record in Student table in Faculty database
 * 2. Use Statement interface for the same.
 * 3. Code as per the TODOs 
 * 
 *
 */

public class InsertStatementDemo {
	

		public static void main(String[] args) {
			try{
			
					// TODO 1 Obtain a connection
					Connection c = null;
					c = ConnectionToDBTryIt.getConnection();
					if (c == null) {
						System.out.println("No connection availiable.");
						System.exit(0);
					} else
						System.out.println("Successful connection.");
					Thread.sleep(500);
					Statement s = c.createStatement();
					c.setAutoCommit(false);
					// TODO 2 Check if connection object is not null, print a message
					// for successful connection

					// TODO 3 Create a PreparedStatement with a query
					// "insert into Employee values(?,?,?)"
					int results = s
							.executeUpdate("insert into faculty.student (Student_id, Student_name, Course_id)values(5432,'Thomas', 101)");
					// TODO 4 Change parameters to appropriate values

					c.commit();
					// TODO 5 Set autoCommit to false
					System.out.println(results + " record(s) were inserted");
					// TODO 6 Execute this query using executeUpdate()

					// TODO 7 commit

					// TODO 8 Print the number of rows deleted

					// TODO 9 Close the connection
// TODO 1 Obtain a connection
				
				// TODO 2 Check if connection object is not null, print a message for successful connection 
				
				// TODO 3 Create a Statement object
				
				// TODO 4 Set autoCommit to false 
				
				// TODO 5 Execute this query using executeUpdate(). Add values S009, Thomas and C001 to it.
				
				// TODO 6 commit 
				
				// TODO 7 Print how many rows got updated
				
				// TODO 8 Close the connection				
			}catch (Exception e){
				System.out.println(e.getMessage());
			}

		
}}