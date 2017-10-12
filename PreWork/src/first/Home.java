package first;

import java.util.ArrayList;
import java.util.Scanner;

public class Home {
	
	static int number1 = 0; // Initialize variable for user's first input. 
	static int number2 = 0; // Initialize variable for user's second input.
	static int num1Slength, num2Slength = 0; // // Initialize variables for user input numbers' length.
	static String num1Length, num2Length; // Initialize variable for user's input as strings. 
	static Scanner scnr;
	static int total = 0; // Initialize variable for equation below. 
	
	public static void main(String[] args) {
		
		scnr = new Scanner(System.in); //Initialize scanner for user input.
		
		// If the values of the user numbers are 0, we call the method compareValues().
		while ((number1 == 0) && (number2 == 0)) {
			
			compareValues(); // Initialize method to obtain and compare user values. 
		
		}
		
	}
	
	public static void compareValues() {
		
		// Prompt user to enter the first number.
		System.out.println("Please enter an integer amount for the first value:");
		
		// Save the user input in the integer variable.
		number1 = scnr.nextInt();
	
		// Prompt user to enter the second number.
		System.out.println("Please enter any integer amount for the second value with the same amount of digits:");
		
		// Save the user input in the integer variable.
		number2 = scnr.nextInt();
	
		// Get the string value of the first number so that you can obtain its length.
		num1Length = String.valueOf(number1);
		num1Slength = num1Length.length();
	
		// Get the string value of the second number so that you can obtain its length.
		num2Length = String.valueOf(number2);
		num2Slength = num2Length.length();
		
		// If both number lengths match continue calculations. 
		if (num1Slength == num2Slength) {

			// Create an ArrayList to store user's numbers' digits.
			ArrayList<Integer> al = new ArrayList<Integer>();
			
			// Loop through both user numbers and add the corresponding digits together.
			for (int i = num1Slength; i > 0; --i ) {
				
				 int sum = Math.abs(getNthDigit(number1, 10, i) + Math.abs(getNthDigit(number2, 10, i)));
				
				 al.add(sum); // Add the sums of those digits to the ArrayList;
				
			}
			
			  // Loop through the ArrayList and add together all the previous sums.
		      for (int i = al.size()-1; i >= 0; --i) {
		    	  
		    	   total = total + al.get(i);
		    	   
		      }
		      
		      // Find the average of the sum of the previous values.
		      int winner = total / al.size();
		      
	    	   /* If the average equals any of the sums in the ArrayList, then each corresponding place in the 
	    	    two numbers sums to the same total.*/
	    	   if (winner == al.get(0)) {
	    		   System.out.println("True");
	    	   } 
	    	   
	    	   else {
	    		   System.out.println("False");
	    	   }
				
		} 
			
		// If the user numbers don't match in size, prompt user to re-enter values 
		else {
			System.out.println("Error: The values given do not have the same number of digits." 
					+ "\n Please re-enter the values.");
			
			number1 = 0; // Declare both user number variables to 0 so that we can loop back to the beginning.
			number2 = 0;
			
		}
		
	}
	
	// Method used for obtaining digits from specific locations
	public static int getNthDigit(int number, int base, int n) {    
		  return (int) ((number / Math.pow(base, n - 1)) % base);
	}
	
}
