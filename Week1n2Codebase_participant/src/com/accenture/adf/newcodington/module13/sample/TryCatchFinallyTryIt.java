package com.accenture.adf.newcodington.module13.sample;

/**
 * 
 * Topic: Error Handling using Try-Catch clause
 * 
 * Instructions: 1. Handle ArrayIndexOutofBounds exception for array using
 * TRY-CATCH clause 2. Print a message "Count down stopped" irrespective of
 * Exception using FINALLY block
 * 
 */

// TODO 1 Create a public class called 'TryCatchFinallyTryIt'
public class TryCatchFinallyTryIt {

	// TODO 2 Create a method called showTrackCount() that returns void
	// a. Initialize an int array with numbers starting from 0 to 10
	// b. Add a for loop to iterate through the int array and display each
	// number on
	// a separate line
	// c. Handle ArrayIndexOutofBounds exception for array using TRY-CATCH
	// clause
	// d. Print a message "Count down stopped" irrespective of Exception using
	// FINALLY block
	public static void showTrackCount() {
		try {
			int[] nums = new int[9];
			for (int i = 0; i < nums.length; i++) {
				nums[i] = i + 1;
			}
			for (int i = 0; i < 20; i++) {
				System.out.println("Counting Down: " + nums[i]);
				Thread.sleep(500);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Countdown Stopped.");
			e.printStackTrace();

		} finally {

			System.out.println("Finished");
		}

	}

	public static void main(String[] args) {
		showTrackCount();
	}

}

// TODO 3 Create a public, static method called main() that has one parameter
// that is a String array called 'args' and doesn't return any values
// a. Create a TryCatchFinallyTryIt instance
// b. Call the showTrackCount() method from the instance created in step 7

