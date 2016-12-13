package com.accenture.adf.newcodington.module20.sample;

/**
 * Topic : JDBC
 * 
 * Instructions : 
 * 1. Use JDBC API to delete a record from Employee table in Participant database
 * 2. Code as per the TODOs 
 * 
 *
 */

public class DeleteTryIt {
	public static void main(String[] args) {
		try{
			// TODO 1 Obtain a connection
			
			// TODO 2 Check if connection object is not null, print a message for successful connection 
			
			// TODO 3 Create a PreparedStatement with a query "delete from Employee where emp_id = ?" 
			
			// TODO 4 Replace ? with actual value E001
			
			// TODO 5 Set autoCommit to false
						
			// TODO 6 Execute this query using executeUpdate()
			
			// TODO 7 commit
			
			// TODO 8 Print the number of rows deleted
			
			// TODO 9 Close the connection
			
							
		}catch (Exception e){
			System.out.println(e.getMessage());
		}

	}
}
