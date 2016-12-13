package com.accenture.adf.newcodington.module6.sample;

/**
 * 
 * CodingtonEventPass is about buying an entry pass which can be used to attend
 * various events taking place in New Codington
 * 
 */

public class CodingtonEventPass_TryIt {
	/*
	 * private static final float basicTicketFare = 5.0f; private static final
	 * float serviceTax = .05F; private static final float childrenFare = 2.0f;
	 * private static final float adultFare = 5.0f; private static final float
	 * eveningCharge = 5.0f;
	 */
	static boolean weekday;

	public static void main(String[] args) {

		EntryPass pass = new OneDayPass(new BasePass());
		//System.out.println(pass.toString());
		System.out.println("Cost: " + pass.getCost() + " Surchage: " + pass.getModifiers());
		pass = new OneDayPass(new AdultPass(new BasePass()));
		System.out.println("Cost: " + pass.getCost() + " Surchage: "
				+ pass.getModifiers());
		pass = new OneDayPass(new ChildPass(new EveningPass(new BasePass())));
		System.out.println("Cost: "  + pass.getCost()+ " Surcharge: "
				+ pass.getModifiers());
		pass = new OneDayPass(new AdultPass(new ThreeDayPass(new EveningPass(new BasePass()))));
		System.out.println("Cost: "  + pass.getCost()+ " Surcharge: "
				+ pass.getModifiers());
		
		
		/*
		 * int numChildren = 10; double childTotal = numChildren * childrenFare
		 * + numChildren childrenFare * serviceTax; int numAdult = 6;
		 * 
		 * int numOfTix = 100; double totalfare = numChildren * childrenFare +
		 * numAdult * adultFare;
		 * 
		 * System.out.println(totalfare);
		 * 
		 * int x = 0; int y = 1; if (x == 0) { weekday = false; }
		 */

		/**
		 * TryIt 1: Creating a class
		 */
		// TODO 1. Create a class named 'CodingtonEventPass_TryIt' with main()
		// method and print
		// * "Hello New Codington Visitors!" message to the console

		/**
		 * TryIt 2: Creating constants and variables of different data types
		 */
		// TODO 1. Declare a private static final float variable for children
		// fare and initialize it between class declaration and main() method
		// TODO 2. On the next line, declare a private static final float
		// variable for adults fare and initialize it
		// TODO 3. Create variables of different data types used in calculating
		// the fare for event pass inside main() method
		// a. Declare an integer variable for number of children attending the
		// event
		// b. Declare an integer variable for number of adults attending the
		// event
		// c. Declare a double variable for total fare

		/**
		 * TryIt 3: Usage of basic arithmetic operators
		 */
		// TODO 1. Declare a double variable for total children fare
		// TODO 2. Declare a double variable for total adults fare
		// TODO 3. Initialize the following variables:
		// a. number of children
		// b. number of adults
		// TODO 4. Calculate total children fare by multiplying number of
		// children with children fare
		// TODO 5. Calculate total adults fare by multiplying number of adults
		// with adults fare
		// TODO 6. Print total children fare to the console
		// TODO 7. Print total adults fare to the console
		// TODO 8. Calculate total ticket fare by adding total children fare
		// with total adult fare
		// TODO 9. Print total fare to the console

		/**
		 * TryIt 4: Usage of If / Else structure
		 */
		// TODO 1. Declare a boolean variable for evening pass or regular pass
		// a. Regular pass can be used between 9 AM till 5 PM
		// b. Evening pass can be used between 5 PM till 9 PM
		// TODO 2. Initialize new declared variables for evening pass
		// TODO 3. Use If / Else structure to check for evening pass and print
		// appropriate message to the console
		// TODO 4. If evening pass, print message
		// "Evening pass hours are from 5 PM - 9 PM, additional evening charge applicable for each pass"
		// TODO 5. If regular pass, print message
		// "Regular pass hours are from 9 AM - 5 PM, no additional charge applicable"
		/*
		 * boolean eveningPass =false; boolean regularPass = true;
		 * 
		 * if(eveningPass == true){ System.out.println(
		 * "Evening pass hours are from 5 PM - 9 PM, additional evening charge applicable for each pass"
		 * ); } else if(regularPass == true){ System.out.println(
		 * "Regular pass hours are from 9 AM - 5 PM, no additional charge applicable"
		 * );
		 * 
		 * }
		 */

		/**
		 * TryIt 5: Usage of logical operators
		 */
		// TODO 1. Declare a short variable to identify pass validity
		// a. A pass can be valid for 1 day, 3 days or 5 days
		// TODO 2. Initialize newly declared variable for pass validity
		// TODO 3. Use If / Else to verify evening pass and pass validity and
		// print appropriate message to the console
		// a. For evening pass and 1 day duration, print "Use of an evening pass
		// incurs additional
		// charge for each ticket."
		// b. For evening pass and 3 or 5 day duration, print "Use of an Evening
		// pass incurs an
		// additional charge, a discount is provided for use of an 3 or 5 day
		// pass."
		// c. For any pass duration that is not equal to 1, 3 or 5, print
		// "Please choose either 1,
		// 3 or 5 days for pass duration."
		// d. otherwise, print "Regular pass offers discount based on pass
		// duration.

		/*
		 * short passVal = 3; if (eveningPass & (passVal==1)){
		 * System.out.println
		 * ("Use of an Evening pass incurs an additional charge for each ticket."
		 * ); }else if (eveningPass & (passVal==3)|| (passVal==5)){
		 * System.out.println(
		 * "Use of an Evening pass incurs an additional charge, a discount is provided for use of a 3 or 5 day pass."
		 * ); } else if (eveningPass & !((passVal==1)||(passVal==3)||
		 * (passVal==5))) System.out.println(
		 * "Please choose either 1, 3, or 5 days for pass duration."); else
		 * System
		 * .out.println("Regular pass offers discount based on pass duration");
		 */

		/**
		 * TryIt 6: Usage of switch-case structure
		 */
		// TODO 1. Modify If / Else to verify only evening pass or regular pass
		// and print appropriate message to the console
		// a. For evening pass, print 'Use of an evening pass incurs an
		// additional charge.'
		// b. Otherwise, print 'No additional charge for use of a regular pass.'
		// TODO 2. Use Switch-Case to verify pass duration and print appropriate
		// message to the console
		// a. On choosing a 1 day pass, print 'No discount on 1 day pass'
		// b. On choosing a 3 day pass, print '3 day pass offers 15% discount'
		// c. On choosing a 5 day pass, print '5 day pass offers 25% discount'
		// d. If an invalid option is chosen print 'Please choose only 1, 3 or 5
		// for valid pass duration.
		/*
		 * switch(passVal){ case 1:
		 * System.out.println("No discount on 1 day pass."); break; case 3:
		 * System.out.println("3 day pass offers 15% discount."); break; case 5:
		 * System.out.println("5 day pass offers 25% discount"); break; default:
		 * System
		 * .out.println("Please choose only 1, 3, or 5 for valid pass duration."
		 * ); }
		 */

		/*
		 * int travelPassID = 0; int ticketsIssued = 10;
		 * System.out.print("For Test: "); for (int i=0;
		 * travelPassID<ticketsIssued;i++){
		 * 
		 * System.out.print(travelPassID + " "); travelPassID++; }
		 */
		/**
		 * TryIt 7: Usage of for loop and while loop
		 */
		// TODO 1. Use for loop to generate travel pass id with number of
		// tickets issued as upper bound
		// a. Declare an integer variable for travel pass id
		// b. Travel pass id can be generated by simply incrementing the loop
		// index by 1
		// c. Print travel pass id to the console along with loop index
		// TODO 2. Declare a temporary index variable and initialize it to zero
		// in main() method
		// TODO 3. Use while loop to generate travel pass id with number of
		// tickets issued as upper bound
		// a. Declare an integer variable for travel pass id
		// b. Travel pass id can be generated by simply incrementing the loop
		// index by 1
		// c. Print travel pass id to the console along with loop index
		// d. Increase index by 1 for next iteration
		// TODO 4. Comment out for loop to demonstrate while loop and vice versa
		/**
		 * TryIt 8: Arrays and population of single dimensional array using for
		 * loop
		 */
		// TODO 1. Declare an integer single dimensional array for travel pass
		// sequence numbers inside main() method
		// a. Initialize travel pass array with size as number of tickets
		// TODO 2. Modify for loop to assign pass id's to travel pass array in
		// respective indexes
		// TODO 3. Modify while loop as a do..while loop with upper bound as
		// travel pass array length
		// a. Remove pass id generation logic
		// b. Print array values along with array index to console
		/*
		 * System.out.println(); travelPassID=0; int[] passes = new
		 * int[ticketsIssued]; System.out.println(passes.length); for (int i=0;
		 * i<passes.length;i++){ passes[i]=travelPassID+100;
		 * System.out.print(passes[i] + " "); travelPassID++; }
		 * System.out.println();
		 */
		/**
		 * TryIt 9: Methods, parameters and return types.
		 */
		// TODO 1. Define a static method to calculate total fare based on
		// evening pass or regular pass (evening pass flag as parameter for the
		// method)
		// TODO 2. Specify return type for the new method as String
		// TODO 3. Move If / Else logic to the new method
		// TODO 4. Declare a String variable to capture return message from If
		// or Else
		// TODO 5. Modify If and Else conditions to set the return message to
		// the string variable
		// TODO 6. Return the string message to main() method instead of
		// printing to console
		// TODO 7. Define method to calculate total fare based on pass validity
		// (pass validity as the parameter for the method)
		// TODO 8. Specify return type for the new method as String
		// TODO 9. Move Switch-Case logic to the new method
		// TODO 10.Modify Case statements to return message to the main ()
		// method
		// TODO 11. Declare a string variable in the main() method to capture
		// the return message from the each of the above methods
		// TODO 12. Invoke method for weekend check and print the return message
		// to console
		// TODO 13. Invoke method for travel class check and print the return
		// message to console
		/*
		 * System.out.println(calculateFare(true, (short) 1));
		 * System.out.println(calculateFare(true, (short) 3));
		 * System.out.println(calculateFare(true, (short) 5));
		 * System.out.println(calculateFare(false, (short) 3));
		 */
	}
	/*
	 * public static String calculateFare(boolean eveningPass, short passTimer){
	 * String fareMessage = " ";
	 * 
	 * if (eveningPass & (passTimer==1)){ fareMessage =
	 * "Use of an Evening pass incurs an additional charge for each ticket.";
	 * }else if (eveningPass & (passTimer==3)|| (passTimer==5)){ fareMessage=
	 * "Use of an Evening pass incurs an additional charge, a discount is provided for use of a 3 or 5 day pass."
	 * ; } else if (eveningPass & !((passTimer==1)||(passTimer==3)||
	 * (passTimer==5)))
	 * fareMessage="Please choose either 1, 3, or 5 days for pass duration.";
	 * else fareMessage="Regular pass offers discount based on pass duration";
	 * return fareMessage;
	 */
}
